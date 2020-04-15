package com.wludio.microservice.pmp.persistence.repository;

import com.wludio.microservice.pmp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
