
package mx.bbv.alerts.rest.repository;


import mx.bbv.alerts.rest.model.OperacionDAO;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface OperacionRepository extends CrudRepository <OperacionDAO, String> {
	
	
}
