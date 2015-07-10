package mx.bbv.alerts.model.persistence;

import java.util.Date;

public class TransactionRawPOJO{

	
	private String nombres;
	private String apellidos;
	private String tipoPersona; // FISICA o MORAL
	private String fechaAltaCliente; // FECHA DE ALTA CLIENTE
	private String fechaAltaCuenta; // FECHA DE APERTURA DE LA CUENTA
	private String fechaOperacion; // FECHA EXACTA TRANSACCIÓN
	private String tipoOperacion; // ABONO O RETIRO
	private Double monto; // MONTO DE LA OPERACION
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private String idTransaccion; // IDENTIFICADOR ÚNICO DE LA TRANSACCIÓN
	private String cuenta; // NÚMERO DE CUENTA
	private String producto; // LIBRETONES, PRACTICAJAS, ETC
	private String crOp; // CR OPERACIÓN
	private String crCuenta; // CR de la cuenta
	private Double montoAcumulado; // MONTO ACUMULADO POR CUENTA
	@Override
	public String toString() {
		return "TransactionRawPOJO [nombres=" + nombres + ", apellidos="
				+ apellidos + ", tipoPersona=" + tipoPersona
				+ ", fechaAltaCliente=" + fechaAltaCliente
				+ ", fechaAltaCuenta=" + fechaAltaCuenta + ", fechaOperacion="
				+ fechaOperacion + ", tipoOperacion=" + tipoOperacion
				+ ", monto=" + monto + ", idCliente=" + idCliente
				+ ", idTransaccion=" + idTransaccion + ", cuenta=" + cuenta
				+ ", producto=" + producto + ", crOp=" + crOp + ", crCuenta="
				+ crCuenta + ", montoAcumulado=" + montoAcumulado + "]";
	}
	public TransactionRawPOJO(String nombres, String apellidos,
			String tipoPersona, String fechaAltaCliente, String fechaAltaCuenta,
			String fechaOperacion, String tipoOperacion, Double monto,
			String idCliente, String idTransaccion, String cuenta,
			String producto, String crOp, String crCuenta, Double montoAcumulado) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoPersona = tipoPersona;
		this.fechaAltaCliente = fechaAltaCliente;
		this.fechaAltaCuenta = fechaAltaCuenta;
		this.fechaOperacion = fechaOperacion;
		this.tipoOperacion = tipoOperacion;
		this.monto = monto;
		this.idCliente = idCliente;
		this.idTransaccion = idTransaccion;
		this.cuenta = cuenta;
		this.producto = producto;
		this.crOp = crOp;
		this.crCuenta = crCuenta;
		this.montoAcumulado = montoAcumulado;
	}
	public TransactionRawPOJO() {
		super();
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
	public String getFechaAltaCliente() {
		return fechaAltaCliente;
	}
	public void setFechaAltaCliente(String fechaAltaCliente) {
		this.fechaAltaCliente = fechaAltaCliente;
	}
	public String getFechaAltaCuenta() {
		return fechaAltaCuenta;
	}
	public void setFechaAltaCuenta(String fechaAltaCuenta) {
		this.fechaAltaCuenta = fechaAltaCuenta;
	}
	public String getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getCrOp() {
		return crOp;
	}
	public void setCrOp(String crOp) {
		this.crOp = crOp;
	}
	public String getCrCuenta() {
		return crCuenta;
	}
	public void setCrCuenta(String crCuenta) {
		this.crCuenta = crCuenta;
	}
	public Double getMontoAcumulado() {
		return montoAcumulado;
	}
	public void setMontoAcumulado(Double montoAcumulado) {
		this.montoAcumulado = montoAcumulado;
	}
}