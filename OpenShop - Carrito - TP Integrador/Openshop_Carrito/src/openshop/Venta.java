package openshop;

import java.util.ArrayList;
import java.util.Date;

public class Venta 
{
	private Cliente cliente;
	private Date fechaVenta;
	private double monto;
	public ArrayList<ItemCarrito>productosVendidos;
	
	public Venta() {}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getFechaVenta() {
		return fechaVenta;
	}
	
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public ArrayList<ItemCarrito> getProductosVendidos() {
		return productosVendidos;
	}
	
	public void setProductosVendidos(ArrayList<ItemCarrito> productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
}
