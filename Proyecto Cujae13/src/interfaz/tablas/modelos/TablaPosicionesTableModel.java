package interfaz.tablas.modelos;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import nucleo.Facultad;

public class TablaPosicionesTableModel extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	
	public TablaPosicionesTableModel() {
		this.setColumnIdentifiers(new String[]{"Nombre y Apellidos", "Carnet de Identidad","No. de Historia Clínica", "Fecha de Indicación", "Tipo de Análisis"});
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
	
	public void adicionar(FacultadPos f) {
		int pos = f.getPos();
		String facultad = f.getFacultad();
		int puntaje = f.getPuntaje();
		
		this.addRow(new Object[] {pos,facultad,puntaje});
		
	}
	
	private List<FacultadPos> extraerPosicionesFacultades(GeneralTree<Facultad> pos) {
		LinkedList<FacultadPos> f = new LinkedList<>();
		
		
		
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
