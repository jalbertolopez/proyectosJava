package mx.bbv.alerts.rest.dto;

public class AlertasDTO {
	private String idAlerta;
	private String fechaGen;
	private String idCliente;
	private String cuenta;
	private String motivo;
	private String montoAcumulado;
	private String estatus;
	private boolean relevante;
	private String noOperaciones;
	@Override
	public String toString() {
		return "alertas [idAlerta=" + idAlerta + ", fechaGen=" + fechaGen
				+ ", idCliente=" + idCliente + ", cuenta=" + cuenta
				+ ", motivo=" + motivo + ", montoAcumulado=" + montoAcumulado
				+ ", estatus=" + estatus + ", relevante=" + relevante
				+ ", noOperaciones=" + noOperaciones + "]";
	}
	public AlertasDTO(String idAlerta, String fechaGen, String idCliente,
			String cuenta, String motivo, String montoAcumulado,
			String estatus, boolean relevante, String noOperaciones) {
		super();
		this.idAlerta = idAlerta;
		this.fechaGen = fechaGen;
		this.idCliente = idCliente;
		this.cuenta = cuenta;
		this.motivo = motivo;
		this.montoAcumulado = montoAcumulado;
		this.estatus = estatus;
		this.relevante = relevante;
		this.noOperaciones = noOperaciones;
	}
	public AlertasDTO() {
		super();
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
	public boolean getRelevante() {
		return relevante;
	}
	public void setRelevante(boolean relevante) {
		this.relevante = relevante;
	}
	public String getNoOperaciones() {
		return noOperaciones;
	}
	public void setNoOperaciones(String noOperaciones) {
		this.noOperaciones = noOperaciones;
	}
}
