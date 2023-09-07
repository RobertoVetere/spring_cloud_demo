package com.holidevs.servicio_pedidos.service;

import com.holidevs.servicio_pedidos.entity.OrderEntity;

public interface OrderServiceInterface {

    public OrderEntity getOrder(Long id);

    public OrderEntity saveOrder(OrderEntity client);
}
