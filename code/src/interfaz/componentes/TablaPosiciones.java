package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import cu.edu.cujae.ceis.tree.general.GeneralTree;
import interfaz.tablas.modelos.TablaPosicionesTableModel;
import nucleo.ClasificacionDeporte;
import nucleo.Facultad;
import nucleo.HistoricoFacultad;

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
	private TablaPosicionesTableModel modelo;
	
	public TablaPosiciones(GeneralTree<Facultad> tablaPos, Color seleccionTexto, Color selecccionFondo, boolean historico) {
		setBackground(Color.LIGHT_GRAY);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		setBounds(589, 140, 290, 424);
		
		modelo = new TablaPosicionesTableModel(historico);
		if(tablaPos!=null)
			modelo.actualizar(tablaPos);
		
		
		tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setFillsViewportHeight(true);
		tabla.getTableHeader().setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tabla.setSelectionForeground(seleccionTexto);
		tabla.setSelectionBackground(selecccionFondo);
		tabla.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tabla.setRowHeight(43);
		setViewportView(tabla);
	}
	
	public TablaPosiciones(GeneralTree<HistoricoFacultad> tablaPos, Color seleccionTexto, Color selecccionFondo, boolean historico, int n) {
		this(null, seleccionTexto, selecccionFondo,historico);
		modelo.actualizarHistorico(tablaPos);
	}
	
	public TablaPosiciones(GeneralTree<ClasificacionDeporte> tablaPos, Color seleccionTexto, Color selecccionFondo) {
		this(null, seleccionTexto, selecccionFondo,false);
		modelo.actualizarDeporte(tablaPos);
	}
	
	public JTable getTabla() {
		return tabla;
	}
	
}
