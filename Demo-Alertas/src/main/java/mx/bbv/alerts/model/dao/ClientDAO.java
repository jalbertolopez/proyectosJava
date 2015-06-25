package mx.bbv.alerts.model.dao;

import java.util.List;

import mx.bbv.alerts.model.persistence.ClientPOJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ClientDAO extends CrudRepository<ClientPOJO, Long> {

	public List<ClientPOJO> findByIdCliente(String idCliente);
}