package nucleo;

import java.io.Serializable;

public class ClasificacionDeporte implements Serializable, Comparable<ClasificacionDeporte>{
	private static final long serialVersionUID = 1L;
	private Facultad facultad;
	private int puntaje;
	
	public ClasificacionDeporte(Facultad facultad,int puntaje) {
		super();
		this.facultad = facultad;
		this.setPuntaje(puntaje);
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	@Override
	public int compareTo(ClasificacionDeporte o) {
		return Integer.compare(puntaje, o.puntaje);
	}
}
