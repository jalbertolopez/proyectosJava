
package mx.bbv.alerts.rest.repository;

import java.util.List;

import mx.bbv.alerts.rest.model.ClientPOJO;
import mx.bbv.alerts.rest.model.RelevantOpPOJO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelevantsRepository extends MongoRepository <RelevantOpPOJO, String> {
	public List<RelevantOpPOJO> findAll();
	public RelevantOpPOJO findByIdOperacion(String idOperacion);	
}
