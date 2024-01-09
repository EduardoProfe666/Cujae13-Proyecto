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
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.componentes.BtnSeleccionFacultad;
import nucleo.NombreFacultad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Selección de Facultad de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Lilian Rojas
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelSeleccionFacultad extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel elegirFacultadLbl;
	private BtnSeleccionFacultad panelInf;
	private BtnSeleccionFacultad panelArq;
	private BtnSeleccionFacultad panelAubi;
	private BtnSeleccionFacultad panelCivil;
	private BtnSeleccionFacultad panelElec;
	private BtnSeleccionFacultad panelInd;
	private BtnSeleccionFacultad panelMec;
	private BtnSeleccionFacultad panelQuim;
	private BtnSeleccionFacultad panelTele;
	private JButton botonAyuda;
		
	public PanelSeleccionFacultad(JFrame padre,EsquemaColores e, JTabbedPane tab) {
		
		botonAyuda = new JButton("");
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Para acceder a la información de la facultad "
						+ "haga click en la facultad deseada");
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
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(843, 42, 36, 36);
		add(botonAyuda);
		
		elegirFacultadLbl = new JLabel("Elegir Facultad");
		elegirFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		elegirFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		elegirFacultadLbl.setBounds(10, 35, 869, 45);
		add(elegirFacultadLbl);
		
		panelInf = new BtnSeleccionFacultad(e,NombreFacultad.INFORMATICA);
		panelInf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.INFORMATICA));
				tab.setSelectedIndex(6);
			}
		});
		panelInf.setBounds(52, 113, 160, 180);
		add(panelInf);
		
		panelArq = new BtnSeleccionFacultad(e, NombreFacultad.ARQUITECTURA);
		panelArq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.ARQUITECTURA));
				tab.setSelectedIndex(6);
			}
		});
		panelArq.setBounds(264, 113, 160, 180);
		add(panelArq);
		
		panelAubi = new BtnSeleccionFacultad(e, NombreFacultad.AUTOMATICA_BIOMEDICA,"Auto/Bio");
		panelAubi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.AUTOMATICA_BIOMEDICA));
				tab.setSelectedIndex(6);
			}
		});
		panelAubi.setBounds(476, 113, 160, 180);
		add(panelAubi);
		
		panelCivil = new BtnSeleccionFacultad(e, NombreFacultad.CIVIL);
		panelCivil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.CIVIL));
				tab.setSelectedIndex(6);
			}
		});
		panelCivil.setBounds(688, 113, 160, 180);
		add(panelCivil);
		
		panelElec = new BtnSeleccionFacultad(e, NombreFacultad.ELECTRICA);
		panelElec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.ELECTRICA));
				tab.setSelectedIndex(6);
			}
		});
		panelElec.setBounds(16, 338, 160, 180);
		add(panelElec);
		
		panelInd = new BtnSeleccionFacultad(e, NombreFacultad.INDUSTRIAL);
		panelInd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.INDUSTRIAL));
				tab.setSelectedIndex(6);
			}
		});
		panelInd.setBounds(192, 338, 160, 180);
		add(panelInd);
		
		panelMec = new BtnSeleccionFacultad(e, NombreFacultad.MECANICA);
		panelMec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.MECANICA));
				tab.setSelectedIndex(6);
			}
		});
		panelMec.setBounds(368, 338, 160, 180);
		add(panelMec);
		
		panelQuim = new BtnSeleccionFacultad(e, NombreFacultad.QUIMICA);
		panelQuim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.QUIMICA));
				tab.setSelectedIndex(6);
			}
		});
		panelQuim.setBounds(544, 338, 160, 180);
		add(panelQuim);
		
		panelTele = new BtnSeleccionFacultad(e, NombreFacultad.TELECOMUNICACIONES,"Tele");
		panelTele.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(padre, e, NombreFacultad.TELECOMUNICACIONES));
				tab.setSelectedIndex(6);
			}
		});
		panelTele.setBounds(720, 338, 160, 180);
		add(panelTele);
		
		
	}
}
