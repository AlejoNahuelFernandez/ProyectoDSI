
package openshop;

import java.util.Scanner;

public class GestorDeVentas 
{
    public static void main (String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        Producto producto1 = new Producto ("Cafetera",3000,10);
        Producto producto2 = new Producto ("Celular",24999.99,8);
        Producto producto3 = new Producto ("Televisor",22000,7);
        Producto producto4 = new Producto ("Ojotas",600,9);
        
        MedioDePago mediopago1 = new MedioDePago ("Tarjeta de credito",6);
        MedioDePago mediopago2 = new MedioDePago ("Tarjeta de debito",1);
        
        Carrito carrito1 = new Carrito();
        
        int opcion;
        do
        {
            RegistroProductos.MostrarProductos();
            int seleccion;
            do
            {
                System.out.println("Seleccione numero de producto: ");
                seleccion= entrada.nextInt();
            } while ((seleccion<1)||(seleccion>RegistroProductos.Productos.size()));
            
            if (RegistroProductos.Productos.get(seleccion - 1).getCantidad()==0)
            {
                System.out.println("No hay stock disponible");
            }
            else
            {
                carrito1.AgregarAlCarrito(RegistroProductos.Productos.get(seleccion-1));
            }
            do
            {
                System.out.println("Ingrese opcion: \n1.Seguir agregando productos \n2.Finalizar seleccion de productos");
                opcion = entrada.nextInt();
            }while ((opcion<1)||(opcion>2));
        }while(opcion!=2);
        
        RegistroMediosDePago.MostrarMediosDePago();
        int numeroMedioPago;
        do
        {
            System.out.println("Seleccionar número de medio de pago");
            numeroMedioPago = entrada.nextInt();
        } while ((numeroMedioPago<1)||(numeroMedioPago>RegistroMediosDePago.MediosDePago.size()));
        carrito1.elegirMedioDePago(RegistroMediosDePago.MediosDePago.get(numeroMedioPago - 1));
        carrito1.MostrarCarrito();
    }
    
}
