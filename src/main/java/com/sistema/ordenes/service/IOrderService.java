package com.sistema.ordenes.service;

import com.sistema.ordenes.dto.orderRequestDto;
import com.sistema.ordenes.dto.orderResponseDto;


public interface IOrderService {
    public orderResponseDto createOrder(orderRequestDto dto);

}
