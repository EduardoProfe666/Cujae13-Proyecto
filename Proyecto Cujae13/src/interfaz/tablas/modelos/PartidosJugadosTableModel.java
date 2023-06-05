package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.EventoFinalizado;

public class PartidosJugadosTableModel extends ModeloPrincipalTableModel<EventoFinalizado>{
	private static final long serialVersionUID = 1L;
	private String facultad;

	public PartidosJugadosTableModel(String facultad) {
		super(new String[] {"Hora Inicio", "Hora Fin", "Deporte", "Adversario", "Tipo de Evento"});
		this.facultad = facultad;
	}

	@Override
	public void adicionar(EventoFinalizado e) {
		this.addRow(new Object[] {e.getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
				e.getFechaFinalizado().format(DateTimeFormatter.ofPattern("hh:mm aa")),
				e.getDeporte().getNombre(),
				e.getFacultadPrimera().getNombre().equals(facultad) ? e.getFacultadSegunda().getNombre() : e.getFacultadPrimera().getNombre(),
				e.getTipo()});
	}

}
