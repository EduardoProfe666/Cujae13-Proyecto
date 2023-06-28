package interfaz.tablas.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import nucleo.EventoDiaFinalizado;
import nucleo.EventoFinalizado;

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
			resultado = e.getResultado().getFacultadGanadora().getNombre().equals(e.getFacultadPrimera().getNombre()) ? e.getFacultadPrimera().getNombre().toString() : e.getFacultadSegunda().getNombre().toString();
			
			this.addRow(new Object[] {f,
					e.getHoraInicio().format(DateTimeFormatter.ofPattern("hh:mm a")),
					e.getHoraFin().format(DateTimeFormatter.ofPattern("hh:mm a")),
					e.getDeporte().getNombre(),
					e.getFacultadPrimera().getNombre(),
					e.getFacultadSegunda().getNombre(),
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
