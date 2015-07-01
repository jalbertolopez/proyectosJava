
package mx.bbv.alerts.rest.repository;

import mx.bbv.alerts.rest.model.Alert;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertsRepository extends MongoRepository <Alert, String> {}
