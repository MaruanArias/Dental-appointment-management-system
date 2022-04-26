package unbosque.odontologia.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

public class VentanaConsultarDisponibilidad extends JFrame{
  public JDateChooser calendario2;
  public JLabel etiquetaFecha2;
  public JButton botonConsultarDisponibilidad;
  public JFrame ventana;
  public JPanel panelD;
  
  public VentanaConsultarDisponibilidad(){
	  ventana = new JFrame("consultar Disponibilidad");
	  panelD = new JPanel();
	  panelD.setLayout(null);
	  
	  etiquetaFecha2 = new JLabel("fecha: ");
	  etiquetaFecha2.setBounds(20, 15, 50, 10);
	  
	  calendario2 = new JDateChooser();
	  calendario2.setBounds(70, 10, 150, 20);
	  
	  botonConsultarDisponibilidad = new JButton("Consular");
	  botonConsultarDisponibilidad.setBounds(100, 50, 80, 20);
	  
	  // Agregar al panel
	  panelD.add(etiquetaFecha2);
	  panelD.add(calendario2);
	  panelD.add(botonConsultarDisponibilidad);
	  
	  ventana.setSize(300, 150);
	  ventana.setLocationRelativeTo(null);
	  ventana.setContentPane(panelD);
	  ventana.setVisible(false);
  }
}
