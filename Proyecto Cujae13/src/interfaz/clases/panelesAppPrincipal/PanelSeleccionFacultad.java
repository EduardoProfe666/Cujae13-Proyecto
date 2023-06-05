package interfaz.clases.panelesAppPrincipal;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.NombreFacultad;
import interfaz.componentes.BtnSeleccionFacultad;

/**
 * JPanel que modela la pantalla de Facultad de la aplicación.
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
		
	public PanelSeleccionFacultad(EsquemaColores e, NombreFacultad f, JTabbedPane tab) {
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
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.INFORMATICA));
				tab.setSelectedIndex(6);
			}
		});
		panelInf.setBounds(52, 113, 160, 180);
		add(panelInf);
		
		panelArq = new BtnSeleccionFacultad(e, NombreFacultad.ARQUITECTURA);
		panelArq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.ARQUITECTURA));
				tab.setSelectedIndex(6);
			}
		});
		panelArq.setBounds(264, 113, 160, 180);
		add(panelArq);
		
		panelAubi = new BtnSeleccionFacultad(e, NombreFacultad.AUTOMATICA_BIOMEDICA,"Auto/Bio");
		panelAubi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.AUTOMATICA_BIOMEDICA));
				tab.setSelectedIndex(6);
			}
		});
		panelAubi.setBounds(476, 113, 160, 180);
		add(panelAubi);
		
		panelCivil = new BtnSeleccionFacultad(e, NombreFacultad.CIVIL);
		panelCivil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.CIVIL));
				tab.setSelectedIndex(6);
			}
		});
		panelCivil.setBounds(688, 113, 160, 180);
		add(panelCivil);
		
		panelElec = new BtnSeleccionFacultad(e, NombreFacultad.ELECTRICA);
		panelElec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.ELECTRICA));
				tab.setSelectedIndex(6);
			}
		});
		panelElec.setBounds(16, 338, 160, 180);
		add(panelElec);
		
		panelInd = new BtnSeleccionFacultad(e, NombreFacultad.INDUSTRIAL);
		panelInd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.INDUSTRIAL));
				tab.setSelectedIndex(6);
			}
		});
		panelInd.setBounds(192, 338, 160, 180);
		add(panelInd);
		
		panelMec = new BtnSeleccionFacultad(e, NombreFacultad.MECANICA);
		panelMec.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.MECANICA));
				tab.setSelectedIndex(6);
			}
		});
		panelMec.setBounds(368, 338, 160, 180);
		add(panelMec);
		
		panelQuim = new BtnSeleccionFacultad(e, NombreFacultad.QUIMICA);
		panelQuim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.QUIMICA));
				tab.setSelectedIndex(6);
			}
		});
		panelQuim.setBounds(544, 338, 160, 180);
		add(panelQuim);
		
		panelTele = new BtnSeleccionFacultad(e, NombreFacultad.TELECOMUNICACIONES,"Tele");
		panelTele.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				tab.setComponentAt(6, new PanelFacultad(e, NombreFacultad.TELECOMUNICACIONES));
				tab.setSelectedIndex(6);
			}
		});
		panelTele.setBounds(720, 338, 160, 180);
		add(panelTele);
		
		
	}
}
