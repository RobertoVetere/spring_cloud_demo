package com.holidevs.servicio_clientes.controller;

import com.holidevs.servicio_clientes.entity.ClientEntity;
import com.holidevs.servicio_clientes.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientEntity getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }

    @PostMapping("/create-client")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientEntity createClient(@RequestBody ClientEntity client){
        return clientService.saveClient(client);
    }
}
