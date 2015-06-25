package mx.bbv.alerts.model.persistence;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class ClientPOJO {	
	private String nombres;
	private String apellidos;
	private String tipoPersona; // FISICA o MORAL
	private String sucursalGestora; // ZONA GEOGRÁFICA DE LA SUCURSAL DONDE SE ABRIO LA CUENTA
	private Date altaCuenta; // FECHA DE APERTURA DE LA CUENTA
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private Double montoAcumulado; // MONTO ACUMULADO DE SUS CUENTAS
	private int estatus;	// INDICA SI EL CLIENTE YA FUÉ BLOQUEADO
	
	
	public ClientPOJO() {
		super();
	}


	public ClientPOJO(String nombres, String apellidos, String tipoPersona,
			String sucursalGestora, Date altaCuenta, String idCliente,
			Double montoAcumulado, int estatus) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoPersona = tipoPersona;
		this.sucursalGestora = sucursalGestora;
		this.altaCuenta = altaCuenta;
		this.idCliente = idCliente;
		this.montoAcumulado = montoAcumulado;
		this.estatus = estatus;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getTipoPersona() {
		return tipoPersona;
	}


	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}


	public String getSucursalGestora() {
		return sucursalGestora;
	}


	public void setSucursalGestora(String sucursalGestora) {
		this.sucursalGestora = sucursalGestora;
	}


	public Date getAltaCuenta() {
		return altaCuenta;
	}


	public void setAltaCuenta(Date altaCuenta) {
		this.altaCuenta = altaCuenta;
	}


	public String getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Double getMontoAcumulado() {
		return montoAcumulado;
	}


	public void setMontoAcumulado(Double montoAcumulado) {
		this.montoAcumulado = montoAcumulado;
	}


	public int getEstatus() {
		return estatus;
	}


	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}	
}
