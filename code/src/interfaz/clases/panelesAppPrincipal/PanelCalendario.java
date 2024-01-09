package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import componentes.CalendarT;
import interfaz.clases.AppPrincipal;
import interfaz.componentes.LabelDiaActual;
import interfaz.tablas.modelos.PartidosPorJugarDiaTableModel;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Archivador;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Calendario de la aplicaci�n.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Brayan Garc�a
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Brayan Garc�a
 * @author Eduardo Gonz�lez
 *
 */
public class PanelCalendario extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private CalendarT calendario;
	private JLabel seleccionarFechaLbl;
	private LabelDiaActual partidosDiaLbl;
	private PartidosPorJugarDiaTableModel modeloPartidosPorJugar;
	private TableRowSorter<PartidosPorJugarDiaTableModel> ordenamientoPartidosPorJugar;
	private JTable tablaPartidosJugar;
	private JButton botonAyuda;
	private LocalDate fechaSeleccionada;

	public PanelCalendario(EsquemaColores e) {
		
		botonAyuda = new JButton("");
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Seleccione una fecha. La tabla de partidos se actualizar� de forma "
						+ "din�mica para ofrecer el listado de los partidos del d�a seleccionado.");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
				
			}
		});
		botonAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(843, 42, 36, 36);
		add(botonAyuda);
		
		seleccionarFechaLbl = new JLabel("Seleccionar Fecha");
		seleccionarFechaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		seleccionarFechaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		seleccionarFechaLbl.setBounds(10, 35, 869, 45);
		add(seleccionarFechaLbl);
		
		partidosDiaLbl = new LabelDiaActual("Partidos del d�a:",e.getBordeLbl());
		partidosDiaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		partidosDiaLbl.setBounds(10, 316, 869, 26);
		add(partidosDiaLbl);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 350, 869, 214);
		add(scrollPane_1);
		
		modeloPartidosPorJugar = new PartidosPorJugarDiaTableModel();
		ordenamientoPartidosPorJugar = new TableRowSorter<>(modeloPartidosPorJugar);
		ordenamientoPartidosPorJugar.toggleSortOrder(0);
		ordenamientoPartidosPorJugar.setComparator(0, Archivador.getComparatorStringLocalTime());
		
		tablaPartidosJugar = new JTable();
		tablaPartidosJugar.setModel(modeloPartidosPorJugar);
		tablaPartidosJugar.setRowSorter(ordenamientoPartidosPorJugar);
		tablaPartidosJugar.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosJugar.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaPartidosJugar.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaPartidosJugar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		//tablaPartidosJugar.getTableHeader().setReorderingAllowed(false);
		scrollPane_1.setViewportView(tablaPartidosJugar);
		
		
		calendario = new CalendarT(e.getColorCalendario(),e.getBordeLbl(), LocalDate.now(),Universidad.getInstancia().getFechaInicio().plusMonths(1).plusDays(15));
		calendario.getDateChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				fechaSeleccionada=calendario.getFechaSeleccionada();
				partidosDiaLbl.cambiarFecha(fechaSeleccionada);
				actualizarTablaCalendario();
			}
		});
		calendario.getDateChooser().setSelectedDate(LocalDate.now());
		calendario.setBounds(317, 95, 266, 210);
		calendario.getDateChooser().setBounds(2,2,262,206);
		add(calendario);

	}
	
	
	public void actualizarTablaCalendario() {
		modeloPartidosPorJugar.actualizar(Universidad.getInstancia().devolverListaEventosPorDia(fechaSeleccionada));
	}
	
}