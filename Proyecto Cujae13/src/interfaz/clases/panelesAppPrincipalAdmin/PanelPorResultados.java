package interfaz.clases.panelesAppPrincipalAdmin;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

import clasesAuxiliares.EsquemaColores;
import componentes.CalendarPicker;
import interfaz.clases.AppPrincipal;
import interfaz.clases.jdialogs.AgregarResultadosJDialog;
import interfaz.clases.panelesAppPrincipal.PanelBaseAppPrincipal;
import interfaz.combobox.modelos.DeporteComboBoxModel;
import interfaz.combobox.modelos.NombreFacultadComboBoxModel;
import interfaz.combobox.modelos.TipoEventoComboBoxModel;
import interfaz.tablas.modelos.PartidosPorResultadosTableModel;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

public class PanelPorResultados extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JButton botonAyudaBusq;
	private JLabel tipoEventoLbl;
	private JComboBox<String> facultad1;
	private JComboBox<String> facultad2;
	private JComboBox<String> deporte;
	private JComboBox<String> tipoEvento;
	private JLabel lblPartidosPorResultados;
	private PartidosPorResultadosTableModel modelo;
	private TableRowSorter<PartidosPorResultadosTableModel> ordenamiento;
	private JTable tablaPartidosPorResultados;
	private CalendarPicker fecha;
	
	
	public PanelPorResultados(EsquemaColores e, JFrame padre) {
		
		botonAyudaBusq = new JButton("");
		botonAyudaBusq.setToolTipText("Ayuda");
		botonAyudaBusq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Para utilizar el buscador de partidos por resultados rellene "
						+ "cualquiera de los campos en el mismo. La tabla de <Partidos por Resultados> se actualizará de forma dinámica");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
				
			}
		});
		
		JButton botonAyudaTabla = new JButton("");
		botonAyudaTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Para agregar los resultados de un partido, haga doble click en el partido deseado");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
				
			}
		});
		botonAyudaTabla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyudaTabla.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaTabla.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaTabla.setContentAreaFilled(false);
		botonAyudaTabla.setBorder(null);
		botonAyudaTabla.setToolTipText("Ayuda");
		botonAyudaTabla.setBounds(843, 223, 36, 36);
		add(botonAyudaTabla);
		
		
		fecha = new CalendarPicker(e.getColorCalendario(),344,LocalDate.now().minusMonths(1),LocalDate.now());
		fecha.setBounds(77, 127, 344, 22);
		add(fecha);
		
		tipoEvento = new JComboBox<String>();
		tipoEvento.setModel(new TipoEventoComboBoxModel());
		tipoEvento.setSelectedIndex(0);
		tipoEvento.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		tipoEvento.setBounds(144, 165, 277, 20);
		add(tipoEvento);
		
		deporte = new JComboBox<String>();
		deporte.setModel(new DeporteComboBoxModel());
		deporte.setSelectedIndex(0);
		deporte.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		deporte.setBounds(553, 129, 326, 20);
		add(deporte);
		
		facultad2 = new JComboBox<String>();
		facultad2.setModel(new NombreFacultadComboBoxModel());
		facultad2.setSelectedIndex(0);
		facultad2.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		facultad2.setBounds(577, 91, 302, 20);
		add(facultad2);
		
		facultad1 = new JComboBox<String>();
		facultad1.setModel(new NombreFacultadComboBoxModel());
		facultad1.setSelectedIndex(0);
		facultad1.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		facultad1.setBounds(119, 91, 302, 20);
		add(facultad1);
		botonAyudaBusq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyudaBusq.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyudaBusq.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyudaBusq.setContentAreaFilled(false);
		botonAyudaBusq.setBorder(null);
		botonAyudaBusq.setBounds(843, 42, 36, 36);
		add(botonAyudaBusq);
		
		JLabel adminLbl = new JLabel("Buscador de Partidos por Resultados");
		adminLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		adminLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		adminLbl.setBounds(10, 35, 869, 45);
		add(adminLbl);
		
		JLabel facultad1Lbl = new JLabel("Facultad 1: ");
		facultad1Lbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad1Lbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad1Lbl.setBounds(10, 91, 411, 26);
		add(facultad1Lbl);
		
		JLabel facultad2Lbl = new JLabel("Facultad 2: ");
		facultad2Lbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad2Lbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad2Lbl.setBounds(468, 91, 411, 26);
		add(facultad2Lbl);
		
		JLabel deporteLbl = new JLabel("Deporte: ");
		deporteLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		deporteLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		deporteLbl.setBounds(468, 128, 411, 26);
		add(deporteLbl);
		
		JLabel fechaLbl = new JLabel("Fecha: ");
		fechaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		fechaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		fechaLbl.setBounds(10, 128, 411, 26);
		add(fechaLbl);
		
		tipoEventoLbl = new JLabel("Tipo de Evento: ");
		tipoEventoLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tipoEventoLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tipoEventoLbl.setBounds(10, 165, 411, 26);
		add(tipoEventoLbl);
		
		lblPartidosPorResultados = new JLabel("Partidos Por Resultados");
		lblPartidosPorResultados.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		lblPartidosPorResultados.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		lblPartidosPorResultados.setBounds(10, 216, 869, 45);
		add(lblPartidosPorResultados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 270, 869, 294);
		add(scrollPane_1);
		
		modelo = new PartidosPorResultadosTableModel();
		modelo.prueba();
		ordenamiento = new TableRowSorter<PartidosPorResultadosTableModel>(modelo);
		ordenamiento.toggleSortOrder(0);
		
		tablaPartidosPorResultados = new JTable();
		tablaPartidosPorResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				if(x.getClickCount()==2) {
					if(tablaPartidosPorResultados.getSelectedRow()!=-1) {
						AgregarResultadosJDialog ventana = new AgregarResultadosJDialog(e, padre, null);
						ventana.setVisible(true);
					}
				}
			}
		});
		tablaPartidosPorResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaPartidosPorResultados.setModel(modelo);
		tablaPartidosPorResultados.setRowSorter(ordenamiento);
		tablaPartidosPorResultados.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPartidosPorResultados.setSelectionForeground(e.getSeleccionTextoTabla());
		tablaPartidosPorResultados.setSelectionBackground(e.getSeleccionFondoTabla());
		tablaPartidosPorResultados.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		scrollPane_1.setViewportView(tablaPartidosPorResultados);
	}
}
