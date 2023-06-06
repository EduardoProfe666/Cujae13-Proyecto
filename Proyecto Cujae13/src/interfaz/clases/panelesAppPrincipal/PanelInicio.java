package interfaz.clases.panelesAppPrincipal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import clasesAuxiliares.NombreFacultad;
import componentes.Imagen;
import interfaz.clases.AppPrincipal;
import interfaz.componentes.LabelDiaActual;
import interfaz.componentes.TablaPosiciones;
import interfaz.tablas.modelos.PartidosJugadosTableModel;
import interfaz.tablas.modelos.PartidosPorJugarTableModel;
import utilidades.Archivador;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Inicio de la aplicación. Está personalizada con 
 * la información de cada facultad.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Katherine Ramírez
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelInicio extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel nombreFacultadLbl;
	private LabelDiaActual diaLbl;
	private TablaPosiciones tablaPosGeneral;
	private JLabel lblPartidosPorJugar;
	private JLabel lblPartidosPorJugar_1;
	private JTable tablaPartidosJugar;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable tablaPartidosJugados;
	private Imagen medalla;
	private PartidosPorJugarTableModel modeloPartidosPorJugar;
	private PartidosJugadosTableModel modeloPartidosJugados;
	private TableRowSorter<PartidosJugadosTableModel> ordenamientoPartidosJugados;
	private TableRowSorter<PartidosPorJugarTableModel> ordenamientoPartidosPorJugar;
	
	
	public PanelInicio(EsquemaColores e, NombreFacultad f) {
		setBackground(Color.WHITE);
		
		//Aqui se va a coger por el singletone, la posicion de cada facultad
		//Provisional
		medalla = new Imagen(Auxiliares.ajustarImagen(new Dimension(32,38), AppPrincipal.class.getResource(Archivador.getDirUrlMedalla(new Random().nextInt(9)+1))));
		medalla.setBounds(837, 35, 42, 42);
		add(medalla);
		
		
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
		
		tablaPosGeneral = new TablaPosiciones(null, e.getSeleccionTextoTabla(), e.getSeleccionFondoTabla(),false);
		add(tablaPosGeneral);
		
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
		
		modeloPartidosPorJugar = new PartidosPorJugarTableModel(f.toString());
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
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 401, 560, 163);
		add(scrollPane_2);
		
		modeloPartidosJugados = new PartidosJugadosTableModel(f.toString());
		ordenamientoPartidosJugados = new TableRowSorter<>(modeloPartidosJugados);
		ordenamientoPartidosJugados.toggleSortOrder(0);
		
		tablaPartidosJugados = new JTable();
		tablaPartidosJugados.setModel(modeloPartidosJugados);
		tablaPartidosJugados.setRowSorter(ordenamientoPartidosJugados);
		tablaPartidosJugados.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosJugar.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaPartidosJugar.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaPartidosJugados.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane_2.setViewportView(tablaPartidosJugados);
		
	}
}
