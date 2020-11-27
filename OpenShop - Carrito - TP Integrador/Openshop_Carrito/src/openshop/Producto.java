package openshop;

public class Producto 
{
	private int id;
	private String nombre;
	private String marca;
	private String descripcion;
	private double precio;
	private int stock;
	private int idTipoProducto;
	private String nombreTipoProducto;
	private String nombreCategoria;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}
	
	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	public boolean HayStockDisponible()
	{
		boolean resultado = false;
		if (stock > 0)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	public boolean HaySuficienteStock(int cantidadDeUnidadesAComprar)
	{
		boolean resultado = false;
		if (cantidadDeUnidadesAComprar <= stock)
		{
			resultado = true;
		}
		
		return resultado;
	}
	
	public int getIdTipoProducto() {
		return idTipoProducto;
	}

	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	

	
	
}
