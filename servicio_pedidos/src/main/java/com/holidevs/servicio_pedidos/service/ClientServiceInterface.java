package com.holidevs.servicio_pedidos.service;

import com.holidevs.servicio_pedidos.entity.ClientEntity;

public interface ClientServiceInterface {

    public ClientEntity getClient(Long id);

    public ClientEntity saveClient(ClientEntity client);
}
