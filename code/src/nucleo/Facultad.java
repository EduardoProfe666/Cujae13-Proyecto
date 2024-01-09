package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Clase que permite modelar las facultades con sus respectivos datos
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public class Facultad extends ListenerSupport implements Serializable, Comparable<Facultad>{
	private static final long serialVersionUID = 1L;
	private NombreFacultad nombre;
	private InfoGeneral informacion;
	private LinkedList<Sancion> sanciones;
	private int puntaje;
	
	public Facultad(NombreFacultad nombre, InfoGeneral informacion) {
		super();
		this.nombre = nombre;
		setInformacion(informacion);
		this.puntaje = 0;
		this.sanciones = new LinkedList<>();
	}
	
	public NombreFacultad getNombre() {
		return nombre;
	}
	
	public InfoGeneral getInformacion() {
		return informacion;
	}
	
	private void setInformacion(InfoGeneral informacion) {
		if(informacion != null){
			this.informacion = informacion;
		} else {
			throw new IllegalArgumentException("La información de la facultad no debe estar vacía");
		}
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void addPuntaje(int puntaje) {
		this.puntaje += puntaje;
		firePropertyChange("Puntaje General Cambiado");
	}
	
	public LinkedList<Sancion> getSanciones() {
		return sanciones;
	}
	
	/**
	 * Permite agregar una sancion que tributa a la tabla de posiciones general
	 * 
	 * @param tipo
	 * @param descripcion
	 */
	public void agregarSancion(TipoSancion tipo, String descripcion) {
		sanciones.add(new Sancion(tipo,descripcion));
		addPuntaje(-tipo.getPuntaje());
	}
	
	@Override
	public int compareTo(Facultad f) {
		return Integer.compare(puntaje, f.getPuntaje());
	}
	
	
}
