
package DSItp2;

public class Espesor 
{
    private String descripcion;
    private double precioPorMetroCuadrado;
    private double rendimientoBolsa;
    
    public Espesor (String descripcion, double precio, double rendBolsa)
    {
        this.descripcion = descripcion;
        this.precioPorMetroCuadrado = precio;
        this.rendimientoBolsa = rendBolsa;
    }
    
    public String getDescripcion()
    {
        return descripcion;
    }
    
    public double getPrecio()
    {
        return precioPorMetroCuadrado;
    }
    
    public double getRendimientoBolsa()
    {
        return rendimientoBolsa;
    }
}
