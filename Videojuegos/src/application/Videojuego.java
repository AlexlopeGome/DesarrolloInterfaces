package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Videojuego {

	private SimpleStringProperty nombre;
	private SimpleFloatProperty precio;
	private SimpleStringProperty consola;
	private SimpleIntegerProperty PEGI;
	
	public Videojuego (String nombre, float precio, 
			String consola, int PEGI) {
		
		this.nombre = new SimpleStringProperty(nombre);
		this.precio = new SimpleFloatProperty(precio);
		this.consola = new SimpleStringProperty(consola);
		this.PEGI = new SimpleIntegerProperty(PEGI);
	}
	public void setNombre(String nombre) {
		this.nombre=new SimpleStringProperty(nombre);
	}
	public String getNombre() {
		return nombre.get();
	}
	
	public void setPrecio(float precio) {
		this.precio = new SimpleFloatProperty(precio);
	}
	
	public float getPrecio() {
		return precio.get();
	}
	
	public void setConsola(String consola) {
		this.consola = new SimpleStringProperty(consola);
	}
	
	public String getConsola() {
		return consola.get();
	}
	
	public void setAutor(String consola) {
		this.consola= new SimpleStringProperty(consola);
	}
	
	public int getPEGI() {
		return PEGI.get();
	}
	
	public void setPEGI(int PEGI) {
		this.PEGI = new SimpleIntegerProperty(PEGI);
	}
	
}
