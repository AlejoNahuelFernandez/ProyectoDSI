
package DSItp2;

public class Material 
{
    private String descripcion;
    private double precioBolsa;
    
    public Material(String descripcion,double precioBolsa)
    {
        this.descripcion = descripcion;
        this.precioBolsa = precioBolsa;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public double getPrecio()
    {
        return precioBolsa;
    }
}
