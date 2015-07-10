package mx.bbv.alerts.rest.model;

public class Relevantes {
	private String	idOperacion;
	private String	folio;
	private String	clasificacion;
	@Override
	public String toString() {
		return "Relevantes [idOperacion=" + idOperacion + ", folio=" + folio
				+ ", clasificacion=" + clasificacion + "]";
	}
	public Relevantes(String idOperacion, String folio, String clasificacion) {
		super();
		this.idOperacion = idOperacion;
		this.folio = folio;
		this.clasificacion = clasificacion;
	}
	public Relevantes() {
		super();
	}
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
}
