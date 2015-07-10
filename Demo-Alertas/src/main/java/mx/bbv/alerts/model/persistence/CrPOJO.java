package mx.bbv.alerts.model.persistence;

public class CrPOJO {
	private String cr;
	private String nomSucursal;
	private String cenSup;
	private String division;
	private String estado;
	@Override
	public String toString() {
		return "CentroResponsable [cr=" + cr + ", nomSucursal=" + nomSucursal
				+ ", cenSup=" + cenSup + ", division=" + division + ", estado="
				+ estado + "]";
	}
	public CrPOJO(String cr, String nomSucursal, String cenSup,
			String division, String estado) {
		super();
		this.cr = cr;
		this.nomSucursal = nomSucursal;
		this.cenSup = cenSup;
		this.division = division;
		this.estado = estado;
	}
	public CrPOJO() {
		super();
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
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
