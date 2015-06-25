package mx.bbv.alerts.services;

import java.util.List;

import mx.bbv.alerts.model.ClientInfoStatus;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.model.dao.ClientDAO;
import mx.bbv.alerts.model.dao.TransactionDAO;
import mx.bbv.alerts.model.persistence.AlertPOJO;
import mx.bbv.alerts.model.persistence.ClientPOJO;
import mx.bbv.alerts.model.persistence.TransactionPOJO;
import mx.bbv.alerts.model.persistence.TransactionRawPOJO;
import mx.bbv.alerts.transforms.Transform2POJO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.stereotype.Component;

@Component
public class AlertsDataService {
	
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	Transform2POJO transform2POJO;
	
//	@Autowired
//	ClientDAO clientDAO;
	
//	@Autowired
//	TransactionDAO transactionDAO;
	
	private MongoOperations mongoOps;
	
	private Logger logger = LoggerFactory.getLogger(AlertsDataService.class);
	
	/* Servicio para persistir las transacciones en crudo en mongo DB */
	
	public boolean saveTransactionRAW(TransactionRaw t){
		logger.info("\nENTRA A saveClient\n");
		init();
		TransactionRawPOJO transaction = transform2POJO.transform2TransactionRawPOJO(t);
		logger.info("\npersistiendo ..... \n {} ",t);
		mongoOps.insert(transaction,"transactionsRaw");
	    return true;
	}
	
	/* Servicio para persistir el cliente frauduleto POSTGRESQL */
	
	public boolean saveClient(TransactionStatus t){
		logger.info("\nENTRA A saveClient\n");
		ClientPOJO client = transform2POJO.transform2ClientPOJO(t);
		logger.info("\n persistiendo ..... \n {} ",client);		
		mongoOps.insert(client,"clients");
//	    clientDAO.save(client);
		return true;
	}
	
	/* Servicio para persistir las transacciones Ftraudulentas POSTGRESQL */

	public boolean saveTransaction(TransactionRaw t){
		logger.info("\nENTRA A saveTestatusransaction\n");
		TransactionPOJO transaction = transform2POJO.transform2TransactionPOJO(t);
		logger.info("\npersistiendo ..... \n {} ",transaction);
		mongoOps.insert(transaction,"transactions");
//		transactionDAO.save(transaction);
		return true;
	}
	
	/* Servicio para persistir las alertas generadas POSTGRESQL */

	public boolean saveAlert(TransactionStatus t){
		logger.info("\nENTRA A saveAlert\n");
		AlertPOJO alerta = transform2POJO.transform2AlertPOJO(t);
		logger.info("\npersistiendo ..... \n {} ",alerta);
		mongoOps.insert(alerta,"alerts");
//		transactionDAO.save(transaction);
		return true;
	}

// PARA LOS REST SERVICES 
//////////////////////////////////////////////////////////////////////////////////////////
	/* Servicio para obtener todas las transacciones peligrosas para un cliente*/
	public List<TransactionPOJO> getDangerousTransactions(String idClient ){
		logger.info("\nENTRA A getDangerousTransactions\n");
		init();
		return mongoTemplate.find(query(where("idCliente").is(idClient)),TransactionPOJO.class, "transactions");
	}
	
	/* Servicio para obtener todas las transacciones peligrosas para un cliente*/
	public List<AlertPOJO> getAllAlerts(){
		logger.info("\nENTRA A getAllAlerts\n");
		init();
		return mongoTemplate.findAll(AlertPOJO.class, "alerts");
	}
	
	/* Servicio para obtener todas los clientes peligrosos*/
	public List<ClientPOJO> getDangerousClients(){
		logger.info("\nENTRA A getDangerousClients\n");
		init();
		return mongoTemplate.findAll(ClientPOJO.class, "clients");
	}
//////////////////////////////////////////////////////////////////////////////////////////	

	/* Servicio para obtener todas las transacciones relacionadas a un cliente de MONGODB*/
	public List<TransactionRaw> getTransactionsForIdMDB(String idClient ){
		logger.info("\nENTRA A getTransactionsForIdMDB\n");
		init();
		return mongoTemplate.find(query(where("idCliente").is(idClient)),TransactionRaw.class, "transactionsRaw");
	}
	
	/*
	 * Servicio para Obtener el monto acumulado de la BD Datos MONGO Colleccion TransactionsRaw
	 * */
	public ClientInfoStatus getAccumulatedAmount(String idClient){
		logger.info("\nENTRA A getAccumulatedAmount\n");
		init();
		
		TypedAggregation<TransactionPOJO> agg = newAggregation(TransactionPOJO.class,
			    group("idCliente").sum("monto").as("montoAcumulado"),
				project("montoAcumulado").and("idCliente").previousOperation(),
				match(where("idCliente").is(idClient))
			);
		
		AggregationResults<ClientInfoStatus> results = mongoTemplate.aggregate(agg, "transactionsRaw", ClientInfoStatus.class);
		List<ClientInfoStatus> amountSum = results.getMappedResults();
		if (!amountSum.isEmpty())
		{
			return amountSum.get(0);
		}
		else
		{
			return null;
		}
	}
	
	private void  init (){
		mongoOps = mongoTemplate;
	}
}
