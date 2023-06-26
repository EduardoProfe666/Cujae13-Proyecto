package nucleo;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Historia13Marzo implements Serializable{
	private static final long serialVersionUID = 1L;
	private GeneralTree<HistoricoFacultad> tablaPosiciones; //ArbolGeneral
	private List<HistoricoFacultad> tablaPosicionesHistorica; //Arreglo de datos del Arbol General
	private String surgimiento;

	public Historia13Marzo(List<HistoricoFacultad> tablaPosicionesHistorica, String surgimiento) {
		super();
		this.tablaPosicionesHistorica = tablaPosicionesHistorica;
		crearTablaPosiciones();
		this.surgimiento = surgimiento;
		
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

//	private void crearTablaPosiciones() {
//		tablaPosiciones = new GeneralTree<>();
//		Collections.sort(tablaPosicionesHistorica, Collections.reverseOrder());
//
//		tablaPosiciones.setRoot(new BinaryTreeNode<HistoricoFacultad>(tablaPosicionesHistorica.get(0)));
//
//		for(int i=1; i<tablaPosicionesHistorica.size(); i++) {
//			if(tablaPosicionesHistorica.get(i).getCantidadJuegos13Ganados() < tablaPosicionesHistorica.get(i-1).getCantidadJuegos13Ganados()) {
//				BinaryTreeNode<HistoricoFacultad> padre = obtenerUltimoNodo(tablaPosiciones);
//				BinaryTreeNode<HistoricoFacultad> n = new BinaryTreeNode<HistoricoFacultad>(tablaPosicionesHistorica.get(i));
//				tablaPosiciones.insertNode(n, padre);
//			}else if(tablaPosicionesHistorica.get(i).getCantidadJuegos13Ganados() == tablaPosicionesHistorica.get(i-1).getCantidadJuegos13Ganados()) {
//				BinaryTreeNode<HistoricoFacultad> ultimoNodo = obtenerUltimoNodo(tablaPosiciones);
//				BinaryTreeNode<HistoricoFacultad> padre = tablaPosiciones.getFather(ultimoNodo);
//				BinaryTreeNode<HistoricoFacultad> n = new BinaryTreeNode<HistoricoFacultad>(tablaPosicionesHistorica.get(i));
//				tablaPosiciones.insertNode(n, padre);
//			}
//		}
//	}
	
	public GeneralTree<HistoricoFacultad> getTablaPosicionesHistorica(){
		if(tablaPosiciones == null || tablaPosiciones.isEmpty())
			crearTablaPosiciones();
		return tablaPosiciones;
	}

//	private BinaryTreeNode<HistoricoFacultad> obtenerUltimoNodo(GeneralTree<HistoricoFacultad> arbol){
//		BinaryTreeNode<HistoricoFacultad> ultimoNodo = new BinaryTreeNode<HistoricoFacultad>();
//		InDepthIterator<HistoricoFacultad> iter = arbol.inDepthIterator();
//
//		while(iter.hasNext()) {
//			BinaryTreeNode<HistoricoFacultad> n = iter.nextNode();
//			if(n.getLeft() == null) {
//				ultimoNodo = n;
//			}
//		}
//		return ultimoNodo;
//
//	}

	public String getSurgimiento() {
		return surgimiento;
	}
	public void setSurgimiento(String surgimiento) {
		this.surgimiento = surgimiento;
	}
	
	public void addJuegoGanado(NombreFacultad n) {
		boolean b = false;
		Iterator<HistoricoFacultad> iter = tablaPosicionesHistorica.iterator();
		
		while(iter.hasNext() && !b) {
			HistoricoFacultad f = iter.next();
			if(f.getFacultad().getNombre().compareTo(n)==0) {
				b=true;
				f.setPuntajeHistorico(f.getPuntajeHistorico()+1);
			}
		}
		
		crearTablaPosiciones();
	}

}
