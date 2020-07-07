
package dsitp3;

public class Docente 
{
    private String NombreYApellido;
    private int DNI;
    private String email;
    private String telefono;
    
    public Docente(String nomYap, int dni, String email, String telefono)
    {
        this.NombreYApellido=nomYap;
        this.DNI=dni;
        this.email=email;
        this.telefono=telefono;
    }
    
    public String getNombre()
    {
        return NombreYApellido;
    }
    
    public int getDNI()
    {
        return DNI;
    }
}
