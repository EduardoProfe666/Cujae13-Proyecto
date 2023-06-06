package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EventoDia implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Evento> eventosDia; //Lista Enlazada
	private LocalDate fechaDia;
	
	public EventoDia() {
		super();
		this.eventosDia = new LinkedList<Evento>();
		this.fechaDia = LocalDate.now();
	}
	public List<Evento> getEventosDia() {
		return eventosDia;
	}
	public LocalDate getFechaDia() {
		return fechaDia;
	}
}
