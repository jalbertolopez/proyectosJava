package mx.bbv.alerts.rest.repository;

import java.util.List;

import mx.bbv.alerts.rest.model.Client;
import mx.bbv.alerts.rest.model.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository <Client, String> {
		public List<Client> findAll();
		public Client findByIdCliente(String idCliente);
	}

