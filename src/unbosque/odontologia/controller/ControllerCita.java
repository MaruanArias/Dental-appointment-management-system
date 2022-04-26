package unbosque.odontologia.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

import unbosque.odontologia.entity.Agenda;
import unbosque.odontologia.entity.Cita;
import unbosque.odontologia.view.VentanaConsultarDisponibilidad;
import unbosque.odontologia.view.VentanaModificarDatos;
import unbosque.odontologia.view.VistaOdontologia;


public class ControllerCita implements ActionListener {
	public char pSexo = 'o';
	public String pTipoCita = "null";
	public String pJornada ="null";

	Agenda agenda = null;
	VistaOdontologia vistaOdontologia = null;
	VentanaModificarDatos vistaModificar = null;
	VentanaConsultarDisponibilidad ventanaDisponibilidad = null;
	
	

	public ControllerCita(Agenda agenda, VistaOdontologia vistaOdontologia, VentanaModificarDatos vistaModificar,
			VentanaConsultarDisponibilidad ventanaDisponibilidad) {
		this.agenda = agenda;
		this.vistaOdontologia = vistaOdontologia;
		this.vistaModificar = vistaModificar;
		this.ventanaDisponibilidad = ventanaDisponibilidad;
		actionListener(this);
	}

	// METODO PARA ESCUCHAR EVENTOS
	public void actionListener(ActionListener escuchador) {
		
		vistaOdontologia.botonEscogerSexo.addActionListener(escuchador);
		vistaOdontologia.botonEscogerTipoDeCita.addActionListener(escuchador);
		vistaOdontologia.botonRegistrar.addActionListener(escuchador);
		vistaOdontologia.botonConsultarPaciente.addActionListener(escuchador);
		vistaOdontologia.botonEliminar.addActionListener(escuchador);
		vistaOdontologia.botonModificar.addActionListener(escuchador);
		vistaOdontologia.botonListaDePacientes.addActionListener(escuchador);
		vistaOdontologia.botonCantidadPacientes.addActionListener(escuchador);
		vistaOdontologia.botonCalcularValorPromedio.addActionListener(escuchador);
		vistaModificar.botonEnviar.addActionListener(escuchador);
		vistaModificar.botonCajaSexo.addActionListener(escuchador);
		vistaModificar.botonCajaTipoCita.addActionListener(escuchador);
		vistaOdontologia.botonMostrarDisponibilidad.addActionListener(escuchador);
		ventanaDisponibilidad.botonConsultarDisponibilidad.addActionListener(escuchador);
		vistaOdontologia.botonImprimirPDF.addActionListener(escuchador);
		vistaOdontologia.botonEscogerJornada.addActionListener(escuchador);
	}

