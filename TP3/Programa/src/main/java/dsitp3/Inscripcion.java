
package dsitp3;

public class Inscripcion 
{
    private Alumno alumno;
    private Curso curso;
    
    public Inscripcion(Alumno alumno, Curso curso)
    {
        this.alumno=alumno;
        this.curso=curso;
    }
    
    public String getAlumno()
    {
        return alumno.getNombre();
    }
    
    public String getCurso()
    {
        return curso.getNombre() + " " + curso.getDescripcion();
    }
}
