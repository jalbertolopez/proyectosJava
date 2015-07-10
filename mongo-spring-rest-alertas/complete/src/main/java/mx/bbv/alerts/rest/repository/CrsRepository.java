
package mx.bbv.alerts.rest.repository;


import java.util.List;

import mx.bbv.alerts.rest.model.CrPOJO;
import mx.bbv.alerts.rest.model.OperationPOJO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CrsRepository extends MongoRepository <CrPOJO, String> {
	
	public List<CrPOJO> findAll();
	public List <CrPOJO> findByCr(String cr);
}
