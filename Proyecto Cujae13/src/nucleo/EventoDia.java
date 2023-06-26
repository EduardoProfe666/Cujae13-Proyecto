package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class EventoDia implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Evento> eventosDia; //Lista Enlazada
	private LocalDate fechaDia;
	
	public EventoDia(LocalDate fecha) {
		super();
		this.eventosDia = new LinkedList<Evento>();
		this.fechaDia = fecha;
	}
	public LinkedList<Evento> getEventosDia() {
		return eventosDia;
	}
	public LocalDate getFechaDia() {
		return fechaDia;
	}
	
	public void setEventosDia(LinkedList<Evento> eventos) {
		this.eventosDia = new LinkedList<Evento>(eventos);
	}
}
