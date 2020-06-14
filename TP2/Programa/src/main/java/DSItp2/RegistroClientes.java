
package DSItp2;
import java.util.ArrayList;

public class RegistroClientes 
{
    public static ArrayList<Cliente>Clientes = new ArrayList();
    
    public RegistroClientes() 
    {
        Clientes.add(new Cliente("Juan Gomez","Empresa 1","Maipú 222", "juangomez@gmail.com","3562674932"));
        Clientes.add(new Cliente("Jose Gimenez","Empresa 2","Libertad 262", "josegmnz@gmail.com","356215632"));
    }
    
    public static void MostrarClientes()
    {
        int pos=1;
        for (Cliente cliente: Clientes)
        {
            System.out.println(pos + "-" + cliente.getNombre() + " -Empresa:" + cliente.getEmpresa());
            pos++;
        }
            
    }
}
