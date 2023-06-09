package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

public class Facultad implements Serializable, Comparable<Facultad>{
	private static final long serialVersionUID = 1L;
	private NombreFacultad nombre;
	private InfoGeneral informacion;
	private LinkedList<Sancion> sanciones;
	private int puntaje;
	
	public Facultad(NombreFacultad nombre, InfoGeneral informacion, int puntaje) {
		super();
		this.nombre = nombre;
		this.informacion = informacion;
		this.puntaje = puntaje;
		this.sanciones = new LinkedList<>();
	}
	public NombreFacultad getNombre() {
		return nombre;
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
	
	@Override
	public int compareTo(Facultad f) {
		return Integer.compare(puntaje, f.getPuntaje());
	}
	
	
}
