
package openshop;

import java.util.Scanner;
import java.util.ArrayList;

public class GestorDeVentas 
{
    static ArrayList<MedioDePago>MediosDePago = new ArrayList();
    static Carrito carrito= new Carrito();
    
    public static void main (String[] args)
    {
        Producto producto1 = new Producto ("Cafetera","Philips",3000,10);
        Producto producto2 = new Producto ("Celular","Samsung",24999.99,8);
        Producto producto3 = new Producto ("Televisor","Sony",22000,7);
        Producto producto4 = new Producto ("Ojotas","Havaianas",600,9);
        Producto producto5 = new Producto ("Teclado","Razer",6500,8);
        
        MedioDePago mediopago1 = new MedioDePago ("Tarjeta de crédito en 6 cuotas sin interés");
        MedioDePago mediopago2 = new MedioDePago ("Tarjeta de débito");
        
        
        while (true)
        {
            boolean finalizado;
            finalizado = Comprar();
            if (finalizado == true)
            {
                break;
            }
        }
        
        AgregarPago();
        
        System.out.println("Gracias por su compra");
    }
    
    public static boolean Comprar()
    {
        RegistroProductos.MostrarProductos();
        
        int seleccion;
        Producto producto;
        Scanner entrada = new Scanner(System.in);
        do
        {
            System.out.println("Seleccione número de producto: ");
            seleccion= entrada.nextInt();
        } while ((seleccion<1)||(seleccion>RegistroProductos.Productos.size()));
        if (RegistroProductos.Productos.get(seleccion - 1).getCantidad()==0)
        {
            System.out.println("No hay stock disponible");
        }
        else
        {
            producto = RegistroProductos.Productos.get(seleccion - 1);
        
            int opcionCantidad;
            do
            {
                System.out.println("Ingrese la cantidad de productos que desea comprar: ");
                opcionCantidad = entrada.nextInt();
                if (opcionCantidad>producto.getCantidad())
                {
                    System.out.println("No hay suficiente stock");
                }
            }while((opcionCantidad<1)||opcionCantidad>producto.getCantidad());
            int cantidadElegida = opcionCantidad;
        
            carrito.AgregarAlCarrito(producto,cantidadElegida);
            carrito.MostrarCarrito();
        }
        
        int opcion;
        do
        {
            System.out.println("Ingrese 1 para seguir comprando y 2 para abonar los productos del carrito");
            opcion = entrada.nextInt();
        }while ((opcion<1)||(opcion>2));
        
        if (opcion == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void AgregarPago()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Medios de pago: ");
        int pos=1;
        for (MedioDePago pago: MediosDePago)
        {
            System.out.println(pos + "-" +pago.getNombre());
            pos++;
        }
        int numeroMedioPago;
        do
        {
            System.out.println("Seleccionar medio de pago, ingrese 1 o 2");
            numeroMedioPago = entrada.nextInt();
        } while ((numeroMedioPago<1)||(numeroMedioPago>MediosDePago.size()));
        
        MedioDePago formaPago;
        formaPago = MediosDePago.get(numeroMedioPago - 1);
        System.out.println("El medio de pago elegido fue: " + formaPago.getNombre());
    }
    
}
