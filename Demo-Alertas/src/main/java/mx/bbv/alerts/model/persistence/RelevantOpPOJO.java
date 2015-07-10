package mx.bbv.alerts.model.persistence;

public class RelevantOpPOJO {
	private String	idOperacion;
	private String	folio;
	private String	clasificacion;
	@Override
	public String toString() {
		return "Relevantes [idOperacion=" + idOperacion + ", folio=" + folio
				+ ", clasificacion=" + clasificacion + "]";
	}
	public RelevantOpPOJO(String idOperacion, String folio, String clasificacion) {
		super();
		this.idOperacion = idOperacion;
		this.folio = folio;
		this.clasificacion = clasificacion;
	}
	public RelevantOpPOJO() {
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
