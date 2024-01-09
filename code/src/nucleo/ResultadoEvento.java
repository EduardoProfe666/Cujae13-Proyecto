package nucleo;

import java.io.Serializable;

/**
 * Clase que permite modelar el resultado del Evento, es decir, la facultad ganadora
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
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
