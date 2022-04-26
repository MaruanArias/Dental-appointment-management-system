package unbosque.odontologia.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import unbosque.odontologia.entity.Agenda;
import unbosque.odontologia.view.VentanaConsultarDisponibilidad;
import unbosque.odontologia.view.VentanaModificarDatos;
import unbosque.odontologia.view.VistaOdontologia;



public class AplAgendaCita {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		Agenda modelo = new Agenda();
		VistaOdontologia vista = new VistaOdontologia();
		VentanaModificarDatos vistaModificar = new VentanaModificarDatos();
		VentanaConsultarDisponibilidad ventanaDisponibilidad = new VentanaConsultarDisponibilidad();
		ControllerCita controlador = new ControllerCita(modelo, vista,vistaModificar,ventanaDisponibilidad);
	}

}
