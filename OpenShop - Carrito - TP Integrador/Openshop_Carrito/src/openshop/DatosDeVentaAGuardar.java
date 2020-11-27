package openshop;

import java.util.ArrayList;
import java.util.Date;

public class DatosDeVentaAGuardar 
{
	private String nombreDeCliente;
	private String apellido;
	private String email;
	private int DNI;
	private String domicilio;
	private String provincia;
	private Date fechaVenta;
	private double monto;
	
	private ArrayList<ItemCarrito>productos = new ArrayList<>();
	
	public String getNombreDeCliente() {
		return nombreDeCliente;
	}
	public void setNombreDeCliente(String nombreDeCliente) {
		this.nombreDeCliente = nombreDeCliente;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
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
		return productos;
	}
	public void setProductosVendidos(ArrayList<ItemCarrito> productosVendidos) {
		this.productos = productosVendidos;
	}
	
	public DatosDeVentaAGuardar(Venta venta)
	{
		nombreDeCliente = venta.getCliente().getNombre();
		apellido = venta.getCliente().getApellido();
		email = venta.getCliente().getMail();
		DNI = venta.getCliente().getDni();
		domicilio = venta.getCliente().getDomicilio();
		provincia = venta.getCliente().getProvincia();
		fechaVenta = venta.getFechaVenta();
		monto = venta.getMonto();
		productos = venta.productosVendidos;
	}
}
