package mx.bbv.alerts.bussines.services;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.bbv.alerts.drools.RuleRunner;
import mx.bbv.alerts.model.ClientInfoStatus;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.services.AlertsDataService;

@Component ("alertsBS")
public class AlertsBSImpl implements IAlertsBS{
	private Logger logger = LoggerFactory.getLogger(AlertsBSImpl.class);
	
	
	@Autowired
	AlertsDataService alertsDataService;
	
	@Autowired
	RuleRunner ruleRunner;
	/*
	 * Servicio para persistir las transacciones RAW en MONGODB
	 * */
	@Override
	public void SaveTransactionBS(TransactionRaw t) {
		logger.info("\n\n ENTRA A SaveTransactionBS \n\n");
		alertsDataService.saveTransactionRAW(t);
	}
	
	/*
	 * Servicio para validar las reglas de negocio en DROOLS
	 * */
	@Override
	public void validateRules(TransactionStatus t) {
		logger.info("\n\n ENTRA A validateRules \n\n");
		logger.info("\n Obteniendo el monto acumulado de el usuario [{}:{}]",t.getIdCliente(),t.getNombres());		
		
		ClientInfoStatus cis = alertsDataService.getAccumulatedAmount(t.getIdCliente());		
				
		if (cis != null ){
			Double montoA = cis.getMontoAcumulado() == null ? 0 : cis.getMontoAcumulado();  			
			t.setMontoAcumulado(montoA);
		}
		//Se evaluan Reglas de Drools
		try {
			ruleRunner.runRules(t);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("{}",e);
			//e.printStackTrace();
		}
	}
	/*
	 * Servicio para persistir la alerta en la tabla de clientes transacciones y alertas en postgersql
	 * */
	@Override
	public void saveAlert(TransactionStatus t) {
		logger.info("\n\n ENTRA A saveAlert \n\n");		
		// Persistimos en Clients
		alertsDataService.saveClient(t);
		
		// Persistimos en Alertas
		alertsDataService.saveAlert(t);
		
		// Obtenemos la transacciones del cliente para general el histórico de alertas
		List<TransactionRaw> trs = alertsDataService.getTransactionsForIdMDB(t.getIdCliente());
		
		if (trs.isEmpty()){
			logger.info("ERROOOOOR NO SE ENCONTRARON LAS TRANSACCIONES RELACIONADAS AL CLIENTE {}", t.getIdCliente());
		}else{
			for(TransactionRaw tr : trs){
				logger.info("Persistiendo Alerta");
				alertsDataService.saveTransaction(tr);
			}
		}
		
	}
}
