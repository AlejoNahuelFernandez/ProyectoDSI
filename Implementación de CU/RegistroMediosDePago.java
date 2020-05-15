
package openshop;
import java.util.ArrayList;

public class RegistroMediosDePago 
{
    public static ArrayList<MedioDePago>MediosDePago = new ArrayList();
    
    public static void MostrarMediosDePago()
    {
        System.out.println ("Medios de pago: ");
        for (MedioDePago medio: MediosDePago)
        {
            System.out.println("-" +medio.getNombre() + "(" +medio.getCuotas() + "cuotas)");
        }
    }
}
