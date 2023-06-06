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
import interfaz.tablas.modelos.InfraccionesFacultadTableModel;
import interfaz.tablas.modelos.MultiLineaCellRendererEditor;
import interfaz.tablas.modelos.SancionesFacultadTableModel;

public class AmonestacionesFacultadJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private SancionesFacultadTableModel modeloSanciones;
	private TableRowSorter<SancionesFacultadTableModel> ordenamientoSanciones;
	private JTable tablaSanciones;
	private InfraccionesFacultadTableModel modeloInfracciones;
	private TableRowSorter<InfraccionesFacultadTableModel> ordenamientoInfracciones;
	private JTable tablaInfracciones;
	
	public AmonestacionesFacultadJDialog(EsquemaColores e, JFrame padre, NombreFacultad f) {
		super("Amonestaciones", e, padre);
		
		JLabel nombreFacultadLbl = new JLabel("Amonestaciones de "+f.toString());
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel sancionesLbl = new JLabel("Sanciones");
		sancionesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		sancionesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		sancionesLbl.setBounds(10, 66, 680, 26);
		panelContenedor.add(sancionesLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 680, 150);
		panelContenedor.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 290, 680, 150);
		panelContenedor.add(scrollPane_1);
		
		modeloSanciones = new SancionesFacultadTableModel();
		ordenamientoSanciones = new TableRowSorter<>(modeloSanciones);
		ordenamientoSanciones.toggleSortOrder(0);
		ordenamientoSanciones.setSortable(2, false);
		
		tablaSanciones = new JTable();
		tablaSanciones.setModel(modeloSanciones);
		tablaSanciones.setRowSorter(ordenamientoSanciones);
		tablaSanciones.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaSanciones.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaSanciones.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaSanciones.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tablaSanciones.setRowHeight(tablaSanciones.getRowHeight() * 3);
		tablaSanciones.getColumnModel().getColumn(2).setCellRenderer(new MultiLineaCellRendererEditor());
		tablaSanciones.getColumnModel().getColumn(2).setCellEditor(new MultiLineaCellRendererEditor());
		scrollPane.setViewportView(tablaSanciones);
		
		
		modeloInfracciones = new InfraccionesFacultadTableModel();
		ordenamientoInfracciones = new TableRowSorter<>(modeloInfracciones);
		ordenamientoInfracciones.toggleSortOrder(0);
		ordenamientoInfracciones.setSortable(3,false);
		
		tablaInfracciones = new JTable();
		tablaInfracciones.setModel(modeloInfracciones);
		tablaInfracciones.setRowSorter(ordenamientoInfracciones);
		tablaInfracciones.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaInfracciones.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaInfracciones.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaInfracciones.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tablaInfracciones.setRowHeight(tablaInfracciones.getRowHeight() * 3);
		tablaInfracciones.getColumnModel().getColumn(3).setCellRenderer(new MultiLineaCellRendererEditor());
		tablaInfracciones.getColumnModel().getColumn(3).setCellEditor(new MultiLineaCellRendererEditor());
		scrollPane_1.setViewportView(tablaInfracciones);
		
		JLabel infraccionesLbl = new JLabel("Infracciones");
		infraccionesLbl.setBounds(10, 260, 680, 26);
		infraccionesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		panelContenedor.add(infraccionesLbl);
		infraccionesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		
		
	}

}
