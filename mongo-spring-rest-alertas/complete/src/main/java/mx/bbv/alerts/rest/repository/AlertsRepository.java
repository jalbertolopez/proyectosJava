
package mx.bbv.alerts.rest.repository;

import mx.bbv.alerts.rest.model.AlertPOJO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertsRepository extends MongoRepository <AlertPOJO, String> {}
