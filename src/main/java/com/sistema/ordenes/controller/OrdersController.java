package com.sistema.ordenes.controller;

import com.sistema.ordenes.model.Order;
import com.sistema.ordenes.service.OrderService;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;
    @Autowired
    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> create(@RequestParam Long userId,
                                       @RequestParam List<Long> productIds,
                                       @RequestParam String note){
        Order order = orderService.createOrder(userId, productIds, note);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Order>> getAll(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/getById")
    public ResponseEntity<Order> getById(@RequestParam Long id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PutMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam Long id){

        if (orderService.exist(id)){
            orderService.deleteOrder(id);
            ResponseEntity.ok().build();
        }else{
            ResponseEntity.notFound().build();
        }
        return null;
    }
}
