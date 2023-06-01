package interfaz.clases.panelesAppPrincipal;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import clasesAuxiliares.NombreFacultad;
import interfaz.componentes.LabelDiaActual;

public class PanelInicio extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel nombreFacultadLbl;
	private LabelDiaActual diaLbl;
	private JTable tablaPosGeneral;
	private JLabel lblPartidosPorJugar;
	private JLabel lblPartidosPorJugar_1;
	private JTable tablaPartidosJugar;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable tablaPartidosPorJugar;
	private JLabel lblNewLabel;
	
	
	public PanelInicio(EsquemaColores e, NombreFacultad f) {
		setBackground(Color.WHITE);
		
		lblNewLabel = new JLabel("1st");
		lblNewLabel.setFont(new Font("Roboto Black", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(820, 35, 49, 37);
		add(lblNewLabel);
		
		nombreFacultadLbl = new JLabel(f.toString());
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		nombreFacultadLbl.setBounds(10, 35, 869, 45);
		add(nombreFacultadLbl);
		
		diaLbl = new LabelDiaActual(e.getBordeLbl());
		//diaLbl = new LabelDiaActual(Color.BLACK);
		diaLbl.setBounds(10, 91, 560, 26);
		add(diaLbl);
		
		JLabel tablaPosLbl = new JLabel("Tabla de Posiciones General");
		tablaPosLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		tablaPosLbl.setBounds(589, 91, 290, 26);
		add(tablaPosLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(589, 140, 290, 424);
		add(scrollPane);
		
		tablaPosGeneral = new JTable();
		tablaPosGeneral.setFillsViewportHeight(true);
		tablaPosGeneral.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
				{new Integer(1), "Inform\u00E1tica", new Integer(99999999)},
			},
			
			new String[] {
				"Posici\u00F3n", "Facultad", "Puntaje"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaPosGeneral.getColumnModel().getColumn(0).setPreferredWidth(59);
		tablaPosGeneral.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPosGeneral.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane.setViewportView(tablaPosGeneral);
		
		lblPartidosPorJugar = new JLabel("Partidos por Jugar");
		lblPartidosPorJugar.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		lblPartidosPorJugar.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//lblPartidosPorJugar.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		lblPartidosPorJugar.setBounds(10, 143, 560, 26);
		add(lblPartidosPorJugar);
		
		lblPartidosPorJugar_1 = new JLabel("Resultados de Partidos Jugados");
		lblPartidosPorJugar_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		lblPartidosPorJugar_1.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//lblPartidosPorJugar_1.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		lblPartidosPorJugar_1.setBounds(10, 364, 560, 26);
		add(lblPartidosPorJugar_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 180, 560, 173);
		add(scrollPane_1);
		
		tablaPartidosJugar = new JTable();
		tablaPartidosJugar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hora", "Deporte", "Adversario", "Tipo de Evento"
			}
		));
		tablaPartidosJugar.getColumnModel().getColumn(3).setPreferredWidth(94);
		tablaPartidosJugar.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosJugar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane_1.setViewportView(tablaPartidosJugar);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 401, 560, 163);
		add(scrollPane_2);
		
		tablaPartidosPorJugar = new JTable();
		tablaPartidosPorJugar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hora Inicio", "Hora Fin", "Deporte", "Adversario", "Resultado"
			}
		));
		tablaPartidosPorJugar.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosPorJugar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane_2.setViewportView(tablaPartidosPorJugar);
		
	}
}
