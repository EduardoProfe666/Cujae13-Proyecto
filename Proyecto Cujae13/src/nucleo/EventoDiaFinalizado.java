package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class EventoDiaFinalizado implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<EventoFinalizado> eventosDia; //Lista Enlazada
	private LocalDate fechaDia;
	
	public EventoDiaFinalizado() {
		super();
		this.eventosDia = new LinkedList<>();
		this.fechaDia = LocalDate.now();
	}
	
	/**
	 * Provisional
	 * @param l
	 */
	public EventoDiaFinalizado(LocalDate l) {
		this();
		this.fechaDia = l;
	}
	public List<EventoFinalizado> getEventosDia() {
		return eventosDia;
	}
	public LocalDate getFechaDia() {
		return fechaDia;
	}

}
