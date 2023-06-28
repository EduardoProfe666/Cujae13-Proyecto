package interfaz.clases.panelesAppPrincipalAdmin;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import clasesAuxiliares.InfraccionReporte;
import clasesAuxiliares.SancionReporte;
import interfaz.clases.AppPrincipal;
import interfaz.clases.jdialogs.AgregarInfraccionJDialog;
import interfaz.clases.jdialogs.AgregarSancionJDialog;
import interfaz.clases.panelesAppPrincipal.PanelBaseAppPrincipal;
import interfaz.tablas.modelos.InfraccionesTableModel;
import interfaz.tablas.modelos.MultiLineaCellRendererEditor;
import interfaz.tablas.modelos.SancionesTableModel;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Archivador;
import utilidades.Auxiliares;

public class PanelAmonestaciones extends PanelBaseAppPrincipal{

	private static final long serialVersionUID = 1L;
	private JButton botonAyudaInfraccion;
	private JButton agregarInfraccion;
	private JButton botonAyudaSanciones;
	private JButton agregarSancion;
	private SancionesTableModel modeloSanciones;
	private TableRowSorter<SancionesTableModel> ordenamientoSanciones;
	private JTable tablaSanciones;
	private InfraccionesTableModel modeloInfracciones;
	private TableRowSorter<InfraccionesTableModel> ordenamientoInfracciones;
	private JTable tablaInfracciones;
	private LinkedList<SancionReporte> listaSanciones = Universidad.getInstancia().obtenerSancionesTodasFacultades();
	private LinkedList<InfraccionReporte> listaInfracciones = Universidad.getInstancia().obtenerInfraccionesTodasFacultades();
	
	public PanelAmonestaciones(EsquemaColores e, JFrame padre) {
		botonAyudaInfraccion = new JButton("");
		botonAyudaInfraccion.setToolTipText("Ayuda de Infracciones");
		botonAyudaInfraccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Las infracciones son amonestaciones menos graves. Tributan a la "
						+ "tabla de posiciones de cada deporte.");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
			}
		});
		botonAyudaInfraccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyudaInfraccion.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaInfraccion.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaInfraccion.setContentAreaFilled(false);
		botonAyudaInfraccion.setBorder(null);
		botonAyudaInfraccion.setBounds(843, 42, 36, 36);
		add(botonAyudaInfraccion);
		
		botonAyudaSanciones = new JButton("");
		botonAyudaSanciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Las sanciones son las amonestaciones más graves. Tributan "
						+ "directamente a la tabla de posiciones general de los Juegos 13 de Marzo.");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
				
			}
		});
		botonAyudaSanciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyudaSanciones.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaSanciones.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaSanciones.setToolTipText("Ayuda de Sanciones");
		botonAyudaSanciones.setContentAreaFilled(false);
		botonAyudaSanciones.setBorder(null);
		botonAyudaSanciones.setBounds(843, 321, 36, 36);
		add(botonAyudaSanciones);
		
		agregarInfraccion = new JButton("");
		agregarInfraccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AgregarInfraccionJDialog ventana = new AgregarInfraccionJDialog(e, padre);
				ventana.setVisible(true);
			}
		});
		agregarInfraccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarInfraccion.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/add01.png")));
		agregarInfraccion.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/add02.png")));
		agregarInfraccion.setToolTipText("Agregar Infracción");
		agregarInfraccion.setContentAreaFilled(false);
		agregarInfraccion.setBorder(null);
		agregarInfraccion.setBounds(797, 42, 36, 36);
		add(agregarInfraccion);
		
		agregarSancion = new JButton("");
		agregarSancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				AgregarSancionJDialog ventana = new AgregarSancionJDialog(e, padre);
				ventana.setVisible(true);
			}
		});
		agregarSancion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		agregarSancion.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/add01.png")));
		agregarSancion.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/add02.png")));
		agregarSancion.setToolTipText("Agregar Sanción");
		agregarSancion.setContentAreaFilled(false);
		agregarSancion.setBorder(null);
		agregarSancion.setBounds(797, 320, 36, 36);
		add(agregarSancion);
		
		JLabel infraccionesLbl = new JLabel("Infracciones");
		infraccionesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		infraccionesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		infraccionesLbl.setBounds(10, 35, 869, 45);
		add(infraccionesLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 869, 196);
		add(scrollPane);
		
		JLabel sancionesLbl = new JLabel("Sanciones");
		sancionesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		sancionesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		sancionesLbl.setBounds(10, 312, 869, 45);
		add(sancionesLbl);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 368, 869, 196);
		add(scrollPane_1);
		
		modeloSanciones = new SancionesTableModel();
		modeloSanciones.actualizar(listaSanciones);
		ordenamientoSanciones = new TableRowSorter<>(modeloSanciones);
		ordenamientoSanciones.toggleSortOrder(0);
		ordenamientoSanciones.setSortable(3, false);
		ordenamientoSanciones.setComparator(0, Archivador.getComparatorStringLocalDate());
		
		tablaSanciones = new JTable();
		tablaSanciones.setModel(modeloSanciones);
		tablaSanciones.setRowSorter(ordenamientoSanciones);
		tablaSanciones.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaSanciones.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaSanciones.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaSanciones.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tablaSanciones.setRowHeight(tablaSanciones.getRowHeight() * 3);
		tablaSanciones.getColumnModel().getColumn(3).setCellRenderer(new MultiLineaCellRendererEditor());
		tablaSanciones.getColumnModel().getColumn(3).setCellEditor(new MultiLineaCellRendererEditor());
		scrollPane_1.setViewportView(tablaSanciones);
		
		modeloInfracciones = new InfraccionesTableModel();
		modeloInfracciones.actualizar(listaInfracciones);
		ordenamientoInfracciones = new TableRowSorter<>(modeloInfracciones);
		ordenamientoInfracciones.toggleSortOrder(0);
		ordenamientoInfracciones.setSortable(4,false);
		ordenamientoInfracciones.setComparator(0, Archivador.getComparatorStringLocalDate());
		
		tablaInfracciones = new JTable();
		tablaInfracciones.setModel(modeloInfracciones);
		tablaInfracciones.setRowSorter(ordenamientoInfracciones);
		tablaInfracciones.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaInfracciones.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaInfracciones.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaInfracciones.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tablaInfracciones.setRowHeight(tablaInfracciones.getRowHeight() * 3);
		tablaInfracciones.getColumnModel().getColumn(4).setCellRenderer(new MultiLineaCellRendererEditor());
		tablaInfracciones.getColumnModel().getColumn(4).setCellEditor(new MultiLineaCellRendererEditor());
		scrollPane.setViewportView(tablaInfracciones);
	}
}
