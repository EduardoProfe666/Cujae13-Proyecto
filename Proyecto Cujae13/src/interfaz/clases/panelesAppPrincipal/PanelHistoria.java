package interfaz.clases.panelesAppPrincipal;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import interfaz.componentes.TablaPosiciones;

/**
 * JPanel que modela la pantalla de Historia de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Cristian Páez
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelHistoria extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel historiaGeneralLbl;
	private JLabel tablaPosLbl;
	private JTextArea historia;
	
	public PanelHistoria(EsquemaColores e) {
		
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
		
		TablaPosiciones tablaPosGeneral = new TablaPosiciones(null, e.getSeleccionTextoTabla(), e.getSeleccionFondoTabla(),true);
		tablaPosGeneral.setBounds(10, 140, 385, 424);
		add(tablaPosGeneral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(410, 140, 480, 424);
		add(scrollPane);
		
		historia = new JTextArea();
		historia.setWrapStyleWord(true);
		historia.setLineWrap(true);
		historia.setText("Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " + 
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum " +
				"Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum Lorem ipsum ");
		historia.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		historia.setEditable(false);
		scrollPane.setViewportView(historia);
	}
}
