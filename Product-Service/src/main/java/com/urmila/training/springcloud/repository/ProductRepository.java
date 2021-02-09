package com.urmila.training.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urmila.training.springcloud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
