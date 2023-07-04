package nucleo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import utilidades.Validaciones;

/**
 * Clase que permite modelar la informacion de la historia de los 13 de marzo, 
 * incluyendo la tabla de posiciones historica y el surgimiento
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public class Historia13Marzo implements Serializable{
	private static final long serialVersionUID = 1L;
	private GeneralTree<HistoricoFacultad> tablaPosiciones; //ArbolGeneral
	private List<HistoricoFacultad> tablaPosicionesHistorica; //Arreglo de datos del Arbol General
	private String surgimiento;

	public Historia13Marzo(List<HistoricoFacultad> tablaPosicionesHistorica, String surgimiento) {
		super();
		this.tablaPosicionesHistorica = tablaPosicionesHistorica;
		crearTablaPosiciones();
	    setSurgimiento(surgimiento);
		
	}
	
	private void crearTablaPosiciones() {
		tablaPosiciones = new GeneralTree<HistoricoFacultad>();
		Collections.sort(tablaPosicionesHistorica, Collections.reverseOrder());
		
		Iterator<HistoricoFacultad> iter = tablaPosicionesHistorica.iterator();
		tablaPosiciones.setRoot(new BinaryTreeNode<HistoricoFacultad>(iter.next()));
		BinaryTreeNode<HistoricoFacultad> ultimo = ((BinaryTreeNode<HistoricoFacultad>)tablaPosiciones.getRoot());
		BinaryTreeNode<HistoricoFacultad> padre = null;
		int pUltimo = ultimo.getInfo().getPuntajeHistorico();
		
		
		while(iter.hasNext()) {
			HistoricoFacultad d1 = iter.next();
			BinaryTreeNode<HistoricoFacultad> n = new BinaryTreeNode<HistoricoFacultad>(d1);
			if(pUltimo > d1.getPuntajeHistorico()) {
				tablaPosiciones.insertNode(n, ultimo);
				pUltimo = d1.getPuntajeHistorico();
				padre = ultimo;
				ultimo = n;
			}
			else {
				tablaPosiciones.insertNode(n, padre);
			}
		}
		
	}
	
	public GeneralTree<HistoricoFacultad> getTablaPosicionesHistorica(){
		if(tablaPosiciones == null || tablaPosiciones.isEmpty())
			crearTablaPosiciones();
		return tablaPosiciones;
	}

	public String getSurgimiento() {
		return surgimiento;
	}
	
	private void setSurgimiento(String surgimiento) {
		if(Validaciones.validarStringNoVacio(surgimiento)){
			this.surgimiento = surgimiento;
		} else {
			throw new IllegalArgumentException("El surgimiento no debe estar vacío");
		}
	}
	

}
