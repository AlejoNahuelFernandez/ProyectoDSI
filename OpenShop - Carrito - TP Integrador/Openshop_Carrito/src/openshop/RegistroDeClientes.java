package openshop;

import java.util.ArrayList;

public class RegistroDeClientes 
{
	public ArrayList<Cliente>clientes = new ArrayList<>();
	
	public RegistroDeClientes()
	{}
	
	public boolean ExisteCliente(String usuario,String contrase�a)
	{
		boolean resultado = false;
		for (Cliente cliente: clientes)
		{
			if (usuario.equals(cliente.getUsuario())&&(contrase�a.equals(cliente.getContrase�a())))
			{
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean IdExistente(int idCliente)
	{
		boolean resultado = false;
		for (Cliente cliente: clientes)
		{
			if (idCliente == cliente.getIdCliente())
			{
				resultado=true;
			}
		}
		return resultado;
	}
	
	public Cliente ClienteActual(String usuario,String contrase�a)
	{
		Cliente clienteActual = null;
		for (Cliente cliente: clientes)
		{
			if (usuario.equals(cliente.getUsuario())&&(contrase�a.equals(cliente.getContrase�a())))
			{
				clienteActual = cliente;
			}
		}
		
		return clienteActual;
	}
	
	public boolean UsuarioOContrase�aExistentes(String usuario,String contrase�a)
	{
		boolean resultado = false;
		for (Cliente cliente: clientes)
		{
			if (usuario.equals(cliente.getUsuario())||(contrase�a.equals(cliente.getContrase�a())))
			{
				resultado=true;
			}
		}
		return resultado;
	}
}
