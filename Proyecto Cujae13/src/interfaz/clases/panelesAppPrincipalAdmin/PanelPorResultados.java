package interfaz.clases.panelesAppPrincipalAdmin;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
import nucleo.Evento;
import nucleo.EventoDia;
import nucleo.InicializacionPartidosDeporte.EventoFecha;
import nucleo.NombreFacultad;
import nucleo.TipoEvento;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Archivador;
import utilidades.Auxiliares;
import utilidades.BuscadorPorResultados;

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
	private LinkedList<EventoDia> partidosPorResultados;
	private JButton btnReset;
	private JCheckBox fechaAct;
	
	
	public PanelPorResultados(EsquemaColores e, JFrame padre) {
		partidosPorResultados = Universidad.getInstancia().obtenerEventosPorResultado();
		
		botonAyudaBusq = new JButton("");
		botonAyudaBusq.setToolTipText("Ayuda");
		botonAyudaBusq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Para utilizar el buscador de partidos por resultados rellene "
						+ "cualquiera de los campos en el mismo. La tabla de <Partidos por Resultados> se actualizará de forma dinámica. Para "
						+ "reiniciar el buscar haga click en el botón de <Reiniciar Buscador>.");
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
		
		fechaAct = new JCheckBox("");
		fechaAct.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				fecha.setEnabled(fechaAct.isSelected());
				filtrar();
			}
		});
		fechaAct.setBounds(399, 127, 22, 23);
		add(fechaAct);
		
		btnReset = new JButton("");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarBuscador();
			}
		});
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReset.setIcon(Auxiliares.ajustarImagen(new Dimension(34,34), AppPrincipal.class.getResource("/interfaz/iconos/reset0.png")));
		btnReset.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(34,34), AppPrincipal.class.getResource("/interfaz/iconos/reset1.png")));
		btnReset.setToolTipText("Reiniciar Buscador");
		btnReset.setContentAreaFilled(false);
		btnReset.setBorder(null);
		btnReset.setBounds(799, 42, 36, 36);
		add(btnReset);
		
		fecha = new CalendarPicker(e.getColorCalendario(),316,Universidad.getInstancia().getFechaInicio(),LocalDate.now());
		fecha.setEnabled(false);
		fecha.addPropertyChangeListener("exito", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				filtrar();
			}
		});
		fecha.setBounds(77, 127, 316, 22);
		add(fecha);
		
		tipoEvento = new JComboBox<String>();
		tipoEvento.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtrar();
			}
		});
		tipoEvento.setModel(new TipoEventoComboBoxModel());
		tipoEvento.setSelectedIndex(0);
		tipoEvento.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		tipoEvento.setBounds(144, 165, 277, 20);
		add(tipoEvento);
		
		deporte = new JComboBox<String>();
		deporte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtrar();
			}
		});
		deporte.setModel(new DeporteComboBoxModel());
		deporte.setSelectedIndex(0);
		deporte.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		deporte.setBounds(553, 129, 326, 20);
		add(deporte);
		
		facultad2 = new JComboBox<String>();
		facultad2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtrar();
			}
		});
		facultad2.setModel(new NombreFacultadComboBoxModel());
		facultad2.setSelectedIndex(0);
		facultad2.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		facultad2.setBounds(577, 91, 302, 20);
		add(facultad2);
		
		facultad1 = new JComboBox<String>();
		facultad1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filtrar();
			}
		});
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
		lblPartidosPorResultados.setBounds(10, 225, 869, 45);
		add(lblPartidosPorResultados);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 270, 869, 294);
		add(scrollPane_1);
		
		modelo = new PartidosPorResultadosTableModel();
		modelo.actualizar(partidosPorResultados);
		ordenamiento = new TableRowSorter<PartidosPorResultadosTableModel>(modelo);
		ordenamiento.toggleSortOrder(0);
		ordenamiento.setComparator(0, Archivador.getComparatorStringLocalDate());
		ordenamiento.setComparator(1, Archivador.getComparatorStringLocalTime());
		
		tablaPartidosPorResultados = new JTable();
		tablaPartidosPorResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				if(x.getClickCount()==2) {
					if(tablaPartidosPorResultados.getSelectedRow()!=-1) {
						int fila = ordenamiento.convertRowIndexToModel(tablaPartidosPorResultados.getSelectedRow());
						AgregarResultadosJDialog ventana = new AgregarResultadosJDialog(e, padre, new EventoFecha(getEvento(fila),LocalDate.parse((String)modelo.getValueAt(fila, 0), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
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
	
	private void reiniciarBuscador() {
		facultad1.setSelectedIndex(0);
		facultad2.setSelectedIndex(0);
		fechaAct.setSelected(false);
		deporte.setSelectedIndex(0);
		tipoEvento.setSelectedIndex(0);
		
		partidosPorResultados = Universidad.getInstancia().obtenerEventosPorResultado();
		actualizarTabla();
	}
	
	private void filtrar() {
		String fac1 = facultad1.getSelectedIndex()<1 ? null : (String)facultad1.getSelectedItem();
		NombreFacultad f1 = fac1==null ? null : NombreFacultad.fromString(fac1);
		
		String fac2 = facultad2.getSelectedIndex()<1 ? null : (String)facultad2.getSelectedItem();
		NombreFacultad f2 = fac2==null ? null : NombreFacultad.fromString(fac2);
		
		LocalDate f = fecha.isEnabled() ? fecha.getFechaSeleccionada() : null;
		String d = deporte.getSelectedIndex()<1 ? null : (String)deporte.getSelectedItem();
		
		String tip = tipoEvento.getSelectedIndex()<1 ? null : (String)tipoEvento.getSelectedItem();
		TipoEvento t = tip==null ? null : TipoEvento.fromString(tip);
		
		partidosPorResultados = BuscadorPorResultados.buscadorPorResultados(Universidad.getInstancia().obtenerEventosPorResultado(), f1, f2, f, d, t);
		
		actualizarTabla();
	}
	
	private void actualizarTabla() {
		modelo.actualizar(partidosPorResultados);
	}
	
	private Evento getEvento(int indice) {
		LinkedList<Evento> lista = new LinkedList<>();
		
		for(EventoDia e : partidosPorResultados) {
			lista.addAll(e.getEventosDia());
		}
		
		return lista.get(indice);
	}
}
