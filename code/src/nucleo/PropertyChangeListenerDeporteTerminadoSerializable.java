package nucleo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.HashMap;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.BreadthNode;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIteratorWithLevels;

/**
 * Clase que permite modelar un PropertyChangeListener Serializable para que se actualice la tabla de posiciones general 
 * al terminar un deporte
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public class PropertyChangeListenerDeporteTerminadoSerializable implements PropertyChangeListener, Serializable{
	private static final long serialVersionUID = 1L;
	private Deporte d;
	
	public PropertyChangeListenerDeporteTerminadoSerializable(Deporte d) {
		this.d = d;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		HashMap<Integer,Integer> sistPuntuacion = d.getTipoDeporte().getSistemaPuntuacion();
		GeneralTree<ClasificacionDeporte> pos = d.getTablaPosiciones();

		BinaryTreeNode<ClasificacionDeporte> n = (BinaryTreeNode<ClasificacionDeporte>)pos.getRoot();
		BinaryTreeNode<ClasificacionDeporte> nH = n.getRight();

		n.getInfo().getFacultad().addPuntaje(sistPuntuacion.get(1));

		while(nH!=null) {
			nH.getInfo().getFacultad().addPuntaje(sistPuntuacion.get(1));
			nH = nH.getRight();
		}

		InBreadthIteratorWithLevels<ClasificacionDeporte> iter = pos.inBreadthIteratorWithLevels();
		iter.next();
		while(iter.hasNext()) {
			BreadthNode<ClasificacionDeporte> bn = iter.nextNodeWithLevel();
			bn.getInfo().getFacultad().addPuntaje(sistPuntuacion.get( bn.getLevel()+1));
		}
		Universidad.getInstancia().construirTablaPosiciones();
	}

}
