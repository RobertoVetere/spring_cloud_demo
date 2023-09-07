package com.holidevs.servicio_pedidos.controller;

import com.holidevs.servicio_pedidos.entity.OrderEntity;
import com.holidevs.servicio_pedidos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderEntity getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("/create-order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderEntity deleteClient(@RequestBody OrderEntity order){
        return orderService.saveOrder(order);
    }
}