	@Override
	public void actionPerformed(ActionEvent objEvento) {
		// TODO Auto-generated method stub

		// validar datos boton sexo paciente
		if (vistaOdontologia.botonEscogerSexo == objEvento.getSource()) {
			int i = vistaOdontologia.botonEscogerSexo.getSelectedIndex();

			if (i == 1) {
				pSexo = 'M';

			} else {
				pSexo = 'F';
			}

		}
		// validar tipo de cita
		if (vistaOdontologia.botonEscogerTipoDeCita == objEvento.getSource()) {
			int o = vistaOdontologia.botonEscogerTipoDeCita.getSelectedIndex();

			if (o == 1) {
				pTipoCita = "Ortodoncia";

			} else if (o == 2) {
				pTipoCita = "Odotonlogia General";

			} else if (o == 3) {
				pTipoCita = "Limpieza";

			} else if (o == 4) {
				pTipoCita = "Periodoncia";

			} else if (o == 5) {
				pTipoCita = "Selladores";

			}
		}
		if(vistaOdontologia.botonEscogerJornada== objEvento.getSource()) {
			int s = vistaOdontologia.botonEscogerJornada.getSelectedIndex();
			if(s==1) {
				pJornada="Mañana";
			}else {
				pJornada="Tarde";
			}
		}

		if (vistaOdontologia.botonRegistrar == objEvento.getSource()) {// --> destectamos la accion de presionar el
																		// boton
			if (!"".equals(vistaOdontologia.campoTextoNombre.getText())
					&& !"".equals(vistaOdontologia.campoTextoApellido.getText())) {
				
				try {
					
					String pNombre = vistaOdontologia.campoTextoNombre.getText();
					String pApellido = vistaOdontologia.campoTextoApellido.getText();
					String pMotivoConsulta = vistaOdontologia.areaTextoMotivoConsulta.getText();
					Long pFecha = vistaOdontologia.calendario.getDate().getTime();
					Date sFecha = new Date(pFecha);
					double pValorProcedimiento = Double
							.parseDouble(vistaOdontologia.campoTextoValorProcedimiento.getText());
					// Creamos objeto de cita

					Cita cita = new Cita(pNombre, pApellido, pSexo, pMotivoConsulta, sFecha, pTipoCita,
							pValorProcedimiento,pJornada);
					// añadimos el Id ALEATORIO
					cita.setId(cita.numeroAleatorioID());
					String mensaje = "";
					mensaje = this.agenda.agregarCita(cita);

					vistaOdontologia.etiquetaResultado.setText(mensaje);
					
					// Activamos los botones
					vistaOdontologia.etiquetaId.setEnabled(true);
					vistaOdontologia.botonCantidadPacientes.setEnabled(true);
					vistaOdontologia.botonConsultarPaciente.setEnabled(true);
					vistaOdontologia.botonListaDePacientes.setEnabled(true);
					vistaOdontologia.botonEliminar.setEnabled(true);
					vistaOdontologia.botonModificar.setEnabled(true);
					vistaOdontologia.campoTextoId.setEnabled(true);
					vistaOdontologia.botonCalcularValorPromedio.setEnabled(true);
					vistaOdontologia.botonMostrarDisponibilidad.setEnabled(true);
					vistaOdontologia.botonImprimirPDF.setEnabled(true);

					// Limpiamos campos de texto
					vistaOdontologia.campoTextoNombre.setText("");
					vistaOdontologia.campoTextoApellido.setText("");
					vistaOdontologia.campoTextoValorProcedimiento.setText("");
					vistaOdontologia.areaTextoMotivoConsulta.setText("");

				} catch (NumberFormatException e) {
					vistaOdontologia.etiquetaResultado.setText("Se ha presentado un error");
					vistaOdontologia.campoTextoNombre.setText("");
					vistaOdontologia.campoTextoApellido.setText("");
					vistaOdontologia.campoTextoValorProcedimiento.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Todos los campos son  requeridos", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (vistaOdontologia.botonCantidadPacientes == objEvento.getSource()) {
			String resultado = this.agenda.getCantidadPacientes();
			vistaOdontologia.mostrarMensajes(resultado);

		} else if (vistaOdontologia.botonListaDePacientes == objEvento.getSource()) {
			String resultado = this.agenda.mostrarInformacionCitas();
			vistaOdontologia.mostrarMensajes(resultado);
			
		} else if (vistaOdontologia.botonEliminar == objEvento.getSource()) {
			String resultado = "";
			if (!"".equals(vistaOdontologia.campoTextoId.getText())) {
				int id = Integer.parseInt(vistaOdontologia.campoTextoId.getText());
				resultado = this.agenda.eliminarPaciente(id);
				
			} else {
				resultado = "ingrese un id para eliminar el pacienet";
			}
			
			vistaOdontologia.etiquetaResultado.setText(resultado);
			vistaOdontologia.campoTextoId.setText("");
			
		} else if (vistaOdontologia.botonConsultarPaciente == objEvento.getSource()) {
			
			
			if (!"".equals(vistaOdontologia.campoTextoId.getText())) {
				String resultado="";
				int id = Integer.parseInt(vistaOdontologia.campoTextoId.getText());
				resultado = this.agenda.consultarCita(id);
				vistaOdontologia.mostrarMensajes(resultado);
			}else {
				JOptionPane.showMessageDialog(null,"ingrese un Id para consultar");
			}
			
			vistaOdontologia.campoTextoId.setText("");
			
		} else if (vistaOdontologia.botonModificar == objEvento.getSource()) {
			String resultado;
			vistaOdontologia.ventana.setVisible(true);
			vistaModificar.frame.setVisible(true);
			
		} else if (vistaOdontologia.botonCalcularValorPromedio == objEvento.getSource()) {
			String resultado = "valor promedio: " + this.agenda.calcularValorPromedioCita() + " $";
			vistaOdontologia.mostrarMensajes(resultado);
			
		} else if (vistaModificar.botonEnviar == objEvento.getSource()) {

			try {
				// --validacion Datos boton escoger sexo----------
				char mSexo = 'x';
				int iBotonSex = vistaModificar.botonCajaSexo.getSelectedIndex();
				if (iBotonSex == 1) {
					mSexo = 'M';
				} else if (iBotonSex == 0) {
					mSexo = 'y';
				} else {
					mSexo = 'F';
				}
				// --validacion Datos boton escoger Tipo cita-----------
				String mTipoCita = "null";
				int iBotonTipoCita = vistaModificar.botonCajaTipoCita.getSelectedIndex();

				if (iBotonTipoCita == 1) {
					mTipoCita = "Ortodoncia";

				} else if (iBotonTipoCita == 2) {
					mTipoCita = "Odotonlogia General";

				} else if (iBotonTipoCita == 3) {
					mTipoCita = "Limpieza";

				} else if (iBotonTipoCita == 4) {
					mTipoCita = "Periodoncia";

				} else if (iBotonTipoCita == 5) {
					mTipoCita = "Selladores";

				} else if (iBotonTipoCita == 0) {
					mTipoCita = "null";
				}
				// obtenemos ID-----------------------
				int id2 = Integer.parseInt(vistaModificar.campoTextoId2.getText());

				// --- Validar VALOR PROCEDIMIENTO----------
				double mValorProcedimiento = 1;
				if ("".equals(vistaModificar.campoTextoValorProcedimiento2.getText())) {
					mValorProcedimiento = 0;
				} else {
					mValorProcedimiento = Double.parseDouble(vistaModificar.campoTextoValorProcedimiento2.getText());
				}

				String mNombre = vistaModificar.campoTextoNombre2.getText();
				
				String mApellido = vistaModificar.campoTextoApellido2.getText();

				String resultado = this.agenda.modificarCita(id2, mNombre, mApellido, mSexo, mTipoCita,
						mValorProcedimiento);
				vistaOdontologia.mostrarMensajes(resultado);

				// limpiamos campos
				vistaModificar.campoTextoNombre2.setText("");
				vistaModificar.campoTextoApellido2.setText("");
				vistaModificar.campoTextoValorProcedimiento2.setText("");
                vistaModificar.campoTextoId2.setText("");
			} catch (NumberFormatException e) {
				String salida = " se ha presentado un errror";
				JOptionPane.showMessageDialog(null, salida, null, JOptionPane.ERROR_MESSAGE);
				vistaModificar.campoTextoNombre2.setText("");
				vistaModificar.campoTextoApellido2.setText("");
				vistaModificar.campoTextoValorProcedimiento2.setText("");
				 vistaModificar.campoTextoId2.setText("");
			}
			
		} else if (vistaOdontologia.botonMostrarDisponibilidad == objEvento.getSource()) {
			ventanaDisponibilidad.ventana.setVisible(true);
			
			
		} else if (ventanaDisponibilidad.botonConsultarDisponibilidad == objEvento.getSource()) {
			Long xFecha = ventanaDisponibilidad.calendario2.getDate().getTime();
			Date vFecha = new Date(xFecha);

			String resultado = agenda.monstrarDisponibilidadCitas(vFecha);
			vistaOdontologia.mostrarMensajes(resultado);

		}else if(vistaOdontologia.botonImprimirPDF == objEvento.getSource()) {
			vistaOdontologia.mostrarMensajes(agenda.imprimirPDF());
		}

	}
}
