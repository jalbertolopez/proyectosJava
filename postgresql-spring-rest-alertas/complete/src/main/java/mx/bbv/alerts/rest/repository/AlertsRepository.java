
package mx.bbv.alerts.rest.repository;

import mx.bbv.alerts.rest.model.AlertaDAO;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;

public interface AlertsRepository extends CrudRepository <AlertaDAO, String> {
	
	
}
