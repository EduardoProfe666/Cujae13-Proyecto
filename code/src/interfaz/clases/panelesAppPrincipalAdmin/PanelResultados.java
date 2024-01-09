package interfaz.clases.panelesAppPrincipalAdmin;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.panelesAppPrincipal.PanelBaseAppPrincipal;
import interfaz.tablas.modelos.PartidosJugadosAdminTableModel;
import nucleo.EventoDiaFinalizado;
import nucleo.Universidad;
import utilidades.Archivador;

public class PanelResultados extends PanelBaseAppPrincipal{

	private static final long serialVersionUID = 1L;
	private PartidosJugadosAdminTableModel modeloResultados;
	private TableRowSorter<PartidosJugadosAdminTableModel> ordenamientoResultados;
	private JTable tablaResultados;

	public PanelResultados(EsquemaColores e) {
	
		JLabel infraccionesLbl = new JLabel("Resultados de Partidos");
		infraccionesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		infraccionesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		infraccionesLbl.setBounds(10, 35, 869, 45);
		add(infraccionesLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 869, 473);
		add(scrollPane);
		
		modeloResultados = new PartidosJugadosAdminTableModel();
		modeloResultados.actualizar(Universidad.getInstancia().obtenerEventosFinalizados());
		ordenamientoResultados = new TableRowSorter<>(modeloResultados);
		ordenamientoResultados.toggleSortOrder(0);
		ordenamientoResultados.setComparator(0, Archivador.getComparatorStringLocalDate());
		ordenamientoResultados.setComparator(1, Archivador.getComparatorStringLocalTime());
		ordenamientoResultados.setComparator(2, Archivador.getComparatorStringLocalTime());
		modeloResultados.actualizar(new ArrayList<EventoDiaFinalizado>(Universidad.getInstancia().getEventosFinalizados()));
		
		tablaResultados = new JTable();
		tablaResultados.setModel(modeloResultados);
		tablaResultados.setRowSorter(ordenamientoResultados);
		tablaResultados.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tablaResultados.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaResultados.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaResultados.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		scrollPane.setViewportView(tablaResultados);
	}
}
