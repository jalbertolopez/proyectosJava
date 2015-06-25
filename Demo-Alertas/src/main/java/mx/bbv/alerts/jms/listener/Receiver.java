package mx.bbv.alerts.jms.listener;

import java.io.IOException;

import mx.bbv.alerts.bussines.services.AlertsBSImpl;
import mx.bbv.alerts.catalogs.TransactionStatusEnum;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.utils.JsonConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Receiver {

	AlertsBSImpl alertsBSImpl;

	private Logger logger = LoggerFactory.getLogger(Receiver.class);

	public void receiveMessage(String message) throws IOException {
		logger.info("\n\n\tMensaje recibido:\n {}", message);
		TransactionRaw t = JsonConverter.fromJson(message, TransactionStatus.class);
		// PERSISTIMOS EN MONGO
		if (alertsBSImpl != null) 
		{
			alertsBSImpl.SaveTransactionBS(t);
			// EVALUAMOS LAS REGLAS DE NEGOCIO
			TransactionStatus ts = (TransactionStatus) t;
			alertsBSImpl.validateRules(ts);			
			
			logger.info("\n********************************************************************************************************************************\n "
					+ "{} \n"
					+ "********************************************************************************************************************************\n",ts);
			
			// SI EL ESTATUS ES DANGER PERSISTIMOS ALERTA
			if (ts.getStatus() == TransactionStatusEnum.DANGER.toInt()){
				logger.info("EL USUARIO {} ES MUY PELIGROSO POR LO QUE SERÁ REPORTADO:",ts.getIdCliente());
				alertsBSImpl.saveAlert(ts);
			}
		}

	}

	public void setAlertsBSImpl(AlertsBSImpl alertsBSImpl) {
		this.alertsBSImpl = alertsBSImpl;
	}

}
