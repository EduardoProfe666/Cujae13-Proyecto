package nucleo;

import java.io.Serializable;

public class ClasificacionDeporte implements Serializable, Comparable<ClasificacionDeporte>{
	private static final long serialVersionUID = 1L;
	private Facultad facultad;
	private int puntaje;
	
	public ClasificacionDeporte(Facultad facultad,int puntaje) {
		super();
		setFacultad(facultad);
		this.setPuntaje(puntaje);
	}
	
	public Facultad getFacultad() {
		return facultad;
	}
	
	private void setFacultad(Facultad facultad) {
		if(facultad != null){
			this.facultad = facultad;
		} else {
			throw new IllegalArgumentException("La facultad no debe estar vacía");
		}
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int puntaje) {
		if(puntaje >= -500 && puntaje <= 700){
			this.puntaje = puntaje;
		} else {
			throw new IllegalArgumentException("El puntaje debe ser mayor o igual que -500 y menor o igual que 700");
		}
	}
	
	@Override
	public int compareTo(ClasificacionDeporte o) {
		return Integer.compare(puntaje, o.puntaje);
	}
}
