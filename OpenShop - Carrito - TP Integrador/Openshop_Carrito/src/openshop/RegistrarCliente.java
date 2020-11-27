package openshop;

import static openshop.Json.JSON_MAPPER;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrarCliente extends JPanel {
	
	public JTextField textFieldIdCliente;
	private JTextField textFieldDomicilio;
	private JTextField textFieldProvincia;
	private JTextField textFieldDni;
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JTextField textFieldMail;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	
	private JLabel lblIdCliente;
	private JLabel lblDomicilio;
	private JLabel lblProvincia;
	private JLabel lblDni;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContraseña;
	private JLabel lblMail;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblMensaje;
	
	private JButton btnRegistrarCliente;
	private JButton btnVolver;
	
	final String MENSAJE_ID_EXISTENTE = "El número de Id ya pertenece a otro cliente. Ingrese otro número";
	final String MENSAJE_USUARIO_O_CONTRASEÑA_EXISTENTE = "Usuario y/o contraseña existente";
	final String MENSAJE_REGISTRO_EXITOSO = "Se ha registrado el cliente con éxito. Vuelva para iniciar sesión";
	final String MENSAJE_DATOS_NO_INGRESADOS = "No igreso el número ID o el DNI. Deben estar ingresados el DNI y el ID para poder registrarse";

	
	public RegistrarCliente(RegistroDeClientes registroDeClientes) {
		setLayout(null);
		
		JLabel lblTitulo = new JLabel("OPENSHOP");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(247, 37, 133, 31);
		add(lblTitulo);
		
		JLabel lblRegistroDeCliente = new JLabel("Registro de cliente:");
		lblRegistroDeCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegistroDeCliente.setBounds(31, 84, 206, 25);
		add(lblRegistroDeCliente);
		
		lblIdCliente = new JLabel("ID:");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdCliente.setBounds(31, 120, 55, 31);
		add(lblIdCliente);
		
		lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDomicilio.setBounds(31, 151, 76, 31);
		add(lblDomicilio);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProvincia.setBounds(31, 180, 68, 31);
		add(lblProvincia);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDni.setBounds(31, 211, 76, 31);
		add(lblDni);
		
		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseña.setBounds(31, 268, 76, 31);
		add(lblContraseña);
		
		lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeUsuario.setBounds(31, 238, 127, 31);
		add(lblNombreDeUsuario);
		
		lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMail.setBounds(31, 294, 76, 31);
		add(lblMail);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(31, 322, 76, 31);
		add(lblApellido);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(31, 351, 76, 31);
		add(lblNombre);
		
		textFieldIdCliente = new JTextField();
		textFieldIdCliente.setColumns(10);
		textFieldIdCliente.setBounds(62, 127, 186, 20);
		add(textFieldIdCliente);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(95, 158, 186, 20);
		add(textFieldDomicilio);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setColumns(10);
		textFieldProvincia.setBounds(95, 187, 186, 20);
		add(textFieldProvincia);
		
		textFieldDni = new JTextField();
		textFieldDni.setColumns(10);
		textFieldDni.setBounds(75, 218, 186, 20);
		add(textFieldDni);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(168, 245, 212, 20);
		add(textFieldUsuario);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(117, 275, 186, 20);
		add(textFieldContraseña);
		
		textFieldMail = new JTextField();
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(75, 301, 186, 20);
		add(textFieldMail);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(95, 329, 186, 20);
		add(textFieldApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(95, 358, 186, 20);
		add(textFieldNombre);
		
		btnRegistrarCliente = new JButton("Registrar cliente");
		btnRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					RegistrarUsuario(registroDeClientes);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnRegistrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarCliente.setBounds(168, 424, 135, 25);
		add(btnRegistrarCliente);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBounds(31, 393, 586, 20);
		add(lblMensaje);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Volver();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(343, 424, 135, 25);
		add(btnVolver);
		
	}
	
	public void RegistrarUsuario(RegistroDeClientes registroDeClientes) throws IOException
	{
		
		String domicilio = textFieldDomicilio.getText();
		String provincia = textFieldProvincia.getText();
		String nombreDeUsuario = textFieldUsuario.getText();
		String contraseña = textFieldContraseña.getText();
		String mail = textFieldMail.getText();
		String apellido = textFieldApellido.getText();
		String nombre = textFieldNombre.getText();
		
		
		if (SeIngresoId(textFieldIdCliente.getText())&&(SeIngresoDNI(textFieldDni.getText())))
		{
			int idCliente = Integer.parseInt(textFieldIdCliente.getText());
			int dni = Integer.parseInt(textFieldDni.getText());
			if (!(registroDeClientes.UsuarioOContraseñaExistentes(nombreDeUsuario,contraseña)))
			{
					
				if(!(registroDeClientes.IdExistente(idCliente)))
				{
					Cliente cliente = new Cliente();
					cliente.setApellido(apellido);
					cliente.setNombre(nombre);
					cliente.setUsuario(nombreDeUsuario);
					cliente.setContraseña(contraseña);
					cliente.setDni(dni);
					cliente.setDomicilio(domicilio);
					cliente.setProvincia(provincia);
					cliente.setMail(mail);
					cliente.setIdCliente(idCliente);
						
					registroDeClientes.clientes.add(cliente);
						
					lblMensaje.setText(MENSAJE_REGISTRO_EXITOSO);
				}
				else
				{
						lblMensaje.setText(MENSAJE_ID_EXISTENTE);
				}
			}
				
			else
			{
				lblMensaje.setText(MENSAJE_USUARIO_O_CONTRASEÑA_EXISTENTE);
			}
				
			JSON_MAPPER.writeValue(new File("C:\\Users\\Usuario\\eclipse-workspace\\Openshop_Carrito\\Clientes.json"),
						registroDeClientes);
		}
		
		else
		{
			lblMensaje.setText(MENSAJE_DATOS_NO_INGRESADOS);
		}
		
	}
	
	public void Volver() throws IOException
	{
		Programa.MostrarPanel(Panel.INICIO_SESION);
	}
	
	public int idClienteIngesado()
	{
		int idCliente = Integer.parseInt(textFieldIdCliente.getText());
		return idCliente;
	}
	
	private boolean SeIngresoId(String txtIdCliente)
	{
		if (!(txtIdCliente.isEmpty()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean SeIngresoDNI(String txtDNI)
	{
		if (!(txtDNI.isEmpty()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}