package mx.bbv.alerts.rest.repository;

import java.util.List;

import mx.bbv.alerts.rest.model.ClientPOJO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository <ClientPOJO, String> {
		public List<ClientPOJO> findAll();
		public List <ClientPOJO> findByIdCliente(String idCliente);
	}

