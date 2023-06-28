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
import interfaz.tablas.modelos.InfraccionesDeporteTableModel;
import interfaz.tablas.modelos.MultiLineaCellRendererEditor;
import nucleo.Deporte;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Archivador;
import utilidades.Auxiliares;

public class InfraccionesJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private InfraccionesDeporteTableModel modeloInfracciones;
	private TableRowSorter<InfraccionesDeporteTableModel> ordenamientoInfracciones;
	private JTable tablaInfracciones;
	private JButton botonAyudaInfraccion;
	
	public InfraccionesJDialog(EsquemaColores e, JFrame padre, Deporte d) {
		super("Infracciones", e, padre);
		
		JDialogGeneral j = this;
		
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
		botonAyudaInfraccion.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaInfraccion.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaInfraccion.setContentAreaFilled(false);
		botonAyudaInfraccion.setBorder(null);
		botonAyudaInfraccion.setBounds(653, 13, 36, 36);
		panelContenedor.add(botonAyudaInfraccion);
		
		JLabel nombreFacultadLbl = new JLabel("Infracciones de "+d.getNombre());
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 680, 378);
		panelContenedor.add(scrollPane);
		
		
		modeloInfracciones = new InfraccionesDeporteTableModel();
		modeloInfracciones.actualizar(d.getInfracciones());
		ordenamientoInfracciones = new TableRowSorter<>(modeloInfracciones);
		ordenamientoInfracciones.toggleSortOrder(0);
		ordenamientoInfracciones.setSortable(3,false);
		ordenamientoInfracciones.setComparator(0, Archivador.getComparatorStringLocalDate());
		
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
		scrollPane.setViewportView(tablaInfracciones);
		
	}

}