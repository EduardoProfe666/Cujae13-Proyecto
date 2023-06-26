package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.binary.PosOrderIterator;
import nucleo.InicializacionPartidosDeporte.EventoFecha;

public class Deporte extends ListenerSupport implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private GeneralTree<ClasificacionDeporte> tablaPosiciones; //Puntaje. Arbol General
	private List<ClasificacionDeporte> tablaPosicionesL;
	private BinaryTree<EventoFecha> torneo;
	private List<EventoFecha> eventosTorneo;
	private EstadoDeporte estado; //Servira para cerrar el deporte, y puntuar a la tabla de posiciones general 
	private LinkedList<Infraccion> infracciones;
	private Sexo sexo;
	private TipoDeporte tipoDeporte;

	public Deporte(String nombre, List<Facultad> listadoFacultades, Sexo sexo, TipoDeporte tipoDeporte) {
		super();
		this.nombre = nombre;
		this.tablaPosicionesL = construirListaPos(listadoFacultades);
		estado = EstadoDeporte.EN_EJECUCION;
		infracciones = new LinkedList<>();
		this.sexo = sexo;
		this.tipoDeporte = tipoDeporte;
		this.eventosTorneo = new ArrayList<EventoFecha>();
	}

	public void inicializarTorneo(List<EventoFecha> eventosTorneo) {
		if(this.eventosTorneo.isEmpty())
			this.eventosTorneo.addAll(eventosTorneo);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoDeporte getEstado() {
		return estado;
	}

	public LinkedList<Infraccion> getInfracciones(){
		return infracciones;
	}

	public void addInfraccion(TipoInfraccion tipo, String descripcion, NombreFacultad nombreFacultad) {
		infracciones.add(new Infraccion(tipo,descripcion,nombreFacultad));
		adicionarPuntaje(nombreFacultad, -tipo.getPuntaje());
	}

	private void adicionarPuntaje(NombreFacultad f,int puntaje) {
		boolean b = false;
		Iterator<ClasificacionDeporte> iter = tablaPosicionesL.iterator();

		while(iter.hasNext() && !b) {
			ClasificacionDeporte d = iter.next();
			if(d.getFacultad().getNombre().compareTo(f)==0) {
				b=true;
				d.setPuntaje(d.getPuntaje()+puntaje);
			}
		}
		construirTablaPosiciones();
	}

	public Sexo getSexo() {
		return sexo;
	}

	public TipoDeporte getTipoDeporte() {
		return tipoDeporte;
	}

	private void construirTablaPosiciones() {
		tablaPosiciones = new GeneralTree<ClasificacionDeporte>();
		Collections.sort(tablaPosicionesL, Collections.reverseOrder());

		Iterator<ClasificacionDeporte> iter = tablaPosicionesL.iterator();
		tablaPosiciones.setRoot(new BinaryTreeNode<ClasificacionDeporte>(iter.next()));
		BinaryTreeNode<ClasificacionDeporte> ultimo = ((BinaryTreeNode<ClasificacionDeporte>)tablaPosiciones.getRoot());
		BinaryTreeNode<ClasificacionDeporte> padre = null;
		int pUltimo = ultimo.getInfo().getPuntaje();


		while(iter.hasNext()) {
			ClasificacionDeporte d1 = iter.next();
			BinaryTreeNode<ClasificacionDeporte> n = new BinaryTreeNode<ClasificacionDeporte>(d1);
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
	//		tablaPosiciones = new GeneralTree<ClasificacionDeporte>();
	//		Collections.sort(tablaPosicionesL, Collections.reverseOrder());
	//
	//		tablaPosiciones.setRoot(new BinaryTreeNode<ClasificacionDeporte>(tablaPosicionesL.get(0)));
	//
	//		for(int i=1; i<tablaPosicionesL.size(); i++) {
	//			if(tablaPosicionesL.get(i).getPuntaje() < tablaPosicionesL.get(i-1).getPuntaje()) {
	//				BinaryTreeNode<ClasificacionDeporte> padre = obtenerUltimoNodo(tablaPosiciones);
	//				BinaryTreeNode<ClasificacionDeporte> n = new BinaryTreeNode<ClasificacionDeporte>(tablaPosicionesL.get(i));
	//				tablaPosiciones.insertNode(n, padre);
	//			}else if(tablaPosicionesL.get(i).getPuntaje() == tablaPosicionesL.get(i-1).getPuntaje()) {
	//				BinaryTreeNode<ClasificacionDeporte> ultimoNodo = obtenerUltimoNodo(tablaPosiciones);
	//				BinaryTreeNode<ClasificacionDeporte> padre = tablaPosiciones.getFather(ultimoNodo);
	//				BinaryTreeNode<ClasificacionDeporte> n = new BinaryTreeNode<ClasificacionDeporte>(tablaPosicionesL.get(i));
	//				tablaPosiciones.insertNode(n, padre);
	//			}
	//		}
	//	}
	//
	//	private BinaryTreeNode<ClasificacionDeporte> obtenerUltimoNodo(GeneralTree<ClasificacionDeporte> arbol){
	//		BinaryTreeNode<ClasificacionDeporte> ultimoNodo = new BinaryTreeNode<ClasificacionDeporte>();
	//		InDepthIterator<ClasificacionDeporte> iter = arbol.inDepthIterator();
	//
	//		while(iter.hasNext()) {
	//			BinaryTreeNode<ClasificacionDeporte> n = iter.nextNode();
	//			if(n.getLeft() == null) {
	//				ultimoNodo = n;
	//			}
	//		}
	//		return ultimoNodo;
	//
	//	}

	public GeneralTree<ClasificacionDeporte> getTablaPosiciones(){ 
		if(tablaPosiciones==null || tablaPosiciones.isEmpty()) {
			construirTablaPosiciones();
		}
		return tablaPosiciones;
	}	

	private List<ClasificacionDeporte> construirListaPos(List<Facultad> facultades){
		List<ClasificacionDeporte> lista = new LinkedList<ClasificacionDeporte>();

		for(Facultad f : facultades) {
			lista.add(new ClasificacionDeporte(f, 0));
		}

		return lista;
	}

	public BinaryTree<EventoFecha> getTorneo(){
		if(torneo == null || torneo.isEmpty())
			construirTorneo();
		actualizarCompetidores();
		return torneo;
	}

	private void construirTorneo() {
		BinaryTreeNode<EventoFecha> oct = new BinaryTreeNode<>(eventosTorneo.get(0));
		BinaryTreeNode<EventoFecha> cuart1 = new BinaryTreeNode<>(eventosTorneo.get(1));
		BinaryTreeNode<EventoFecha> cuart2 = new BinaryTreeNode<>(eventosTorneo.get(2));
		BinaryTreeNode<EventoFecha> cuart3 = new BinaryTreeNode<>(eventosTorneo.get(3));
		BinaryTreeNode<EventoFecha> cuart4 = new BinaryTreeNode<>(eventosTorneo.get(4));
		BinaryTreeNode<EventoFecha> sem1 = new BinaryTreeNode<>(eventosTorneo.get(5));
		BinaryTreeNode<EventoFecha> sem2 = new BinaryTreeNode<>(eventosTorneo.get(6));
		BinaryTreeNode<EventoFecha> fin = new BinaryTreeNode<>(eventosTorneo.get(7));


		torneo = new BinaryTree<EventoFecha>(fin);
		BinaryTreeNode<EventoFecha> raiz = (BinaryTreeNode<EventoFecha>)torneo.getRoot();
		raiz.setLeft(sem1);
		raiz.setRight(sem2);
		raiz.getLeft().setLeft(cuart1);
		raiz.getLeft().setRight(cuart2);
		raiz.getRight().setLeft(cuart3);
		raiz.getRight().setRight(cuart4);
		raiz.getRight().getRight().setRight(oct);

	}

	public int getIndiceEvento(EventoFecha e) {
		int indice = -1;
		
		Iterator<EventoFecha> iter = eventosTorneo.iterator();
		while(iter.hasNext() && indice==-1) {
			EventoFecha ef = iter.next();
			if(ef.getFecha().equals(e.getFecha()) && ef.getEvento().equals(e.getEvento()))
				indice = eventosTorneo.indexOf(ef);
		}
		
		return indice;
	}

	public void setEventoResultado(EventoFecha e, int indiceEvento) {
		if(e.getEvento() instanceof EventoFinalizado && estado.equals(EstadoDeporte.EN_EJECUCION)) {
			eventosTorneo.set(indiceEvento, e);
			adicionarPuntaje(((EventoFinalizado)e.getEvento()).getResultado().getFacultadGanadora().getNombre(), tipoDeporte.getPuntuacionPartidoGanado());
			comprobarEstado();
			actualizarCompetidores();
		}
		else
			throw new RuntimeException();
	}

	private void comprobarEstado() {
		
		if(((BinaryTreeNode<EventoFecha>)getTorneo().getRoot()).getInfo().getEvento() instanceof EventoFinalizado) {
			estado = EstadoDeporte.FINALIZADO;
			firePropertyChange("Deporte Terminado");
		}
	}

	private void actualizarCompetidores() {
		construirTorneo();
		PosOrderIterator<EventoFecha> iter = torneo.posOrderIterator();

		while(iter.hasNext()) {
			BinaryTreeNode<EventoFecha> n = iter.nextNode();
			Evento e = n.getInfo().getEvento();
			if(e instanceof EventoFinalizado) {
				BinaryTreeNode<EventoFecha> nP = torneo.getFather(n);
				if(nP!=null) {
					Facultad f = ((EventoFinalizado)e).getResultado().getFacultadGanadora();
					if(nP.getLeft()!=null && nP.getLeft().equals(n))
						nP.getInfo().getEvento().setFacultadPrimera(f);
					else
						nP.getInfo().getEvento().setFacultadSegunda(f);
				}
			}
		}
		
	}
	
	public boolean tieneEventosHoy() {
		boolean b = false;
		
		Iterator<EventoFecha> iter = eventosTorneo.iterator();
		while(iter.hasNext() && !b) {
			b = iter.next().getFecha().equals(LocalDate.now());
		}
		
		return b;
	}

}
