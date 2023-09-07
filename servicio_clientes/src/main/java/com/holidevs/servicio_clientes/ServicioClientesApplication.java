package com.holidevs.servicio_clientes;

import com.holidevs.servicio_clientes.entity.ClientEntity;
import com.holidevs.servicio_clientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicioClientesApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServicioClientesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createAndSaveClient("Roberto Vetere", "Carrer Arquimedes");
		createAndSaveClient("Veronica Cardona", "Carrer Forza");

	}

	private void createAndSaveClient(String name, String address){
		ClientEntity newClient = new ClientEntity();
		newClient.setName(name);
		newClient.setAddress(address);
		clientRepository.save(newClient);
	}
}
