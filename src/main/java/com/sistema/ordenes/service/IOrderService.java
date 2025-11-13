package com.sistema.ordenes.service;

import com.sistema.ordenes.model.Order;

import java.util.List;

public interface IOrderService {
    public Order createOrder(Long idUser,
                             List<Long> idProducts,
                             String notes);

}
