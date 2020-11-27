package openshop;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import static openshop.Json.JSON_MAPPER;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



public class VistaCarrito extends JPanel
{
	final String MENSAJE_STOCK_INSUFICIENTE = "No hay suficiente stock";
	final String MENSAJE_COMPRA_EXITOSA = "Compra exitosa";
	final String MENSAJE_ID_INCORRECTO = "El producto no se encuentra agregado al carrito";
	
	private JTable tablaProductosEnCarrito;
	private JTextField textFieldIdProductoAModificar;
	private JTextField textFieldCantidad;
	private JTextField textFieldIdProductoAEliminar;
	private JLabel lblMensaje;
	private JLabel lblMontoAPagar;
	private JLabel lblMensajeCompra;
	
	private JButton btnModificarCantidad;
	private JButton btnEliminarProducto;
	private JButton btnComprar;
	
	private JButton btnVolver;
	
	RegistroDeVentas registroDeVentas;
	
	
	ArrayList<Venta>ventas = new ArrayList<>();
	
	Calendar calendario = new GregorianCalendar();
	
	public VistaCarrito(Carrito carrito) 
	{
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("OPENSHOP");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitulo.setBounds(246, 0, 160, 73);
		add(lblTitulo);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lblMensajeCompra.setText("");
					Programa.MostrarPanel(Panel.PRINCIPAL);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(582, 465, 89, 23);
		add(btnVolver);
		
		JLabel lblModificarCantidad = new JLabel("Modificar cantidad: ");
		lblModificarCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModificarCantidad.setBounds(542, 82, 160, 23);
		add(lblModificarCantidad);
		
		JLabel lblIdProductoAModificar = new JLabel("Id de producto: ");
		lblIdProductoAModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProductoAModificar.setBounds(540, 113, 104, 23);
		add(lblIdProductoAModificar);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidad.setBounds(542, 140, 71, 23);
		add(lblCantidad);
		
		textFieldIdProductoAModificar = new JTextField();
		textFieldIdProductoAModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldIdProductoAModificar.setColumns(10);
		textFieldIdProductoAModificar.setBounds(638, 113, 86, 20);
		add(textFieldIdProductoAModificar);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(603, 142, 86, 20);
		add(textFieldCantidad);
		
		btnModificarCantidad = new JButton("Modificar cantidad");
		btnModificarCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarCantidadDeUnidades(carrito);
			}
		});
		btnModificarCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificarCantidad.setBounds(562, 173, 134, 23);
		add(btnModificarCantidad);
		
		JLabel lblEliminarProducto = new JLabel("Eliminar producto: ");
		lblEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEliminarProducto.setBounds(542, 218, 160, 23);
		add(lblEliminarProducto);
		
		JLabel lblIdProductoAEliminar = new JLabel("Id de producto: ");
		lblIdProductoAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProductoAEliminar.setBounds(540, 252, 104, 23);
		add(lblIdProductoAEliminar);
		
		textFieldIdProductoAEliminar = new JTextField();
		textFieldIdProductoAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldIdProductoAEliminar.setColumns(10);
		textFieldIdProductoAEliminar.setBounds(638, 254, 86, 20);
		add(textFieldIdProductoAEliminar);
		
		btnEliminarProducto = new JButton("Eliminar producto");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarProductoDelCarrito(carrito);
			}
		});
		btnEliminarProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarProducto.setBounds(562, 286, 134, 23);
		add(btnEliminarProducto);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBounds(492, 204, 262, 14);
		add(lblMensaje);
		
		lblMontoAPagar = new JLabel("");
		lblMontoAPagar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMontoAPagar.setBounds(523, 320, 213, 49);
		add(lblMontoAPagar);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Comprar(carrito);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnComprar.setBounds(582, 399, 107, 23);
		add(btnComprar);
		
		lblMensajeCompra = new JLabel("");
		lblMensajeCompra.setBounds(551, 440, 151, 14);
		add(lblMensajeCompra);
		
		MostrarCarrito(carrito);
		
	}
	
	public void MostrarCarrito(Carrito carrito)
	{
		String[] nombreDeColumnas = {"Id","Nombre","Descripcion","Marca","Precio","Cantidad"};
		Object[][] datosDeFilas = new Object[carrito.productosAgregados.size()][6];
		int x=0;
		int y=0;
		
		for (ItemCarrito itemCarrito: carrito.productosAgregados)
		{
			datosDeFilas[x][y++] = itemCarrito.producto.getId();
			datosDeFilas[x][y++] = itemCarrito.producto.getNombre();
			datosDeFilas[x][y++] = itemCarrito.producto.getDescripcion();
			datosDeFilas[x][y++] = itemCarrito.producto.getMarca();
			datosDeFilas[x][y++] = itemCarrito.producto.getPrecio();
			datosDeFilas[x][y++] = itemCarrito.cantidad;
			
			x++;
			y=0;
		}
		
		tablaProductosEnCarrito = new JTable(datosDeFilas,nombreDeColumnas);
		JScrollPane scrollPaneTabla = new JScrollPane(tablaProductosEnCarrito);
		scrollPaneTabla.setBounds(10, 66, 452, 438);
		add(scrollPaneTabla);
		tablaProductosEnCarrito.setEnabled(false);
		
		double montoAPagar = carrito.MontoDeLaCompra();
		lblMontoAPagar.setText("MONTO: " + montoAPagar);
		
	}
	
	public void ModificarCantidadDeUnidades(Carrito carrito)
	{
		int idProductoAModificar;
		idProductoAModificar = Integer.parseInt(textFieldIdProductoAModificar.getText());
		int nuevaCantidad = Integer.parseInt(textFieldCantidad.getText());
		
		lblMensaje.setText("");
		boolean idCorrecto = false;
		for (ItemCarrito itemCarrito: carrito.productosAgregados)
		{
			if (idProductoAModificar == itemCarrito.producto.getId())
			{
				idCorrecto = true;
				if (itemCarrito.producto.HaySuficienteStock(nuevaCantidad))
				{
					itemCarrito.ModificarCantidad(nuevaCantidad);
				}
				else
				{
					lblMensaje.setText(MENSAJE_STOCK_INSUFICIENTE);
				}
			}
		}
		
		if (!idCorrecto)
		{
			lblMensaje.setText(MENSAJE_ID_INCORRECTO);
		}
		
		MostrarCarrito(carrito);
	}
	
	public void EliminarProductoDelCarrito(Carrito carrito)
	{
		int idProductoAEliminar = Integer.parseInt(textFieldIdProductoAEliminar.getText());
		
		boolean idCorrecto = false;
		for (ItemCarrito itemCarrito: carrito.productosAgregados)
		{
			if (idProductoAEliminar == itemCarrito.producto.getId())
			{
				idCorrecto = true;
				carrito.EliminarItem(idProductoAEliminar);
			}
		}
		
		if (!idCorrecto)
		{
			lblMensaje.setText(MENSAJE_ID_INCORRECTO);
		}
		
		MostrarCarrito(carrito);
	}
	
	public void Comprar(Carrito carrito) throws IOException
	{
		registroDeVentas = new RegistroDeVentas();
		ArrayList<DatosDeVentaAGuardar>ventas = new ArrayList<>();
		ventas = registroDeVentas.ObtenerVentas();
		
		ArrayList<ItemCarrito>productosComprados = new ArrayList<>();
		productosComprados = carrito.productosAgregados;
		
		double montoAPagar = carrito.MontoDeLaCompra();
		Date fechaDeVenta = calendario.getTime();
		Cliente clienteActual = InicioSesion.ClienteIngresado();
		
		Venta venta = new Venta();
		venta.setCliente(clienteActual);
		venta.setFechaVenta(fechaDeVenta);
		venta.setMonto(montoAPagar);
		venta.setProductosVendidos(productosComprados);
		
		DatosDeVentaAGuardar datosVenta = new DatosDeVentaAGuardar(venta);
		ventas.add(datosVenta);
		
		registroDeVentas.RegistrarVentas(ventas);
		
		lblMensajeCompra.setText(MENSAJE_COMPRA_EXITOSA);
		
		carrito.VaciarCarrito();
	}
}
