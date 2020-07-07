
package dsitp3;
import java.util.ArrayList;

public class RegistroInscripciones 
{
    public static ArrayList<Inscripcion>Inscripciones=new ArrayList<Inscripcion>();
    
    public static void MostrarInscripciones()
    {
        int pos = 1;
        for (Inscripcion inscripcion: Inscripciones)
        {
            System.out.println(pos + "- Alumno: " + inscripcion.getAlumno() + " Curso: " + inscripcion.getCurso());
        }
    }
}
