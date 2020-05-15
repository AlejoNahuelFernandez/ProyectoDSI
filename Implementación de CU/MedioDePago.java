
package openshop;

public class MedioDePago 
{
    private String nombre;
    private int cuotas;
    
    public MedioDePago (String nombre,int cuotas)
    {
        this.nombre=nombre;
        this.cuotas=cuotas;
        RegistroMediosDePago.MediosDePago.add(this);
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public int getCuotas()
    {
        return cuotas;
    }
}
