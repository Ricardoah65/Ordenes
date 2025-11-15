package com.sistema.ordenes.controller;

import com.sistema.ordenes.dto.productRequest;
import com.sistema.ordenes.mapper.productMapper;
import com.sistema.ordenes.dto.productResponse;
import com.sistema.ordenes.model.Product;
import com.sistema.ordenes.model.User;
import com.sistema.ordenes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<productResponse> saveProduct(@RequestBody productRequest productRequest){

        Product product = productMapper.toEntity(productRequest);
        this.productService.saveProduct(product);
        return ResponseEntity.ok(productMapper.toResponse(product));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<productResponse>> getAll(){
        List<Product> products = productService.findAll();
        List<productResponse> dtos = products.stream()
                .map(productMapper::toResponse)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<productResponse> getById(@PathVariable Long id){

        if (!productService.exits(id)){
            return ResponseEntity.notFound().build();
        }

        Product product = this.productService.findById(id);
        return ResponseEntity.ok(productMapper.toResponse(product));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.productService.findByName(name));
    }

    @GetMapping("/getByPrice/{price}")
    public ResponseEntity<List<Product>> getByPrice(@PathVariable Double price){
        return ResponseEntity.ok(this.productService.findByPrice(price));
    }

    @GetMapping("/getAllById/{ids}")
    public ResponseEntity<List<Product>> getAllById(@PathVariable List<Long> ids){
        return ResponseEntity.ok(productService.findAllById(ids));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@RequestBody Product product){
        return ResponseEntity.ok(productService.update(id, product));
    }

    @PutMapping("/updatePrice/{id}")
    public ResponseEntity<Product> updatePrice(@PathVariable Long id,@RequestBody Double price){
        return ResponseEntity.ok(productService.updatePrice(id, price));
    }

    @PutMapping("/updatePrice/{stock}")
    public ResponseEntity<Product> updateStock(@PathVariable Long id,@RequestBody int stock){
        return ResponseEntity.ok(productService.updateStock(id, stock));
    }
}
