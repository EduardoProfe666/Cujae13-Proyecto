package interfaz.clases.jdialogs;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import componentes.CalendarPicker;
import interfaz.clases.AppPrincipal;
import interfaz.tablas.modelos.PartidosJugadosTableModel;
import nucleo.NombreFacultad;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Archivador;
import utilidades.Auxiliares;

public class HistorialJuegosFacultadJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private PartidosJugadosTableModel modeloPartidosJugados;
	private TableRowSorter<PartidosJugadosTableModel> ordenamientoPartidosJugados;
	private JTable tablaPartidosJugados;
	private CalendarPicker fecha;
	private JButton botonAyuda;

	public HistorialJuegosFacultadJDialog(EsquemaColores e, JFrame padre, NombreFacultad f) {
		super("Historial de Juegos", e, padre);
		JDialogGeneral j = this;
		botonAyuda = new JButton("");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Seleccione una fecha. La tabla de partidos jugados se actualizar� de forma "
						+ "din�mica para ofrecer el listado con los resultados de los partidos del "
						+ "d�a seleccionado.");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
						j.setVisible(true);
					}
				});
				GlassPanePopup.showPopup(m, o);
				j.setVisible(false);
				
			}
		});
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(662, 64, 28, 28);
		panelContenedor.add(botonAyuda);

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

		modeloPartidosJugados = new PartidosJugadosTableModel(f);
		modeloPartidosJugados.actualizar(Universidad.getInstancia().obtenerEventosDiaDado(f, Universidad.getInstancia().getFechaInicio()));
		ordenamientoPartidosJugados = new TableRowSorter<>(modeloPartidosJugados);
		ordenamientoPartidosJugados.toggleSortOrder(0);
		ordenamientoPartidosJugados.setComparator(0, Archivador.getComparatorStringLocalTime());
		ordenamientoPartidosJugados.setComparator(1, Archivador.getComparatorStringLocalTime());

		tablaPartidosJugados = new JTable();
		tablaPartidosJugados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaPartidosJugados.setModel(modeloPartidosJugados);
		tablaPartidosJugados.setRowSorter(ordenamientoPartidosJugados);
		tablaPartidosJugados.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosJugados.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaPartidosJugados.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaPartidosJugados.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane.setViewportView(tablaPartidosJugados);

		fecha = new CalendarPicker(e.getColorCalendario(), 180, Universidad.getInstancia().getFechaInicio(),LocalDate.now());
		fecha.addPropertyChangeListener("exito", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {

				modeloPartidosJugados.actualizar(Universidad.getInstancia().obtenerEventosDiaDado(f, fecha.getFechaSeleccionada()));
			}
		});
		fecha.setBounds(178, 66, 180, 22);
		panelContenedor.add(fecha);
	}
}