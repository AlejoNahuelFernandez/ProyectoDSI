
package dsitp3;
import java.util.ArrayList;


public class RegistroCursos 
{
    public static ArrayList<Curso>Cursos=new ArrayList<Curso>();
    
    public RegistroCursos()
    {
        Cursos.add(new Curso("Curso de Excel","para empresas"));
        Cursos.add(new Curso("Curso de Java", "para estudiantes de Ing. en Sistemas"));
    }
    
    public static void MostrarCursos()
    {
        int pos=1;
        for (Curso curso: Cursos)
        {
            System.out.println(pos + "-" + curso.getNombre() + " " + curso.getDescripcion());
            pos++;
        }
    }
}
