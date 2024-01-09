package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.EventoFinalizado;
import nucleo.NombreFacultad;

public class PartidosJugadosTableModel extends ModeloPrincipalTableModel<EventoFinalizado>{
	private static final long serialVersionUID = 1L;
	private NombreFacultad facultad;

	public PartidosJugadosTableModel(NombreFacultad facultad) {
		super(new String[] {"Hora Inicio", "Hora Fin", "Deporte", "Adversario", "T/Evento","Resultado"});
		this.facultad = facultad;
	}

	@Override
	public void adicionar(EventoFinalizado e) {
		if(e.getFacultadPrimera().getNombre().equals(facultad) || e.getFacultadSegunda().getNombre().equals(facultad)) {
			String resultado="";
			resultado = e.getResultado().getFacultadGanadora().getNombre().equals(facultad) ? "Ganador" : "Perdedor";

			this.addRow(new Object[] {e.getHoraInicio().format(DateTimeFormatter.ofPattern("hh:mm a")),
					e.getHoraFin().format(DateTimeFormatter.ofPattern("hh:mm a")),
					e.getDeporte().getNombre(),
					e.getFacultadPrimera().getNombre().equals(facultad) ? e.getFacultadSegunda().getNombre() : e.getFacultadPrimera().getNombre(),
							e.getTipo(),
							resultado});
		}
	}

}
