package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.tablas.modelos.SeleccionDeporteTableModel;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

public class PanelSeleccionarDeporte extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel elegirDeporteLbl;
	private SeleccionDeporteTableModel modelo;
	private TableRowSorter<SeleccionDeporteTableModel> ordenamiento;
	private JTable tabla;
	private JButton botonAyuda;
	
	public PanelSeleccionarDeporte(JFrame padre, EsquemaColores e, JTabbedPane tab) {
		
		botonAyuda = new JButton("");
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Para acceder a la información del deporte "
						+ "haga doble click en el deporte deseado");
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
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(851, 96, 28, 28);
		add(botonAyuda);
		
		elegirDeporteLbl = new JLabel("Elegir Deporte");
		elegirDeporteLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		elegirDeporteLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		elegirDeporteLbl.setBounds(10, 35, 869, 45);
		add(elegirDeporteLbl);
		
		JLabel lblTablaDeportes = new JLabel("Tabla de Deportes");
		lblTablaDeportes.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		lblTablaDeportes.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		lblTablaDeportes.setBounds(10, 98, 869, 26);
		add(lblTablaDeportes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 130, 869, 434);
		add(scrollPane_1);
		
		modelo = new SeleccionDeporteTableModel();
		modelo.prueba();
		ordenamiento = new TableRowSorter<SeleccionDeporteTableModel>(modelo);
		ordenamiento.toggleSortOrder(0);
		
		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				if(x.getClickCount()==2) {
					if(tabla.getSelectedRow()!=-1) {
						tab.setComponentAt(7, new PanelDeporte(padre, e, null));
						tab.setSelectedIndex(7);
					}
				}
			}
		});
		tabla.setModel(modelo);
		tabla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabla.setRowSorter(ordenamiento);
		tabla.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tabla.setSelectionForeground(e.getSeleccionTextoTabla());
		tabla.setSelectionBackground(e.getSeleccionFondoTabla());
		tabla.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane_1.setViewportView(tabla);
	}

}
