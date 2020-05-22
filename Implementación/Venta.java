
package openshop;
import java.util.ArrayList;

public class Venta 
{
    private static Carrito carrito;
    private MedioDePago medioDePago;
    
    public Venta (ArrayList<ProductoEnCarrito>listaCarrito ,MedioDePago medio)
    {
        Carrito carrito = new Carrito();
        this.medioDePago = medio;
        
        //for (ProductoEnCarrito producto: listaCarrito)
        //{
            //carrito.AgregarAlCarrito(producto.Producto,producto.cantidad);
        //}
    }
    
    public Carrito getCarrito()
    {
        return carrito;
    }
    
    public MedioDePago getPago()
    {
        return medioDePago;
    }
}
