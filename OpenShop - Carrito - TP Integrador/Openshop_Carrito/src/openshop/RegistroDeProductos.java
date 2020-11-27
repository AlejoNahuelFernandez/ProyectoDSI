package openshop;

import java.util.ArrayList;

public class RegistroDeProductos 
{
	public ArrayList<Producto>productos = new ArrayList<>();
	
	public RegistroDeProductos() {}
	
	public ArrayList<String>Categorias()
	{
		ArrayList<String>categorias = new ArrayList<>();
		categorias.add(productos.get(0).getNombreCategoria());
		
		for (Producto producto: productos)
		{
			if(!(categorias.contains(producto.getNombreCategoria())))
			{
				categorias.add(producto.getNombreCategoria());
			}
		}
		
		return categorias;
	}
	
	public ArrayList<String>TiposDeProducto()
	{
		ArrayList<String>tiposDeProducto = new ArrayList<>();
		tiposDeProducto.add(productos.get(0).getNombreTipoProducto());
		
		for (Producto producto: productos)
		{
			if(!(tiposDeProducto.contains(producto.getNombreTipoProducto())))
			{
				tiposDeProducto.add(producto.getNombreTipoProducto());
			}
		}
		
		return tiposDeProducto;
	}
	
	public boolean ExisteProductoSeleccionado(int idProductoSeleccionado)
	{
		boolean resultado = false;
		for (Producto producto: productos)
		{
			if (idProductoSeleccionado == producto.getId())
			{
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public Producto ProductoSeleccionado(int idProductoSeleccionado)
	{
		Producto productoSeleccionado = new Producto();
		for (Producto producto: productos)
		{
			if (idProductoSeleccionado == producto.getId())
			{
				productoSeleccionado = producto;
			}
		}
		
		return productoSeleccionado;
	}
}
