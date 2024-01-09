package interfaz.combobox.modelos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import nucleo.NombreFacultad;

public class NombreFacultadComboBoxModel extends ModeloPrincipalComboBoxModel {

	private static final long serialVersionUID = 1L;
	private static List<String> lista;

	public NombreFacultadComboBoxModel() {
		super(tipo());
	}

	@Override
	protected void inicializar() {
		this.addElement("<Seleccionar una facultad>");
	}
	
	private static List<String> tipo(){
		LinkedList<String> s = new LinkedList<String>();
		NombreFacultad[] tipos = NombreFacultad.values();
		
		for(NombreFacultad t : tipos) {
			s.add(t.toString());
		}
		
		lista = s;
		
		return s;
	}
	
	public void eliminarFacultades(List<NombreFacultad> f) {
		for(NombreFacultad nf : f) {
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
	
	public void eliminarFacultad(NombreFacultad n) {
		String f = n.toString();
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
