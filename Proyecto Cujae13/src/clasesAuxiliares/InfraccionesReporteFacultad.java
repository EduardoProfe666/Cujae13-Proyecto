package clasesAuxiliares;

import nucleo.Infraccion;

public class InfraccionesReporteFacultad {
	private Infraccion infraccion;
	private String deporte;
	
	public InfraccionesReporteFacultad(Infraccion infraccion, String deporte) {
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
