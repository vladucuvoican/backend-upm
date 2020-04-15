package com.wludio.microservice.pmp.service;

import com.google.common.base.Preconditions;
import com.wludio.microservice.pmp.entities.Product;
import com.wludio.microservice.pmp.exception.ItemNotFoundException;
import com.wludio.microservice.pmp.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Product save(final Product product) {
        log.debug("Calling save for product: '{}'", product);
        Preconditions.checkNotNull(product, "The passed object 'product' must not be null!");

        return productRepository.save(product);
    }

    @Transactional
    public Product update(final Product product) {
        log.debug("Calling update for product: '{}'", product);
        Preconditions.checkNotNull(product, "The passed object 'product' must not be null!");
        Preconditions.checkNotNull(product.getId(), "The passed object 'product' must have a valid id!");

        productRepository.findById(product.getId()).orElseThrow(() -> new ItemNotFoundException("Missing product with the id : '{}'", product.getId()));

        return productRepository.save(product);
    }

    public void delete(final Long productId) {
        log.debug("Calling delete for productId: '{}'", productId);
        Preconditions.checkNotNull(productId, "The passed object 'productId' must not be null!");

        try {
            productRepository.deleteById(productId);
        } catch (EmptyResultDataAccessException e) {
            log.warn("There's no product with the id: {}, that can be deleted!", productId);
        }
    }

    public Long getNumberOfProducts() {
        log.debug("Calling getNumberOfProducts");

        return productRepository.count();
    }

    public List<Product> findAll() {
        log.debug("Calling findAll");

        return productRepository.findAll();
    }
}
