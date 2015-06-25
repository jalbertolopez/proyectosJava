package mx.bbv.alerts.transforms;

import java.util.Date;

import org.springframework.stereotype.Component;

import mx.bbv.alerts.catalogs.ClientStatusEnum;
import mx.bbv.alerts.model.TransactionRaw;
import mx.bbv.alerts.model.TransactionStatus;
import mx.bbv.alerts.model.persistence.AlertPOJO;
import mx.bbv.alerts.model.persistence.ClientPOJO;
import mx.bbv.alerts.model.persistence.TransactionPOJO;
import mx.bbv.alerts.model.persistence.TransactionRawPOJO;

@Component
public class Transform2POJO {
	
	public ClientPOJO transform2ClientPOJO(TransactionStatus t){
		ClientPOJO clientPOJO = new ClientPOJO ();
		
		clientPOJO.setAltaCuenta(t.getAltaCuenta());
		clientPOJO.setApellidos(t.getApellidos());
		clientPOJO.setIdCliente(t.getIdCliente());
		clientPOJO.setNombres(t.getNombres());
		clientPOJO.setTipoPersona(t.getTipoPersona());
		clientPOJO.setSucursalGestora(t.getSucursalGestora());
		
		clientPOJO.setMontoAcumulado(t.getMontoAcumulado());
		clientPOJO.setEstatus(ClientStatusEnum.UNLOCK.toInt());
		
		return clientPOJO;
	}
	
	public TransactionPOJO transform2TransactionPOJO(TransactionRaw t){
		TransactionPOJO transactionPOJO = new TransactionPOJO ();
		
		transactionPOJO.setCuenta(t.getCuenta());
		transactionPOJO.setFechaOperacion(t.getFechaOperacion());
		transactionPOJO.setIdCliente(t.getIdCliente());
		transactionPOJO.setIdTransaccion(t.getIdTransaccion());
		transactionPOJO.setMonto(t.getMonto());
		transactionPOJO.setProducto(t.getProducto());
		transactionPOJO.setSucursal(t.getSucursal());
		transactionPOJO.setTipoOperacion(t.getTipoOperacion());
		
		return transactionPOJO;
	}

	public TransactionRawPOJO transform2TransactionRawPOJO(TransactionRaw t) {
		TransactionRawPOJO transactionRawPOJO= new TransactionRawPOJO ();
		
		transactionRawPOJO.setAltaCuenta(t.getAltaCuenta());
		transactionRawPOJO.setApellidos(t.getApellidos());
		transactionRawPOJO.setCuenta(t.getCuenta());
		transactionRawPOJO.setSucursalGestora(t.getSucursalGestora());
		transactionRawPOJO.setIdCliente(t.getIdCliente());
		transactionRawPOJO.setNombres(t.getNombres());
		transactionRawPOJO.setTipoPersona(t.getTipoPersona());
		
		transactionRawPOJO.setFechaOperacion(t.getFechaOperacion());
		transactionRawPOJO.setIdTransaccion(t.getIdTransaccion());
		transactionRawPOJO.setMonto(t.getMonto());
		transactionRawPOJO.setProducto(t.getProducto());
		transactionRawPOJO.setSucursal(t.getSucursal());
		transactionRawPOJO.setTipoOperacion(t.getTipoOperacion());
		
		return transactionRawPOJO;
	}
	
	public AlertPOJO transform2AlertPOJO(TransactionStatus t){
		AlertPOJO alertPOJO = new AlertPOJO ();	
		
		alertPOJO.setIdCliente(t.getIdCliente());
		alertPOJO.setMensaje(t.getMessage());
		alertPOJO.setFecha(new Date());
		
		return alertPOJO;
	}
}
