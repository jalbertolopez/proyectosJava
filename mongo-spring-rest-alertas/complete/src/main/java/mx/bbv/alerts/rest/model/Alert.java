package mx.bbv.alerts.rest.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="alerts")
public class Alert {	
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private String mensaje; // Mensaje de la alerta 
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date fecha; // FECHA DE GENERACIÓN DE LA ALERTA
	
	public Alert() {
		super();
	}

	public Alert(String idCliente, String mensaje, Date fecha) {
		super();
		this.idCliente = idCliente;
		this.mensaje = mensaje;
		this.fecha = fecha;
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
