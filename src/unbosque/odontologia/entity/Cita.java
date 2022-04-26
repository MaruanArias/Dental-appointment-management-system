package unbosque.odontologia.entity;

import java.util.Date;

public class Cita {
	private String nombre;
	private String apellido;
	private char sexo;
	private String motivoConsulta;
	private Date fecha;
	private String tipoDeCita;
	private double valorProcedimiento;
	private int id;
	private String jornada;

	public Cita(String nombre, String apellido, char sexo, String motivoConsulta, Date pFecha,String tipoCita, 
			double valorPromedioProcedimiento, String jornada)
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.motivoConsulta = motivoConsulta;
		this.fecha =  pFecha;
		this.tipoDeCita = tipoCita;
		this.valorProcedimiento = valorPromedioProcedimiento;
		this.jornada= jornada;
		//this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoDeCita() {
		return tipoDeCita;
	}

	public void setTipoDeCita(String tipoDeCita) {
		this.tipoDeCita = tipoDeCita;
	}

	public double getValorPromedioProcedimiento() {
		return valorProcedimiento;
	}

	public void setValorPromedioProcedimiento(double valorPromedioProcedimiento) {
		this.valorProcedimiento = valorPromedioProcedimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// metodo pra llenar el id
	public int numeroAleatorioID() {
		int resultado;
		resultado=(int) (Math.random() * (100 - 999)) + 999;
		return resultado;
	}
	
	// mostar Informacion
	
	public String mostrarInformacionCitaIndivudial() {
		String lista;
		lista = "Fecha: "+ this.fecha + " ID: "+ this.id;
		lista+= "\n Nombre: " + this.nombre + "\n Apellido: " + this.apellido;
		lista+= " \n sexo :" +  this.sexo;
		lista+= "\n tipo de cita: " +  this.tipoDeCita;
		lista+= "\n valor Procedimiento: " + this.valorProcedimiento+" $";
		return lista;
	}

}
