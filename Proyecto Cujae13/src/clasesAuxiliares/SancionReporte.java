package clasesAuxiliares;

import nucleo.NombreFacultad;
import nucleo.Sancion;

public class SancionReporte {
	private Sancion sancion;
	private NombreFacultad facultad;
	
	
	
	public SancionReporte(Sancion sancion, NombreFacultad facultad) {
		super();
		this.sancion = sancion;
		this.facultad = facultad;
	}
	public Sancion getSancion() {
		return sancion;
	}
	public void setSancion(Sancion sancion) {
		this.sancion = sancion;
	}
	public NombreFacultad getFacultad() {
		return facultad;
	}
	public void setFacultad(NombreFacultad facultad) {
		this.facultad = facultad;
	}
	
	
	
	
}
