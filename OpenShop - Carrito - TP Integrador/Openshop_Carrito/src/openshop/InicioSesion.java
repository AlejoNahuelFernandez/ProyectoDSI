package openshop;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class InicioSesion extends JPanel {
	private JLabel lblTitulo,lblSubtitulo,lblMensaje;
	private JTextField textFieldUsuario, textFieldContrase�a;
	private JButton btnIngresar;
	
	//static RegistroDeClientes registroDeClientes;
	
	final String MENSAJE_CLIENTE_NO_EXISTENTE = "Cliente no existente. Debe registrarse para continuar";
	private JButton btnRegistrarse;
	
	static Cliente cliente;
	
	public InicioSesion(RegistroDeClientes registroDeClientes) 
	{
		setLayout(null);
		lblTitulo = new JLabel("OPENSHOP");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(252, 49, 133, 31);
		add(lblTitulo);
		
		lblSubtitulo = new JLabel("Inicio de sesi\u00F3n");
		lblSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubtitulo.setBounds(46, 109, 156, 25);
		add(lblSubtitulo);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreDeUsuario.setBounds(144, 161, 133, 31);
		add(lblNombreDeUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(299, 168, 186, 20);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrase�a = new JLabel("Contrase�a:");
		lblContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrase�a.setBounds(144, 237, 97, 31);
		add(lblContrase�a);
		
		textFieldContrase�a = new JTextField();
		textFieldContrase�a.setColumns(10);
		textFieldContrase�a.setBounds(252, 244, 186, 20);
		add(textFieldContrase�a);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBounds(73, 315, 506, 20);
		add(lblMensaje);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					IniciarSesion(registroDeClientes);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIngresar.setBounds(259, 378, 107, 33);
		add(btnIngresar);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Programa.MostrarPanel(Panel.REGISTRO_CLIENTE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarse.setBounds(406, 378, 107, 33);
		add(btnRegistrarse);
	}
	
	public void IniciarSesion(RegistroDeClientes registroDeClientes) throws IOException
	{
		String nombreDeUsuario,contrase�a;
		
		nombreDeUsuario = textFieldUsuario.getText();
		contrase�a = textFieldContrase�a.getText();
		
		if (registroDeClientes.ExisteCliente(nombreDeUsuario, contrase�a))
		{
			cliente = registroDeClientes.ClienteActual(nombreDeUsuario, contrase�a);
			Programa.MostrarPanel(Panel.PRINCIPAL);
		}
		else
		{
			lblMensaje.setText(MENSAJE_CLIENTE_NO_EXISTENTE);
		}
	}
	
	public static Cliente ClienteIngresado()
	{
		return cliente;
	}
	
	
}
