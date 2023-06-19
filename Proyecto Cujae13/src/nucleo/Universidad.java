package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import clasesAuxiliares.EstadisticasReporte;
import clasesAuxiliares.InfraccionesReporteFacultad;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import definiciones.DefinicionesLogica;

public class Universidad implements Serializable{ //Faltarian las localizaciones con el uso de grafos con pesos
	private static final long serialVersionUID = 1L;
	private ArrayList<Facultad> listadoFacultades; //Lista Secuencial
	private ArrayList<Deporte> listadoDeportes; //Lista Secuencial
	private Queue<EventoDia> eventosActivos; //Cola
	private LinkedList<EventoDia> eventosPorResultados; //Lista enlazada (Admin)
	private Deque<EventoDiaFinalizado> eventosFinalizados; //Pila 
	private Historia13Marzo historia;
	private LocalDate fechaInicio;
	//private WeightedGraph<Localizacion> localizaciones;

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
	public static Universidad getInstancia(Historia13Marzo historia, LocalDate fechaInicio) {
		if(instancia==null)
			instancia = new Universidad(historia,fechaInicio);
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

	private Universidad(Historia13Marzo historia,LocalDate fechaInicio) {
		eventosFinalizados = new ArrayDeque<EventoDiaFinalizado>();
		eventosActivos = new ArrayDeque<EventoDia>();
		listadoFacultades = new ArrayList<Facultad>(DefinicionesLogica.CANT_MIN_FACULTADES);
		listadoDeportes = new ArrayList<>();
		this.historia = historia;
		this.fechaInicio = fechaInicio;
		eventosPorResultados = new LinkedList<EventoDia>();
		//localizaciones = GraphBuilders.makeSimpleWeightedGraph(false);

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
			this.fechaInicio = u.fechaInicio;
			eventosPorResultados = u.getEventosPorResultados();
			//localizaciones = u.getLocalizaciones();
		}
	}

	public void addFacultad(Facultad f) {
		if(f==null)
			throw new IllegalArgumentException();
		listadoFacultades.add(f);
	}

