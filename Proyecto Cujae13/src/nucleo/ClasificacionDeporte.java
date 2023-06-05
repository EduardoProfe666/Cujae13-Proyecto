package nucleo;

import java.io.Serializable;

public abstract class ClasificacionDeporte implements Serializable{
	private static final long serialVersionUID = 1L;
	private Facultad facultad;
	
	
	
	public ClasificacionDeporte(Facultad facultad) {
		super();
		this.facultad = facultad;
	}
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
}
