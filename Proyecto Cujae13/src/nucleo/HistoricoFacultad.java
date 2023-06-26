package nucleo;

import java.io.Serializable;

public class HistoricoFacultad implements Serializable,Comparable<HistoricoFacultad>{
	private static final long serialVersionUID = 1L;
	private Facultad facultad;
	private int puntajeHistorico;
	
	public HistoricoFacultad(Facultad facultad, int puntajeHistorico) {
		super();
		this.facultad = facultad;
		this.puntajeHistorico = puntajeHistorico;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public int getPuntajeHistorico() {
		return puntajeHistorico;
	}

	public void setPuntajeHistorico(int puntajeHistorico) {
		this.puntajeHistorico = puntajeHistorico;
	}

	@Override
	public int compareTo(HistoricoFacultad o) {
		return Integer.compare(puntajeHistorico, o.puntajeHistorico);
	}
	
	
	
	
}
