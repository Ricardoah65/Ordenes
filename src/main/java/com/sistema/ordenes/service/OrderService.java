package com.sistema.ordenes.service;

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
    public Order createOrder(Long idUser,
                             List<Long> idProducts,
                             String notes){
        User user = userRepo.findById(idUser)
                .orElseThrow(()-> new RuntimeException("No se encontró usuaripo por el Id" + idUser));

        List<Product> product = productRepo.findAllById(idProducts);

        Order order = new Order();
        order.setUser(user);
        order.setProducts(product);
        order.setAdditionalNotes(notes);
        order.setDate(LocalDateTime.now());

        orderRepo.save(order);
        return order;
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
