package interfaz.tablas.modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.BreadthNode;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIteratorWithLevels;
import nucleo.ClasificacionDeporte;
import nucleo.Facultad;
import nucleo.HistoricoFacultad;

/**
 * Modelo de tabla empleado en las tablas de posiciones de la aplicación.
 * 
 * @version 2023.06.02
 * @author Eduardo González
 *
 */
public class TablaPosicionesTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;

	public TablaPosicionesTableModel(boolean historico) {
		String s = historico ? "Puntaje Histórico" : "Puntaje" ;
		this.setColumnIdentifiers(new String[]{"Posición", "Facultad", s});
	}

	public void eliminarFilas() {
		this.setRowCount(0);
	}

	public void actualizar(GeneralTree<Facultad> pos){
		if(pos!=null) {
			this.eliminarFilas();
			List<FacultadPos> lista = extraerPosicionesFacultades(pos);
			for(FacultadPos f : lista) {
				adicionar(f);
			}
		}
	}
	
	public void actualizarHistorico(GeneralTree<HistoricoFacultad> pos){
		if(pos!=null) {
			this.eliminarFilas();
			List<FacultadPos> lista = extraerPosicionesFacultadesH(pos);
			for(FacultadPos f : lista) {
				adicionar(f);
			}
		}
	}
	
	public void actualizarDeporte(GeneralTree<ClasificacionDeporte> pos) {
		if(pos!=null) {
			this.eliminarFilas();
			List<FacultadPos> lista = extraerPosicionesFacultadesD(pos);
			for(FacultadPos f : lista) {
				adicionar(f);
			}
		}
	}

	public void adicionar(FacultadPos f) {
		int pos = f.getPos();
		String facultad = f.getFacultad();
		int puntaje = f.getPuntaje();

		this.addRow(new Object[] {pos,facultad,puntaje});

	}

	private List<FacultadPos> extraerPosicionesFacultades(GeneralTree<Facultad> pos) {
		LinkedList<FacultadPos> f = new LinkedList<>();
		BinaryTreeNode<Facultad> n = (BinaryTreeNode<Facultad>)pos.getRoot();
		BinaryTreeNode<Facultad> nH = n.getRight();

		f.add(new FacultadPos(n.getInfo().getNombre().toString(),n.getInfo().getPuntaje(),1));
		while(nH!=null) {
			f.add(new FacultadPos(nH.getInfo().getNombre().toString(),nH.getInfo().getPuntaje(),1));
			nH = nH.getRight();
		}

		InBreadthIteratorWithLevels<Facultad> iter = pos.inBreadthIteratorWithLevels();
		iter.next();
		while(iter.hasNext()) {
			BreadthNode<Facultad> bn = iter.nextNodeWithLevel();
			f.add(new FacultadPos(bn.getInfo().getNombre().toString(), bn.getInfo().getPuntaje(), bn.getLevel()+1));
		}

		return f;
	}
	
	private List<FacultadPos> extraerPosicionesFacultadesH(GeneralTree<HistoricoFacultad> pos) {
		LinkedList<FacultadPos> f = new LinkedList<>();
		BinaryTreeNode<HistoricoFacultad> n = (BinaryTreeNode<HistoricoFacultad>)pos.getRoot();
		BinaryTreeNode<HistoricoFacultad> nH = n.getRight();

		f.add(new FacultadPos(n.getInfo().getFacultad().getNombre().toString(),n.getInfo().getPuntajeHistorico(),1));
		while(nH!=null) {
			f.add(new FacultadPos(nH.getInfo().getFacultad().getNombre().toString(),nH.getInfo().getPuntajeHistorico(),1));
			nH = nH.getRight();
		}

		InBreadthIteratorWithLevels<HistoricoFacultad> iter = pos.inBreadthIteratorWithLevels();
		iter.next();
		while(iter.hasNext()) {
			BreadthNode<HistoricoFacultad> bn = iter.nextNodeWithLevel();
			f.add(new FacultadPos(bn.getInfo().getFacultad().getNombre().toString(), bn.getInfo().getPuntajeHistorico(), bn.getLevel()+1));
		}

		return f;
	}

	private List<FacultadPos> extraerPosicionesFacultadesD(GeneralTree<ClasificacionDeporte> pos) {
		LinkedList<FacultadPos> f = new LinkedList<>();
		BinaryTreeNode<ClasificacionDeporte> n = (BinaryTreeNode<ClasificacionDeporte>)pos.getRoot();
		BinaryTreeNode<ClasificacionDeporte> nH = n.getRight();

		f.add(new FacultadPos(n.getInfo().getFacultad().getNombre().toString(),n.getInfo().getPuntaje(),1));
		while(nH!=null) {
			f.add(new FacultadPos(nH.getInfo().getFacultad().getNombre().toString(),nH.getInfo().getPuntaje(),1));
			nH = nH.getRight();
		}

		InBreadthIteratorWithLevels<ClasificacionDeporte> iter = pos.inBreadthIteratorWithLevels();
		iter.next();
		while(iter.hasNext()) {
			BreadthNode<ClasificacionDeporte> bn = iter.nextNodeWithLevel();
			f.add(new FacultadPos(bn.getInfo().getFacultad().getNombre().toString(), bn.getInfo().getPuntaje(), bn.getLevel()+1));
		}

		return f;
	}

	@Override
	public boolean isCellEditable(int row, int column) { 
		return false;
	}

	private class FacultadPos {
		private String facultad;
		private int puntaje;
		private int pos;

		public FacultadPos(String facultad, int puntaje, int pos){
			this.facultad = facultad;
			this.puntaje = puntaje;
			this.pos = pos;
		}

		public String getFacultad() {
			return facultad;
		}

		public int getPuntaje() {
			return puntaje;
		}

		public int getPos() {
			return pos;
		}
	}
}
