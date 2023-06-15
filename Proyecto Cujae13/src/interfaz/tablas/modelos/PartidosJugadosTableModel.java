package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.EventoFinalizado;
import nucleo.NombreFacultad;
import nucleo.ResultadoEvento;
import nucleo.ResultadoEventoEmpate;

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
			ResultadoEvento r = e.getResultado();
			if(r instanceof ResultadoEventoEmpate)
				resultado = "Empate";
			else
				resultado = r.getFacultadGanadora().getNombre().equals(facultad) ? "Ganador" : "Perdedor";

			this.addRow(new Object[] {e.getFecha().format(DateTimeFormatter.ofPattern("hh:mm a")),
					e.getFechaFinalizado().format(DateTimeFormatter.ofPattern("hh:mm a")),
					e.getDeporte().getNombre(),
					e.getFacultadPrimera().getNombre().equals(facultad) ? e.getFacultadSegunda().getNombre() : e.getFacultadPrimera().getNombre(),
							e.getTipo(),
							resultado});
		}
	}

}
