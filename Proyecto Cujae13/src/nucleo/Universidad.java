package nucleo;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import cu.edu.cujae.ceis.tree.general.GeneralTree;
import definiciones.DefinicionesLogica;

public class Universidad implements Serializable{ //Faltarian las localizaciones con el uso de grafos con pesos
	private static final long serialVersionUID = 1L;
	private ArrayList<Facultad> listadoFacultades; //Lista Secuencial
	private ArrayList<Deporte> listadoDeportes; //Lista Secuencial
	private Queue<EventoDia> eventosActivos; //Cola
	private LinkedList<EventoDia> eventosPorResultados; //Lista enlazada (Admin)
	private Deque<EventoDiaFinalizado> eventosFinalizados; //Pila 
	private Historia13Marzo historia;
	private static Universidad instancia;
	
	/**
	 * Se usará esta normalmente
	 * 
	 * @return
	 */
	public static Universidad getInstancia() {
		if(instancia==null)
			throw new RuntimeException("La instancia de universidad no ha sido inicializada");
		return instancia;
	}
	
	/**
	 * SOLO PARA CONSTRUCCION DE INSTANCIA
	 * 
	 * @param historia
	 * @return
	 */
	public static Universidad getInstancia(Historia13Marzo historia) {
		if(instancia==null)
			instancia = new Universidad(historia);
		return instancia;
	}
	/**
	 * SOLO PARA CONTRUCCION DE INSTANCIA
	 * @param u
	 * @return
	 */
	public static Universidad getInstancia(Universidad u) {
		if(instancia==null)
			instancia = new Universidad(u);
		return instancia;
	}
	
	private Universidad(Historia13Marzo historia) {
		eventosFinalizados = new ArrayDeque<EventoDiaFinalizado>();
		eventosActivos = new ArrayDeque<EventoDia>();
		listadoFacultades = new ArrayList<Facultad>(DefinicionesLogica.CANT_MIN_FACULTADES);
		listadoDeportes = new ArrayList<>();
		this.historia = historia;
		eventosPorResultados = new LinkedList<EventoDia>();
	}
	
	/**
	 * Constructor Copia. Sirve para la hora de la instanciación
	 * 
	 * @param u
	 */
	private Universidad(Universidad u) {
		if(u!=null) {
			eventosFinalizados = u.getEventosFinalizados();
			eventosActivos = u.getEventosActivos();
			listadoFacultades = u.getListadoFacultades();
			listadoDeportes = u.getListadoDeportes();
			this.historia = u.getHistoria();
			eventosPorResultados = u.getEventosPorResultados();
		}
	}
	
	public void addFacultad(Facultad f) {
		if(f==null)
			throw new IllegalArgumentException();
		listadoFacultades.add(f);
	}
	
	/**
	 * Se retorna una copia del listado original de facultades, para 
	 * proteger la información.
	 * 
	 * @return Listado de Facultad
	 */
	public ArrayList<Facultad> getListadoFacultades(){
		return new ArrayList<Facultad>(listadoFacultades); 
	}
	/**
	 * Se retorna una copia del listado original de deportes, para 
	 * proteger la información.
	 * 
	 * @return Listado de Facultad
	 */
	public ArrayList<Deporte> getListadoDeportes() {
		return listadoDeportes;
	}

	public Queue<EventoDia> getEventosActivos() {
		return eventosActivos;
	}

	public Deque<EventoDiaFinalizado> getEventosFinalizados() {
		return eventosFinalizados;
	}
	
	public Historia13Marzo getHistoria() {
		return historia;
	}

	public GeneralTree<Facultad> getTablaPosicionesGlobal(){ //Arbol General (Cada Facultad tiene su puntuacion)
		return null;
	}

	public LinkedList<EventoDia> getEventosPorResultados() {
		return eventosPorResultados;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
