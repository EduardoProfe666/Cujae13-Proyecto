package utilidades;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;

import nucleo.Evento;
import nucleo.EventoDia;
import nucleo.NombreFacultad;
import nucleo.TipoEvento;

public class BuscadorPorResultados {
	private BuscadorPorResultados() {}

	private static final int FILTRO_FACULTAD_1 = 0;
	private static final int FILTRO_FACULTAD_2 = 1;
	private static final int FILTRO_FECHA = 2;
	private static final int FILTRO_DEPORTE = 3;
	private static final int FILTRO_TIPO_EVENTO = 4;

	public static LinkedList<EventoDia> buscadorPorResultados(LinkedList<EventoDia> listadoBase, NombreFacultad facultad1, NombreFacultad facultad2, LocalDate fecha, String nombreDeporte, TipoEvento tipoEvento) {
		LinkedList<EventoDia> listadoResultante = filtrar(listadoBase, facultad1, FILTRO_FACULTAD_1);
		listadoResultante = filtrar(listadoResultante, facultad2, FILTRO_FACULTAD_2);
		listadoResultante = filtrar(listadoResultante, fecha, FILTRO_FECHA);
		listadoResultante = filtrar(listadoResultante, nombreDeporte, FILTRO_DEPORTE);
		listadoResultante = filtrar(listadoResultante, tipoEvento, FILTRO_TIPO_EVENTO);

		return listadoResultante;
	}

	private static LinkedList<EventoDia> filtrar(LinkedList<EventoDia> listadoBase, Object o, int tipoFiltro) {
		LinkedList<EventoDia> listadoResultante = listadoBase;

		switch(tipoFiltro) {
		case FILTRO_FACULTAD_1:
			listadoResultante = filtroFacultad1(listadoBase, (NombreFacultad)o);
			break;
		case FILTRO_FACULTAD_2:
			listadoResultante = filtroFacultad2(listadoBase, (NombreFacultad)o);
			break;
		case FILTRO_FECHA:
			listadoResultante = filtroFecha(listadoBase, (LocalDate)o);
			break;
		case FILTRO_DEPORTE:
			listadoResultante = filtroDeporte(listadoBase, (String)o);
			break;
		case FILTRO_TIPO_EVENTO:
			listadoResultante = filtroTipoEvento(listadoBase, (TipoEvento)o);
			break;
		default:
			break;
		}

		return listadoResultante;
	}

	private static LinkedList<EventoDia> filtroFacultad1(LinkedList<EventoDia> listadoBase, NombreFacultad n) {
		LinkedList<EventoDia> listadoResultante = new LinkedList<>(listadoBase);

		if(n!=null) {
			Iterator<EventoDia> iterD = listadoResultante.iterator();
			while(iterD.hasNext()) {
				Iterator<Evento> iter = iterD.next().getEventosDia().iterator();
				while(iter.hasNext()) {
					if(!iter.next().getFacultadPrimera().getNombre().equals(n)) {
						iter.remove();
					}
				}
			}
		}

		return listadoResultante;
	}

	private static LinkedList<EventoDia> filtroFacultad2(LinkedList<EventoDia> listadoBase, NombreFacultad n) {
		LinkedList<EventoDia> listadoResultante = new LinkedList<>(listadoBase);

		if(n!=null) {
			Iterator<EventoDia> iterD = listadoResultante.iterator();
			while(iterD.hasNext()) {
				Iterator<Evento> iter = iterD.next().getEventosDia().iterator();
				while(iter.hasNext()) {
					if(!iter.next().getFacultadSegunda().getNombre().equals(n)) {
						iter.remove();
					}
				}
			}
		}

		return listadoResultante;
	}

	private static LinkedList<EventoDia> filtroFecha(LinkedList<EventoDia> listadoBase, LocalDate f) {
		LinkedList<EventoDia> listadoResultante = new LinkedList<>(listadoBase);

		if(f!=null) {
			Iterator<EventoDia> iterD = listadoResultante.iterator();
			while(iterD.hasNext()) {
				if(iterD.next().getFechaDia().compareTo(f)!=0) {
					iterD.remove();
				}
			}
		}

		return listadoResultante;

	}

	private static LinkedList<EventoDia> filtroDeporte(LinkedList<EventoDia> listadoBase, String n){
		LinkedList<EventoDia> listadoResultante = new LinkedList<>(listadoBase);

		if(n!=null) {
			Iterator<EventoDia> iterD = listadoResultante.iterator();
			while(iterD.hasNext()) {
				Iterator<Evento> iter = iterD.next().getEventosDia().iterator();
				while(iter.hasNext()) {
					if(!iter.next().getDeporte().getNombre().equals(n)) {
						iter.remove();
					}
				}
			}
		}

		return listadoResultante;

	}

	private static LinkedList<EventoDia> filtroTipoEvento(LinkedList<EventoDia> listadoBase, TipoEvento t){
		LinkedList<EventoDia> listadoResultante = new LinkedList<>(listadoBase);

		if(t!=null) {
			Iterator<EventoDia> iterD = listadoResultante.iterator();
			while(iterD.hasNext()) {
				Iterator<Evento> iter = iterD.next().getEventosDia().iterator();
				while(iter.hasNext()) {
					if(!iter.next().getTipo().equals(t)) {
						iter.remove();
					}
				}
			}
		}

		return listadoResultante;
	}


}
