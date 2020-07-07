
package dsitp3;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroAlumnos 
{
    public static ArrayList<Alumno>Alumnos=new ArrayList<Alumno>();
    
    public RegistroAlumnos()
    {
        Alumnos.add(new Alumno("Alejo Fernandez",42513154,"alejofernandez@hotmail.com","3564231267"));
        Alumnos.add(new Alumno("Franco Luque",41234678,"fluque@gmail.com","3564879032"));
    }
    
    public static void MostrarAlumnos()
    {
        int pos=1;
        for (Alumno alumno: Alumnos)
        {
            System.out.println(pos + "-" +alumno.getNombre() + " " +alumno.getDNI());
            pos++;
        }
    }
}
