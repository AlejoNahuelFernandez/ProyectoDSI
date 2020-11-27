package openshop;

import java.util.ArrayList;

public class Carrito 
{
	public ArrayList<ItemCarrito>productosAgregados = new ArrayList<>();
	
	public Carrito() {}
	
	public void AgregarProducto(Producto productoSeleccionado, int cantidad)
	{
		
		if (!(ProductoYaFueAgregado(productoSeleccionado)))
		{
			ItemCarrito itemCarrito = new ItemCarrito();
			itemCarrito.producto = productoSeleccionado;
			itemCarrito.cantidad = cantidad;
			productosAgregados.add(itemCarrito);
		}
		else
		{
			for (ItemCarrito item: productosAgregados)
			{
				if (item.producto == productoSeleccionado)
				{
					item.AumentarCantidad(cantidad);
				}
			}
		}
	}
	
	
	private boolean ProductoYaFueAgregado(Producto productoSeleccionado)
	{
		boolean resultado = false;
		for (ItemCarrito itemCarrito: productosAgregados)
		{
			if (itemCarrito.producto == productoSeleccionado)
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public void EliminarItem(int idProducto)
	{
		ItemCarrito itemAEliminar = null;
		for (ItemCarrito itemCarrito: productosAgregados)
		{
			if (idProducto == itemCarrito.producto.getId())
			{
				itemAEliminar = itemCarrito;
			}
		}
		
		productosAgregados.remove(itemAEliminar);
	}
	
	public double MontoDeLaCompra()
	{
		double montoTotal = 0;
		for (ItemCarrito itemCarrito: productosAgregados)
		{
			montoTotal = montoTotal + (itemCarrito.producto.getPrecio()*itemCarrito.cantidad);
		}
		
		return montoTotal;
	}
	
	public void VaciarCarrito()
	{
		productosAgregados.clear();
	}
	
	
}
