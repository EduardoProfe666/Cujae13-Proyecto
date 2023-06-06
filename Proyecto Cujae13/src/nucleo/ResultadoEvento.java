package nucleo;

import java.io.Serializable;

public class ResultadoEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	private Facultad facultadGanadora; 
	
	public ResultadoEvento(Facultad facultadGanadora) {
		super();
		this.facultadGanadora = facultadGanadora;
	}
	public Facultad getFacultadGanadora() {
		return facultadGanadora;
	}	
	
}
