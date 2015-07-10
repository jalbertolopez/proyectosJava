package mx.bbv.alerts.transforms;

import java.util.Date;

import org.springframework.stereotype.Component;

import mx.bbv.alerts.catalogs.AccountStatusEnum;
import mx.bbv.alerts.catalogs.AlertStatusEnum;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.model.persistence.AccountPOJO;
import mx.bbv.alerts.model.persistence.AlertPOJO;
import mx.bbv.alerts.model.persistence.ClientPOJO;
import mx.bbv.alerts.model.persistence.OperationPOJO;
import mx.bbv.alerts.model.persistence.TransactionRawPOJO;

@Component
public class Transform2POJO {
	
	/* Transformador de un TransacctionRaw a un ClientPOJO*/
	public ClientPOJO transform2ClientPOJO(TransactionStatus t){
		ClientPOJO clientPOJO = new ClientPOJO ();
		
		clientPOJO.setIdCliente(t.getIdCliente());
		clientPOJO.setNombres(t.getNombres());		
		clientPOJO.setApellidos(t.getApellidos());
		clientPOJO.setTipoPersona(t.getTipoPersona());
		clientPOJO.setFechaAlta(t.getFechaAltaCliente().toString());
		
		return clientPOJO;
	}
	
	/* Transformador de un TransacctionRaw a un OperationPOJO*/
	public OperationPOJO transform2OperationPOJO(TransactionRaw t, String alertId){
		OperationPOJO transactionPOJO = new OperationPOJO ();
		
		transactionPOJO.setIdOperacion(t.getIdTransaccion());
		transactionPOJO.setFechaGen(t.getFechaOperacion().toString());
		transactionPOJO.setCuenta(t.getCuenta());
		transactionPOJO.setMonto(t.getMonto());
		transactionPOJO.setCr(t.getCrOp());
		transactionPOJO.setTipo(t.getTipoOperacion());
		transactionPOJO.setIdAlerta(alertId);	
		
		return transactionPOJO;
	}
	
	/*Transformador de un TransacctionStatus a un AlertPOJO*/
	public AlertPOJO transform2AlertPOJO(TransactionStatus t, String alertId){
		AlertPOJO alertPOJO = new AlertPOJO ();	
		
		alertPOJO.setIdAlerta(alertId);
		alertPOJO.setFechaGen((new Date()).toString());
		alertPOJO.setIdCliente(t.getIdCliente());
		alertPOJO.setCuenta(t.getCuenta());
		alertPOJO.setMotivo(t.getMessage());
		alertPOJO.setMontoAcumulado(String.valueOf(t.getMontoAcumulado()));
		alertPOJO.setEstatus(AlertStatusEnum.UNRESOLVED.name());
		return alertPOJO;
	}
	
	/*Transformador de un TransacctionStatus a un AccountPOJO*/
	public AccountPOJO transform2AccountPOJO(TransactionRaw t){
		AccountPOJO accountPOJO = new AccountPOJO ();			
		accountPOJO.setCuenta(t.getCuenta());
		accountPOJO.setIdCliente(t.getIdCliente());
		accountPOJO.setFechaGen(t.getFechaAltaCuenta().toString());
		accountPOJO.setCr(t.getCrCuenta());		
		accountPOJO.setEstatus(AccountStatusEnum.UNLOCK.name());
		return accountPOJO;
	}

	/*Transformador de un TransacctionRaw a un TransacctionRawPOJO*/
	public TransactionRawPOJO transform2TransactionRawPOJO(TransactionRaw t) {
		TransactionRawPOJO transactionRawPOJO= new TransactionRawPOJO ();
		
		transactionRawPOJO.setApellidos(t.getApellidos());
		transactionRawPOJO.setCrCuenta(t.getCrCuenta());
		transactionRawPOJO.setCrOp(t.getCrOp());
		transactionRawPOJO.setCuenta(t.getCuenta());
		transactionRawPOJO.setFechaAltaCliente(t.getFechaAltaCliente());
		transactionRawPOJO.setFechaAltaCuenta(t.getFechaAltaCuenta());
		transactionRawPOJO.setFechaOperacion(t.getFechaOperacion());
		transactionRawPOJO.setIdCliente(t.getIdCliente());
		transactionRawPOJO.setIdTransaccion(t.getIdTransaccion());
		transactionRawPOJO.setMonto(t.getMonto());
		//transactionRawPOJO.setMontoAcumulado(montoAcumulado);
		transactionRawPOJO.setNombres(t.getNombres());
		transactionRawPOJO.setProducto(t.getProducto());
		transactionRawPOJO.setTipoOperacion(t.getTipoOperacion());
		transactionRawPOJO.setTipoPersona(t.getTipoPersona());
				
		return transactionRawPOJO;
	}
}
