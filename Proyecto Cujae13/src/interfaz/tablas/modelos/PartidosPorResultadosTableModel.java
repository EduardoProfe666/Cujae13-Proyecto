package interfaz.tablas.modelos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import nucleo.Evento;
import nucleo.EventoDia;

public class PartidosPorResultadosTableModel extends ModeloPrincipalTableModel<EventoDia>{
	private static final long serialVersionUID = 1L;

	public PartidosPorResultadosTableModel() {
		super(new String[] {"Fecha","Hora Inicio", "Deporte", "Facultad 1", "Facultad 2", "T/Evento"});
	}

	@Override
	public void adicionar(EventoDia ev) {
		String f = crearFecha(ev.getFechaDia());
		Iterator<Evento> iter = ev.getEventosDia().iterator();

		while(iter.hasNext()) {
			Evento e = iter.next();
			if(!e.estaIndeterminado())
				this.addRow(new Object[] {f,
						e.getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
						e.getDeporte().getNombre(),
						e.getFacultadPrimera(),
						e.getFacultadSegunda(),
						e.getTipo()});
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

	/**
	 * Provisional
	 * 
	 */
	public void prueba() {
		this.addRow(new Object[] {"Prueba",
				"Prueba",
				"Prueba",
				"Prueba",
				"Prueba",
				"Prueba"
		});
	}

}
