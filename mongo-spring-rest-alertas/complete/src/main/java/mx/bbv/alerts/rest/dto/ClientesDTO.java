package mx.bbv.alerts.rest.dto;

public class ClientesDTO {
	private String idCliente; 
	private String nombres;
	private String apellidos;
	private String tipoPersona;
	private String fechaAlta;
	@Override
	public String toString() {
		return "clientes [idCliente=" + idCliente + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", tipoPersona=" + tipoPersona
				+ ", fechaAlta=" + fechaAlta + "]";
	}
	public ClientesDTO(String idCliente, String nombres, String apellidos,
			String tipoPersona, String fechaAlta) {
		super();
		this.idCliente = idCliente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoPersona = tipoPersona;
		this.fechaAlta = fechaAlta;
	}
	public ClientesDTO() {
		super();
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
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
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
