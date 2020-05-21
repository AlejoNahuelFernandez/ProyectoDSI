
package openshop;
import java.util.ArrayList;

public class RegistroProductos 
{
    public static ArrayList<Producto>Productos = new ArrayList();
    
    public static void MostrarProductos()
    {
        System.out.println("Productos: ");
        int pos=1;
        for (Producto producto: Productos)
        {
            System.out.println(pos + "-" + producto.getNombre() + " " + producto.getMarca() + " $" + producto.getPrecio() + " (" + producto.getCantidad() + " disponibles)");
            pos++;
	}
     }
}
