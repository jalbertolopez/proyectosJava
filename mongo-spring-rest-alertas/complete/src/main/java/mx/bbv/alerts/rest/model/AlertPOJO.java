package mx.bbv.alerts.rest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="alerts")
public class AlertPOJO {

	private String idAlerta; // IDENTIFICADOR ÚNICO ALERTA
	private String fechaGen; // FECHA DE GENERACIÓN DE LA ALERTA
	private String idCliente; // IDENTIFICADOR DEL CLIENTE ASOCIADO 
	private String cuenta; // CUENTA ASOCIADA A LA ALERTA
	private String motivo; // MOTIVO POR EL QUE LA ALERTA FUE DISPARADA
	private String montoAcumulado; //MONTO ACUMULADO DE LAS OPERACIONES
	private String estatus; // ESTADO ACTUAL DE LA ALERTA
	
	@Override
	public String toString() {
		return "AlertDAO [idAlerta=" + idAlerta + ", fechaGen=" + fechaGen
				+ ", idCliente=" + idCliente + ", cuenta=" + cuenta
				+ ", motivo=" + motivo + ", montoAcumulado=" + montoAcumulado
				+ ", estatus=" + estatus + "]";
	}

	
	public AlertPOJO() {
		super();
	}

	public AlertPOJO(String idAlerta, String fechaGen, String idCliente,
			String cuenta, String motivo, String montoAcumulado, String estatus) {
		super();
		this.idAlerta = idAlerta;
		this.fechaGen = fechaGen;
		this.idCliente = idCliente;
		this.cuenta = cuenta;
		this.motivo = motivo;
		this.montoAcumulado = montoAcumulado;
		this.estatus = estatus;
	}



	public String getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(String idAlerta) {
		this.idAlerta = idAlerta;
	}

	public String getFechaGen() {
		return fechaGen;
	}

	public void setFechaGen(String fechaGen) {
		this.fechaGen = fechaGen;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMontoAcumulado() {
		return montoAcumulado;
	}

	public void setMontoAcumulado(String montoAcumulado) {
		this.montoAcumulado = montoAcumulado;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
