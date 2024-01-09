package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que permite la inicializacion de los eventos del torneo de cada deporte
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public class InicializacionPartidosDeporte {
	private List<EventoFecha> listadoPartidos;
	
	
	public InicializacionPartidosDeporte(Facultad facultadOct1, Facultad facultadOct2, ListadoFechaHora listado, List<Facultad> facultades) {
		listadoPartidos = new ArrayList<>(8);
		EventoFecha oct = new EventoFecha(new Evento(null, facultadOct1, facultadOct2, listado.getFechaHora(1).getHora(), TipoEvento.ELIMINATORIA),listado.getFechaHora(1).getFecha());
		
		List<Facultad> f = randomizarFacultades(facultades, facultadOct1, facultadOct2);
		
		EventoFecha cuar1 = new EventoFecha(new Evento(null, f.get(0), f.get(1), listado.getFechaHora(2).getHora(), TipoEvento.CUARTO),listado.getFechaHora(2).getFecha());
		EventoFecha cuar2 = new EventoFecha(new Evento(null, f.get(2), f.get(3), listado.getFechaHora(3).getHora(), TipoEvento.CUARTO),listado.getFechaHora(3).getFecha());
		EventoFecha cuar3 = new EventoFecha(new Evento(null, f.get(4), f.get(5), listado.getFechaHora(4).getHora(), TipoEvento.CUARTO),listado.getFechaHora(4).getFecha());
		EventoFecha cuar4 = new EventoFecha(new Evento(null, f.get(6), null, listado.getFechaHora(5).getHora(), TipoEvento.CUARTO),listado.getFechaHora(5).getFecha());
		
		EventoFecha sem1 = new EventoFecha(new Evento(null, null, null, listado.getFechaHora(6).getHora(), TipoEvento.SEMIFINAL),listado.getFechaHora(6).getFecha());
		EventoFecha sem2 = new EventoFecha(new Evento(null, null, null, listado.getFechaHora(7).getHora(), TipoEvento.SEMIFINAL),listado.getFechaHora(7).getFecha());
		
		EventoFecha fin = new EventoFecha(new Evento(null, null, null, listado.getFechaHora(8).getHora(), TipoEvento.FINAL),listado.getFechaHora(8).getFecha());
		
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
		 * fh1 Octavo de Final <br>
		 * fh2-fh5 Cuartos de Final <br>
		 * fh6/fh7 Semifinales <br>
		 * fh8 Final <br>
		 * @param fh1
		 * @param fh2
		 * @param fh3
		 * @param fh4
		 * @param fh5
		 * @param fh6
		 * @param fh7
		 * @param fh8
		 */
		public ListadoFechaHora(FechaHora fh1, FechaHora fh2, FechaHora fh3, FechaHora fh4, FechaHora fh5, FechaHora fh6
				, FechaHora fh7, FechaHora fh8) {
			listado = new LinkedList<>();
			if(fh1==null)
				throw new IllegalArgumentException("fh1");
			listado.add(fh1);
			
			if(fh2==null || fh2.getFecha().isBefore(fh1.getFecha()) || (fh2.getFecha().compareTo(fh1.getFecha())==0 && fh2.getHora().isBefore(fh1.getHora())))
				throw new IllegalArgumentException("fh2");
			listado.add(fh2);
			
			if(fh3==null || fh3.getFecha().isBefore(fh1.getFecha()) || (fh3.getFecha().compareTo(fh1.getFecha())==0 && fh3.getHora().isBefore(fh1.getHora())))
				throw new IllegalArgumentException("fh3");
			listado.add(fh3);
			
			if(fh4==null || fh4.getFecha().isBefore(fh1.getFecha()) || (fh4.getFecha().compareTo(fh1.getFecha())==0 && fh4.getHora().isBefore(fh1.getHora())))
				throw new IllegalArgumentException("fh4");
			listado.add(fh4);
			
			if(fh5==null || fh5.getFecha().isBefore(fh1.getFecha()) || (fh5.getFecha().compareTo(fh1.getFecha())==0 && fh5.getHora().isBefore(fh1.getHora())))
				throw new IllegalArgumentException("fh5");
			listado.add(fh5);
			
			if(fh6==null || fh6.getFecha().isBefore(menorFechaCuarto()))
				throw new IllegalArgumentException("fh6");
			listado.add(fh6);
			
			if(fh7==null || fh7.getFecha().isBefore(menorFechaCuarto()))
				throw new IllegalArgumentException("fh7");
			listado.add(fh7);
			
			if(fh8==null || fh7.getFecha().isBefore(menorFechaCuarto()))
				throw new IllegalArgumentException("fh8");
			listado.add(fh8);
		}
		
		public LocalDate menorFechaCuarto() {
			LocalDate l = LocalDate.MAX;
			if(listado.get(1).fecha.isBefore(l))
				l = listado.get(1).fecha;
			else if(listado.get(2).fecha.isBefore(l))
				l = listado.get(2).fecha;
			else if(listado.get(3).fecha.isBefore(l))
				l = listado.get(3).fecha;
			else
				l = listado.get(4).fecha;
			
			return l;
		}
		
		public LocalDate menorFechaSemi() {
			LocalDate l = LocalDate.MAX;
			if(listado.get(5).fecha.isBefore(l))
				l = listado.get(5).fecha;
			else
				l = listado.get(6).fecha;
			
			return l;
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
