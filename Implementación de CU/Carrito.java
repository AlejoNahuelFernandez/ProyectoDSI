
package openshop;
import java.util.ArrayList;
import java.util.Scanner;

public class Carrito 
{
    int cantidadTotalProductos;
    double precioTotal;
    private ArrayList<Producto>productos;
    private ArrayList<Integer>cantProducto;
    private MedioDePago medioPago; 
    
    public Carrito()
    {
        productos=new ArrayList<Producto>();
        cantProducto=new ArrayList<Integer>();
        cantidadTotalProductos=0;
        precioTotal=0;
    }
    
    public void AgregarAlCarrito(Producto producto)
    {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
       
        do
        {
            System.out.println("Ingrese cantidad de unidades: ");
            cantidad = entrada.nextInt();
            if (cantidad > producto.getCantidad())
            {
                System.out.println("No hay suficiente stock");
            }
        }while((cantidad<1)||cantidad>producto.getCantidad());
        
       int s=0;
       for (int i=0;i<productos.size();i++)
       {
           if (productos.get(i)== producto)
           {
               int cantidadTotal;
               cantidadTotal = cantProducto.get(i) + cantidad;
               cantProducto.remove(i);
               cantProducto.add(i,cantidadTotal);
               s=1;
           }
       }
       if (s==0)
       {
           productos.add(producto);
           cantProducto.add(cantidad);
       }
       cantidadTotalProductos= cantidadTotalProductos + cantidad;
       CalcularPrecio(producto,cantidad);
       producto.ActualizarStock(cantidad);
        
    }
    public void CalcularPrecio(Producto producto,int cantidad)
    {
        precioTotal = precioTotal + (producto.getPrecio()*cantidad);
    }
    public void elegirMedioDePago(MedioDePago medio)
    {
        medioPago=medio;
    }
    public void MostrarCarrito()
    {
        System.out.println("Carrito de compras");
        for (int i=0;i<productos.size();i++)
        {
            System.out.println("Artículo: " +productos.get(i).getNombre() + " Cantidad: " +cantProducto.get(i) + " Precio: " +productos.get(i).getPrecio());
        }
        System.out.println("Cantidad total de artículos: " +cantidadTotalProductos);
        System.out.println("Precio total: " +precioTotal);
        System.out.println("Medio de pago: " + medioPago.getNombre() + " Cuotas: " + medioPago.getCuotas());
    }
}
