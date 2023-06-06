package interfaz.tablas.modelos;

import javax.swing.table.DefaultTableModel;

import clasesAuxiliares.EstadisticasReporte;

public class EstadisticasTableModel extends DefaultTableModel{
	private static final long serialVersionUID = 1L;
	
	public EstadisticasTableModel() {
		setColumnIdentifiers(new String[] {"Parámetro", "Cantidad"});
	}
	
	public void eliminarFilas() {
		this.setRowCount(0);
	}
	
	public void actualizar(EstadisticasReporte e){
		if(e!=null) {
			this.eliminarFilas();
			this.addRow(new Object[] {"Puntaje",e.getPuntaje()});
			this.addRow(new Object[] {"Infracciones",e.getInfracciones()});
			this.addRow(new Object[] {"Sanciones",e.getSanciones()});
			this.addRow(new Object[] {"Partidos Jugados",e.getPartidosJugados()});
			this.addRow(new Object[] {"Partidos Ganados",e.getPartidosGanados()});
			this.addRow(new Object[] {"Partidos Empatados",e.getPartidosEmpatados()});
			this.addRow(new Object[] {"Partidos Perdidos",e.getPartidosPerdidos()});
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int column) { 
		return false;
	}

}