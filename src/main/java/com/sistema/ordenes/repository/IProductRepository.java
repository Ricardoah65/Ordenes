package com.sistema.ordenes.repository;

import com.sistema.ordenes.model.Product;
import com.sistema.ordenes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findByPrice(Double price);
    Optional<Product> findByName(String name);
    List<Product> findByPriceLessThanEquals(Double price);
    List<Product> findAllById(List<Long> ids);
}
