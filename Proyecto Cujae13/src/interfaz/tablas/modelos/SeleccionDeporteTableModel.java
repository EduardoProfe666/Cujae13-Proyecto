package interfaz.tablas.modelos;

import nucleo.Deporte;
import nucleo.EstadoDeporte;
import nucleo.Sexo;
import nucleo.TipoDeporte;

public class SeleccionDeporteTableModel extends ModeloPrincipalTableModel<Deporte>{
	private static final long serialVersionUID = 1L;

	public SeleccionDeporteTableModel() {
		super(new String[] {"Deporte", "Sexo", "Tipo", "Estado", "Tiene Partidos Hoy"});
	}

	@Override
	public void adicionar(Deporte d) {
		this.addRow(new Object[] {d.getNombre(),
				d.getSexo(),
				d.getTipoDeporte(),
				d.getEstado(),
				d.tieneEventosHoy() ? "Sí" : "No"});
	}
	
	public void prueba() {
		this.addRow(new Object[] {"Prueba",
				TipoDeporte.DEPORTE_COLECTIVO,
				Sexo.MIXTO,
				EstadoDeporte.EN_EJECUCION});
	}
	
}
