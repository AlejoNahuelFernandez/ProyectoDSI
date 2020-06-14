
package DSItp2;
import java.util.ArrayList;

public class RegistroEspesores 
{
    public static ArrayList<Espesor>Espesores = new ArrayList<Espesor>();
    
    public RegistroEspesores()
    {
        Espesores.add(new Espesor ("Aplicado en pared 50 mm",53.60,9.00));
        Espesores.add(new Espesor ("Aplicado en pared 70 mm",87.00,6.43));
        Espesores.add(new Espesor ("Aplicado en pared 100 mm",117.49,4.50));
        Espesores.add(new Espesor ("Aplicado en pared 120 mm",128.48,3.75));
        Espesores.add(new Espesor ("Aplicado en pared 160 mm",143.05,2.81));
        Espesores.add(new Espesor ("Aplicado en pared 200 mm",180.79,2.25));
    }
    
    public static void MostrarEspesores()
    {
        System.out.println("Listado de espesores de aplicación: ");
        
        int pos=1;
        for (Espesor espesor: Espesores)
        {
            System.out.println(pos + "-" +espesor.getDescripcion() + " $" + espesor.getPrecio());
            pos++;
        }
    }
    
}
