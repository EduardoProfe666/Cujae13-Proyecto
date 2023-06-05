package nucleo;

import java.io.Serializable;

public class ResultadoEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	private Facultad facultadGanadora; 
	private int marcadorFacultadPrimera;
	private int marcadorFacultadSegunda;
	private int puntajeEvento;
	
	public ResultadoEvento(Facultad facultadGanadora, int marcadorFacultadPrimera, int marcadorFacultadSegunda,
			int puntajeEvento) {
		super();
		this.facultadGanadora = facultadGanadora;
		this.marcadorFacultadPrimera = marcadorFacultadPrimera;
		this.marcadorFacultadSegunda = marcadorFacultadSegunda;
		this.puntajeEvento = puntajeEvento;
	}
	public Facultad getFacultadGanadora() {
		return facultadGanadora;
	}
	public void setFacultadGanadora(Facultad facultadGanadora) {
		this.facultadGanadora = facultadGanadora;
	}
	public int getMarcadorFacultadPrimera() {
		return marcadorFacultadPrimera;
	}
	public void setMarcadorFacultadPrimera(int marcadorFacultadPrimera) {
		this.marcadorFacultadPrimera = marcadorFacultadPrimera;
	}
	public int getMarcadorFacultadSegunda() {
		return marcadorFacultadSegunda;
	}
	public void setMarcadorFacultadSegunda(int marcadorFacultadSegunda) {
		this.marcadorFacultadSegunda = marcadorFacultadSegunda;
	}
	public int getPuntajeEvento() {
		return puntajeEvento;
	}
	public void setPuntajeEvento(int puntajeEvento) {
		this.puntajeEvento = puntajeEvento;
	}
	
	
}
