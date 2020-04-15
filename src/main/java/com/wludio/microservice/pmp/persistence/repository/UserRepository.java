package com.wludio.microservice.pmp.persistence.repository;

import com.wludio.microservice.pmp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	
    Optional<User> findByUsername(String username);
}
