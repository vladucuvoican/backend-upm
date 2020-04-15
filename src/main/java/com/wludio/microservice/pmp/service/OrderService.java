package com.wludio.microservice.pmp.service;

import com.google.common.base.Preconditions;
import com.wludio.microservice.pmp.entities.Order;
import com.wludio.microservice.pmp.exception.ItemNotFoundException;
import com.wludio.microservice.pmp.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public Order save(final Order order) {
        log.debug(format("Calling save for order: '{}')", order));
        Preconditions.checkNotNull(order, "The passed object 'order' must not be null!");

        return orderRepository.save(order);
    }

    @Transactional
    public Order update(final Order order) {
        log.debug(format("Calling update for order: '{}')", order));
        Preconditions.checkNotNull(order, "The passed object 'order' must not be null!");
        Preconditions.checkNotNull(order.getId(), "The passed object 'order' must have a valid id!");

        orderRepository.findById(order.getId()).orElseThrow(() -> new ItemNotFoundException("Missing order with the id : '{}'", order.getId()));

        return orderRepository.save(order);
    }

    public void delete(final Long orderId) {
        log.debug("Calling delete for orderId: '{}'", orderId);
        Preconditions.checkNotNull(orderId, "The passed object 'orderId' must not be null!");

        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {
            log.warn("There's no order with the id: {}, that can be deleted!", orderId);

        }
    }

    public Long getNumberOfOrders() {
        log.debug("Calling getNumberOfOrders");

        return orderRepository.count();
    }

    public List<Order> findAll() {
        log.debug("Calling findAll");

        return orderRepository.findAll();
    }
}
