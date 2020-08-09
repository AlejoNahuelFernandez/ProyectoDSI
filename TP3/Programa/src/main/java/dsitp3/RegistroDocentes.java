
package dsitp3;
import java.util.ArrayList;

public class RegistroDocentes 
{
    public static ArrayList<Docente>Docentes=new ArrayList();
    
    public RegistroDocentes()
    {
        Docentes.add(new Docente("Pablo Pioli",23456782,"ppioli@hotmail.com","3564783212"));
        Docentes.add(new Docente("Juan Pablo Ferreyra", 27890321,"jpferreyra@hotmail.com","3564674512"));
        Docentes.add(new Docente("Marisa Perez", 20345678,"mperez@gmail.com","3564781234"));
        Docentes.add(new Docente("Carlos Alvarez", 19345789,"carlosalvarez@gmail.com","3564123490"));
    }
    
    public static void MostrarDocentes()
    {
        int pos=1;
        for (Docente docente: Docentes)
        {
            System.out.println(pos + "-" +docente.getNombre() +" DNI: " +docente.getDNI());
            pos++;
        }
    }
}
