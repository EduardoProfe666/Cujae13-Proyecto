package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

/**
 * Componente gráfico que modela las tablas de posición de la aplicación
 * 
 * @version 2023.06.02
 * @author Eduardo González
 *
 */
public class TablaPosiciones extends JScrollPane{
	private static final long serialVersionUID = 1L;
	private JTable tabla;
	
	public TablaPosiciones() {
		setBackground(Color.LIGHT_GRAY);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		setBounds(589, 140, 290, 424);
		tabla = new JTable();
		tabla.setFillsViewportHeight(true);
		tabla.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tabla.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
	}
	
}
