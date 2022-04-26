package unbosque.odontologia.entity;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import unbosque.odontologia.view.VistaOdontologia;

public class Agenda {

	private static ArrayList<Cita> m = new ArrayList<Cita>();

	public Agenda() {
	}

	public String getCantidadPacientes() {
		return "En este momento hay " + "[" + m.size() + "]" + " pacientes";
	}

	public String agregarCita(Cita pCita) {
		String resultado = "";
		m.add(pCita);
		resultado = "Se ha registrado el paciente...";
		return resultado;
	}
/**
 * Método que elimina un objecto cita por medio del id
 * Method that removes a quoted object by means of the id
 * @param id
 * @return String con la confirmación de que se ha eliminado el objecto cita
 */
	public String eliminarPaciente(int id) {
		String resultado = "no se encontro el paciente";
		int x = 0;
		for (int i = 0; i < m.size() && x == 0; i++) {
			if (m.get(i).getId() == id) {
				m.remove(i);
				x++;
				resultado = "se ha eliminado el paciente";
			}
		}
		return resultado;
	}

	public String mostrarInformacionCitas() {
		String listadoPacientes = "*** LISTA DE PACIENTES ***** \n Fecha--------Jornada--------id------Nombre------Apellido"
				+ "-------Sexo-----Tipo cita--------Valor Procedimiento\n";
		listadoPacientes += "----------------------------------------------------------------------------------------\n";
		Iterator<Cita> itrCitas = m.iterator();
		while (itrCitas.hasNext()) {
			Cita cita = itrCitas.next();

			listadoPacientes += cita.getFecha() + "---" + cita.getJornada() + "-----" + "[" + cita.getId() + "]"
					+ "------" + cita.getNombre() + "---------" + cita.getApellido() + "----------" + cita.getSexo()
					+ "-----" + cita.getTipoDeCita() + "----------------" + "$" + cita.getValorPromedioProcedimiento()
					+ "\n" + "Motivo consulta: " + cita.getMotivoConsulta() + "\n";
		}
		return listadoPacientes;
	}

	public String listaPacientes = "hola gente como esta";

	/**
	 * Método que consulta un objecto cita por medio del id
	 * Method that queries a quoted object by means of the id
	 * @param id
	 * @return
	 */
	public String consultarCita(int id) {
		String infoPaciente = "No se encontro el paciente";
		int x = 0;
		for (int i = 0; i < m.size() && x == 0; i++) {
			if (m.get(i).getId() == id) {
				infoPaciente = m.get(i).mostrarInformacionCitaIndivudial();
				x++;
			}
		}
		return infoPaciente;
	}

	public double calcularValorPromedioCita() {
		double suma = 0;
		double resultado = 0;
		for (int i = 0; i < m.size(); i++) {
			suma += m.get(i).getValorPromedioProcedimiento();
		}
		if (m.size() != 0)
			resultado = suma / m.size();
		return resultado;
	}
/**
 * Método para modicar los atributos de la clase cita
 * Method for modifying the attributes of the appointment class
 * @param id
 * @param pnombre
 * @param pApellido
 * @param pSexo
 * @param pTipoCita
 * @param pValorProcedimiento
 * @return objecto cita con nuevos valores en los atributos
 */
	public String modificarCita(int id, String pnombre, String pApellido, char pSexo, String pTipoCita,
			double pValorProcedimiento) {
		String resultado = "No se encontro el paciente";
		int x = 0;
		String w = "null";
		String q = "null";
		double e = 0;
		char y = 'x';
		String k = "null";
		for (int i = 0; i < m.size() && x == 0; i++) {

			if (m.get(i).getId() == id) {
				x++;
				// ---->NOMBRE
				if ("".equals(pnombre)) {
					w = m.get(i).getNombre();
					m.get(i).setNombre(w);
				} else {
					m.get(i).setNombre(pnombre);
				}
				// --->APELLIDO
				if ("".equals(pApellido)) {
					q = m.get(i).getApellido();
					m.get(i).setApellido(q);
				} else {
					m.get(i).setApellido(pApellido);
				}
				// ---->SEXO
				if (pSexo == 'y') {
					y = m.get(i).getSexo();
					m.get(i).setSexo(y);
				} else {
					m.get(i).setSexo(pSexo);
				}
				// ---->TIPO CITA
				if (pTipoCita.equals("null")) {
					k = m.get(i).getTipoDeCita();
					m.get(i).setTipoDeCita(k);
				} else {
					m.get(i).setTipoDeCita(pTipoCita);
				}
				// ----->VALOR PROCEDIMIENTO
				if (pValorProcedimiento == 0) {
					e = m.get(i).getValorPromedioProcedimiento();
					m.get(i).setValorPromedioProcedimiento(e);
				} else {
					m.get(i).setValorPromedioProcedimiento(pValorProcedimiento);
				}
				resultado = "se modificaron los datos";
			}
		}
		return resultado;
	}
/**
 * Método que muestra la disponibilidad citas en el horario de la mañana y tarde
 * Method showing availability of appointments in the morning and afternoon hours
 * @param xfecha
 * @return String con la informacion de disponibilidad de las citas
 */
	public String monstrarDisponibilidadCitas(Date xfecha) {

		String resultado = "no hay disponibilidad";
		int contador = 0;
		int contadorTarde = 0;
		int contadorMañana = 0;
		int disponibilidad = 0;
		int disponibilidadMañana = 0;
		int disponibilidadTarde = 0;
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).getFecha().equals(xfecha)) {
				contador++;
				if (m.get(i).getJornada().equals("Mañana")) {
					contadorMañana++;
				} else {
					contadorTarde++;
				}
			}
		}
		if (contador < 20) {
			disponibilidad = 20 - contador;
			if (contadorMañana <10)
				disponibilidadMañana = 10 - contadorMañana;
			if (contadorTarde <10)
				disponibilidadTarde = 10 - contadorTarde;;
			
				resultado = "en este momento hay " + disponibilidad + "  cita disponible\n"
						+ "en la mañana hay disponible " + disponibilidadMañana + " citas \n"
						+ "en la tarde hay disponible " + disponibilidadTarde;
		}
		return resultado;
	}
/**
 * Método para generar un PDF con el listado de las citas
 * Method to generate a PDF with the list of citations
 * @return String que confirma que se genero el PDF
 * @see Método mostrarInformacionCitas
 */
	public String imprimirPDF() {
		String resultado = "";
		// Se crea el documento
		// Instance of the document object
		Document documento = new Document();
		try {
			// primero creamos el flujo de salida de datos para guardalos en un archivo
			// Data output stream to save it to a file
			FileOutputStream fichero1 = new FileOutputStream("prueba.pdf");
			// Se asocia el documento al OutputStream(Flujo de salida) y se indica que el
			// espaciado entre lineas
			PdfWriter.getInstance(documento, fichero1).setInitialLeading(20);
			; // le pasamos dos parametros el primero el documento ,el segundo el fichero

			// Se abre el documento.
			documento.open();

			// ------------------AÑADIR ELEMENTOS AL DOCUMENTO------------------------//
			documento.add(new Paragraph(mostrarInformacionCitas()));//
			// Cerramos el documento
			documento.close();

			resultado = "Se genero el Pdf";

		} catch (Exception e) {

		}

		return resultado;

	}

}
