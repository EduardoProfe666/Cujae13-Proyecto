package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import clasesAuxiliares.InfraccionesReporteFacultad;

public class InfraccionesTableModel extends ModeloPrincipalTableModel<InfraccionesReporteFacultad>{
	private static final long serialVersionUID = 1L;

	public InfraccionesTableModel() {
		super(new String[] {"Fecha","Tipo", "Facultad","Deporte"," Descripción"});
	}

	@Override
	public void adicionar(InfraccionesReporteFacultad i) {
		this.addRow(new Object[] {i.getInfraccion().getFecha().format(DateTimeFormatter.ofPattern("hh:mm aa")),
				i.getInfraccion().getTipo().toString(),
				i.getInfraccion().getNombreFacultad(),
				i.getDeporte(),
				i.getInfraccion().getDescripcion()});
		
	}

}
