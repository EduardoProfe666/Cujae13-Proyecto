package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class InicializacionPartidosDeporte {
	private List<EventoFecha> listadoPartidos;
	private Deporte deporte;
	
	
	public InicializacionPartidosDeporte(Deporte d,Facultad facultadOct1, Facultad facultadOct2, ListadoFechaHora listado, List<Facultad> facultades) {
		listadoPartidos = new ArrayList<>(8);
		deporte = d;
		EventoFecha oct = new EventoFecha(new Evento(d, facultadOct1, facultadOct2, listado.getFechaHora(1).getHora(), TipoEvento.ELIMINATORIA),listado.getFechaHora(1).getFecha());
		
		List<Facultad> f = randomizarFacultades(facultades, facultadOct1, facultadOct2);
		
		EventoFecha cuar1 = new EventoFecha(new Evento(d, f.get(0), f.get(1), listado.getFechaHora(2).getHora(), TipoEvento.CUARTO),listado.getFechaHora(2).getFecha());
		EventoFecha cuar2 = new EventoFecha(new Evento(d, f.get(2), f.get(3), listado.getFechaHora(3).getHora(), TipoEvento.CUARTO),listado.getFechaHora(3).getFecha());
		EventoFecha cuar3 = new EventoFecha(new Evento(d, f.get(4), f.get(5), listado.getFechaHora(4).getHora(), TipoEvento.CUARTO),listado.getFechaHora(4).getFecha());
		EventoFecha cuar4 = new EventoFecha(new Evento(d, f.get(6), null, listado.getFechaHora(5).getHora(), TipoEvento.CUARTO),listado.getFechaHora(5).getFecha());
		
		EventoFecha sem1 = new EventoFecha(new Evento(d, null, null, listado.getFechaHora(6).getHora(), TipoEvento.SEMIFINAL),listado.getFechaHora(6).getFecha());
		EventoFecha sem2 = new EventoFecha(new Evento(d, null, null, listado.getFechaHora(7).getHora(), TipoEvento.SEMIFINAL),listado.getFechaHora(7).getFecha());
		
		EventoFecha fin = new EventoFecha(new Evento(d, null, null, listado.getFechaHora(8).getHora(), TipoEvento.FINAL),listado.getFechaHora(8).getFecha());
		
		listadoPartidos.add(oct);
		listadoPartidos.add(cuar1);
		listadoPartidos.add(cuar2);
		listadoPartidos.add(cuar3);
		listadoPartidos.add(cuar4);
		listadoPartidos.add(sem1);
		listadoPartidos.add(sem2);
		listadoPartidos.add(fin);
	}
	
	private List<Facultad> randomizarFacultades(List<Facultad> listado, Facultad f1, Facultad f2) {
		List<Facultad> l = new LinkedList<>(listado);
		l.remove(f1);
		l.remove(f2);
		Collections.shuffle(l);
		return l;
	}
	
	
	public List<EventoFecha> getListadoPartidos() {
		return listadoPartidos;
	}
	
	public Deporte getDeporte() {
		return deporte;
	}
	
	public static class FechaHora {
		private LocalDate fecha;
		private LocalTime hora;
		
		public FechaHora(LocalDate fecha, LocalTime hora) {
			this.fecha = fecha;
			this.hora = hora;
		}
		
		public LocalDate getFecha() {
			return fecha;
		}
		
		public LocalTime getHora() {
			return hora;
		}
	}
	
	/** 
	 * Falta validar el horario
	 * 
	 *
	 */
	public static class ListadoFechaHora {
		private List<FechaHora> listado;
		
		
		/**
		 * fh1 Octavo de Final
		 * fh2-fh5 Cuartos de Final
		 * fh6/fh7 Semifinales
		 * fh8 Final
		 * @return
		 */
		public ListadoFechaHora(FechaHora fh1, FechaHora fh2, FechaHora fh3, FechaHora fh4, FechaHora fh5, FechaHora fh6
				, FechaHora fh7, FechaHora fh8) {
			listado = new LinkedList<>();
			listado.add(fh1);
			listado.add(fh2);
			listado.add(fh3);
			listado.add(fh4);
			listado.add(fh5);
			listado.add(fh6);
			listado.add(fh7);
			listado.add(fh8);
		}
		
		public FechaHora getFechaHora(int numeroPartido){
			return listado.get(numeroPartido-1);
		}
	}
	
	public static class EventoFecha implements Serializable{
		private static final long serialVersionUID = 1L;
		private Evento evento;
		private LocalDate fecha;
		
		public EventoFecha(Evento evento, LocalDate fecha) {
			this.evento = evento;
			this.fecha = fecha;
		}
		
		public Evento getEvento() {
			return evento;
		}
		
		public LocalDate getFecha() {
			return fecha;
		}
	}
}
