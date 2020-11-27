package openshop;

import static openshop.Json.JSON_MAPPER;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Programa extends JFrame 
{
	private static JPanel contentPane;
	static RegistroDeClientes registroDeClientes;
	static RegistroDeProductos registroDeProductos;
	static Carrito carrito;
	
	public static void main(String[] args) throws IOException 
	{
		registroDeClientes = new RegistroDeClientes();
		registroDeProductos = new RegistroDeProductos();
		carrito = new Carrito();
				
		
		registroDeClientes = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"), RegistroDeClientes.class);
		registroDeProductos.productos = JSON_MAPPER.readValue(new
				File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Productos.json"),
				JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Producto.class));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Programa() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 487);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		MostrarPanel(Panel.INICIO_SESION);
	}
	
	public static void MostrarPanel(Panel panel) throws IOException 
	{
		JPanel panelAMostrar = null;
		
		switch(panel)
		{
			case INICIO_SESION:
				InicioSesion inicioSesion = new InicioSesion(registroDeClientes);
				panelAMostrar = inicioSesion;
				break;
				
			case PRINCIPAL:
				Principal principal = new Principal(registroDeProductos,carrito);
				panelAMostrar = principal;
				break;
				
			case REGISTRO_CLIENTE:
				RegistrarCliente registroCliente = new RegistrarCliente(registroDeClientes);
				panelAMostrar = registroCliente;
				break;
				
			case VISTA_CARRITO:
				VistaCarrito vistaCarrito = new VistaCarrito(carrito);
				panelAMostrar = vistaCarrito;
				break;
				
		}
		
		contentPane.removeAll();
		contentPane.add(panelAMostrar);
		contentPane.repaint();
		contentPane.revalidate();
	}

}
