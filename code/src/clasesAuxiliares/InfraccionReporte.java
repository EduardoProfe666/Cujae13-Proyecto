package clasesAuxiliares;

import nucleo.Infraccion;

/**
 * 
 * Clase informacional para la tabla de infracciones
 * 
 * @author Eduardo Gonz�lez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 */
public class InfraccionReporte {
	private Infraccion infraccion;
	private String deporte;
	
	public InfraccionReporte(Infraccion infraccion, String deporte) {
		this.infraccion = infraccion;
		this.deporte = deporte;
	}
	
	public Infraccion getInfraccion() {
		return infraccion;
	}
	public void setInfraccion(Infraccion infraccion) {
		this.infraccion = infraccion;
	}
	public String getDeporte() {
		return deporte;
	}
}	
