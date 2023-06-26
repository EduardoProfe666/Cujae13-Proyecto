package interfaz.clases.jdialogs;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.BotonAnimacion;
import interfaz.clases.AppPrincipal;
import interfaz.clases.AppPrincipalAdmin;
import interfaz.combobox.modelos.DeporteComboBoxModel;
import interfaz.combobox.modelos.NombreFacultadComboBoxModel;
import interfaz.combobox.modelos.TipoInfraccionComboBoxModel;
import nucleo.Deporte;
import nucleo.NombreFacultad;
import nucleo.TipoDeporte;
import nucleo.TipoInfraccion;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import raven.toast.Notifications;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

public class AgregarInfraccionJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private JButton botonAyuda;
	private JComboBox<String> infraccion;
	private String inf;
	private JLabel pLbl;
	private JLabel dLbl;
	private JScrollPane scrollPane;
	private JTextArea descripcion;
	private TipoDeporte tipoDeporte;
	private JLabel pLbl_1;
	private JLabel pLbl_2;
	private JComboBox<String> facultad;
	private JComboBox<String> deporte;
	private BotonAnimacion aceptar;
	private BotonAnimacion cancelar;

	public AgregarInfraccionJDialog(EsquemaColores e, JFrame padre) {
		super("Agregar Infracción", e, padre);
		
		inf = "Seleccione una infracción";
		
		deporte = new JComboBox<String>();
		deporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deporte.setEnabled(false);
		deporte.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				deporte.putClientProperty("JComponent.outline", null);
			}
		});
		deporte.setModel(new DeporteComboBoxModel());
		deporte.setSelectedIndex(0);
		deporte.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		deporte.setBounds(96, 131, 313, 20);
		panelContenedor.add(deporte);
		
		infraccion = new JComboBox<>();
		infraccion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		infraccion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				infraccion.putClientProperty("JComponent.outline", null);
				TipoInfraccion t = TipoInfraccion.fromString((String)infraccion.getSelectedItem());
				inf = t==null ? "Seleccione una infracción" : t.getDescripcion();
				pLbl.setText("Puntaje a quitar: "+ ((t==null) ? "-" : t.getPuntaje()));
				tipoDeporte = t==null ? null : t.getTipo() ;
				if(tipoDeporte == null) {
					deporte.setEnabled(false);
				}else {
					deporte.setEnabled(true);
					((DeporteComboBoxModel)deporte.getModel()).reiniciar();
					((DeporteComboBoxModel)deporte.getModel()).eliminarDeportes(Universidad.getInstancia().obtenerDeporteEliminar(tipoDeporte));
				}
			}
		});
		infraccion.setModel(new TipoInfraccionComboBoxModel());
		infraccion.setSelectedIndex(0);
		infraccion.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		infraccion.setBounds(172, 12, 481, 20);
		panelContenedor.add(infraccion);
		
		JDialogGeneral j = this;
		
		botonAyuda = new JButton("");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Descripción", inf);
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
		botonAyuda.setToolTipText("Descripción");
		botonAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(662, 8, 28, 28);
		panelContenedor.add(botonAyuda);
		
		JLabel historiaLbl = new JLabel("Tipo de Infracción: ");
		historiaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		historiaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		historiaLbl.setBounds(10, 10, 680, 26);
		panelContenedor.add(historiaLbl);
		
		
		
		facultad = new JComboBox<String>();
		facultad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		facultad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				facultad.putClientProperty("JComponent.outline", null);
			}
		});
		facultad.setModel(new NombreFacultadComboBoxModel());
		facultad.setSelectedIndex(0);
		facultad.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		facultad.setBounds(96, 94, 313, 20);
		panelContenedor.add(facultad);
		
		pLbl = new JLabel("Puntaje a quitar: -");
		pLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		pLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		pLbl.setBounds(10, 47, 399, 26);
		panelContenedor.add(pLbl);
		
		dLbl = new JLabel("Descripci\u00F3n");
		dLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		dLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		dLbl.setBounds(419, 47, 271, 26);
		panelContenedor.add(dLbl);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 84, 271, 300);
		panelContenedor.add(scrollPane);
		
		descripcion = new JTextArea();
		descripcion.setWrapStyleWord(true);
		descripcion.setLineWrap(true);
		descripcion.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		descripcion.setEditable(true);
		scrollPane.setViewportView(descripcion);
		
		pLbl_1 = new JLabel("Facultad: ");
		pLbl_1.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		pLbl_1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		pLbl_1.setBounds(10, 91, 399, 26);
		panelContenedor.add(pLbl_1);
		
		pLbl_2 = new JLabel("Deporte: ");
		pLbl_2.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		pLbl_2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		pLbl_2.setBounds(10, 128, 399, 26);
		panelContenedor.add(pLbl_2);
		
		aceptar = new BotonAnimacion();
		aceptar.setEffectColor(e.getBtnAceptarColorEfecto());
		aceptar.setBackground(e.getBtnAceptar());
		aceptar.setForeground(e.getBtnAceptarTxt());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(validarInfraccion()) {
					String nombreDeporte = (String)deporte.getSelectedItem();
					Deporte dep = Universidad.getInstancia().buscarDeporte(nombreDeporte);
					String fac = (String)facultad.getSelectedItem();
					String infrac = (String)infraccion.getSelectedItem();
					dep.addInfraccion(TipoInfraccion.fromString(infrac), descripcion.getText(), NombreFacultad.fromString(fac));
					dispose();
					AppPrincipalAdmin.actualizar();
					Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, 2500, "Se ha agregado la infracción correctamente");
				}else {
					Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
					MessageSinCancel m = new MessageSinCancel("Error", "Compruebe los datos de los campos señalados");
					m.eventOK(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							GlassPanePopup.closePopupLast();
							j.setVisible(true);
						}
					});
					GlassPanePopup.showPopup(m, o);
					j.setVisible(false);
					mostrarErrorComponente();
				}
			}
		});
		aceptar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		aceptar.setText("Aceptar");
		aceptar.setBounds(560, 407, 130, 26);
		aceptar.setBorder(null);
		panelContenedor.add(aceptar);
		
		cancelar = new BotonAnimacion();
		cancelar.setEffectColor(e.getBtnCancelarColorEfecto());
		cancelar.setForeground(e.getBtnCancelarTxt());
		cancelar.setBackground(e.getBtnCancelar());
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		cancelar.setText("Cancelar");
		cancelar.setBounds(420, 407, 130, 26);
		cancelar.setBorder(null);
		panelContenedor.add(cancelar);
		
		
	}
	
	public boolean validarInfraccion() {
		boolean validada = true;
		
		if(infraccion.getSelectedIndex() <= 0) {
			validada = false;
		}
		
		if(facultad.getSelectedIndex() <= 0) {
			validada = false;
		}
		
		if(deporte.getSelectedIndex() <= 0) {
			validada = false;
		}
		
		return validada;
	}
	
public void mostrarErrorComponente() {
		
		if(infraccion.getSelectedIndex() <= 0) {
			infraccion.putClientProperty("JComponent.outline", "error");
		}
		
		if(facultad.getSelectedIndex() <= 0) {
			facultad.putClientProperty("JComponent.outline", "error");
		}
		
		if(deporte.getSelectedIndex() <= 0 && deporte.isEnabled()) {
			deporte.putClientProperty("JComponent.outline", "error");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
