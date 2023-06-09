package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JCalendar;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.componentes.LabelDiaActual;
import interfaz.tablas.modelos.PartidosPorJugarDiaTableModel;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Calendario de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Eduardo González
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelCalendario extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JCalendar calendario;
	private JLabel seleccionarFechaLbl;
	private LabelDiaActual partidosDiaLbl;
	private PartidosPorJugarDiaTableModel modeloPartidosPorJugar;
	private TableRowSorter<PartidosPorJugarDiaTableModel> ordenamientoPartidosPorJugar;
	private JTable tablaPartidosJugar;
	private AbstractButton botonAyuda;

	public PanelCalendario(EsquemaColores e) {
		
		botonAyuda = new JButton("");
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Seleccione una fecha. La tabla de partidos se actualizará de forma "
						+ "dinámica para ofrecer el listado de los partidos del día seleccionado.",
						"Ayuda", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		botonAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(843, 42, 36, 36);
		add(botonAyuda);
		
		calendario = new JCalendar();
		calendario.setBorder(new LineBorder(e.getBordeLbl(), 2));
		calendario.setBounds(220, 90, 460, 200);
		add(calendario);
		
		seleccionarFechaLbl = new JLabel("Seleccionar Fecha");
		seleccionarFechaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		seleccionarFechaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		seleccionarFechaLbl.setBounds(10, 35, 869, 45);
		add(seleccionarFechaLbl);
		
		partidosDiaLbl = new LabelDiaActual("Partidos del día:",e.getBordeLbl());
		partidosDiaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		partidosDiaLbl.setBounds(10, 316, 869, 26);
		add(partidosDiaLbl);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 350, 869, 214);
		add(scrollPane_1);
		
		modeloPartidosPorJugar = new PartidosPorJugarDiaTableModel();
		ordenamientoPartidosPorJugar = new TableRowSorter<>(modeloPartidosPorJugar);
		ordenamientoPartidosPorJugar.toggleSortOrder(0);
		
		tablaPartidosJugar = new JTable();
		tablaPartidosJugar.setModel(modeloPartidosPorJugar);
		tablaPartidosJugar.setRowSorter(ordenamientoPartidosPorJugar);
		tablaPartidosJugar.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosJugar.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaPartidosJugar.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaPartidosJugar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane_1.setViewportView(tablaPartidosJugar);

	}
}
