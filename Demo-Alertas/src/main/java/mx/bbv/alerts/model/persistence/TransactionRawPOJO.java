package mx.bbv.alerts.model.persistence;

import java.util.Date;

public class TransactionRawPOJO{

	private String nombres;
	private String apellidos;
	private String tipoPersona; // FISICA o MORAL
	private String sucursalGestora; // ZONA GEOGRÁFICA DE LA SUCURSAL DONDE SE ABRIO LA CUENTA
	private Date altaCuenta; // FECHA DE APERTURA DE LA CUENTA
	private Date fechaOperacion; // FECHA EXACTA TRANSACCIÓN
	private String tipoOperacion; // ABONO O RETIRO
	private Double monto; // MONTO DE LA OPERACION
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private String idTransaccion; // IDENTIFICADOR ÚNICO DE LA TRANSACCIÓN
	private String cuenta; // NÚMERO DE CUENTA
	private String producto; // LIBRETONES, PRACTICAJAS, ETC
	private String sucursal; // ZONA GEOGRÁFICA DE LA SUCURSAL DE LA TRANSACCIÓN
	
	public TransactionRawPOJO(String nombres, String apellidos,
			String tipoPersona, String sucursalGestora, Date altaCuenta,
			Date fechaOperacion, String tipoOperacion, Double monto,
			String idCliente, String idTransaccion, String cuenta,
			String producto, String sucursal) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoPersona = tipoPersona;
		this.sucursalGestora = sucursalGestora;
		this.altaCuenta = altaCuenta;
		this.fechaOperacion = fechaOperacion;
		this.tipoOperacion = tipoOperacion;
		this.monto = monto;
		this.idCliente = idCliente;
		this.idTransaccion = idTransaccion;
		this.cuenta = cuenta;
		this.producto = producto;
		this.sucursal = sucursal;
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
	public String getSucursalGestora() {
		return sucursalGestora;
	}
	public void setSucursalGestora(String sucursalGestora) {
		this.sucursalGestora = sucursalGestora;
	}
	public Date getAltaCuenta() {
		return altaCuenta;
	}
	public void setAltaCuenta(Date altaCuenta) {
		this.altaCuenta = altaCuenta;
	}
	public Date getFechaOperacion() {
		return fechaOperacion;
	}
	public void setFechaOperacion(Date fechaOperacion) {
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
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
}