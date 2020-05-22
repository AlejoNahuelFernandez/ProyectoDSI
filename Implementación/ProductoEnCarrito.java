
package openshop;

public class ProductoEnCarrito 
{
    public Producto Producto;
    public int cantidad;
    
    public void ActualizarCantidad (int cant)
    {
        cantidad = cantidad + cant;
    }
}
