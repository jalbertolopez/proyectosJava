package mx.bbv.alerts.model.persistence;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class AlertPOJO {	
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private String mensaje; // Mensaje de la alerta 
	private Date fecha; // FECHA DE GENERACIÓN DE LA ALERTA
	
	public AlertPOJO() {
		super();
	}

	@Override
	public String toString() {
		return "AlertPOJO [idCliente=" + idCliente + ", mensaje=" + mensaje
				+ ", fecha=" + fecha + "]";
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
