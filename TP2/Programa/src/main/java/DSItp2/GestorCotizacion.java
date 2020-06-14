
package DSItp2;
import java.util.Scanner;
import java.util.ArrayList;

public class GestorCotizacion 
{   
    static ArrayList<Cotizacion>Cotizaciones = new ArrayList();
    
    public static void main (String[]args)
    {
         RegistroMateriales registro = new RegistroMateriales();
         RegistroEspesores regEspesores = new RegistroEspesores();
         RegistroClientes regClientes = new RegistroClientes();
        
        while (true)
        {
            boolean finalizado = Menu();
            if (finalizado)
            {
                break;
            }
        }
        System.out.println("Cotizaciones: ");
        for (Cotizacion cotizacion: Cotizaciones)
        {
            cotizacion.MostrarCotizacion();
            System.out.println(" ");
        }
    }
    
    public static boolean Menu()
    {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        System.out.println ("Elegir operacion a realizar: \n1.Registrar cliente \n2.Realizar cotización");
        do
        {
            opcion = entrada.nextInt(); 
            if ((opcion<1)||(opcion>2))
            {
                System.out.println ("La opción ingresada no es valida, vuelva a ingresar");
            }
            
        } while ((opcion<1)||(opcion>2));
        
        switch(opcion)
        {
            case 1:
                RegistrarCliente();
                break;
                
            case 2:
                RealizarCotizacion();
                break;
        }
        
        System.out.println("¿Seguir operando? \n1.Sí \n2.No");
        
        int opc2;
        do
        {
            opc2 = entrada.nextInt(); 
            if ((opcion<1)||(opcion>2))
            {
                System.out.println ("La opción ingresada no es valida, vuelva a ingresar");
            }
            
        } while ((opc2<1)||(opc2>2));
        
        if (opc2==1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void RealizarCotizacion()
    {
        Scanner entrada = new Scanner(System.in);
        RegistroClientes.MostrarClientes();
        System.out.println("Seleccione un cliente: ");
        int opc = entrada.nextInt();
        int pos1 = opc - 1;
        Cliente cliente = RegistroClientes.Clientes.get(pos1);
        
        RegistroMateriales.MostrarMateriales();
        System.out.println("Seleccione el material");
        int seleccion = entrada.nextInt();
        int posicion = seleccion - 1;
        Material material = RegistroMateriales.Materiales.get(posicion);
        
        System.out.println ("Ingrese la cantidad de metros cuadrados que desea comprar");
        double metrosCuad = entrada.nextDouble();
        
        RegistroEspesores.MostrarEspesores();
        System.out.println("Seleccione el espesor del aplicado en pared:");
        int opcion = entrada.nextInt();
        int pos = opcion - 1;
        Espesor espesor = RegistroEspesores.Espesores.get(pos);
        
        Cotizacion cotizacion = new Cotizacion();
        cotizacion.setCliente(cliente);
        cotizacion.setMaterial(material);
        cotizacion.setMetrosCuadrados(metrosCuad);
        cotizacion.setEspesor(espesor);
        cotizacion.ObtenerCotizacion();
        cotizacion.MostrarCotizacion();
        Cotizaciones.add(cotizacion);
        
    }
    
    public static void RegistrarCliente()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Nevo cliente:");
        
        System.out.println("Nombre y apellido del cliente: ");
        String nombreApellido = entrada.nextLine();
        System.out.println("Empresa: ");
        String empresa = entrada.nextLine();
        System.out.println("Domicilio de la obra: ");
        String domicilioObra = entrada.nextLine();
        System.out.println("Email: ");
        String email = entrada.nextLine();
        System.out.println("Telefono: ");
        String telefono = entrada.nextLine();
        
        Cliente cliente = new Cliente (nombreApellido,empresa,domicilioObra,email,telefono);
        RegistroClientes.Clientes.add(cliente);
    }
}


