package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import clasesAuxiliares.InfraccionReporte;

public class InfraccionesFacultadTableModel extends ModeloPrincipalTableModel<InfraccionReporte>{
	private static final long serialVersionUID = 1L;

	public InfraccionesFacultadTableModel() {
		super(new String[] {"Fecha","Tipo", "Deporte"," Descripci�n"});
	}

	@Override
	public void adicionar(InfraccionReporte i) {
		this.addRow(new Object[] {i.getInfraccion().getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				i.getInfraccion().getTipo().toString(),
				i.getDeporte(),
				i.getInfraccion().getDescripcion()});
		
	}
	
	@Override
	public boolean isCellEditable(int row, int column) { 
		return column==3;
	}

}