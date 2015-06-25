package mx.bbv.alerts.model.persistence;

import java.util.Date;

public class TransactionPOJO {
	
	private String idCliente; // IDENTIFICADOR ÚNICO CLIENTE
	private String idTransaccion; // IDENTIFICADOR ÚNICO DE LA TRANSACCIÓN
	private String cuenta; // NÚMERO DE CUENTA
	private Date fechaOperacion; // FECHA EXACTA TRANSACCIÓN
	private String tipoOperacion; // ABONO O RETIRO
	private Double monto; // MONTO DE LA OPERACION
	private String producto; // LIBRETONES, PRACTICAJAS, ETC
	private String sucursal; // ZONA GEOGRÁFICA DE LA SUCURSAL
	
	public TransactionPOJO() {
		super();
	}
	public TransactionPOJO(String idCliente, String idTransaccion,
			String cuenta, Date fechaOperacion, String tipoOperacion, 
			Double monto, String producto, String sucursal) {
		super();
		this.idCliente = idCliente;
		this.idTransaccion = idTransaccion;
		this.cuenta = cuenta;
		this.sucursal = sucursal;
		this.fechaOperacion = fechaOperacion;
		this.tipoOperacion = tipoOperacion;
		this.monto = monto;
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "TransactionPOJO [idCliente=" + idCliente + ", idTransaccion="
				+ idTransaccion + ", cuenta=" + cuenta + ", sucursalGestora="
				+ sucursal + ", fechaOperacion=" + fechaOperacion
				+ ", tipoOperacion=" + tipoOperacion + ", monto=" + monto
				+ ", producto=" + producto + "]";
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
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursalGestora) {
		this.sucursal = sucursalGestora;
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
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
}
