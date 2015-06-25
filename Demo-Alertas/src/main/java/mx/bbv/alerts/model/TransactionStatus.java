package mx.bbv.alerts.model;

import mx.bbv.alerts.catalogs.TransactionStatusEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionStatus extends TransactionRaw {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double montoAcumulado;
	private Logger logger = LoggerFactory.getLogger(TransactionStatus.class);
	private String message = "";
	private int status = TransactionStatusEnum.OK.toInt();
	
	public TransactionStatus() {
		super();
	}



	@Override
	public String toString() {
		return "TransactionStatus [ idCliente=" + this.getIdCliente() +", nombres=" + this.getNombres() 
				+ ", montoAcumulado=" + montoAcumulado
				+ ", message=" + message + ", status="
				+ TransactionStatusEnum.fromInt(status).name() + "]";
	}



	public TransactionStatus(Double montoAcumulado) {
		super();
		this.montoAcumulado = montoAcumulado;
	}

	public Double getMontoAcumulado() {
		return montoAcumulado;
	}

	public void setMontoAcumulado(Double montoAcumulado) {
		this.montoAcumulado = montoAcumulado;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void triggerAlert(String message) {
		logger.info("\n**********************************************************"
					+ "\n**** USUARIO : {} [{}] ****"
					+ "\n***********************************************************",
					this.getIdCliente(),message);
		
		this.message = message;	
	}
}