	public void addDeporte(Deporte d) {
		listadoDeportes.add(d);
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

	/**
	 * Confeccionar el arbol general con las puntuaciones de las facultades. Primero ordenar la lista de facultades de mayor a menor. 
	 * Luego crear el arbol poniendo de hermanos a las facultades empatadas y de hijos a las menores.
	 * @return
	 */
	public GeneralTree<Facultad> getTablaPosicionesGlobal(){ //Arbol General (Cada Facultad tiene su puntuacion)
		GeneralTree<Facultad> tablaPosiciones = new GeneralTree<Facultad>();
		Collections.sort(listadoFacultades, Collections.reverseOrder());

		tablaPosiciones.setRoot(new BinaryTreeNode<Facultad>(listadoFacultades.get(0)));

		for(int i=1; i<listadoFacultades.size(); i++) {
			if(listadoFacultades.get(i).getPuntaje() < listadoFacultades.get(i-1).getPuntaje()) {
				BinaryTreeNode<Facultad> padre = obtenerUltimoNodo(tablaPosiciones);
				BinaryTreeNode<Facultad> n = new BinaryTreeNode<Facultad>(listadoFacultades.get(i));
				tablaPosiciones.insertNode(n, padre);
			}else if(listadoFacultades.get(i).getPuntaje() == listadoFacultades.get(i-1).getPuntaje()) {
				BinaryTreeNode<Facultad> ultimoNodo = obtenerUltimoNodo(tablaPosiciones);
				BinaryTreeNode<Facultad> padre = tablaPosiciones.getFather(ultimoNodo);
				BinaryTreeNode<Facultad> n = new BinaryTreeNode<Facultad>(listadoFacultades.get(i));
				tablaPosiciones.insertNode(n, padre);
			}
		}
		return tablaPosiciones;
	}	

	public BinaryTreeNode<Facultad> obtenerUltimoNodo(GeneralTree<Facultad> arbol){
		BinaryTreeNode<Facultad> ultimoNodo = new BinaryTreeNode<Facultad>();
		InDepthIterator<Facultad> iter = arbol.inDepthIterator();

		while(iter.hasNext()) {
			BinaryTreeNode<Facultad> n = iter.nextNode();
			if(n.getLeft() == null) {
				ultimoNodo = n;
			}
		}
		return ultimoNodo;

	}

	public LinkedList<EventoDia> getEventosPorResultados() {
		return eventosPorResultados;
	}

	//buscar una facultad dada en la lista de facultades
	public Facultad buscarFacultad(NombreFacultad f) {
		Facultad facultad = null;
		boolean encontrado = false;

		if(f== null) {
			throw new IllegalArgumentException("Se necesita el nombre de la facutad");
		}

		for(int i=0; i<listadoFacultades.size() && !encontrado; i++) {
			if(listadoFacultades.get(i).getNombre() == f) {
				facultad = listadoFacultades.get(i);
				encontrado = true;
			}
		}
		return facultad;
	}

	private void actualizarEventosActivos() {
		LocalDate diaActual = LocalDate.now();
		boolean parar = false;

		while(!eventosActivos.isEmpty() && !parar) {
			EventoDia evt = eventosActivos.peek();
			if(evt.getFechaDia().equals(diaActual)) {
				parar = true;
				actualizarEventosActivosDia(evt);
			}else if(evt.getFechaDia().compareTo(diaActual) < 0) {
				if(eventosPorResultados.isEmpty())
					eventosPorResultados.add(new EventoDia(evt.getFechaDia()));
				EventoDia e = eventosPorResultados.getLast();
				if(e.getFechaDia().equals(evt.getFechaDia())) {
					e.getEventosDia().addAll(evt.getEventosDia());
					eventosActivos.poll();
					parar = true;
				}else {
					eventosPorResultados.add(eventosActivos.poll());
					parar = true;
				}
			}else {
				throw new RuntimeException("Viaje en el tiempo");
			}
		}

	}

	private void actualizarEventosActivosDia(EventoDia evt) {	
		if(eventosPorResultados.isEmpty() || !eventosPorResultados.getLast().getFechaDia().equals(LocalDate.now()))
			eventosPorResultados.add(new EventoDia(LocalDate.now()));

		EventoDia e = eventosPorResultados.getLast();
		Iterator<Evento> iter = evt.getEventosDia().iterator(); 

		while(iter.hasNext()) {
			Evento evento = iter.next();
			if(evento.getFecha().compareTo(LocalTime.now())<=0) {
				e.getEventosDia().add(evento);
				iter.remove();

			}
		}
	}


	public LinkedList<Evento> getListadoEventosDiaActual() {
		LinkedList<Evento> lista = null;
		actualizarEventosActivos();
		if(!eventosActivos.isEmpty()) {
			lista = eventosActivos.peek().getEventosDia();
		}
		return lista;

	}

	public void ingresarEvento(Evento e, LocalDate fecha) {
		if(fecha.compareTo(fechaInicio)>=0) {
			boolean insertado = false;
			Queue<EventoDia> colaAuxiliar = new ArrayDeque<>();

			//Buscar fecha
			while(!eventosActivos.isEmpty() && !insertado) {
				EventoDia evt = eventosActivos.peek();
				int comp = fecha.compareTo(evt.getFechaDia());

				if(comp==0) {
					evt.getEventosDia().add(e);
					insertado = true;
				}
				else if(comp<0) {
					EventoDia evtAux = new EventoDia(fecha);
					evtAux.getEventosDia().add(e);
					colaAuxiliar.offer(evtAux);
					insertado = true;
				}	
				else {
					colaAuxiliar.offer(eventosActivos.poll());
				}
			}

			if(!insertado) {
				EventoDia evtAux = new EventoDia(fecha);
				evtAux.getEventosDia().add(e);
				colaAuxiliar.offer(evtAux);
			}

			//Ingresar restantes
			while(!eventosActivos.isEmpty()) {
				colaAuxiliar.offer(eventosActivos.poll());
			}

			//ReingresarEventos
			while(!colaAuxiliar.isEmpty()) {
				eventosActivos.offer(colaAuxiliar.poll());
			}
		}
	}

	public int getCantidadAmonestaciones() {
		return getCantidadInfracciones() + getCantidadSanciones();
	}

	public int getCantidadInfracciones() {
		int cant = 0;

		for(Deporte d : listadoDeportes) {
			cant+=d.getInfracciones().size();
		}

		return cant;
	}

	public int getCantidadSanciones(){
		int cant = 0;

		for(Facultad f : listadoFacultades) {
			cant+=f.getSanciones().size();
		}

		return cant;
	}

	public void actualizar() {
		actualizarEventosActivos();
	}

	public LinkedList<String> nombresDeportes(){
		LinkedList<String> d = new LinkedList<>();

		for(Deporte s : listadoDeportes) {
			d.add(s.getNombre());
		}

		return d;
	}


	public LinkedList<EventoFinalizado> getListadoPartidosConResultadoDiaActual() {
		LinkedList<EventoFinalizado> lista = new LinkedList<EventoFinalizado>();
		Deque<EventoDiaFinalizado> pilaEventos = new ArrayDeque<EventoDiaFinalizado>(eventosFinalizados);


		if(!pilaEventos.isEmpty() && pilaEventos.peek().getFechaDia().compareTo(LocalDate.now()) == 0) {
			lista.addAll(pilaEventos.peek().getEventosDia());

		}

		return lista;
	}

	public EstadisticasReporte obtenerEstadisticas(NombreFacultad f) {
		Facultad fac = buscarFacultad(f);

		int puntaje = fac.getPuntaje();
		int infracciones = obtenerCantInfracciones(fac);
		int sanciones = fac.getSanciones().size();
		int partidosJugados = obtenerCantPartidosJugados(fac);
		int partidosGanados = obtenerCantPartidosGanados(fac);
		int partidosPerdidos = obtenerCantPartidosPerdidos(fac);

		EstadisticasReporte e = new EstadisticasReporte(puntaje, infracciones, sanciones, partidosJugados, partidosGanados, partidosPerdidos);

		return e;
	}

	public int obtenerCantPartidosJugados(Facultad f) {
		int pJugados = 0;
		int tam = 0;
		Deque<EventoDiaFinalizado> pilaEventos = new ArrayDeque<EventoDiaFinalizado>(eventosFinalizados);

		while(!pilaEventos.isEmpty()) {
			EventoDiaFinalizado e = pilaEventos.pop();
			tam = e.getEventosDia().size();
			for(int i=0; i<tam; i++) { 
				if(e.getEventosDia().get(i).getFacultadPrimera().getNombre().equals(f.getNombre()) ||
						e.getEventosDia().get(i).getFacultadSegunda().getNombre().equals(f.getNombre())) {
					pJugados++;
				}
			}
		}

		return pJugados;
	}

	public int obtenerCantPartidosGanados(Facultad f) {
		int pGanados = 0;
		int tam = 0;
		Deque<EventoDiaFinalizado> pilaEventos = new ArrayDeque<EventoDiaFinalizado>(eventosFinalizados);

		while(!pilaEventos.isEmpty()) {
			EventoDiaFinalizado e = pilaEventos.pop();
			tam = e.getEventosDia().size();
			for(int i=0; i<tam; i++) {
				if(e.getEventosDia().get(i).getResultado().getFacultadGanadora().equals(f)) {
					pGanados++;
				}
			}
		}

		return pGanados;
	}

	public int obtenerCantPartidosPerdidos(Facultad f) {
		int pPerdidos = 0;
		int tam = 0;
		Deque<EventoDiaFinalizado> pilaEventos = new ArrayDeque<EventoDiaFinalizado>(eventosFinalizados);

		while(!pilaEventos.isEmpty()) {
			EventoDiaFinalizado e = pilaEventos.pop();
			tam = e.getEventosDia().size();
			for(int i=0; i<tam; i++) {
				if((e.getEventosDia().get(i).getFacultadPrimera().getNombre().equals(f.getNombre()) ||
								e.getEventosDia().get(i).getFacultadSegunda().getNombre().equals(f.getNombre())) &&
						!e.getEventosDia().get(i).getResultado().getFacultadGanadora().equals(f)) {
					pPerdidos++;
				}
			}
		}

		return pPerdidos;
	}

	public int obtenerCantInfracciones(Facultad f) {
		int infracciones = 0;
		int tam = listadoDeportes.size();

		for(int i=0; i<tam; i++) {
			LinkedList<Infraccion> infrac = listadoDeportes.get(i).getInfracciones();
			Iterator<Infraccion> iter = infrac.iterator();
			while(iter.hasNext()) {
				Infraccion inf = iter.next();
				if(inf.getNombreFacultad().equals(f.getNombre())) {
					infracciones++;
				}
			}
		}

		return infracciones;
	}

	public LinkedList<InfraccionesReporteFacultad> getListadoInfracciones(NombreFacultad f){
		LinkedList<InfraccionesReporteFacultad> lista = new LinkedList<InfraccionesReporteFacultad>();

		Facultad fac = buscarFacultad(f);

		for(int i=0; i<listadoDeportes.size(); i++) {
			LinkedList<Infraccion> infrac = listadoDeportes.get(i).getInfracciones();
			Iterator<Infraccion> iter = infrac.iterator();
			while(iter.hasNext()) {
				Infraccion inf = iter.next();
				if(inf.getNombreFacultad().equals(fac.getNombre())) {
					InfraccionesReporteFacultad rep = new InfraccionesReporteFacultad(inf, listadoDeportes.get(i).getNombre());
					lista.add(rep);
				}
			}
		}

		return lista;
	}

	public LinkedList<EventoFinalizado> obtenerEventosDiaDado(NombreFacultad f, LocalDate fecha){
		LinkedList<EventoFinalizado> lista = new LinkedList<EventoFinalizado>();
		Deque<EventoDiaFinalizado> pilaEventos = new ArrayDeque<EventoDiaFinalizado>(eventosFinalizados);
		Facultad fac = buscarFacultad(f);

		while(!pilaEventos.isEmpty()) {
			EventoDiaFinalizado e = pilaEventos.pop();
			if(e.getFechaDia().equals(fecha)) {
				List<EventoFinalizado> eventos = e.getEventosDia();
				for(int i=0; i<eventos.size(); i++) {
					if(eventos.get(i).getFacultadPrimera().equals(fac) ||
							eventos.get(i).getFacultadSegunda().equals(fac)) {
						lista.add(eventos.get(i));
					}
				}
			}
		}

		return lista;
	}

	/**
	 * Provisional
	 */
	public void ingresarEventoFinalizado(EventoFinalizado e, LocalDate fecha) {
		Deque<EventoDiaFinalizado> pila = new ArrayDeque<EventoDiaFinalizado>(eventosFinalizados);
		boolean ingresado = false;

		while(!pila.isEmpty() && !ingresado) {
			EventoDiaFinalizado evento = pila.pop();
			if(fecha.compareTo(evento.getFechaDia())==0) {
				evento.getEventosDia().add(e);
				ingresado = true;
			}
		}

		if(!ingresado) {
			EventoDiaFinalizado evento = new EventoDiaFinalizado(fecha);
			evento.getEventosDia().add(e);

			if(eventosFinalizados.isEmpty() || eventosFinalizados.peek().getFechaDia().compareTo(fecha)<0) {
				eventosFinalizados.push(evento);
			}
			else {
				pila = new ArrayDeque<EventoDiaFinalizado>();
				boolean terminado = false;

				while(!eventosFinalizados.isEmpty() && !terminado) {
					EventoDiaFinalizado ev = eventosFinalizados.peek();
					if(evento.getFechaDia().compareTo(ev.getFechaDia())>0) {
						eventosFinalizados.push(evento);
						terminado = true;
					}
					else {
						pila.push(eventosFinalizados.pop());
					}
				}

				if(!terminado)
					eventosFinalizados.push(evento);

				while(!pila.isEmpty())
					eventosFinalizados.push(pila.pop());
			}
		}
	}

	//Metodo para obtener la lista de eventos correspondientes a un dia seleccionado por el usuario//
	public LinkedList<Evento> devolverListaEventosPorDia(LocalDate fecha) {
		LinkedList<Evento> listaEventosPorDia=new LinkedList<Evento>();
		Queue<EventoDia> colaCopia = new ArrayDeque<EventoDia>(eventosActivos);
		boolean encontrado=false;
		while(!colaCopia.isEmpty() && !encontrado) {
			EventoDia eventosPorDia=colaCopia.poll();		
			if(eventosPorDia.getFechaDia().equals(fecha)){
				for(int i=0; i<eventosPorDia.getEventosDia().size();i++) {
					listaEventosPorDia.add(eventosPorDia.getEventosDia().get(i));
				}
				encontrado=true;
			}

		}
		return listaEventosPorDia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public int obtenerLugar(NombreFacultad f) {
		int lugar = 0;
		boolean encontrado = false;
		GeneralTree<Facultad> tabla = getTablaPosicionesGlobal();
		InDepthIterator<Facultad> iter = tabla.inDepthIterator();

		while(iter.hasNext() && !encontrado) {
			BinaryTreeNode<Facultad> nodo = iter.nextNode();
			if(nodo.getInfo().getNombre().equals(f)) {
				lugar = tabla.nodeLevel(nodo) + 1;
				encontrado = true;
			}
		}

		return lugar;
	}


	/**
	 * Retorna todas las localizaciones, agregando como peso si presenta deportes activos
	 * @return
	 */
	//	public WeightedGraph<LocalizacionPeso> getLocalizacionesDeportesActivos() {
	//		return null;
	//	}
	//	
	//	public WeightedGraph<Localizacion> getLocalizaciones() {
	//		return localizaciones;
	//	}




















}
