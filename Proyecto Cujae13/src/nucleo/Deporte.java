package nucleo;

import java.io.Serializable;

import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Deporte implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private GeneralTree<ClasificacionDeporte> clasificacion; //Puntaje. Arbol General
	//Al modificar la clasificacion hay que actualizar la estructura del arbol
	
	public Deporte(String nombre, GeneralTree<ClasificacionDeporte> clasificacion) {
		super();
		this.nombre = nombre;
		this.clasificacion = clasificacion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GeneralTree<ClasificacionDeporte> getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(GeneralTree<ClasificacionDeporte> clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	
}
