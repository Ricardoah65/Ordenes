package com.sistema.ordenes.service;

import com.sistema.ordenes.model.Product;
import com.sistema.ordenes.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    private final IProductRepository productRepo;

    @Autowired
    public ProductService(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);

    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(()->new RuntimeException("No hay un usuario con ese id"));
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name)
                .orElseThrow(()-> new RuntimeException("No hay ningun producto por ese nombre"));

    }

    @Override
    public List<Product> findByPrice(Double price) {
        return productRepo.findByPriceLessThanEquals(price);
    }

    @Override
    public List<Product> findAllById(List<Long> ids) {
        return productRepo.findAllById(ids);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product update(Long id, Product product) {
        Product prod = productRepo.findById(id).orElseThrow(()->new RuntimeException("no hay producto con ese id"));

        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());

        return productRepo.save(prod);
    }

    @Override
    public Product updatePrice(Long id, Double newPrice) {
        Product prod = productRepo.findById(id).orElseThrow(()-> new RuntimeException("No hay producto por ese id"));
        prod.setPrice(newPrice);
        return productRepo.save(prod);
    }

    public Boolean exits(Long id){
        if (productRepo.existsById(id)){
            return true;
        }else {return false;}
    }
}
