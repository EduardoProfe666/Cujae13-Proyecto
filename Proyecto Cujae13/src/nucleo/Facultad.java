package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

public class Facultad extends ListenerSupport implements Serializable, Comparable<Facultad>{
	private static final long serialVersionUID = 1L;
	private NombreFacultad nombre;
	private InfoGeneral informacion;
	private LinkedList<Sancion> sanciones;
	private int puntaje;
	
	public Facultad(NombreFacultad nombre, InfoGeneral informacion) {
		super();
		this.nombre = nombre;
		this.informacion = informacion;
		this.puntaje = 0;
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
	public void addPuntaje(int puntaje) {
		this.puntaje+=puntaje;
		firePropertyChange("Puntaje General Cambiado");
	}
	public LinkedList<Sancion> getSanciones() {
		return sanciones;
	}
	
	public void agregarSancion(TipoSancion tipo, String descripcion) {
		sanciones.add(new Sancion(tipo,descripcion));
		addPuntaje(-tipo.getPuntaje());
	}
	
	@Override
	public int compareTo(Facultad f) {
		return Integer.compare(puntaje, f.getPuntaje());
	}
	
	
}
