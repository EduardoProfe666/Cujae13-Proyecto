package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.Evento;
import nucleo.NombreFacultad;

public class PartidosPorJugarTableModel extends ModeloPrincipalTableModel<Evento>{
	private static final long serialVersionUID = 1L;
	private NombreFacultad facultad;
	
	public PartidosPorJugarTableModel(NombreFacultad facultad) {
		super(new String[] {"Hora", "Deporte","Adversario", "Tipo de Evento"});
		this.facultad = facultad;
	}

	@Override
	public void adicionar(Evento e) {
		this.addRow(new Object[] {e.getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
				e.getDeporte().getNombre(),
				e.getFacultadPrimera().getNombre().equals(facultad) ? e.getFacultadSegunda().getNombre() : e.getFacultadPrimera().getNombre(),
				e.getTipo()});
	}
}


