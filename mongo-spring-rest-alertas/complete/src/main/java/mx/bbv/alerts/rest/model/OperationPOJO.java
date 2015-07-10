package mx.bbv.alerts.rest.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="transactions")
public class OperationPOJO {
	
	private String idOperacion; // IDENTIFICADOR ÚNICO DE LA OPERACIÓN
	private String fechaGen; // FECHA DE LA OPERACIÓN 
	private String cuenta;	// CUENTA RELACIONADA A LA OPERACIÓN
	private Double monto;	// MONTO DE LA OPERACIÓN
	private String cr;	// CENTRO RESPONSABLE DONDE SE REALIZÓ LA OPERACIÓN
	private String tipo;	// TIPO DE OPERACIÓN (CARGO O ABONO)
	private String idAlerta;	// IDENTIFICADOR DE LA ALERTA A LA QUE PERTENECE LA OPERACIÓN
	
	@Override
	public String toString() {
		return "TransactionDAO [idOperacion=" + idOperacion + ", fechaGen="
				+ fechaGen + ", cuenta=" + cuenta + ", monto=" + monto
				+ ", cr=" + cr + ", tipo=" + tipo + ", idAlerta=" + idAlerta
				+ "]";
	}
	public OperationPOJO(String idOperacion, String fechaGen, String cuenta,
			Double monto, String cr, String tipo, String idAlerta) {
		super();
		this.idOperacion = idOperacion;
		this.fechaGen = fechaGen;
		this.cuenta = cuenta;
		this.monto = monto;
		this.cr = cr;
		this.tipo = tipo;
		this.idAlerta = idAlerta;
	}
	public OperationPOJO() {
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
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
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
