package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.Evento;

public class PartidosPorJugarDiaTableModel extends ModeloPrincipalTableModel<Evento>{
	private static final long serialVersionUID = 1L;
	
	public PartidosPorJugarDiaTableModel() {
		super(new String[] {"Hora", "Deporte","Primer Adversario", "Segundo Adversario", "Tipo de Evento"});
	}

	@Override
	public void adicionar(Evento e) {
		this.addRow(new Object[] {e.getFecha().format(DateTimeFormatter.ofPattern("hh:mm a")),
				e.getDeporte().getNombre(),
				e.getFacultadPrimera() == null ? "Por Determinar" : e.getFacultadPrimera().getNombre(),
				e.getFacultadSegunda() == null ? "Por Determinar" : e.getFacultadSegunda().getNombre(),
				e.getTipo()});
	}

}
