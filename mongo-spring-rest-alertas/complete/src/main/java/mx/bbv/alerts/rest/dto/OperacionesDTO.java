package mx.bbv.alerts.rest.dto;

public class OperacionesDTO {
	private String idOperacion;
	private String fechaGen;
	private String cuenta;
	private String monto;
	private String crOp;
	private String tipo;
	private String idAlerta;
	@Override
	public String toString() {
		return "Operaciones [idOperacion=" + idOperacion + ", fechaGen="
				+ fechaGen + ", cuenta=" + cuenta + ", monto=" + monto
				+ ", crOp=" + crOp + ", tipo=" + tipo + ", idAlerta="
				+ idAlerta + "]";
	}
	public OperacionesDTO(String idOperacion, String fechaGen, String cuenta,
			String monto, String crOp, String tipo, String idAlerta) {
		super();
		this.idOperacion = idOperacion;
		this.fechaGen = fechaGen;
		this.cuenta = cuenta;
		this.monto = monto;
		this.crOp = crOp;
		this.tipo = tipo;
		this.idAlerta = idAlerta;
	}
	public OperacionesDTO() {
		super();
	}
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getFechaGen() {
		return fechaGen;
	}
	public void setFechaGen(String fechaGen) {
		this.fechaGen = fechaGen;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getCrOp() {
		return crOp;
	}
	public void setCrOp(String crOp) {
		this.crOp = crOp;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIdAlerta() {
		return idAlerta;
	}
	public void setIdAlerta(String idAlerta) {
		this.idAlerta = idAlerta;
	}
}
