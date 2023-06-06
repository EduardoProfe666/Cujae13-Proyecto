package nucleo;

import java.io.Serializable;

import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Historia13Marzo implements Serializable{
	private static final long serialVersionUID = 1L;
	private GeneralTree<HistoricoFacultad> tablaPosicionesHistorica; //Arbol General
	private String surgimiento;
	
	public Historia13Marzo(GeneralTree<HistoricoFacultad> tablaPosicionesHistorica, String surgimiento) {
		super();
		this.tablaPosicionesHistorica = tablaPosicionesHistorica;
		this.surgimiento = surgimiento;
	}
	
	public GeneralTree<HistoricoFacultad> getTablaPosicionesHistorica() {
		return tablaPosicionesHistorica;
	}
	public String getSurgimiento() {
		return surgimiento;
	}
	public void setSurgimiento(String surgimiento) {
		this.surgimiento = surgimiento;
	}
	
}
