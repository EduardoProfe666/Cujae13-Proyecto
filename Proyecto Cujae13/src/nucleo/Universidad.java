package nucleo;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import cu.edu.cujae.ceis.tree.general.GeneralTree;
import definiciones.DefinicionesLogica;

public class Universidad implements Serializable{ //Faltarian las localizaciones con el uso de grafos con pesos
	private static final long serialVersionUID = 1L;
	private ArrayList<Facultad> listadoFacultades; //Lista Secuencial
	private ArrayList<Deporte> listadoDeportes; //Lista Secuencial
	private Queue<EventoDia> eventosActivos; //Cola
	private Deque<EventoFinalizado> eventosFinalizados; //Pila 
	private Historia13Marzo historia;
	
	
	public Universidad() {
		eventosFinalizados = new ArrayDeque<EventoFinalizado>();
		eventosActivos = new ArrayDeque<EventoDia>();
		listadoFacultades = new ArrayList<Facultad>(DefinicionesLogica.CANT_MIN_FACULTADES);
	}
	
	public void addFacultad(Facultad f) {
		if(f==null)
			throw new IllegalArgumentException();
		listadoFacultades.add(f);
	}
	public List<Facultad> getListadoFacultades(){
		return new ArrayList<Facultad>(listadoFacultades); 
	}
	
	public ArrayList<Deporte> getListadoDeportes() {
		return listadoDeportes;
	}

	public void setListadoDeportes(ArrayList<Deporte> listadoDeportes) {
		this.listadoDeportes = listadoDeportes;
	}

	public Queue<EventoDia> getEventosActivos() {
		return eventosActivos;
	}

	public void setEventosActivos(Queue<EventoDia> eventosActivos) {
		this.eventosActivos = eventosActivos;
	}

	public Deque<EventoFinalizado> getEventosFinalizados() {
		return eventosFinalizados;
	}

	public void setEventosFinalizados(Deque<EventoFinalizado> eventosFinalizados) {
		this.eventosFinalizados = eventosFinalizados;
	}

	public Historia13Marzo getHistoria() {
		return historia;
	}

	public void setHistoria(Historia13Marzo historia) {
		this.historia = historia;
	}

	public GeneralTree<Facultad> getTablaPosicionesGlobal(){ //Arbol General (Cada Facultad tiene su puntuacion)
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
