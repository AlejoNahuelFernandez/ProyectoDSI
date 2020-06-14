
package openshop;

public class Producto 
{
    private String nombre;
    private double precio;
    private int cantidad;
    private String marca;
    
    public Producto(String nombre,String marca,double precio,int cantidad)
    {
        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
        this.marca=marca;
        RegistroProductos.Productos.add(this);
    }
    
    
    public String getNombre()
    {
        return nombre;
    }
    public double getPrecio()
    {
        return precio;
    }
    public int getCantidad()
    {
        return cantidad;
    }
    public void ActualizarStock (int cantidadComprada)
    {
        cantidad = cantidad - cantidadComprada;
    }
    public String getMarca()
    {
        return marca;
    }
}
