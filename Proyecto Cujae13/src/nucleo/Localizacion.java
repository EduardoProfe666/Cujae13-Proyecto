package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

public class Localizacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Deporte> deportes;
	private String nombre;
	private String dirUrlImagen;
	private int coordenadaX;
	private int coordenadaY;
	
	public Localizacion(LinkedList<Deporte> deportes, String nombre, String dirUrlImagen, int coordenadaX, int coordenadaY) {
		super();
		this.deportes = deportes;
		this.nombre = nombre;
		this.dirUrlImagen = dirUrlImagen;
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	public LinkedList<Deporte> getDeportes() {
		return deportes;
	}

	public void setDeportes(LinkedList<Deporte> deportes) {
		this.deportes = deportes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDirUrlImagen() {
		return dirUrlImagen;
	}

	public void setDirUrlImagen(String dirUrlImagen) {
		this.dirUrlImagen = dirUrlImagen;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	
	
	
	
}
