
package DSItp2;
import java.util.ArrayList;

public class RegistroMateriales 
{
    public static ArrayList<Material>Materiales= new ArrayList<Material>();
    
    public RegistroMateriales()
    {
        Materiales.add(new Material("Aislante 120",2300.00));
        Materiales.add(new Material("Aislante 132",1500.00));
        Materiales.add(new Material("Aislante 144",1330.00));
    }
    
    public static void MostrarMateriales()
    {
        System.out.println ("Listado de materiales: ");
        int pos=1;
        for (Material material: Materiales)
        {
            System.out.println (pos + "-" + material.getDescripcion() + " $" + material.getPrecio());
            pos++;
        }
    }      

}