package com.holidevs.servicio_pedidos.repository;
import com.holidevs.servicio_pedidos.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findById(Long id);

    OrderEntity save(OrderEntity client);
}
