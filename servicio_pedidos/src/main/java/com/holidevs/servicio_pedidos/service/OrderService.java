package com.holidevs.servicio_pedidos.service;

import com.holidevs.servicio_pedidos.entity.ClientEntity;
import com.holidevs.servicio_pedidos.entity.OrderEntity;
import com.holidevs.servicio_pedidos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService implements OrderServiceInterface {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderEntity getOrder(Long id) {
        try {
            OrderEntity order = orderRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with id " + id + " not found"));

            return order;
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while fetching the order with id " + id, ex);
        }
    }

    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        try {
            //TODO: logica de negocio y validaciones
            OrderEntity newOrder = new OrderEntity(order.getDescription());
            orderRepository.save(newOrder);
            return newOrder;
        } catch (Exception e) {// Aquí puedes personalizar la gestión de la excepción.
            //TODO implementar manejo personalizado de excepciones
            //throw new ProductCreationException("Error al crear el producto.");
            throw new RuntimeException("Error al crear el pedido." + e.getMessage());
        }
    }
}
