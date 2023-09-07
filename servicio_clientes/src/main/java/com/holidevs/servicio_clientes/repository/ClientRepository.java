package com.holidevs.servicio_clientes.repository;

import com.holidevs.servicio_clientes.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Optional<ClientEntity> findById(Long id);

    ClientEntity save(ClientEntity client);

    //ClientEntity updateClient(ClientEntity client);

    void delete(ClientEntity client);
}
