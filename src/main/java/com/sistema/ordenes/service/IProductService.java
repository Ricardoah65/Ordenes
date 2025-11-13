package com.sistema.ordenes.service;

import com.sistema.ordenes.model.Product;

import java.util.List;

public interface IProductService {
    public void saveProduct(Product product);
    public Product findById(Long id);
    public List<Product> findAll();
    public Product findByName(String name);
    public List<Product> findByPrice(Double price);
    public void deleteById(Long id);
    public Product update(Long id, Product product);
    public Product updatePrice(Long id, Double newPrice);
    public List<Product> findAllById(List<Long> ids);
}
