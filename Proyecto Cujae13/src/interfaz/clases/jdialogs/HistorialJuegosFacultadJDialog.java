package interfaz.clases.jdialogs;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import clasesAuxiliares.NombreFacultad;
import interfaz.tablas.modelos.PartidosJugadosTableModel;
import com.toedter.calendar.JDateChooser;

public class HistorialJuegosFacultadJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private PartidosJugadosTableModel modeloPartidosJugados;
	private TableRowSorter<PartidosJugadosTableModel> ordenamientoPartidosJugados;
	private JTable tablaPartidosJugados;
	private JDateChooser fecha;
	
	public HistorialJuegosFacultadJDialog(EsquemaColores e, JFrame padre, NombreFacultad f) {
		super("Historial de Juegos", e, padre);
		
		JLabel nombreFacultadLbl = new JLabel("Historial de Juegos de "+f.toString());
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel seleccionarFechaLbl = new JLabel("Seleccionar Fecha:");
		seleccionarFechaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		seleccionarFechaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		seleccionarFechaLbl.setBounds(10, 66, 680, 26);
		panelContenedor.add(seleccionarFechaLbl);
		
		JLabel resultadosPartidosLbl = new JLabel("Resultados de Partidos Jugados");
		resultadosPartidosLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		resultadosPartidosLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		resultadosPartidosLbl.setBounds(10, 112, 680, 26);
		panelContenedor.add(resultadosPartidosLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 680, 303);
		panelContenedor.add(scrollPane);
		
		modeloPartidosJugados = new PartidosJugadosTableModel(f.toString());
		ordenamientoPartidosJugados = new TableRowSorter<>(modeloPartidosJugados);
		ordenamientoPartidosJugados.toggleSortOrder(0);
		
		tablaPartidosJugados = new JTable();
		tablaPartidosJugados.setModel(modeloPartidosJugados);
		tablaPartidosJugados.setRowSorter(ordenamientoPartidosJugados);
		tablaPartidosJugados.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosJugados.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaPartidosJugados.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaPartidosJugados.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane.setViewportView(tablaPartidosJugados);
		
		fecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
		fecha.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		fecha.setBounds(178, 66, 142, 22);
		panelContenedor.add(fecha);
	}
}
