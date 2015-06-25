package mx.bbv.alerts.model.dao;

import java.util.List;

import mx.bbv.alerts.model.persistence.TransactionPOJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TransactionDAO extends CrudRepository<TransactionPOJO, Long> {

	public List<TransactionPOJO> findByIdCliente(String idCliente);
}
