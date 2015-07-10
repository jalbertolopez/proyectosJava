package mx.bbv.alerts.rest.dto;

public class CuentasDTO {
	private String idCuenta;
	private String idCliente;
	private String fechaGen;
	private String crGestor;
	private String nomSucursal;
	private String cenSup;
	private String division;
	private String estado;
	@Override
	public String toString() {
		return "CuentasDTO [idCuenta=" + idCuenta + ", idCliente=" + idCliente
				+ ", fechaGen=" + fechaGen + ", crGestor=" + crGestor
				+ ", nomSucursal=" + nomSucursal + ", cenSup=" + cenSup
				+ ", division=" + division + ", estado=" + estado + "]";
	}
	public CuentasDTO(String idCuenta, String idCliente, String fechaGen,
			String crGestor, String nomSucursal, String cenSup,
			String division, String estado) {
		super();
		this.idCuenta = idCuenta;
		this.idCliente = idCliente;
		this.fechaGen = fechaGen;
		this.crGestor = crGestor;
		this.nomSucursal = nomSucursal;
		this.cenSup = cenSup;
		this.division = division;
		this.estado = estado;
	}
	public CuentasDTO() {
		super();
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
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
	public String getCrGestor() {
		return crGestor;
	}
	public void setCrGestor(String crGestor) {
		this.crGestor = crGestor;
	}
	public String getNomSucursal() {
		return nomSucursal;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getCenSup() {
		return cenSup;
	}
	public void setCenSup(String cenSup) {
		this.cenSup = cenSup;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
