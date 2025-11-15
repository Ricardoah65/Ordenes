package com.sistema.ordenes.service;

import com.sistema.ordenes.dto.orderRequestDto;
import com.sistema.ordenes.dto.orderResponseDto;
import com.sistema.ordenes.model.Order;
import com.sistema.ordenes.model.Product;
import com.sistema.ordenes.model.User;
import com.sistema.ordenes.repository.IOrderRepository;
import com.sistema.ordenes.repository.IProductRepository;
import com.sistema.ordenes.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepo;
    private final IUserRepository userRepo;
    private final IProductRepository productRepo;
    @Autowired
    public OrderService(IOrderRepository orderRepo, IUserRepository userRepo, IProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }

    //CREAR UNA ORDEN
    public orderResponseDto createOrder(orderRequestDto orderRequest){
        User user = userRepo.findById(orderRequest.getUserId())
                .orElseThrow(()-> new RuntimeException("No se encontró usuario por el Id" + orderRequest.getUserId()));

        List<Product> product = productRepo.findAllById(orderRequest.getProductsId());

        Order order = new Order();
        order.setUser(user);
        order.setProducts(product);
        order.setAdditionalNotes(orderRequest.getAdditionalNotes());
        order.setDate(LocalDateTime.now());

        orderRepo.save(order);

        //convertimos a dto la respuesta
        List<String> productNames = product.stream().map(Product::getName).toList();


        return new orderResponseDto(
            order.getIdOrder(),
            order.getDate(),
            order.getAdditionalNotes(),
            user.getName(),
            productNames
        );
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }

    public Order getById(Long id){
        return orderRepo.findById(id).orElseThrow(()-> new RuntimeException("no hay"));
    }

    public void deleteOrder(Long id){
        orderRepo.deleteById(id);
    }

    public boolean exist(Long id){
        return orderRepo.existsById(id);
    }


}
