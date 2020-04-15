package com.medici.app.shop.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.medici.app.shop.domain.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
