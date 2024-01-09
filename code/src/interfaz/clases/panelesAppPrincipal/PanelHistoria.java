package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.AppPrincipal;
import interfaz.componentes.TablaPosiciones;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Historia de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Cristian Páez
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Cristian Páez
 * @author Eduardo González
 *
 */
public class PanelHistoria extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel historiaGeneralLbl;
	private JLabel tablaPosLbl;
	private JTextArea historia;
	private JButton botonAyuda;
	
	public PanelHistoria(EsquemaColores e) {
		
		botonAyuda = new JButton("");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "La tabla de posiciones histórica presenta un sistema de puntuaciones que favorece a las facultades que obtuvieron primeros lugares por cada año de los Juegos 13 de Marzo, desde 1994 hasta 2022, de la siguiente manera:\n"
						+ "-1er Lugar -> 50 puntos\n"
						+ "-2do Lugar -> 20 puntos\n"
						+ "-3er Lugar -> 10 puntos\n");
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
		botonAyuda.setBounds(367, 103, 28, 28);
		add(botonAyuda);
		
		historiaGeneralLbl = new JLabel("Historia General de los Juegos 13 de Marzo");
		historiaGeneralLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		historiaGeneralLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		historiaGeneralLbl.setBounds(10, 35, 869, 45);
		add(historiaGeneralLbl);
		
		tablaPosLbl = new JLabel("Tabla de Posiciones Hist\u00F3rica");
		tablaPosLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tablaPosLbl.setBounds(10, 105, 385, 26);
		add(tablaPosLbl);
		
		JLabel historiaLbl = new JLabel("Historia de los Juegos 13 de Marzo");
		historiaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		historiaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		historiaLbl.setBounds(410, 105, 469, 26);
		add(historiaLbl);
		
		TablaPosiciones tablaPosGeneral = new TablaPosiciones(Universidad.getInstancia().getHistoria().getTablaPosicionesHistorica(), e.getSeleccionTextoTabla(), e.getSeleccionFondoTabla(),true,0);
		tablaPosGeneral.setBounds(10, 140, 385, 424);
		add(tablaPosGeneral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 140, 480, 424);
		add(scrollPane);
		
		historia = new JTextArea();
		historia.setWrapStyleWord(true);
		historia.setLineWrap(true);
		historia.setText(Universidad.getInstancia().getHistoria().getSurgimiento());
		historia.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		historia.setEditable(false);
		scrollPane.setViewportView(historia);
	}
}
