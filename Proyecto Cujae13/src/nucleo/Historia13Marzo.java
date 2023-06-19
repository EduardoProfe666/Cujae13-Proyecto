package nucleo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class Historia13Marzo implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<HistoricoFacultad> tablaPosicionesHistorica; //Arbol General
	private String surgimiento;
	
	public Historia13Marzo(List<HistoricoFacultad> tablaPosicionesHistorica, String surgimiento) {
		super();
		this.tablaPosicionesHistorica = tablaPosicionesHistorica;
		this.surgimiento = surgimiento;
	}
	
	public GeneralTree<HistoricoFacultad> getTablaPosicionesHistorica() {
		GeneralTree<HistoricoFacultad> tablaPosiciones = new GeneralTree<>();
		Collections.sort(tablaPosicionesHistorica, Collections.reverseOrder());
		
		tablaPosiciones.setRoot(new BinaryTreeNode<HistoricoFacultad>(tablaPosicionesHistorica.get(0)));

		for(int i=1; i<tablaPosicionesHistorica.size(); i++) {
			if(tablaPosicionesHistorica.get(i).getCantidadJuegos13Ganados() < tablaPosicionesHistorica.get(i-1).getCantidadJuegos13Ganados()) {
				BinaryTreeNode<HistoricoFacultad> padre = obtenerUltimoNodo(tablaPosiciones);
				BinaryTreeNode<HistoricoFacultad> n = new BinaryTreeNode<HistoricoFacultad>(tablaPosicionesHistorica.get(i));
				tablaPosiciones.insertNode(n, padre);
			}else if(tablaPosicionesHistorica.get(i).getCantidadJuegos13Ganados() == tablaPosicionesHistorica.get(i-1).getCantidadJuegos13Ganados()) {
				BinaryTreeNode<HistoricoFacultad> ultimoNodo = obtenerUltimoNodo(tablaPosiciones);
				BinaryTreeNode<HistoricoFacultad> padre = tablaPosiciones.getFather(ultimoNodo);
				BinaryTreeNode<HistoricoFacultad> n = new BinaryTreeNode<HistoricoFacultad>(tablaPosicionesHistorica.get(i));
				tablaPosiciones.insertNode(n, padre);
			}
		}
		
		return tablaPosiciones;
	}
	
	public BinaryTreeNode<HistoricoFacultad> obtenerUltimoNodo(GeneralTree<HistoricoFacultad> arbol){
		BinaryTreeNode<HistoricoFacultad> ultimoNodo = new BinaryTreeNode<HistoricoFacultad>();
		InDepthIterator<HistoricoFacultad> iter = arbol.inDepthIterator();

		while(iter.hasNext()) {
			BinaryTreeNode<HistoricoFacultad> n = iter.nextNode();
			if(n.getLeft() == null) {
				ultimoNodo = n;
			}
		}
		return ultimoNodo;

	}
	
	public String getSurgimiento() {
		return surgimiento;
	}
	public void setSurgimiento(String surgimiento) {
		this.surgimiento = surgimiento;
	}
	
	
}
