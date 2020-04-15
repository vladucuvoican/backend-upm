package com.wludio.microservice.pmp.persistence.repository;

import com.wludio.microservice.pmp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
