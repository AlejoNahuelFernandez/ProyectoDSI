package openshop;

public class ItemCarrito 
{
	public Producto producto;
	public int cantidad;
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	
	public ItemCarrito() {}
	
	public void AumentarCantidad(int cantidadAgregada)
	{
		cantidad = cantidad + cantidadAgregada;
	}
	
	public void ModificarCantidad(int nuevaCantidad)
	{
		cantidad = nuevaCantidad;
	}
}
