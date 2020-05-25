
package openshop;

import java.util.Scanner;
import java.util.ArrayList;

public class GestorDeVentas 
{
    static ArrayList<MedioDePago>MediosDePago = new ArrayList();
    static ArrayList<Venta>Ventas= new ArrayList();
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
            finalizado = Menu();
            if (finalizado == true)
            {
                break;
            }
        }
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
    
    public static MedioDePago AgregarPago()
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
        return formaPago;
        
    }
    
    public static boolean Menu()
    {
        
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println ("Menu: \n1.Comprar \n2.Preparar pedido");
        System.out.println ("Digite el numero correspondiente");
        do
        {
            opcion = entrada.nextInt();
            if ((opcion<1)||(opcion>2))
            {
                System.out.println ("La opción ingresada no es valida");
            }
        } while((opcion<1)||(opcion>2));
        
        switch(opcion)
        {
            case 1:
                while (true)
                {
                    boolean finalizado;
                    finalizado = Comprar();
                    if (finalizado == true)
                    {
                        break;
                    }
                }
                MedioDePago medioPago;
                medioPago = AgregarPago();
                System.out.println("Gracias por su compra");
                
                ArrayList<ProductoEnCarrito>productos;
                productos=carrito.obtenerLista();
                Venta venta = new Venta("20-04-2020",medioPago);
                for (ProductoEnCarrito item: productos)
                {
                    ItemVenta itemVenta = new ItemVenta(item.Producto,item.cantidad,item.Producto.getPrecio());
                    venta.AgregarItem(itemVenta);
                }
                Ventas.add(venta);
                carrito.VaciarCarrito();
                break;
            
            case 2:
                System.out.println ("Pedidos: ");
                System.out.println(" ");
                if (Ventas.size()>0)
                {
                    for (Venta vta: Ventas)
                    {
                        System.out.println("Fecha: " +vta.getFecha());
                        vta.MostrarItems();
                        System.out.println("Medio de pago: " +vta.getPago());
                        System.out.println(" ");
                    }
                }
                else
                {
                    System.out.println("No hay ventas");
                }
                
                break;
        }
        
        int opc;
        System.out.println("¿Desea seguir trabajando?");
        System.out.println("\n1.Continuar  \n2.Finalizar ");
        
        do
        {
            opc = entrada.nextInt();
            if ((opc<1)||(opc>2))
            {
                System.out.println ("La opción ingresada no es válida, vuelva a ingresar");
            }
        }while((opc<1)||(opc>2));
        
        if(opc==1)
        {
            return false;
        }
        else
        {
            return true;
        }
        
    }
}
