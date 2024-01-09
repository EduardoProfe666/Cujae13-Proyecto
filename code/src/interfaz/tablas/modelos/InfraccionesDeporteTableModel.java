package interfaz.tablas.modelos;

import java.time.format.DateTimeFormatter;

import nucleo.Infraccion;

public class InfraccionesDeporteTableModel extends ModeloPrincipalTableModel<Infraccion>{
	private static final long serialVersionUID = 1L;

	public InfraccionesDeporteTableModel() {
		super(new String[] {"Fecha","Tipo", "Facultad"," Descripci�n"});
	}

	@Override
	public void adicionar(Infraccion i) {
		this.addRow(new Object[] {i.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				i.getTipo().toString(),
				i.getNombreFacultad(),
				i.getDescripcion()});
		
	}
	
	@Override
	public boolean isCellEditable(int row, int column) { 
		return column==3;
	}

}