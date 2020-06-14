
package openshop;

public class ItemVenta 
{
    Producto producto;
    public int cantidad;
    public double precio;
    
    public ItemVenta(Producto producto,int cantidad,double precio)
    {
        this.producto=producto;
        this.cantidad=cantidad;
        this.precio=precio;
    }
}
