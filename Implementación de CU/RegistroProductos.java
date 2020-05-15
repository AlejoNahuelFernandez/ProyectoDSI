
package openshop;
import java.util.ArrayList;

public class RegistroProductos 
{
    public static ArrayList<Producto>Productos = new ArrayList();
    
    public static void MostrarProductos()
    {
        System.out.println("Productos: ");
        for (Producto producto: Productos)
        {
            System.out.println("-" + producto.getNombre() + " $" + producto.getPrecio() + " (" + producto.getCantidad() + " disponibles)");
	}
     }
}
