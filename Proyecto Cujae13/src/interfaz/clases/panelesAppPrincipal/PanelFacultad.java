package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import interfaz.clases.jdialogs.AmonestacionesFacultadJDialog;
import interfaz.clases.jdialogs.HistoriaCuriosidadesFacultadJDialog;
import interfaz.clases.jdialogs.HistorialJuegosFacultadJDialog;
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
	
	public PanelFacultad(JFrame padre,EsquemaColores e, NombreFacultad f) {
		
		EsquemaColores ex = Archivador.getEsquemaColores(f);
		
		avatar = new AvatarCircular(new ImageIcon(BtnSeleccionFacultad.class.getResource(ex.getDirUrlImagenAvatar())), 2);
		avatar.setForeground(ex.getBordeAvatar());
		avatar.setBounds(xAvatar(f.toString()), 35, 42, 42);
		add(avatar);
		
		JButton sancionesInfraccionesBtn = new JButton();
		sancionesInfraccionesBtn.setToolTipText("Amonestaciones");
		sancionesInfraccionesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				AmonestacionesFacultadJDialog ventana = new AmonestacionesFacultadJDialog(e, padre, f);
				ventana.setVisible(true);
			}
		});
		sancionesInfraccionesBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sancionesInfraccionesBtn.setBorder(null);
		sancionesInfraccionesBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/amonestacion01.png")));
		sancionesInfraccionesBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/amonestacion02.png")));
		sancionesInfraccionesBtn.setContentAreaFilled(false);
		sancionesInfraccionesBtn.setBounds(681, 35, 42, 42);
		add(sancionesInfraccionesBtn);
		
		JButton historiaJuegosBtn = new JButton();
		historiaJuegosBtn.setToolTipText("Historial de Juegos");
		historiaJuegosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				HistorialJuegosFacultadJDialog ventana = new HistorialJuegosFacultadJDialog(e, padre, f);
				ventana.setVisible(true);
			}
		});
		historiaJuegosBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		historiaJuegosBtn.setBorder(null);
		historiaJuegosBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/historialJuegos01.png")));
		historiaJuegosBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/historialJuegos02.png")));
		historiaJuegosBtn.setContentAreaFilled(false);
		historiaJuegosBtn.setBounds(733, 35, 42, 42);
		add(historiaJuegosBtn);
		
		JButton histCuriosBtn = new JButton();
		histCuriosBtn.setToolTipText("Historia y Curiosidades");
		histCuriosBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				HistoriaCuriosidadesFacultadJDialog ventana = new HistoriaCuriosidadesFacultadJDialog(e, padre, f);
				ventana.setVisible(true);
			}
		});
		histCuriosBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		histCuriosBtn.setBounds(629, 35, 42, 42);
		histCuriosBtn.setBorder(null);
		histCuriosBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/historiaCurios01.png")));
		histCuriosBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/historiaCurios02.png")));
		histCuriosBtn.setContentAreaFilled(false);
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
	
	private int xAvatar(String nombreFacultad) {
		int x = 10+15;
		String modelo1 = "IitrlT";
		String modelo2 = "AmBEM";
		
		for(Character c : nombreFacultad.toCharArray()) {
			if(modelo1.contains(c.toString()))
				x+=6;
			else if(c == 'v')
				x+=10;
			else if(modelo2.contains(c.toString()))
				x+=16;
			else
				x+=14;
				
		}
		
		return x;
	}
}
