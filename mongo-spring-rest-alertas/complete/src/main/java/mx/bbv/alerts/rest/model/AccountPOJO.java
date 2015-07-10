package mx.bbv.alerts.rest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="accounts")
public class AccountPOJO {
	private String cuenta;
	private String idCliente;
	private String fechaGen;
	private String cr;
	private String estatus;
	@Override
	public String toString() {
		return "AccountPOJO [cuenta=" + cuenta + ", idCliente=" + idCliente
				+ ", fechaGen=" + fechaGen + ", cr=" + cr + ", estatus="
				+ estatus + "]";
	}
	public AccountPOJO(String idCuenta, String idCliente, String fechaGen,
			String cr, String estatus) {
		super();
		this.cuenta = idCuenta;
		this.idCliente = idCliente;
		this.fechaGen = fechaGen;
		this.cr = cr;
		this.estatus = estatus;
	}
	public AccountPOJO() {
		super();
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String idCuenta) {
		this.cuenta = idCuenta;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getFechaGen() {
		return fechaGen;
	}
	public void setFechaGen(String fechaGen) {
		this.fechaGen = fechaGen;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}
