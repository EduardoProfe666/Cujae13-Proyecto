package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

public class Facultad implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private InfoGeneral informacion;
	private LinkedList<Sancion> sanciones;
	private int puntaje;
	
	public Facultad(String nombre, InfoGeneral informacion, int puntaje) {
		super();
		this.nombre = nombre;
		this.informacion = informacion;
		this.puntaje = puntaje;
		this.sanciones = new LinkedList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public InfoGeneral getInformacion() {
		return informacion;
	}
	public void setInformacion(InfoGeneral informacion) {
		this.informacion = informacion;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public LinkedList<Sancion> getSanciones() {
		return sanciones;
	}
	
	
}
