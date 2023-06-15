package nucleo;

import java.io.Serializable;
import java.util.LinkedList;

import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Deporte implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private GeneralTree<ClasificacionDeporte> clasificacion; //Puntaje. Arbol General
	//Al modificar la clasificacion hay que actualizar la estructura del arbol
	private EstadoDeporte estado; //Servira para cerrar el deporte, y puntuar a la tabla de posiciones general 
	private LinkedList<Infraccion> infracciones;
	private Sexo sexo;
	private TipoDeporte tipoDeporte;
	
	public Deporte(String nombre, GeneralTree<ClasificacionDeporte> clasificacion, Sexo sexo, TipoDeporte tipoDeporte) {
		super();
		this.nombre = nombre;
		this.clasificacion = clasificacion;
		estado = EstadoDeporte.EN_EJECUCION;
		infracciones = new LinkedList<>();
		this.sexo = sexo;
		this.tipoDeporte = tipoDeporte;
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

	public EstadoDeporte getEstado() {
		return estado;
	}

	public void setEstado(EstadoDeporte estado) {
		this.estado = estado;
	}
	
	public LinkedList<Infraccion> getInfracciones(){
		return infracciones;
	}
	
	public void addInfraccion(TipoInfraccion tipo, String descripcion, NombreFacultad nombreFacultad) {
		infracciones.add(new Infraccion(tipo,descripcion,nombreFacultad));
	}
	
	public Sexo getSexo() {
		return sexo;
	}

	public TipoDeporte getTipoDeporte() {
		return tipoDeporte;
	}
	
	
}
