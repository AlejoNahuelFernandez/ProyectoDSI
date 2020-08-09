
package dsitp3;
import static dsitp3.RegistroDocentes.Docentes;
import java.util.ArrayList;

public class Curso 
{
    private String nombre;
    private String descripcion;
    private String horario;
    private String fechasDictado;
    public ArrayList<Docente>docentes = new ArrayList();
    private String aula;
    private int cupoMinimo;
    private int cupoMaximo;
    private String fechaLimiteInscripcion;
    private boolean estadoCurso;
    
    public Curso(String nombre, String descripcion)
    {
        this.nombre = nombre;
        this.descripcion=descripcion;
    }
    
    public void AgregarDocente(Docente docente)
    {
        docentes.add(docente);
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public void setHorario(String horario)
    {
        this.horario=horario;
    }
    
    public void setFechasDictado(String fechas)
    {
        this.fechasDictado=fechas;
    }
    
    public void setAula(String aula)
    {
        this.aula=aula;
    }
    
    public void setCupoMinimo(int cupoMin)
    {
        this.cupoMinimo=cupoMin;
    }
    
    public void setCupoMaximo(int cupoMax)
    {
        this.cupoMaximo=cupoMax;
    }
    
    public void setFechaLimite(String fecha)
    {
        this.fechaLimiteInscripcion=fecha;
    }
    
    public void setEstadoCurso(boolean estado)
    {
        this.estadoCurso=estado;
    }
    public void MostrarDocentes()
    {
        int pos = 1;
        System.out.println ("Docentes del curso: " +nombre + " " + descripcion);
        
        for (Docente docente: docentes)
        {
            System.out.println(pos + "-" +docente.getNombre() +" DNI: " +docente.getDNI());
            pos++;
        }
    }
}
