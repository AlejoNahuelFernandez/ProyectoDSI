package openshop;

import java.util.ArrayList;

public class RegistroDeClientes 
{
	public ArrayList<Cliente>clientes = new ArrayList<>();
	
	public RegistroDeClientes()
	{}
	
	public boolean ExisteCliente(String usuario,String contraseña)
	{
		boolean resultado = false;
		for (Cliente cliente: clientes)
		{
			if (usuario.equals(cliente.getUsuario())&&(contraseña.equals(cliente.getContraseña())))
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
	
	public Cliente ClienteActual(String usuario,String contraseña)
	{
		Cliente clienteActual = null;
		for (Cliente cliente: clientes)
		{
			if (usuario.equals(cliente.getUsuario())&&(contraseña.equals(cliente.getContraseña())))
			{
				clienteActual = cliente;
			}
		}
		
		return clienteActual;
	}
	
	public boolean UsuarioOContraseñaExistentes(String usuario,String contraseña)
	{
		boolean resultado = false;
		for (Cliente cliente: clientes)
		{
			if (usuario.equals(cliente.getUsuario())||(contraseña.equals(cliente.getContraseña())))
			{
				resultado=true;
			}
		}
		return resultado;
	}
}
