package com.holidevs.servicio_pedidos.entity;

import jakarta.persistence.*;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    public ClientEntity getClient() {
        return client;
    }

    public OrderEntity(String description) {
        this.description = description;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
