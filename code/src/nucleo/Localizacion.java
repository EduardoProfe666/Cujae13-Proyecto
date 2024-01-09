package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

import utilidades.Validaciones;

/**
 * Clase que permite modelar cada localizacion
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 *
 */
public class Localizacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Deporte> deportes;
	private String nombre;
	private String dirUrlImagen;
	private int coordenadaX;
	private int coordenadaY;
	
	public Localizacion(String nombre, String dirUrlImagen, int coordenadaX, int coordenadaY) {
		super();
		this.deportes = new LinkedList<>();
		setNombre(nombre);
		this.dirUrlImagen = dirUrlImagen;
		setCoordenadaX(coordenadaX);
		setCoordenadaY(coordenadaY);
	}

	public LinkedList<Deporte> getDeportes() {
		return deportes;
	}
	
	public void addDeporte(Deporte deporte) {
		if(deporte==null)
			throw new IllegalArgumentException("El deporte no puede ser null");
		deportes.add(deporte);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if(Validaciones.validarStringNoVacio(nombre)){
			if(Validaciones.validarTamString(nombre, 4, 50)){
				this.nombre = nombre;
			} else {
				throw new IllegalArgumentException("El nombre de la localizaci�n debe ser superior a 4 caracteres e inferior a 50 caracteres");
			}
		} else {
			throw new IllegalArgumentException("El nombre de la localizaci�n no debe estar vac�o");
		}
	}

	public String getDirUrlImagen() {
		return dirUrlImagen;
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	private void setCoordenadaX(int coordenadaX) {
		if(coordenadaX >= 0 && coordenadaX <= 900){
			this.coordenadaX = coordenadaX;
		} else {
			throw new IllegalArgumentException("El valor de la coordenada X no es v�lido");
		}
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	private void setCoordenadaY(int coordenadaY) {
		if(coordenadaY >= 0 && coordenadaY <= 600){
			this.coordenadaY = coordenadaY;
		} else {
			throw new IllegalArgumentException("El valor de la coordenada Y no es v�lido");
		}
	}
	
	
	
	
}
