
package openshop;
import java.util.ArrayList;
import java.util.Date;

public class Venta 
{
    private ArrayList<ItemVenta>productosVendidos;
    private String fecha;
    private MedioDePago medioDePago;
    
    public Venta (String fecha, MedioDePago medioDePago)
    {
        productosVendidos = new ArrayList();
        this.fecha = fecha;
        this.medioDePago=medioDePago;
    }
    
    public String getFecha()
    {
        return fecha;
    }
    public String getPago()
    {
        return medioDePago.getNombre();
    }
    
    public void AgregarItem(ItemVenta item)
    {
        productosVendidos.add(item);
    }
    
    public void MostrarItems()
    {
        double total=0;
        for (ItemVenta item: productosVendidos)
        {
            System.out.println(item.cantidad + "x" + item.producto.getNombre()+ " " +item.producto.getMarca()+ " $" +item.precio);
            total= total + (item.cantidad*item.precio);
        }
        System.out.println("Total: $" + total);
    }
    
}
