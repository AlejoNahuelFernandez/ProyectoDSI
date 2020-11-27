package openshop;

import static openshop.Json.JSON_MAPPER;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RegistroDeVentas 
{
	
	public ArrayList<DatosDeVentaAGuardar> ObtenerVentas() throws IOException
	{
		ArrayList<DatosDeVentaAGuardar>ventas = new ArrayList<>();
		ventas = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Ventas.json"),
				JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class,DatosDeVentaAGuardar.class));
		
		return ventas;
	}
	
	public void RegistrarVentas(ArrayList<DatosDeVentaAGuardar>ventas) throws IOException
	{
		JSON_MAPPER.writeValue(new File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Ventas.json"),
				ventas);
	}
	
	
}
