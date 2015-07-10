
package mx.bbv.alerts.rest.repository;

import java.util.List;

import mx.bbv.alerts.rest.model.AccountPOJO;
import mx.bbv.alerts.rest.model.OperationPOJO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountsRepository extends MongoRepository <AccountPOJO, String> {
	public List<AccountPOJO> findAll();
	public List<AccountPOJO> findByIdCliente(String idCliente);
}
