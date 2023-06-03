package nucleo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public class EventoDia implements Serializable{
	private static final long serialVersionUID = 1L;
	private LinkedList<Evento> eventosDia; //Lista Enlazada
	private LocalDate fechaDia;
}
