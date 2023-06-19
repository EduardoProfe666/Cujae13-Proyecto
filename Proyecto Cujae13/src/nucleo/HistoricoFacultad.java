package nucleo;

import java.io.Serializable;

public class HistoricoFacultad implements Serializable,Comparable<HistoricoFacultad>{
	private static final long serialVersionUID = 1L;
	private Facultad facultad;
	private int cantidadJuegos13Ganados;
	
	public HistoricoFacultad(Facultad facultad, int cantidadJuegos13Ganados) {
		super();
		this.facultad = facultad;
		this.cantidadJuegos13Ganados = cantidadJuegos13Ganados;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public int getCantidadJuegos13Ganados() {
		return cantidadJuegos13Ganados;
	}

	public void setCantidadJuegos13Ganados(int cantidadJuegos13Ganados) {
		this.cantidadJuegos13Ganados = cantidadJuegos13Ganados;
	}

	@Override
	public int compareTo(HistoricoFacultad o) {
		return Integer.compare(cantidadJuegos13Ganados, o.cantidadJuegos13Ganados);
	}
	
	
	
	
}
