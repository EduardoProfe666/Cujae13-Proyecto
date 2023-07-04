package nucleo;

import java.io.Serializable;

/**
 * Clase que permite modelar los nodos de la tabla de posiciones historica
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 *
 */
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
			throw new IllegalArgumentException("La facultad no debe estar vac�a");
		}
	}

	public int getPuntajeHistorico() {
		return puntajeHistorico;
	}

	public void setPuntajeHistorico(int puntajeHistorico) {
		if(puntajeHistorico >= 0){
			this.puntajeHistorico = puntajeHistorico;
		} else {
			throw new IllegalArgumentException("El puntaje hist�rico debe ser mayor o igual que cero");
		}
	}

	@Override
	public int compareTo(HistoricoFacultad o) {
		return Integer.compare(puntajeHistorico, o.puntajeHistorico);
	}
	
	
	
	
}
