package com.sistema.ordenes.mapper;

import com.sistema.ordenes.dto.productRequest;
import com.sistema.ordenes.dto.productResponse;
import com.sistema.ordenes.model.Product;
import org.springframework.stereotype.Component;

@Component
public class productMapper {

    public static Product toEntity(productRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        return product;
    }

    public static productResponse toResponse(Product product){
        return new productResponse(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
