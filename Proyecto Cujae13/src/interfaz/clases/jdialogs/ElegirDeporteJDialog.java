package interfaz.clases.jdialogs;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.tablas.modelos.SeleccionDeporteTableModel;
import nucleo.Deporte;
import utilidades.Auxiliares;

public class ElegirDeporteJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private JButton botonAyudaSancion;
	private SeleccionDeporteTableModel modelo;
	private TableRowSorter<SeleccionDeporteTableModel> ordenamiento;
	private JTable tabla;
	
	public ElegirDeporteJDialog(String localizacion, EsquemaColores e, JFrame padre, List<Deporte> deportes) {
		super(localizacion, e, padre);
		
		botonAyudaSancion = new JButton("");
		botonAyudaSancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Para acceder a la informaci�n del deporte activo "
						+ "haga doble click en el deporte deseado", "Ayuda", JOptionPane.INFORMATION_MESSAGE);
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
		
		JLabel nombreFacultadLbl = new JLabel("Elegir Deporte");
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel sancionesLbl = new JLabel("Tabla de deportes activos");
		sancionesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		sancionesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		sancionesLbl.setBounds(10, 66, 680, 26);
		panelContenedor.add(sancionesLbl);
		
		modelo = new SeleccionDeporteTableModel();
		modelo.prueba();
		ordenamiento = new TableRowSorter<SeleccionDeporteTableModel>(modelo);
		ordenamiento.toggleSortOrder(0);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 98, 680, 345);
		panelContenedor.add(scrollPane_1);
		
		tabla = new JTable();
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				if(x.getClickCount()==2) {
					if(tabla.getSelectedRow()!=-1) {
//						tab.setComponentAt(7, new PanelDeporte(padre, e, null));
//						tab.setSelectedIndex(7);
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