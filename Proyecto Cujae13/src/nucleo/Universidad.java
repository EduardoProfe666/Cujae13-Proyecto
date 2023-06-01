package nucleo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import cu.edu.cujae.ceis.tree.general.GeneralTree;
import definiciones.DefinicionesLogica;

public class Universidad { //Faltarian las localizaciones con el uso de grafos con pesos
	private ArrayList<Facultad> listadoFacultades; //Lista Secuencial
	private ArrayList<Deporte> listadoDeportes; //Lista Secuencial
	private Queue<EventoDia> eventosActivos; //Cola
	private Deque<EventoFinalizado> eventosFinalizados; //Pila 
	private Historia13Marzo historia;
	private static Universidad instancia;
	
	public static Universidad getInstancia() {
		if(instancia==null)
			instancia = new Universidad();
		return instancia;
	}
	
	private Universidad() {
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
	
	public GeneralTree<Facultad> getTablaPosicionesGlobal(){ //Arbol General (Cada Facultad tiene su puntuacion)
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
