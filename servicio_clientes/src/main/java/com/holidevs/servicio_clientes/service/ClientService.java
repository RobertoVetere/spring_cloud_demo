package com.holidevs.servicio_clientes.service;

import com.holidevs.servicio_clientes.entity.ClientEntity;
import com.holidevs.servicio_clientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientEntity getClient(Long id) {
        try {
            ClientEntity client = clientRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client with id " + id + " not found"));

            return client;
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while fetching the client with id " + id, ex);
        }
    }

    @Override
    public ClientEntity saveClient(ClientEntity client) {
        try {
            //TODO: logica de negocio y validaciones
            ClientEntity newClient = new ClientEntity(client.getName(),client.getAddress());
            clientRepository.save(newClient);
            return newClient;
        } catch (Exception e) {// Aquí puedes personalizar la gestión de la excepción.
            //TODO implementar manejo personalizado de excepciones
            //throw new ProductCreationException("Error al crear el producto.");
            throw new RuntimeException("Error al crear el producto." + e.getMessage());
        }
    }

    @Override
    public ClientEntity updateClient(ClientEntity client) {
        return null;
    }

    @Override
    public String deleteClient(Long id) {
        try {
            Optional<ClientEntity> existingClientOptional = clientRepository.findById(id);
            if (existingClientOptional.isPresent())
            {
                //TODO logica de negocio y validaciones
                clientRepository.delete(existingClientOptional.get());
                return "The client with: " + id + " " + existingClientOptional.get() + " has been deleted";
            }
            else {
                throw new RuntimeException("Client with id: " + id + " not found!");
            }

        }catch (Exception e){
            //TODO implementar manejo personalizado de excepciones
            throw new RuntimeException("An error occurred while fetching the client with id. " + e.getMessage());
        }
    }
}
