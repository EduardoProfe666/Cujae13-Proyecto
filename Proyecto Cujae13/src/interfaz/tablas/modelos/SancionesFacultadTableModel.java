package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.Sancion;

public class SancionesFacultadTableModel extends ModeloPrincipalTableModel<Sancion>{
	private static final long serialVersionUID = 1L;

	public SancionesFacultadTableModel() {
		super(new String[] {"Fecha", "Tipo", "Descripción"});
	}

	@Override
	public void adicionar(Sancion s) {
		this.addRow(new Object[] {s.getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
				s.getTipo().toString(),
				s.getDescripcion()});
		
	}
	
}
