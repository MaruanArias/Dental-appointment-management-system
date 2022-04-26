package unbosque.odontologia.view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class VentanaModificarDatos extends JFrame {

	public JFrame frame;
	public JLabel lblNombre;
	public JLabel lblApellido;
	public JLabel lblSexo;
	public JLabel etiquetaTitulo;
	public JTextField campoTextoNombre2;
	public JTextField campoTextoApellido2;
	public JTextField campoTextoValorProcedimiento2;
	public JTextField campoTextoId2;
    public JButton botonEnviar;
    public JComboBox botonCajaSexo;
    public JComboBox botonCajaTipoCita;
    
    public ImageIcon imagenTitulo;
	
	public VentanaModificarDatos() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 199, 344);
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(63, 79, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(63, 123, 46, 14);
		frame.getContentPane().add(lblApellido);
		
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(22, 168, 46, 14);
		frame.getContentPane().add(lblSexo);
		
		campoTextoNombre2 = new JTextField();
		campoTextoNombre2.setBounds(33, 92, 123, 20);
		frame.getContentPane().add(campoTextoNombre2);
		campoTextoNombre2.setColumns(10);
		
		campoTextoApellido2 = new JTextField();
		campoTextoApellido2.setBounds(33, 137, 123, 20);
		frame.getContentPane().add(campoTextoApellido2);
		campoTextoApellido2.setColumns(10);
		String[] listaSexo = {"--------","masculino","femenino"};
		botonCajaSexo = new JComboBox(listaSexo);
		botonCajaSexo.setBounds(66, 165, 76, 20);
		frame.getContentPane().add(botonCajaSexo);
		
		JLabel lblTipoCita = new JLabel("Tipo cita");
		lblTipoCita.setBounds(10, 193, 46, 14);
		frame.getContentPane().add(lblTipoCita);
		String [] tipoCita = {"----------------","Ortodoncia","Odontología General","Limpieza","Periodoncia","Selladores"};
		botonCajaTipoCita = new JComboBox(tipoCita);
		botonCajaTipoCita.setBounds(66, 190, 76, 20);
		frame.getContentPane().add(botonCajaTipoCita);
		
		JLabel lblValorProcedimiento = new JLabel("valor Procedimiento");
		lblValorProcedimiento.setBounds(40, 215, 104, 14);
		frame.getContentPane().add(lblValorProcedimiento);
		
		campoTextoValorProcedimiento2 = new JTextField();
		campoTextoValorProcedimiento2.setBounds(33, 240, 123, 20);
		frame.getContentPane().add(campoTextoValorProcedimiento2);
		campoTextoValorProcedimiento2.setColumns(10);
		
	    botonEnviar = new JButton("Enviar");
		botonEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonEnviar.setBounds(53, 271, 89, 23);
		frame.getContentPane().add(botonEnviar);
		
		
		imagenTitulo = new ImageIcon("tituloModificar.PNG");
		etiquetaTitulo = new JLabel();
		etiquetaTitulo.setBounds(18, 5, 150, 30);
		etiquetaTitulo.setIcon(new ImageIcon(imagenTitulo.getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH)));
	    frame.getContentPane().add(etiquetaTitulo);
		
		JLabel label = new JLabel("----------------------");
		label.setBounds(25, 18, 96, 7);
		frame.getContentPane().add(label);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(81, 36, 31, 14);
		frame.getContentPane().add(lblId);
		
		campoTextoId2 = new JTextField();
		campoTextoId2.setBounds(33, 48, 123, 20);
		frame.getContentPane().add(campoTextoId2);
		campoTextoId2.setColumns(10);
	}
}
