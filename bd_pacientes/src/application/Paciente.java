package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Paciente {
	private int id;
	private SimpleStringProperty nombre;
	private SimpleStringProperty apellidoUno;
	private SimpleStringProperty apellidoDos;
	private SimpleIntegerProperty edad;
	private SimpleStringProperty sexo;
	private SimpleStringProperty enfermedad;
	private SimpleIntegerProperty duracion;
	private SimpleStringProperty dHM;

	public Paciente(String nombre, String apellidoUno, String apellidoDos, int edad, String sexo, String enfermedad,
			int duracion, String dHM) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.apellidoUno = new SimpleStringProperty(apellidoUno);
		this.apellidoDos = new SimpleStringProperty(apellidoDos);
		this.edad = new SimpleIntegerProperty(edad);
		this.sexo = new SimpleStringProperty(sexo);
		this.enfermedad = new SimpleStringProperty(enfermedad);
		this.duracion = new SimpleIntegerProperty(duracion);
		this.dHM = new SimpleStringProperty(dHM);
	}

	public Paciente(int id, String nombre, String apellidoUno, String apellidoDos, int edad, String sexo,
			String enfermedad, int duracion, String dHM) {
		super();
		this.id = id;
		this.nombre = new SimpleStringProperty(nombre);
		this.apellidoUno = new SimpleStringProperty(apellidoUno);
		this.apellidoDos = new SimpleStringProperty(apellidoDos);
		this.edad = new SimpleIntegerProperty(edad);
		this.sexo = new SimpleStringProperty(sexo);
		this.enfermedad = new SimpleStringProperty(enfermedad);
		this.duracion = new SimpleIntegerProperty(duracion);
		this.dHM = new SimpleStringProperty(dHM);
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public String getApellidoUno() {
		return apellidoUno.get();
	}

	public void setApellidoUno(String apellidoUno) {
		this.apellidoUno = new SimpleStringProperty(apellidoUno);
	}

	public String getApellidoDos() {
		return apellidoDos.get();
	}

	public void setApellidoDos(String apellidoDos) {
		this.apellidoDos = new SimpleStringProperty(apellidoDos);
	}

	public int getEdad() {
		return edad.get();
	}

	public void setEdad(int edad) {
		this.edad = new SimpleIntegerProperty(edad);

	}

	public String getSexo() {
		return sexo.get();
	}

	public void setSexo(String sexo) {
		this.sexo = new SimpleStringProperty(sexo);

	}

	public String getEnfermedad() {
		return enfermedad.get();
	}

	public void setEmfermedad(String enfermedad) {
		this.enfermedad = new SimpleStringProperty(enfermedad);

	}

	public int getDuracion() {
		return duracion.get();
	}

	public void setDuracion(int duracion) {
		this.duracion = new SimpleIntegerProperty(duracion);

	}

	public String getDHM() {
		return dHM.get();
	}

	public void setDHM(String dHM) {
		this.dHM= new SimpleStringProperty(dHM);
	}

}
