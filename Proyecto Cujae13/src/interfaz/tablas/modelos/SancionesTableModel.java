package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import clasesAuxiliares.SancionReporte;

public class SancionesTableModel extends ModeloPrincipalTableModel<SancionReporte>{
	private static final long serialVersionUID = 1L;

	public SancionesTableModel() {
		super(new String[] {"Fecha", "Tipo", "Facultad", "Descripción"});
	}

	@Override
	public void adicionar(SancionReporte s) {
		this.addRow(new Object[] {s.getSancion().getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
				s.getSancion().getTipo().toString(),
				s.getFacultad(),
				s.getSancion().getDescripcion()});
		
	}
	

}
