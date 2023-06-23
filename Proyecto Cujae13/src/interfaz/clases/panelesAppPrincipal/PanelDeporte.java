package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.clases.jdialogs.InfraccionesJDialog;
import interfaz.componentes.TablaPosiciones;
import interfaz.componentes.Torneo;
import nucleo.Deporte;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Deporte de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Brayan García
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelDeporte extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel nombreDeporteLbl;
	private TablaPosiciones tablaPosGeneral;
	private JButton botonAyuda;
	
	public PanelDeporte(JFrame padre,EsquemaColores e, Deporte d) {
		
		botonAyuda = new JButton("");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Haga click en el partido deseado para ver información ampliada del mismo");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
				
			}
		});
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(28,28), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(551, 89, 28, 28);
		add(botonAyuda);
		
		JButton infraccionesBtn = new JButton();
		infraccionesBtn.setToolTipText("Infracciones");
		infraccionesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				InfraccionesJDialog ventana = new InfraccionesJDialog(e, padre, d);
				ventana.setVisible(true);
			}
		});
		infraccionesBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		infraccionesBtn.setBorder(null);
		infraccionesBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/amonestacion01.png")));
		infraccionesBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/amonestacion02.png")));
		infraccionesBtn.setContentAreaFilled(false);
		infraccionesBtn.setBounds(785, 35, 42, 42);
		add(infraccionesBtn);
		
		JButton infoBtn = new JButton();
		infoBtn.setToolTipText("Información General");
		infoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Información general de " + d.getNombre(), "Tipo: "+d.getTipoDeporte()+"\n"
						+ "Sexo: "+d.getSexo()+"\n"
								+ "Estado: "+d.getEstado()+"\n"
										+ "Localización: "+Universidad.getInstancia().buscarLocalizacion(d));
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
			}
		});
		infoBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		infoBtn.setBorder(null);
		infoBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(38,38), AppPrincipal.class.getResource("/interfaz/iconos/info0.png")));
		infoBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(38,38), AppPrincipal.class.getResource("/interfaz/iconos/info1.png")));
		infoBtn.setContentAreaFilled(false);
		infoBtn.setBounds(837, 35, 42, 42);
		add(infoBtn);
		
		nombreDeporteLbl = new JLabel(d.getNombre());
		nombreDeporteLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreDeporteLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		nombreDeporteLbl.setBounds(10, 35, 869, 45);
		add(nombreDeporteLbl);
		
		JLabel tablaPosLbl = new JLabel("Tabla de Posiciones");
		tablaPosLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		tablaPosLbl.setBounds(589, 91, 290, 26);
		add(tablaPosLbl);
		
		tablaPosGeneral = new TablaPosiciones(d.getTablaPosiciones(), e.getSeleccionTextoTabla(), e.getSeleccionFondoTabla());
		tablaPosGeneral.setBounds(589, 128, 290, 436);
		add(tablaPosGeneral);
		
		JLabel torneoLbl = new JLabel("Partidos");
		torneoLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		torneoLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		torneoLbl.setBounds(10, 91, 569, 26);
		add(torneoLbl);
		
		Torneo torneo = new Torneo(d.getTorneo(), padre, e);
		torneo.setBounds(10, 128, 569, 436);
		add(torneo);
		
	}
}
