package mx.bbv.alerts.rest.repository;

import java.util.List;

import mx.bbv.alerts.rest.model.Transaction;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

	public List<Transaction> findAll();
	public List<Transaction> findByIdCliente(String idCliente);
}
