package mx.bbv.alerts.rest.dto;

public class OperacionesRelevantesDTO {
	private String idCuenta;
	private String fechaGen;
	private String folio;
	private String tipo;
	private String oficina;
	private String idOperacion;
	private String clasificacion;
	private String monto;
	@Override
	public String toString() {
		return "OperacionesRelevantesDTO [idCuenta=" + idCuenta + ", fechaGen="
				+ fechaGen + ", folio=" + folio + ", tipo=" + tipo
				+ ", oficina=" + oficina + ", idOperacion=" + idOperacion
				+ ", clasificacion=" + clasificacion + ", monto=" + monto + "]";
	}
	public OperacionesRelevantesDTO(String idCuenta, String fechaGen,
			String folio, String tipo, String oficina, String idOperacion,
			String clasificacion, String monto) {
		super();
		this.idCuenta = idCuenta;
		this.fechaGen = fechaGen;
		this.folio = folio;
		this.tipo = tipo;
		this.oficina = oficina;
		this.idOperacion = idOperacion;
		this.clasificacion = clasificacion;
		this.monto = monto;
	}
	public OperacionesRelevantesDTO() {
		super();
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getFechaGen() {
		return fechaGen;
	}
	public void setFechaGen(String fechaGen) {
		this.fechaGen = fechaGen;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
}
