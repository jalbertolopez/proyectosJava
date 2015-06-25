package mx.bbv.alerts.bussines.services;

import java.util.List;

import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.model.persistence.ClientPOJO;
public interface IAlertsBS {
	
	public void SaveTransactionBS (TransactionRaw t);
	public void validateRules (TransactionStatus t);
	public void saveAlert (TransactionStatus t);
}
