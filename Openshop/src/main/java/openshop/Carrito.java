
package openshop;
import java.util.ArrayList;

public class Carrito 
{
    private double precioTotal;
    private ArrayList<ProductoEnCarrito>productos;
    
    
    public Carrito()
    {
        productos=new ArrayList<ProductoEnCarrito>();
    }
    
    public void AgregarAlCarrito(Producto producto, int cantidad)
    {   
       
       int s=0;
       for (int i=0;i<productos.size();i++)
       {
           if (productos.get(i).Producto == producto)
           {
               productos.get(i).ActualizarCantidad(cantidad);
               s=1;
           }
       }
       if (s==0)
       {
           ProductoEnCarrito prodEnCarrito = new ProductoEnCarrito(); 
           prodEnCarrito.Producto = producto;
           prodEnCarrito.cantidad = cantidad;
           productos.add(prodEnCarrito);
       }
     producto.ActualizarStock(cantidad);
     
    }
    
    public void MostrarCarrito()
    {
        precioTotal=0;
        System.out.println("Carrito de compras: ");
        for (ProductoEnCarrito productoenCarrito: productos)
        {
           System.out.println (productoenCarrito.cantidad + "x " +productoenCarrito.Producto.getNombre() + " " +productoenCarrito.Producto.getMarca() +" $" + productoenCarrito.Producto.getPrecio());
           precioTotal= precioTotal + ((productoenCarrito.cantidad)*productoenCarrito.Producto.getPrecio());
        }
        System.out.println("Precio total: $" +precioTotal);
    }
    
    public ArrayList<ProductoEnCarrito>obtenerLista()
    {
        return productos;
    }
    public void VaciarCarrito()
    {
        productos.clear();
    }
    
 }

