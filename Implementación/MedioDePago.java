
package openshop;

public class MedioDePago 
{
    private String nombre;
    
    public MedioDePago (String nombre)
    {
        this.nombre=nombre;
        GestorDeVentas.MediosDePago.add(this);
    }
    
    public String getNombre()
    {
        return nombre;
    }
}
