package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class EventoDia implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Evento> eventosDia; //Lista Enlazada
	private LocalDate fechaDia;
	
	public EventoDia(LinkedList<Evento> eventosDia, LocalDate fechaDia) {
		super();
		this.eventosDia = eventosDia;
		this.fechaDia = fechaDia;
	}
	public LinkedList<Evento> getEventosDia() {
		return eventosDia;
	}
	public void setEventosDia(LinkedList<Evento> eventosDia) {
		this.eventosDia = eventosDia;
	}
	public LocalDate getFechaDia() {
		return fechaDia;
	}
	public void setFechaDia(LocalDate fechaDia) {
		this.fechaDia = fechaDia;
	}
}
