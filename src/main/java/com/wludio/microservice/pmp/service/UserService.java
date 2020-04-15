package com.wludio.microservice.pmp.service;

import com.google.common.base.Preconditions;
import com.wludio.microservice.pmp.entities.User;
import com.wludio.microservice.pmp.exception.ItemNotFoundException;
import com.wludio.microservice.pmp.exception.UserNotFoundException;
import com.wludio.microservice.pmp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(final User user) {
        log.debug("Calling save for user: '{}'", user);
        Preconditions.checkNotNull(user, "The passed object 'user' must not be null!");

        user.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    public User update(final User user) {
        log.debug("Calling save for user: '{}'", user);
        Preconditions.checkNotNull(user, "The passed object 'user' must not be null!");
        Preconditions.checkNotNull(user.getId(), "The passed object 'user' must have a valid id!");

        userRepository.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("Missing user with the id : '{}'", user.getId()));

        return userRepository.save(user);
    }

    public void delete(Long userId) {
        log.debug("Calling delete user with the userId: {}", userId);
        Preconditions.checkNotNull(userId, "The userId should not be null!");

        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            log.warn("There's no user with the id: {}, that can be deleted!", userId);
        }
    }

    public User findByUsername(final String username) {
        log.debug("Calling findByUsername with the username: {}", username);
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "The username must not be blank!");

        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("No user with the 'username'!", username));
    }

    public Long getNumberOfUsers() {
        log.debug("Calling getNumberOfUsers");

        return userRepository.count();
    }

    public List<User> findAll() {
        log.debug("Calling findAll");

        return userRepository.findAll();
    }
}
