package interfaz.clases.panelesAppPrincipal;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import clasesAuxiliares.EstadisticasReporte;
import clasesAuxiliares.NombreFacultad;
import componentes.AvatarCircular;
import componentes.Imagen;
import interfaz.clases.AppPrincipal;
import interfaz.componentes.BtnSeleccionFacultad;
import interfaz.componentes.LabelDiaActual;
import interfaz.tablas.modelos.EstadisticasTableModel;
import interfaz.tablas.modelos.PartidosJugadosTableModel;
import interfaz.tablas.modelos.PartidosPorJugarTableModel;
import utilidades.Archivador;
import utilidades.Auxiliares;
/**
 * JPanel que modela la pantalla de Facultad de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Lilian Rojas
 * 
 * @version 2023.06.06
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelFacultad extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private AvatarCircular avatar;
	private Imagen medalla;
	private JLabel nombreFacultadLbl;
	private LabelDiaActual diaLbl;
	private JLabel lblPartidosPorJugar;
	private JLabel lblPartidosPorJugar_1;
	private JTable tablaPartidosJugar;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTable tablaPartidosJugados;
	private PartidosPorJugarTableModel modeloPartidosPorJugar;
	private PartidosJugadosTableModel modeloPartidosJugados;
	private TableRowSorter<PartidosJugadosTableModel> ordenamientoPartidosJugados;
	private JScrollPane scrollPane_3;
	private EstadisticasTableModel modeloEstadisticas;
	private JTable estadisticas;
	private TableRowSorter<PartidosPorJugarTableModel> ordenamientoPartidosPorJugar;
	
	public PanelFacultad(EsquemaColores e, NombreFacultad f) {
		EsquemaColores ex = Archivador.getEsquemaColores(f);
		
		avatar = new AvatarCircular(new ImageIcon(BtnSeleccionFacultad.class.getResource(ex.getDirUrlImagenAvatar())), 2);
		avatar.setForeground(ex.getBordeAvatar());
		avatar.setBounds(f.toString().length()*13+15, 35, 42, 42);
		add(avatar);
		
		JButton sancionesInfraccionesBtn = new JButton("S");
		sancionesInfraccionesBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sancionesInfraccionesBtn.setBounds(681, 35, 42, 42);
		add(sancionesInfraccionesBtn);
		
		JButton historiaJuegosBtn = new JButton("J");
		historiaJuegosBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		historiaJuegosBtn.setBounds(733, 35, 42, 42);
		add(historiaJuegosBtn);
		
		JButton histCuriosBtn = new JButton("H");
		histCuriosBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		histCuriosBtn.setBounds(629, 35, 42, 42);
		add(histCuriosBtn);
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
		
		JLabel estadisticasLbl = new JLabel("Estadísticas");
		estadisticasLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		estadisticasLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		estadisticasLbl.setBounds(589, 91, 290, 26);
		add(estadisticasLbl);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(589, 140, 290, 424);
		add(scrollPane_3);
		
		modeloEstadisticas = new EstadisticasTableModel();
		//Crear una funcion que te haga el reporte
		modeloEstadisticas.actualizar(new EstadisticasReporte(999, 999, 999, 999, 999, 999, 999));
		
		estadisticas = new JTable();
		estadisticas.setModel(modeloEstadisticas);
		estadisticas.setFillsViewportHeight(true);
		estadisticas.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		estadisticas.setSelectionForeground(e.getSeleccionTextoTabla());
		estadisticas.setSelectionBackground(e.getSeleccionFondoTabla());
		estadisticas.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		estadisticas.setRowHeight(56);
		scrollPane_3.setViewportView(estadisticas);
		
		
	}
}
