package nucleo;

import java.io.Serializable;

public class HistoricoFacultad implements Serializable,Comparable<HistoricoFacultad>{
	private static final long serialVersionUID = 1L;
	private Facultad facultad;
	private int puntajeHistorico;
	
	public HistoricoFacultad(Facultad facultad, int puntajeHistorico) {
		super();
		setFacultad(facultad);
		setPuntajeHistorico(puntajeHistorico);
	}

	public Facultad getFacultad() {
		return facultad;
	}

	private void setFacultad(Facultad facultad) {
		if(facultad != null){
			this.facultad = facultad;
		} else {
			throw new IllegalArgumentException("La facultad no debe estar vacía");
		}
	}

	public int getPuntajeHistorico() {
		return puntajeHistorico;
	}

	public void setPuntajeHistorico(int puntajeHistorico) {
		if(puntajeHistorico >= 0){
			this.puntajeHistorico = puntajeHistorico;
		} else {
			throw new IllegalArgumentException("El puntaje histórico debe ser mayor o igual que cero");
		}
	}

	@Override
	public int compareTo(HistoricoFacultad o) {
		return Integer.compare(puntajeHistorico, o.puntajeHistorico);
	}
	
	
	
	
}
