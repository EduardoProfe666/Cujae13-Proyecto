package interfaz.combobox.modelos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import nucleo.Universidad;

public class DeporteComboBoxModel extends ModeloPrincipalComboBoxModel {

	private static final long serialVersionUID = 1L;
	private static List<String> lista;

	public DeporteComboBoxModel() {
		super(tipo());
	}

	@Override
	protected void inicializar() {
		this.addElement("<Seleccionar un deporte>");
	}
	
	private static List<String> tipo(){
		LinkedList<String> s = new LinkedList<String>();
		
		for(String t : Universidad.getInstancia().nombresDeportes()) {
			s.add(t);
		}
		
		lista = s;
		
		return s;
	}
	
	public void eliminarDeportes(List<String> f) {
		for(String nf : f) {
			eliminarFacultad(nf);
		}
		
	}
	
	private void actualizar() {
		this.removeAllElements();
		this.inicializar();
		for(String s : lista) {
			this.addElement(s);
		}
	}
	
	public void reiniciar() {
		tipo();
		actualizar();
	}
	
	public void eliminarFacultad(String f) {
		Iterator<String> iter = lista.iterator();
		boolean eliminado = false;
		
		while(iter.hasNext() && !eliminado) {
			String s = iter.next();
			if(s.equals(f)) {
				iter.remove();
				eliminado = true;
			}
		}
		actualizar();
	}
}
