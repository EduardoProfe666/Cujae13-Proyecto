package interfaz.combobox.modelos;

import java.util.LinkedList;
import java.util.List;

import nucleo.TipoSancion;

public class TipoSancionComboBoxModel extends ModeloPrincipalComboBoxModel {

	private static final long serialVersionUID = 1L;

	public TipoSancionComboBoxModel() {
		super(tipo());
	}

	@Override
	protected void inicializar() {
		this.addElement("<Seleccionar una sanción>");
	}
	
	private static List<String> tipo(){
		LinkedList<String> s = new LinkedList<String>();
		
		TipoSancion[] tipos = TipoSancion.values();
		
		for(TipoSancion t : tipos) {
			s.add(t.toString());
		}
		
		return s;
	}

}
