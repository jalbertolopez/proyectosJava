package mx.bbv.alerts.rest.dto;

public class CrInfoDTO {
	private String idCr;
	private String nomSucursal;
	private String cenSup;
	private String division;
	private String estado;
	@Override
	public String toString() {
		return "CrInfoDTO [idCr=" + idCr + ", nomSucursal=" + nomSucursal
				+ ", cenSup=" + cenSup + ", division=" + division + ", estado="
				+ estado + "]";
	}
	public CrInfoDTO(String idCr, String nomSucursal, String cenSup,
			String division, String estado) {
		super();
		this.idCr = idCr;
		this.nomSucursal = nomSucursal;
		this.cenSup = cenSup;
		this.division = division;
		this.estado = estado;
	}
	public CrInfoDTO() {
		super();
	}
	public String getIdCr() {
		return idCr;
	}
	public void setIdCr(String idCr) {
		this.idCr = idCr;
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
