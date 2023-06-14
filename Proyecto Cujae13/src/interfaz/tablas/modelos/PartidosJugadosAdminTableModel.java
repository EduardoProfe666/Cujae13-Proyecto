package interfaz.tablas.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import nucleo.EventoDiaFinalizado;
import nucleo.EventoFinalizado;
import nucleo.ResultadoEvento;
import nucleo.ResultadoEventoEmpate;

public class PartidosJugadosAdminTableModel extends ModeloPrincipalTableModel<EventoDiaFinalizado>{
	private static final long serialVersionUID = 1L;

	public PartidosJugadosAdminTableModel() {
		super(new String[] {"Fecha","Hora Inicio", "Hora Fin", "Deporte", "Facultad 1", "Facultad 2", "T/Evento", "Ganador"});
	}

	@Override
	public void adicionar(EventoDiaFinalizado ev) {
		String f = crearFecha(ev.getFechaDia());
		Iterator<EventoFinalizado> iter = ev.getEventosDia().iterator();
		
		while(iter.hasNext()) {
			EventoFinalizado e = iter.next();
			
			String resultado="";
			ResultadoEvento r = e.getResultado();
			if(r instanceof ResultadoEventoEmpate)
				resultado = "Empate";
			else
				resultado = r.getFacultadGanadora().getNombre().equals(e.getFacultadPrimera().getNombre()) ? e.getFacultadPrimera().getNombre().toString() : e.getFacultadSegunda().getNombre().toString();
			
			this.addRow(new Object[] {f,
					e.getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
					e.getFechaFinalizado().format(DateTimeFormatter.ofPattern("hh:mm aa")),
					e.getDeporte().getNombre(),
					e.getFacultadPrimera(),
					e.getFacultadSegunda(),
					e.getTipo(),
					resultado});
		}
	}
	
	private String crearFecha(LocalDate l) {
		return convertirNumeroString(l.getDayOfMonth())+"/"+convertirNumeroString(l.getMonthValue())+"/"+convertirNumeroString(l.getYear());
	}
	
	private String convertirNumeroString(Integer n) {
		String s = n.toString();
		
		if(n<10)
			s = "0"+n.toString();
		
		return s;
	}

}
