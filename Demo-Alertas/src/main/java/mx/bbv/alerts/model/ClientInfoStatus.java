package mx.bbv.alerts.model;

public class ClientInfoStatus {
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private Double montoAcumulado;
	
	
	@Override
	public String toString() {
		return "ClientInfoStatus [idCliente=" + idCliente + ", montoAcumulado="
				+ montoAcumulado + "]";
	}

	public ClientInfoStatus() {
		super();
	}

	public ClientInfoStatus(String idCliente, Double montoAcumulado) {
		super();
		this.idCliente = idCliente;
		this.montoAcumulado = montoAcumulado;
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
}
