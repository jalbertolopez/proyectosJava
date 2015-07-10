package mx.bbv.alerts.rest.repository;

import java.util.List;





import mx.bbv.alerts.rest.model.ClientPOJO;
import mx.bbv.alerts.rest.model.OperationPOJO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperationsRepository extends MongoRepository<OperationPOJO, String> {

	public List<OperationPOJO> findAll();
	public List<OperationPOJO> findByIdAlerta(String idAlerta);
	public List<OperationPOJO> findByCuenta(String cuenta);
	public OperationPOJO findByIdOperacion(String idOperacion);
}
