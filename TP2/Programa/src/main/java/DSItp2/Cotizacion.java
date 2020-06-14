
package DSItp2;

public class Cotizacion 
{
    private Material material;
    private double metrosCuadrados;
    private Espesor espesor;
    private Cliente cliente;
    private double precioCotizacion;
    
    public Cotizacion(){}
    
    
    public void setMaterial (Material material)
    {
        this.material = material;
    }
    
    public void setMetrosCuadrados (double mCuad)
    {
        this.metrosCuadrados = mCuad;
    }
    
    public void setEspesor(Espesor espesor)
    {
        this.espesor = espesor;
    }
    
    public void setCliente(Cliente cliente)
    {
        this.cliente=cliente;
    }
    
    public void ObtenerCotizacion()
    {
        double cantidadBolsas = this.metrosCuadrados/espesor.getRendimientoBolsa();
        double precioAplicacion = this.metrosCuadrados*espesor.getPrecio();
        double precioMaterial = (Math.ceil(cantidadBolsas))*this.material.getPrecio();
        precioCotizacion = precioMaterial + precioAplicacion;
    }
    
    public void MostrarCotizacion()
    {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println ("Material: " + material.getDescripcion());
        System.out.println ("Espesor: " + espesor.getDescripcion());
        System.out.println ("Metros cuadrados " + metrosCuadrados);
        System.out.println ("Cotizacion: " + precioCotizacion);
    }
}
