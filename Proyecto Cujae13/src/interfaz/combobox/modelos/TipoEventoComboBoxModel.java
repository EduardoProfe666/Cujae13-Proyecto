package interfaz.combobox.modelos;

import java.util.LinkedList;
import java.util.List;

import nucleo.TipoEvento;

public class TipoEventoComboBoxModel extends ModeloPrincipalComboBoxModel {

	private static final long serialVersionUID = 1L;

	public TipoEventoComboBoxModel() {
		super(tipo());
	}

	@Override
	protected void inicializar() {
		this.addElement("<Seleccionar un tipo de evento>");
	}
	
	private static List<String> tipo(){
		LinkedList<String> s = new LinkedList<String>();
		
		TipoEvento[] tipos = TipoEvento.values();
		
		for(TipoEvento t : tipos) {
			s.add(t.toString());
		}
		
		return s;
	}
}
