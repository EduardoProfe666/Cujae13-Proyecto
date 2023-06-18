package interfaz.clases.jdialogs;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.tablas.modelos.InfraccionesFacultadTableModel;
import interfaz.tablas.modelos.MultiLineaCellRendererEditor;
import interfaz.tablas.modelos.SancionesFacultadTableModel;
import nucleo.NombreFacultad;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

public class AmonestacionesFacultadJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private SancionesFacultadTableModel modeloSanciones;
	private TableRowSorter<SancionesFacultadTableModel> ordenamientoSanciones;
	private JTable tablaSanciones;
	private InfraccionesFacultadTableModel modeloInfracciones;
	private TableRowSorter<InfraccionesFacultadTableModel> ordenamientoInfracciones;
	private JTable tablaInfracciones;
	private JButton botonAyudaSancion;
	private JButton botonAyudaInfraccion;
	
	public AmonestacionesFacultadJDialog(EsquemaColores e, JFrame padre, NombreFacultad f) {
		super("Amonestaciones", e, padre);
		
		JDialogGeneral j = this;
		
		botonAyudaSancion = new JButton("");
		botonAyudaSancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Las sanciones son las amonestaciones más graves. Tributan "
						+ "directamente a la tabla de posiciones general de los Juegos 13 de Marzo.");
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
		botonAyudaSancion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyudaSancion.setIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaSancion.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaSancion.setContentAreaFilled(false);
		botonAyudaSancion.setBorder(null);
		botonAyudaSancion.setToolTipText("Ayuda");
		botonAyudaSancion.setBounds(662, 64, 28, 28);
		panelContenedor.add(botonAyudaSancion);
		
		botonAyudaInfraccion = new JButton("");
		botonAyudaInfraccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Las infracciones son amonestaciones menos graves. Tributan a la "
						+ "tabla de posiciones de cada deporte.");
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
		botonAyudaInfraccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyudaInfraccion.setToolTipText("Ayuda");
		botonAyudaInfraccion.setIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaInfraccion.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaInfraccion.setContentAreaFilled(false);
		botonAyudaInfraccion.setBorder(null);
		botonAyudaInfraccion.setBounds(662, 258, 28, 28);
		panelContenedor.add(botonAyudaInfraccion);
		
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
		modeloSanciones.actualizar(Universidad.getInstancia().buscarFacultad(f).getSanciones());
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
		modeloInfracciones.actualizar(Universidad.getInstancia().getListadoInfracciones(f));
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
