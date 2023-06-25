package nucleo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import clasesAuxiliares.EstadisticasReporte;
import clasesAuxiliares.InfraccionReporte;
import clasesAuxiliares.SancionReporte;
import cu.edu.cujae.ceis.graph.LinkedGraphModificado;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeWeightedVertexNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.BreadthNode;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIteratorWithLevels;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;
import definiciones.DefinicionesLogica;
import nucleo.InicializacionPartidosDeporte.EventoFecha;

public class Universidad extends ListenerSupport implements Serializable{ //Faltarian las localizaciones con el uso de grafos con pesos
	private static final long serialVersionUID = 1L;
	private ArrayList<Facultad> listadoFacultades; //Lista Secuencial
	private ArrayList<Deporte> listadoDeportes; //Lista Secuencial
	private Queue<EventoDia> eventosActivos; //Cola
	private LinkedList<EventoDia> eventosPorResultados; //Lista enlazada (Admin)
	private Deque<EventoDiaFinalizado> eventosFinalizados; //Pila 
	private Historia13Marzo historia;
	private LocalDate fechaInicio;
	private GeneralTree<Facultad> tablaPosiciones;
	private ILinkedWeightedEdgeWeightedVertexNotDirectedGraph<Localizacion, Boolean, Integer> localizaciones;

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
		localizaciones = new LinkedGraphModificado<>();

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
			this.tablaPosiciones = u.tablaPosiciones;
			localizaciones = u.getLocalizaciones();
		}
	}

	public void addFacultad(Facultad f) {
		if(f==null)
			throw new IllegalArgumentException();
		listadoFacultades.add(f);

		addListenerPuntaje(f);
	}

	public void addDeporte(String nombre, Sexo sexo, TipoDeporte tipoDeporte) {
		if(nombre == null || sexo == null || tipoDeporte == null)
			throw new IllegalArgumentException();

		Deporte d = new Deporte(nombre, listadoFacultades, sexo, tipoDeporte);
		listadoDeportes.add(d);
		addListenerPuntaje(d);

		d.addPropertyChangeListener("Deporte Terminado", new PropertyChangeListener() {
			//Coger tabla de posiciones y agregar puntaje de acuerdo con el tipo de deporte
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				HashMap<Integer,Integer> sistPuntuacion = d.getTipoDeporte().getSistemaPuntuacion();
				GeneralTree<ClasificacionDeporte> pos = d.getTablaPosiciones();

				BinaryTreeNode<ClasificacionDeporte> n = (BinaryTreeNode<ClasificacionDeporte>)pos.getRoot();
				BinaryTreeNode<ClasificacionDeporte> nH = n.getRight();

				n.getInfo().getFacultad().addPuntaje(sistPuntuacion.get(1));

				while(nH!=null) {
					nH.getInfo().getFacultad().addPuntaje(sistPuntuacion.get(1));
					nH = nH.getRight();
				}

				InBreadthIteratorWithLevels<ClasificacionDeporte> iter = pos.inBreadthIteratorWithLevels();
				iter.next();
				while(iter.hasNext()) {
					BreadthNode<ClasificacionDeporte> bn = iter.nextNodeWithLevel();
					bn.getInfo().getFacultad().addPuntaje(sistPuntuacion.get( bn.getLevel()+1));
				}
			}
		});
	}

	public void inicializarTorneoDeporte(InicializacionPartidosDeporte inic) {
		inic.getDeporte().inicializarTorneo(inic.getListadoPartidos());
		insertarEventos(inic.getListadoPartidos());
	}

	private void insertarEventos(List<EventoFecha> listado) {
		for(EventoFecha e : listado) {
			ingresarEvento(e.getEvento(), e.getFecha());
		}

	}

	/**
	 * Esto permitira actualizar la tabla de posiciones cada vez que se cambia el puntaje por cualquiera de las 
	 * variantes
	 * @param l
	 */
	private void addListenerPuntaje(ListenerSupport l) {
		l.addPropertyChangeListener("Puntaje General Cambiado", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				construirTablaPosiciones();
			}
		});
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
		if(tablaPosiciones==null || tablaPosiciones.isEmpty()) {
			construirTablaPosiciones();
		}
		return tablaPosiciones;
	}	

	private void construirTablaPosiciones() {
		tablaPosiciones = new GeneralTree<Facultad>();
		Collections.sort(listadoFacultades, Collections.reverseOrder());

		Iterator<Facultad> iter = listadoFacultades.iterator();
		tablaPosiciones.setRoot(new BinaryTreeNode<Facultad>(iter.next()));
		BinaryTreeNode<Facultad> ultimo = ((BinaryTreeNode<Facultad>)tablaPosiciones.getRoot());
		BinaryTreeNode<Facultad> padre = null;
		int pUltimo = ultimo.getInfo().getPuntaje();


		while(iter.hasNext()) {
			Facultad d1 = iter.next();
			BinaryTreeNode<Facultad> n = new BinaryTreeNode<Facultad>(d1);
			if(pUltimo > d1.getPuntaje()) {
				tablaPosiciones.insertNode(n, ultimo);
				pUltimo = d1.getPuntaje();
				padre = ultimo;
				ultimo = n;
			}
			else {
				tablaPosiciones.insertNode(n, padre);
			}
		}

	}

	//	private void construirTablaPosiciones() {
	//		tablaPosiciones = new GeneralTree<Facultad>();
	//		Collections.sort(listadoFacultades, Collections.reverseOrder());
	//
	//		tablaPosiciones.setRoot(new BinaryTreeNode<Facultad>(listadoFacultades.get(0)));
	//
	//		for(int i=1; i<listadoFacultades.size(); i++) {
	//			if(listadoFacultades.get(i).getPuntaje() < listadoFacultades.get(i-1).getPuntaje()) {
	//				BinaryTreeNode<Facultad> padre = obtenerUltimoNodo(tablaPosiciones);
	//				BinaryTreeNode<Facultad> n = new BinaryTreeNode<Facultad>(listadoFacultades.get(i));
	//				tablaPosiciones.insertNode(n, padre);
	//			}else if(listadoFacultades.get(i).getPuntaje() == listadoFacultades.get(i-1).getPuntaje()) {
	//				BinaryTreeNode<Facultad> ultimoNodo = obtenerUltimoNodo(tablaPosiciones);
	//				BinaryTreeNode<Facultad> padre = tablaPosiciones.getFather(ultimoNodo);
	//				BinaryTreeNode<Facultad> n = new BinaryTreeNode<Facultad>(listadoFacultades.get(i));
	//				tablaPosiciones.insertNode(n, padre);
	//			}
	//		}
	//	}
	//
	//	private BinaryTreeNode<Facultad> obtenerUltimoNodo(GeneralTree<Facultad> arbol){
	//		BinaryTreeNode<Facultad> ultimoNodo = new BinaryTreeNode<Facultad>();
	//		InDepthIterator<Facultad> iter = arbol.inDepthIterator();
	//
	//		while(iter.hasNext()) {
	//			BinaryTreeNode<Facultad> n = iter.nextNode();
	//			if(n.getLeft() == null) {
	//				ultimoNodo = n;
	//			}
	//		}
	//		return ultimoNodo;
	//
	//	}

	public LinkedList<EventoDia> getEventosPorResultados() {
		return eventosPorResultados;
	}

	//buscar una facultad dada en la lista de facultades
	public Facultad buscarFacultad(NombreFacultad f) {
		Facultad facultad = null;
		boolean encontrado = false;

		if(f== null) {
			throw new IllegalArgumentException("Se necesita el nombre de la facultad");
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
				}else {
					eventosPorResultados.add(eventosActivos.poll());
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
			if(evento.getFecha().compareTo(LocalTime.now().minusMinutes(15))<=0) {
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

	private void ingresarEvento(Evento e, LocalDate fecha) {
		rellenarEventosActivos(fecha);
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
		else {
			throw new IllegalArgumentException();
		}
	}

	private void rellenarEventosActivos(LocalDate fecha) {
		if(fecha.compareTo(LocalDate.now())<0)
			throw new RuntimeException();
		
		
		Queue<EventoDia> colaAuxiliar = new ArrayDeque<EventoDia>(eventosActivos);
		EventoDia e = colaAuxiliar.peek();
		LocalDate fechaInd = LocalDate.now();

		LocalDate f = e==null ? null : e.getFechaDia();

		if(f==null || fecha.compareTo(f)<0) {
			eventosActivos.clear();
			while(fechaInd.compareTo(fecha)<0) {
				eventosActivos.offer(new EventoDia(fechaInd));
				fechaInd = fechaInd.plusDays(1);
			}
			
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
		actualizarLocalizaciones();
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

	public LinkedList<InfraccionReporte> getListadoInfracciones(NombreFacultad f){
		LinkedList<InfraccionReporte> lista = new LinkedList<InfraccionReporte>();

		Facultad fac = buscarFacultad(f);

		for(int i=0; i<listadoDeportes.size(); i++) {
			LinkedList<Infraccion> infrac = listadoDeportes.get(i).getInfracciones();
			Iterator<Infraccion> iter = infrac.iterator();
			while(iter.hasNext()) {
				Infraccion inf = iter.next();
				if(inf.getNombreFacultad().equals(fac.getNombre())) {
					InfraccionReporte rep = new InfraccionReporte(inf, listadoDeportes.get(i).getNombre());
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
	private void ingresarEventoFinalizado(EventoFinalizado e, LocalDate fecha) {
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
		GeneralTree<Facultad> t = getTablaPosicionesGlobal();
		GeneralTree<Facultad> tabla = new GeneralTree<Facultad>(new BinaryTreeNode<Facultad>());
		((BinaryTreeNode<Facultad>)tabla.getRoot()).setLeft((BinaryTreeNode<Facultad>)(t.getRoot()));
		InDepthIterator<Facultad> iter = tabla.inDepthIterator();

		while(iter.hasNext() && !encontrado) {
			BinaryTreeNode<Facultad> nodo = iter.nextNode();
			if(nodo.getInfo()!=null && nodo.getInfo().getNombre().equals(f)) {
				lugar = tabla.nodeLevel(nodo);
				encontrado = true;
			}
		}

		return lugar;
	}

	public Deporte buscarDeporte(String nombre) {
		Deporte d = null;
		Iterator<Deporte> iter = listadoDeportes.iterator();

		while(iter.hasNext() && d==null) {
			Deporte de = iter.next();
			if(de.getNombre().compareToIgnoreCase(nombre)==0)
				d = de;
		}

		if(d==null)
			throw new IllegalArgumentException();


		return d;
	}


	/**
	 * 
	 * @param e
	 * @param fecha
	 * @param facultadGanadora 1->Facultad Primera, 2->Facultad Segunda
	 */
	public void agregarResultadoEvento(EventoFecha ef, int facultadGanadora, LocalTime horaFin) {
		if(ef.getEvento().estaIndeterminado() || !borrarEventoPorResultado(ef.getEvento(), ef.getFecha()))
			throw new RuntimeException();

		EventoFinalizado e = new EventoFinalizado(ef.getEvento().getDeporte(),
				ef.getEvento().getFacultadPrimera(), ef.getEvento().getFacultadSegunda(), ef.getEvento().getFecha(),
				horaFin, new ResultadoEvento(facultadGanadora == 1 ? ef.getEvento().getFacultadPrimera() : ef.getEvento().getFacultadSegunda()),
				ef.getEvento().getTipo());

		ingresarEventoFinalizado(e, ef.getFecha());
		ef.getEvento().getDeporte().setEventoResultado(new EventoFecha(e, ef.getFecha()), ef.getEvento().getDeporte().getIndiceEvento(ef));


	}

	private boolean borrarEventoPorResultado(Evento e, LocalDate fecha) {
		boolean b = false;
		boolean bDia = false;

		Iterator<EventoDia> iterD = eventosPorResultados.iterator();

		while(iterD.hasNext() && !bDia) {
			EventoDia ev = iterD.next();
			if(ev.getFechaDia().compareTo(fecha)==0) {
				bDia = true;
				List<Evento> evDia = ev.getEventosDia();
				Iterator<Evento> iter = evDia.iterator();
				while(iter.hasNext() && !b) {
					Evento even = iter.next();
					if(even.equals(e)) {
						b = true;
						iter.remove();
					}
				}
			}
		}
		return b;
	}

	/**
	 * 
	 * @return 0->Por Jugar, 1->Por Resultado, 2->Finalizado
	 */
	public int getEstadoEvento(Evento e, LocalDate fecha) {	
		int n = 2;

		if(eventoActivo(e, fecha))
			n=0;
		else if(eventoPorResultado(e, fecha))
			n=1;

		return n;
	}

	private boolean eventoActivo(Evento e, LocalDate fecha) {
		boolean b = false;
		boolean bDia = false;

		Queue<EventoDia> eventos = new ArrayDeque<EventoDia>(eventosActivos);

		while(!eventos.isEmpty() && !bDia) {
			EventoDia ev = eventos.poll();
			if(ev.getFechaDia().compareTo(fecha)==0) {
				bDia = true;
				List<Evento> evDia = ev.getEventosDia();
				Iterator<Evento> iter = evDia.iterator();
				while(iter.hasNext() && !b) {
					b = iter.next().equals(e);
				}
			}
		}

		return b;
	}

	private boolean eventoPorResultado(Evento e, LocalDate fecha) {
		boolean b = false;
		boolean bDia = false;

		Iterator<EventoDia> iterD = eventosPorResultados.iterator();

		while(iterD.hasNext() && !bDia) {
			EventoDia ev = iterD.next();
			if(ev.getFechaDia().compareTo(fecha)==0) {
				bDia = true;
				List<Evento> evDia = ev.getEventosDia();
				Iterator<Evento> iter = evDia.iterator();
				while(iter.hasNext() && !b) {
					b = iter.next().equals(e);
				}
			}
		}
		return b;
	}
	
	
	public LinkedList<SancionReporte> obtenerSancionesTodasFacultades(){
		LinkedList<SancionReporte> sanciones = new LinkedList<SancionReporte>();
		
		for(int i=0; i<listadoFacultades.size(); i++) {
			LinkedList<Sancion> listaSanciones = listadoFacultades.get(i).getSanciones();
			for(Sancion s: listaSanciones) {
				SancionReporte sancion = new SancionReporte(s, listadoFacultades.get(i).getNombre());
				sanciones.add(sancion);
			}
		}
		
		return sanciones;
	}

	public LinkedList<InfraccionReporte> obtenerInfraccionesTodasFacultades(){
		LinkedList<InfraccionReporte> infracciones = new LinkedList<InfraccionReporte>();
		
		for(int i=0; i<listadoDeportes.size(); i++) {
			LinkedList<Infraccion> listaInfracciones = listadoDeportes.get(i).getInfracciones();
			for(Infraccion inf: listaInfracciones) {
				InfraccionReporte reporte = new InfraccionReporte(inf, listadoDeportes.get(i).getNombre());
				infracciones.add(reporte);	
			}
		}
		
		return infracciones;
	}

	public LinkedList<EventoDiaFinalizado> obtenerEventosFinalizados(){
		LinkedList<EventoDiaFinalizado> eventos = new LinkedList<EventoDiaFinalizado>(eventosFinalizados);
		return eventos;
	}

	public LinkedList<EventoDia> obtenerEventosPorResultado(){
		LinkedList<EventoDia> eventos = new LinkedList<EventoDia>(eventosPorResultados);
		
		for(int i=0; i<eventos.size(); i++) {
			LinkedList<Evento> listaEventos = eventos.get(i).getEventosDia();
			Iterator<Evento> iter = listaEventos.iterator();
			while(iter.hasNext()) {
				if(iter.next().estaIndeterminado())
					iter.remove();
			}
//			for(Evento e: listaEventos) {
//				if(e.estaIndeterminado()) {
//					listaEventos.remove(e);
//				}
//			}
		}
		
		return eventos;
	}

	public ArrayList<String> obtenerDeporteEliminar(TipoDeporte t){
		ArrayList<String> paraEliminar = new ArrayList<String>();
		
		if(t == TipoDeporte.DEPORTE_COLECTIVO) {
			for(Deporte d: listadoDeportes) {
				if(d.getTipoDeporte() == TipoDeporte.DEPORTE_INDIVIDUAL) {
					paraEliminar.add(d.getNombre());
				}
			}
		}else if(t == TipoDeporte.DEPORTE_INDIVIDUAL) {
			for(Deporte d: listadoDeportes) {
				if(d.getTipoDeporte() == TipoDeporte.DEPORTE_COLECTIVO) {
					paraEliminar.add(d.getNombre());
				}
			}
		}
		
		return paraEliminar;
	}

	public int cantDeportesActivos() {
		int cont = 0;
		
		for(Deporte d: listadoDeportes) {
			if(d.getEstado().equals(EstadoDeporte.EN_EJECUCION)) {
				cont++;
			}
		}
		
		return cont;
	}

	public int cantDeportesPorResultado() {
		int cont = 0;
		
		for(EventoDia e: eventosPorResultados) {
			cont += e.getEventosDia().size();
		}
		
		return cont;
	}
	
	
	
	public ILinkedWeightedEdgeWeightedVertexNotDirectedGraph<Localizacion, Boolean, Integer> getLocalizaciones() {
		actualizarLocalizaciones();
		return this.localizaciones;
	}
	
	private void actualizarLocalizaciones() {
		
	}
	
	public String buscarLocalizacion(Deporte d) {
		String s = null;
		
		Iterator<Vertex<Localizacion>> iter = localizaciones.getVerticesList().iterator();
		
		while(iter.hasNext() && s==null) {
			Localizacion l = iter.next().getInfo();
			Iterator<Deporte> iterD = l.getDeportes().iterator();
			while(iterD.hasNext() && s==null) {
				if(iterD.next().getNombre().equals(d.getNombre()))
					s = l.getNombre();
			}
		}
		
		return s;
	}
	
	public LinkedList<Deporte> getDeportes(LinkedList<String> nombreDeportes) {
		LinkedList<Deporte> listado = new LinkedList<Deporte>();
		
		for(String s : nombreDeportes) {
			listado.add(buscarDeporte(s));
		}
		
		return listado;
	}



















}
