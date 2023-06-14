package interfaz.combobox.modelos;

import java.util.LinkedList;
import java.util.List;

import nucleo.TipoInfraccion;

public class TipoInfraccionComboBoxModel extends ModeloPrincipalComboBoxModel {

	private static final long serialVersionUID = 1L;

	public TipoInfraccionComboBoxModel() {
		super(tipo());
	}

	@Override
	protected void inicializar() {
		this.addElement("<Seleccionar una infracción>");
	}
	
	private static List<String> tipo(){
		LinkedList<String> s = new LinkedList<String>();
		
		TipoInfraccion[] tipos = TipoInfraccion.values();
		
		for(TipoInfraccion t : tipos) {
			s.add(t.toString());
		}
		
		return s;
	}

}
