package com.sistema.ordenes.controller;

import com.sistema.ordenes.model.Product;
import com.sistema.ordenes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        this.productService.saveProduct(product);
        return ResponseEntity.ok("Se guardó correctamente");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        if (!productService.exits(id)){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.productService.findById(id));
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

    @PutMapping("/updateByPrice/{id}")
    public ResponseEntity<Product> updateByPrice(@PathVariable Long id,@RequestBody Double price){
        return ResponseEntity.ok(productService.updatePrice(id, price));
    }
}
