package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import cu.edu.cujae.ceis.tree.general.GeneralTree;
import interfaz.tablas.modelos.TablaPosicionesTableModel;
import nucleo.Facultad;

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
	
	public TablaPosiciones(GeneralTree<Facultad> tablaPos, Color seleccionTexto, Color selecccionFondo) {
		setBackground(Color.LIGHT_GRAY);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		setBounds(589, 140, 290, 424);
		
		TablaPosicionesTableModel modelo = new TablaPosicionesTableModel();
		//modelo.actualizar(tablaPos);
		
		//PROVISIONAL
		modelo.actualizar();
		
		tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setFillsViewportHeight(true);
		tabla.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tabla.setSelectionForeground(seleccionTexto);
		tabla.setSelectionBackground(selecccionFondo);
		tabla.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		setViewportView(tabla);
	}
	
	public JTable getTabla() {
		return tabla;
	}
	
}
