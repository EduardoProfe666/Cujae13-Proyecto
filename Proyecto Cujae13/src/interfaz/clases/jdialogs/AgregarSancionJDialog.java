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
import interfaz.combobox.modelos.NombreFacultadComboBoxModel;
import interfaz.combobox.modelos.TipoSancionComboBoxModel;
import nucleo.Facultad;
import nucleo.NombreFacultad;
import nucleo.TipoSancion;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import raven.toast.Notifications;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

public class AgregarSancionJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private JButton botonAyuda;
	private JComboBox<String> sancion;
	private String inf;
	private JLabel pLbl;
	private JLabel dLbl;
	private JScrollPane scrollPane;
	private JTextArea descripcion;
	private JLabel pLbl_1;
	private JComboBox<String> facultad;
	private BotonAnimacion aceptar;
	private BotonAnimacion cancelar;

	public AgregarSancionJDialog(EsquemaColores e, JFrame padre) {
		super("Agregar Sanción", e, padre);
		
		inf = "Seleccione una sanción";
		
		sancion = new JComboBox<>();
		sancion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		sancion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				sancion.putClientProperty("JComponent.outline", null);
				TipoSancion t = TipoSancion.fromString((String)sancion.getSelectedItem());
				inf = t==null ? "Seleccione una sanción" : t.getDescripcion();
				pLbl.setText("Puntaje a quitar: "+ ((t==null) ? "-" : t.getPuntaje()));
			}
		});
		sancion.setModel(new TipoSancionComboBoxModel());
		sancion.setSelectedIndex(0);
		sancion.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		sancion.setBounds(160, 12, 493, 20);
		panelContenedor.add(sancion);
		
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
		
		JLabel historiaLbl = new JLabel("Tipo de Sanción: ");
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
		
		aceptar = new BotonAnimacion();
		aceptar.setEffectColor(e.getBtnAceptarColorEfecto());
		aceptar.setBackground(e.getBtnAceptar());
		aceptar.setForeground(e.getBtnAceptarTxt());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(validarSancion()) {
					String fac = (String)facultad.getSelectedItem();
					String s = (String)sancion.getSelectedItem();
					Facultad f = Universidad.getInstancia().buscarFacultad(NombreFacultad.fromString(fac));
					f.agregarSancion(TipoSancion.fromString(s), descripcion.getText());
					dispose();
					AppPrincipalAdmin.actualizar();
					Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, 2500, "Se ha agregado la sanción correctamente");
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
		cancelar.setBackground(e.getBtnCancelar());
		cancelar.setForeground(e.getBtnAceptarTxt());
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
	
	public boolean validarSancion() {
		boolean validada = true;
		
		if(sancion.getSelectedIndex() <= 0) {
			validada = false;
		}
		
		if(facultad.getSelectedIndex() <= 0) {
			validada = false;
		}
		
		return validada;
	}
	
	public void mostrarErrorComponente() {
		
		if(sancion.getSelectedIndex() <= 0) {
			sancion.putClientProperty("JComponent.outline", "error");
		}
		
		if(facultad.getSelectedIndex() <= 0) {
			facultad.putClientProperty("JComponent.outline", "error");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
