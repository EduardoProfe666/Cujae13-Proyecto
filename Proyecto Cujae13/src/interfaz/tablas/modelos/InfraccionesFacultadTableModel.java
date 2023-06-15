package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import clasesAuxiliares.InfraccionesReporteFacultad;

public class InfraccionesFacultadTableModel extends ModeloPrincipalTableModel<InfraccionesReporteFacultad>{
	private static final long serialVersionUID = 1L;

	public InfraccionesFacultadTableModel() {
		super(new String[] {"Fecha","Tipo", "Deporte"," Descripción"});
	}

	@Override
	public void adicionar(InfraccionesReporteFacultad i) {
		this.addRow(new Object[] {i.getInfraccion().getFecha().format(DateTimeFormatter.ofPattern("hh:mm a")),
				i.getInfraccion().getTipo().toString(),
				i.getDeporte(),
				i.getInfraccion().getDescripcion()});
		
	}

}
