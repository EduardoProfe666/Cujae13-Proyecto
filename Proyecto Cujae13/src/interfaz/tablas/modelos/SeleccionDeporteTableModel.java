package interfaz.tablas.modelos;

import nucleo.Deporte;
import nucleo.EstadoDeporte;
import nucleo.Sexo;

public class SeleccionDeporteTableModel extends ModeloPrincipalTableModel<Deporte>{
	private static final long serialVersionUID = 1L;

	public SeleccionDeporteTableModel() {
		super(new String[] {"Deporte", "Sexo", "Estado"});
	}

	@Override
	public void adicionar(Deporte d) {
		this.addRow(new Object[] {d.getNombre(),
				d.getSexo(),
				d.getEstado()});
	}
	
	public void prueba() {
		this.addRow(new Object[] {"Prueba",
				Sexo.MIXTO,
				EstadoDeporte.EN_EJECUCION});
	}
	
}
