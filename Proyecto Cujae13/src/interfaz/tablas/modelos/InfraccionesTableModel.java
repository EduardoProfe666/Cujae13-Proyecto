package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import clasesAuxiliares.InfraccionReporte;

public class InfraccionesTableModel extends ModeloPrincipalTableModel<InfraccionReporte>{
	private static final long serialVersionUID = 1L;

	public InfraccionesTableModel() {
		super(new String[] {"Fecha","Tipo", "Facultad","Deporte"," Descripción"});
	}

	@Override
	public void adicionar(InfraccionReporte i) {
		this.addRow(new Object[] {i.getInfraccion().getFecha().format(DateTimeFormatter.ofPattern("hh:mm a")),
				i.getInfraccion().getTipo().toString(),
				i.getInfraccion().getNombreFacultad(),
				i.getDeporte(),
				i.getInfraccion().getDescripcion()});
		
	}

	@Override
	public boolean isCellEditable(int row, int column) { 
		return column==4;
	}
	
}
