package unbosque.odontologia.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class VistaOdontologia extends JFrame{

	// atributos variables
	public JLabel etiquetaImagenC;
	//imagenes
	public ImageIcon imagen;
	public ImageIcon imagenEliminar;
	public ImageIcon imagenRegistrar;
	public ImageIcon imagenConsultar;
	public ImageIcon imagenImprimir;
	public ImageIcon imagenMostrar;
	//Etiquetas ventana 1
	public JLabel etiquetaResultado;
	public JLabel etiquetaNombre;
	public JLabel etiquetaApellido;
	public JLabel etiquetaSexo;
	public JLabel etiquetaMotivoConsulta;
	public JLabel etiquetaFecha;
	public JLabel etiquetaTipoCita;
	public JLabel etiquetaValorProcedimiento;
	public JLabel etiquetaId;
	public JLabel etiqueta$;
	public JLabel etiquetaJornada;
	
	// Campo de Texto ventana 1
	public JTextField campoTextoNombre;
	public JTextField campoTextoApellido;
	public JTextField campoTextoFecha;
	public JTextField campoTextoValorProcedimiento;
	public JTextField campoTextoId;
	
	//Area De texto  ventana 1
	public JTextArea areaTextoMotivoConsulta;
	
	// Botones ventana 1 
	public JButton botonRegistrar;
	public JButton botonListaDePacientes;
	public JButton botonCantidadPacientes;
	public JButton botonConsultarPaciente;
	public JButton botonEliminar; 
	public JButton botonModificar;
	public JButton botonCalcularValorPromedio;
	public JButton botonMostrarDisponibilidad;
	public JButton botonImprimirPDF;
	// Botones de cajas de Texto ventana
	public JComboBox botonEscogerSexo;
	public JComboBox botonEscogerTipoDeCita;
	public JComboBox botonEscogerJornada;
	
	//calendario ventana 1
	public JDateChooser calendario;
	//Paneles
	public JPanel panel1;
	public JPanel panel2;
	public JFrame ventana;
	public JFrame ventana2;
	
	public VistaOdontologia(){
		
		 ventana = new JFrame("Formulario Cita");
		 
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		
		/**imagen = new ImageIcon("calendario.png");
		etiquetaImagenC = new JLabel(imagen);
		etiquetaImagenC.setBounds(50,400, 300,300);**/
		
		//Creamos las instancias de las etiquetas
		etiquetaNombre = new JLabel ("Nombre: ");
		etiquetaNombre.setBounds(20, 45, 50, 10);
	   
		etiquetaApellido = new JLabel("Apellido: ");
		etiquetaApellido.setBounds(200, 45, 50, 10);
		
		etiquetaSexo = new JLabel("Sexo: ");
		etiquetaSexo.setBounds(20,75, 50, 10);
		etiquetaMotivoConsulta = new JLabel("Motivo Consulta:");
		etiquetaMotivoConsulta.setBounds(20, 110, 100, 10);
		
		etiquetaFecha = new JLabel("Fecha: ");
		etiquetaFecha.setBounds(20, 15, 50, 10);
		
		etiquetaTipoCita = new JLabel ("Tipo de Cita:");
		etiquetaTipoCita.setBounds(182, 75, 80, 10);
		
		etiquetaJornada = new JLabel("Jornada:");
		etiquetaJornada.setBounds(198, 100, 80, 10);
		
		etiquetaValorProcedimiento = new JLabel("Valor Procedimiento:");
		etiquetaValorProcedimiento.setBounds(10, 220, 100, 10);
		
		etiqueta$ = new JLabel("$");
		etiqueta$.setBounds(240, 220, 10, 10);
		
		etiquetaId = new JLabel("Id:");
		etiquetaId.setBounds(115, 275, 30, 20);
		etiquetaId.setEnabled(false);//-->Desactivar la etiqueta Id
		
		etiquetaResultado = new JLabel();
		etiquetaResultado.setBounds(120, 245, 200, 20);
		
		
		//Creamos las instancias de los campos de Texto
		          //Nombre
		campoTextoNombre = new JTextField(20);
		campoTextoNombre.setBounds(70, 40, 120, 20);
		         //Apellido
		campoTextoApellido = new JTextField(20);
		campoTextoApellido.setBounds(250, 40, 120, 20);
		
		//campoTextoFecha = new JTextField(20);
		//campoTextoFecha.setBounds(70, 10, 120, 20);
		
		campoTextoValorProcedimiento = new JTextField(20);
		campoTextoValorProcedimiento.setBounds(115, 215, 120, 20);
		
		campoTextoId = new JTextField(20);
		campoTextoId.setBounds(135, 275, 80, 20);
		campoTextoId.setEnabled(false);
		
		// Area de Texto
		areaTextoMotivoConsulta = new JTextArea();
		areaTextoMotivoConsulta.setBounds(10,130,365,70);
		
		
		// Botones con lista
		String [] sexos = {"------------------------","(M)Masculino","(F)Femenino"};
		botonEscogerSexo = new JComboBox(sexos);
		botonEscogerSexo.setBounds(70, 70, 90, 20);
		String [] tipoCita = {"------------------------","Ortodoncia","Odontología General","Limpieza","Periodoncia","Selladores"};
		botonEscogerTipoDeCita = new JComboBox(tipoCita);
		botonEscogerTipoDeCita.setBounds(250, 70, 110, 20);
		String[] jornada= {"---------","Mañana","Tarde"};
		botonEscogerJornada = new JComboBox(jornada);
		botonEscogerJornada.setBounds(250, 95, 70, 20);
		
		// Agregas Etiquetas y campo de texto al panel
		panel1.add(etiquetaNombre);
		panel1.add(campoTextoNombre);
		panel1.add(etiquetaApellido);
		panel1.add(campoTextoApellido);
		panel1.add(etiquetaFecha);
		//panel1.add(campoTextoFecha);
		panel1.add(etiquetaSexo);
		panel1.add(botonEscogerSexo);
		panel1.add(etiquetaTipoCita);
		panel1.add(botonEscogerTipoDeCita);
		panel1.add(etiquetaMotivoConsulta);
		panel1.add(areaTextoMotivoConsulta);
		panel1.add(etiquetaValorProcedimiento);
		panel1.add(campoTextoValorProcedimiento);
		panel1.add(etiqueta$);
		panel1.add(etiquetaId);
		panel1.add(campoTextoId);
		panel1.add(etiquetaResultado);
		panel1.add(etiquetaJornada);
		panel1.add(botonEscogerJornada);
		
		//---------->panel1.add(etiquetaImagenC);		
		//creacion calendario
		calendario = new JDateChooser(); 
		calendario.setBounds(70, 10, 150, 20);
		// Creamos las intancia botones
		botonRegistrar = new JButton("Registar");
		botonRegistrar.setBounds(20, 300, 97, 20);
		imagenRegistrar = new ImageIcon("registrar.png");
		botonRegistrar.setIcon(new ImageIcon(imagenRegistrar.getImage().getScaledInstance(15, 14,Image.SCALE_SMOOTH)));
		botonRegistrar.setOpaque(true);
		botonRegistrar.setBackground(Color.GREEN);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(20, 350, 97, 20);
		imagenEliminar = new ImageIcon("eliminar.PNG");
		botonEliminar.setIcon(new ImageIcon(imagenEliminar.getImage().getScaledInstance(15, 18, Image.SCALE_SMOOTH)));
		botonEliminar.setBackground(Color.RED);
		botonEliminar.setEnabled(false);
		
		botonConsultarPaciente = new JButton("Consultar");
		botonConsultarPaciente.setBounds(20, 325, 97, 20);
		imagenConsultar = new ImageIcon("consultar.png");
		botonConsultarPaciente.setIcon(new ImageIcon(imagenConsultar.getImage().getScaledInstance(15, 18, Image.SCALE_SMOOTH)));
		botonConsultarPaciente.setEnabled(false);
		
		botonListaDePacientes = new JButton("Mostar Lista Pacientes");
		botonListaDePacientes.setBounds(170, 300, 200, 20);
		imagenMostrar = new ImageIcon("mostrar.png");
		botonListaDePacientes.setIcon(new ImageIcon(imagenMostrar.getImage().getScaledInstance(15, 18, Image.SCALE_SMOOTH)));
		botonListaDePacientes.setEnabled(false);
		
		
		botonCantidadPacientes = new JButton("Cantidad");
		botonCantidadPacientes.setBounds(170, 350, 80, 20);
		botonCantidadPacientes.setEnabled(false);
		
		botonModificar = new JButton("Modificar");
		botonModificar.setBounds(170, 325, 80, 20);
		botonModificar.setEnabled(false);
		
		botonCalcularValorPromedio= new JButton("Valor Promedio");
		botonCalcularValorPromedio.setBounds(260, 350, 110, 20);
		botonCalcularValorPromedio.setEnabled(false);
		
		botonMostrarDisponibilidad = new JButton("Diponibilidad");
		botonMostrarDisponibilidad.setBounds(260, 325, 110, 20);
		botonMostrarDisponibilidad.setEnabled(false);
		
		botonImprimirPDF= new JButton("Imprimir");
		botonImprimirPDF.setBounds(280, 10, 90, 20);
		imagenImprimir = new ImageIcon("imprimir.png");
		botonImprimirPDF.setIcon(new ImageIcon(imagenImprimir.getImage().getScaledInstance(15, 18, Image.SCALE_SMOOTH)));
		botonImprimirPDF.setEnabled(false);
		
		//nAgregar calendario
		panel1.add(calendario);
		//Agregamos Botones al panel
		panel1.add(botonRegistrar);
		panel1.add(botonEliminar);
		panel1.add(botonConsultarPaciente);
		panel1.add(botonListaDePacientes);
		panel1.add(botonCantidadPacientes);
		panel1.add(botonModificar);
		panel1.add(botonCalcularValorPromedio);
		panel1.add(botonMostrarDisponibilidad);
		panel1.add(botonImprimirPDF);
		
		ventana.setContentPane(panel1);
		ventana.setVisible(true);
		ventana.setSize(400,420);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
	public void mostrarMensajes(String men) {
		JOptionPane.showMessageDialog(null, men);
	}

	
}
