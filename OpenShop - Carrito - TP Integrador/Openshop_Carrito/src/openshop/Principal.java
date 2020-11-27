package openshop;

//import static openshop.Json.JSON_MAPPER;

import java.awt.Font;
//import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Principal extends JPanel {
	
	private JTable tablaDeProductos;
	
	private JButton btnFiltrarPorCategoria;
	private JComboBox<String> comboBoxCategorias;
	private JLabel lblCategoria;
	
	private JLabel lblTipoDeProducto;
	private JComboBox<String> comboBoxTiposDeProducto;
	private JButton btnFiltrarPorTipoDeProducto;
	
	private JLabel lblIdProducto;
	public JTextField textFieldIdProducto;
	private JTextField textFieldCantidad;
	private JLabel lblSeleccionProducto;
	private JLabel lblCantidad;
	private JButton btnAgregarAlCarrito;
	private JLabel lblMensaje;
	private JButton btnVisualizarCarrito;
	
	final String MENSAJE_PRODUCTO_NO_EXISTENTE = "Producto no existente";
	final String MENSAJE_FALTA_DE_STOCK = "No hay stock disponible";
	final String MENSAJE_STOCK_INSUFICIENTE ="No hay suficiente stock";
	final String PRODUCTO_AGREGADO_CON_EXITO = "Se ha agregado el producto elegido al carrito";
	
	public Principal(RegistroDeProductos registroDeProductos, Carrito carrito) throws IOException
	{
		setLayout(null);
		JLabel lblTitulo = new JLabel("OPENSHOP");
		lblTitulo.setBounds(260, 0, 160, 73);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblTitulo);
		
		comboBoxCategorias = new JComboBox<String>();
		comboBoxCategorias.setBounds(517, 100, 160, 20);
		add(comboBoxCategorias);
		
		lblCategoria = new JLabel("Categoría: ");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoria.setBounds(551, 66, 83, 23);
		add(lblCategoria);
		
		btnFiltrarPorCategoria = new JButton("Filtrar por categoría");
		btnFiltrarPorCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarProductosPorCategoria(registroDeProductos);
			}
		});
		btnFiltrarPorCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrarPorCategoria.setBounds(517, 131, 171, 23);
		add(btnFiltrarPorCategoria);
		
		ArrayList<String>categorias = new ArrayList<>();
		categorias = registroDeProductos.Categorias();
		
		for (String categoria: categorias)
		{
			comboBoxCategorias.addItem(categoria);
		}
		
		lblTipoDeProducto = new JLabel("Tipo de producto: ");
		lblTipoDeProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoDeProducto.setBounds(537, 171, 126, 23);
		add(lblTipoDeProducto);
		
		comboBoxTiposDeProducto = new JComboBox<String>();
		comboBoxTiposDeProducto.setBounds(517, 195, 160, 20);
		add(comboBoxTiposDeProducto);
		
		btnFiltrarPorTipoDeProducto = new JButton("Filtrar por tipo de producto");
		btnFiltrarPorTipoDeProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarProductosPorTipo(registroDeProductos);
			}
		});
		btnFiltrarPorTipoDeProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFiltrarPorTipoDeProducto.setBounds(504, 226, 199, 23);
		add(btnFiltrarPorTipoDeProducto);
		
		ArrayList<String>tiposDeProducto = new ArrayList<>();
		tiposDeProducto = registroDeProductos.TiposDeProducto();
		
		for (String tipoDeProducto: tiposDeProducto)
		{
			comboBoxTiposDeProducto.addItem(tipoDeProducto);
		}
		
		lblSeleccionProducto = new JLabel("Selecci\u00F3n de producto: ");
		lblSeleccionProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccionProducto.setBounds(528, 286, 160, 23);
		add(lblSeleccionProducto);
		
		lblIdProducto = new JLabel("Id de producto: ");
		lblIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProducto.setBounds(503, 320, 104, 23);
		add(lblIdProducto);
		
		textFieldIdProducto = new JTextField();
		textFieldIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldIdProducto.setBounds(602, 321, 86, 20);
		add(textFieldIdProducto);
		textFieldIdProducto.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidad.setBounds(504, 354, 71, 23);
		add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(566, 354, 86, 20);
		add(textFieldCantidad);
		
		btnAgregarAlCarrito = new JButton("Agregar al carrito");
		btnAgregarAlCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarProductoAlCarrito(registroDeProductos,carrito);
			}
		});
		btnAgregarAlCarrito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarAlCarrito.setBounds(517, 415, 171, 23);
		add(btnAgregarAlCarrito);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBounds(504, 390, 286, 14);
		add(lblMensaje);
		
		btnVisualizarCarrito = new JButton("Ver carrito");
		btnVisualizarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					VerCarrito();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnVisualizarCarrito.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVisualizarCarrito.setBounds(551, 466, 140, 23);
		add(btnVisualizarCarrito);
		
		MostrarProductos(registroDeProductos);
	}
	
	public void MostrarProductos(RegistroDeProductos registroDeProductos)
	{
		String[] nombreDeColumnas = {"Id","Nombre","Descripcion","Marca","Precio"};
		Object[][] datosDeFilas = new Object[registroDeProductos.productos.size()][5];
		int x=0;
		int y=0;
		
		for (Producto producto: registroDeProductos.productos)
		{
			datosDeFilas[x][y++] = producto.getId();
			datosDeFilas[x][y++] = producto.getNombre();
			datosDeFilas[x][y++] = producto.getDescripcion();
			datosDeFilas[x][y++] = producto.getMarca();
			datosDeFilas[x][y++] = producto.getPrecio();
			
			x++;
			y=0;
		}
		
		tablaDeProductos = new JTable(datosDeFilas,nombreDeColumnas);
		JScrollPane scrollPaneTabla = new JScrollPane(tablaDeProductos);
		scrollPaneTabla.setBounds(10, 66, 452, 438);
		add(scrollPaneTabla);
		tablaDeProductos.setEnabled(false);
		
	}
	
	public void MostrarProductosPorCategoria(RegistroDeProductos registroDeProductos)
	{
		String[] nombreDeColumnas = {"Id","Nombre","Descripcion","Marca","Precio"};
		Object[][] datosDeFilas = new Object[registroDeProductos.productos.size()][5];
		int x=0;
		int y=0;
		
		for (Producto producto: registroDeProductos.productos)
		{
			if (comboBoxCategorias.getSelectedItem().equals(producto.getNombreCategoria()))
			{
				datosDeFilas[x][y++] = producto.getId();
				datosDeFilas[x][y++] = producto.getNombre();
				datosDeFilas[x][y++] = producto.getDescripcion();
				datosDeFilas[x][y++] = producto.getMarca();
				datosDeFilas[x][y++] = producto.getPrecio();
				
				x++;
				y=0;
			}
		}
		
		tablaDeProductos = new JTable(datosDeFilas,nombreDeColumnas);
		JScrollPane scrollPaneTabla = new JScrollPane(tablaDeProductos);
		scrollPaneTabla.setBounds(10, 66, 452, 438);
		add(scrollPaneTabla);
		tablaDeProductos.setEnabled(false);
		
	}
	
	public void MostrarProductosPorTipo(RegistroDeProductos registroDeProductos)
	{
		String[] nombreDeColumnas = {"Id","Nombre","Descripcion","Marca","Precio"};
		Object[][] datosDeFilas = new Object[registroDeProductos.productos.size()][5];
		int x=0;
		int y=0;
		
		for (Producto producto: registroDeProductos.productos)
		{
			if (comboBoxTiposDeProducto.getSelectedItem().equals(producto.getNombreTipoProducto()))
			{
				datosDeFilas[x][y++] = producto.getId();
				datosDeFilas[x][y++] = producto.getNombre();
				datosDeFilas[x][y++] = producto.getDescripcion();
				datosDeFilas[x][y++] = producto.getMarca();
				datosDeFilas[x][y++] = producto.getPrecio();
				
				x++;
				y=0;
			}
		}
		
		tablaDeProductos = new JTable(datosDeFilas,nombreDeColumnas);
		JScrollPane scrollPaneTabla = new JScrollPane(tablaDeProductos);
		scrollPaneTabla.setBounds(10, 66, 452, 438);
		add(scrollPaneTabla);
		tablaDeProductos.setEnabled(false);
	}
	
	public void AgregarProductoAlCarrito(RegistroDeProductos registroDeProductos, Carrito carrito)
	{
		int idProductoSeleccionado;
		idProductoSeleccionado = Integer.parseInt(textFieldIdProducto.getText());
		int cantidadDeUnidades;
		cantidadDeUnidades = Integer.parseInt(textFieldCantidad.getText());
		
		if (registroDeProductos.ExisteProductoSeleccionado(idProductoSeleccionado))
		{
			Producto productoElegido = new Producto();
			productoElegido = registroDeProductos.ProductoSeleccionado(idProductoSeleccionado);
			
			if (productoElegido.HayStockDisponible())
			{
				if (productoElegido.HaySuficienteStock(cantidadDeUnidades))
				{
					carrito.AgregarProducto(productoElegido, cantidadDeUnidades);
					lblMensaje.setText(PRODUCTO_AGREGADO_CON_EXITO);
				}
				else
				{
					lblMensaje.setText(MENSAJE_STOCK_INSUFICIENTE);
				}
			}
			else
			{
				lblMensaje.setText(MENSAJE_FALTA_DE_STOCK);
			}
		}
		
		else
		{
			lblMensaje.setText(MENSAJE_PRODUCTO_NO_EXISTENTE);
		}
		
	}
	
	public void VerCarrito() throws IOException
	{
		Programa.MostrarPanel(Panel.VISTA_CARRITO);
	}
	
	public int IdProductoIngresado()
	{
		int idProducto= Integer.parseInt(textFieldIdProducto.getText());
		
		return idProducto;
	}
}
