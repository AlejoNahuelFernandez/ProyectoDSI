package openshop;

import static openshop.Json.JSON_MAPPER;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class TestUnitarios {
	
	RegistroDeClientes registroDeClientes;
	RegistroDeProductos registroDeProductos;
	Carrito carrito = new Carrito();
	
	InicioSesion inicioSesion = new InicioSesion(registroDeClientes);
	RegistrarCliente registrarCliente = new RegistrarCliente(registroDeClientes);
	
			
	@Test
	void IngresoUsuarioConDatosCorrectos() throws IOException
	{
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		assertEquals(true,registroDeClientes.ExisteCliente("Julio123", "julio987"));
	}
	
	@Test
	void IngresoClienteConNombreDeUsuarioIncorrecto() throws IOException
	{
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		assertEquals(false,registroDeClientes.ExisteCliente("jose2020", "josediaz1234"));
	}
	
	@Test
	void IngresoClienteConContraseñaIncorrecta() throws IOException
	{
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		assertEquals(false,registroDeClientes.ExisteCliente("Alberto12", "albertojimenez2020"));
	}
	
	@Test
	void IngresoDeUnIdDeClienteYaExistente() throws IOException
	{
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		registrarCliente.textFieldIdCliente.setText("78");
		int idCliente = registrarCliente.idClienteIngesado();
		assertEquals(true,registroDeClientes.IdExistente(idCliente));
	}
	
	@Test 
	void IngresoDeUnNuevoIdDeCliente() throws IOException 
	{
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		registrarCliente.textFieldIdCliente.setText("29");
		int idCliente = registrarCliente.idClienteIngesado();
		assertEquals(false,registroDeClientes.IdExistente(idCliente));
	}
	
	@Test 
	void ObtenerClienteQueInicioSesion() throws IOException
	{
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		
		assertEquals("Oscar",registroDeClientes.ClienteActual("ocarcab12", "oscar1234").getNombre());
	}
	

	
	
	
	

}
