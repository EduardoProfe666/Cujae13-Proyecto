package clasesAuxiliares;

/**
 * Clase informacional para la tabla de estadísticas de las facultades.
 * 
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class EstadisticasReporte {
	private int puntaje;
	private int infracciones; //Indisciplinas que tributan a la tabla de deportes
	private int sanciones; //Indisciplinas que tributan a la tabla general
	private int partidosJugados;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	
	public EstadisticasReporte(int puntaje, int infracciones, int sanciones, int partidosJugados, int partidosGanados,
			int partidosEmpatados, int partidosPerdidos) {
		super();
		this.puntaje = puntaje;
		this.infracciones = infracciones;
		this.sanciones = sanciones;
		this.partidosJugados = partidosJugados;
		this.partidosGanados = partidosGanados;
		this.partidosEmpatados = partidosEmpatados;
		this.partidosPerdidos = partidosPerdidos;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public int getInfracciones() {
		return infracciones;
	}
	public void setInfracciones(int infracciones) {
		this.infracciones = infracciones;
	}
	public int getSanciones() {
		return sanciones;
	}
	public void setSanciones(int sanciones) {
		this.sanciones = sanciones;
	}
	public int getPartidosJugados() {
		return partidosJugados;
	}
	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}
	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	
	
}
