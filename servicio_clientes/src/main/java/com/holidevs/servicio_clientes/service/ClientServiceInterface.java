package com.holidevs.servicio_clientes.service;


import com.holidevs.servicio_clientes.entity.ClientEntity;


public interface ClientServiceInterface {

    public ClientEntity getClient(Long id);

    public ClientEntity saveClient(ClientEntity client);

    public ClientEntity updateClient(ClientEntity client);

    public String deleteClient(Long id);
}
