package interfaz.tablas.modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.BreadthNode;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIteratorWithLevels;
import nucleo.Facultad;
import nucleo.NombreFacultad;

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
		String s = historico ? "Cant. de Juegos Ganados" : "Puntaje" ;
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

	/**
	 * PROVISIONAL... SOLO PARA PRUEBAS
	 * @param pos
	 */
	public void actualizar() {
		this.eliminarFilas();
		List<FacultadPos> lista = posicionesFacultades();
		for(FacultadPos f : lista) {
			adicionar(f);
		}
	}

	/**
	 * PROVISIONAL... SOLO PARA PRUEBAS
	 * @param pos
	 * @return
	 */
	private List<FacultadPos> posicionesFacultades() {
		LinkedList<FacultadPos> f = new LinkedList<>();
		LinkedList<Facultad> fac = new LinkedList<>();
		
		fac.add(new Facultad(NombreFacultad.INFORMATICA, null, 999));
		fac.add(new Facultad(NombreFacultad.TELECOMUNICACIONES, null, 800));
		fac.add(new Facultad(NombreFacultad.ARQUITECTURA, null, 700));
		fac.add(new Facultad(NombreFacultad.QUIMICA, null, 600));
		fac.add(new Facultad(NombreFacultad.AUTOMATICA_BIOMEDICA, null, 500));
		fac.add(new Facultad(NombreFacultad.CIVIL, null, 400));
		fac.add(new Facultad(NombreFacultad.ELECTRICA, null, 300));
		fac.add(new Facultad(NombreFacultad.INDUSTRIAL, null, 200));
		fac.add(new Facultad(NombreFacultad.MECANICA, null, 100));
		
		for(int i=0;i<9;i++) {
			f.add(new FacultadPos(fac.get(i).getNombre().toString(), fac.get(i).getPuntaje(), i+1));
		}

		return f;
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
