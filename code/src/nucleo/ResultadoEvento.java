package nucleo;

import java.io.Serializable;

/**
 * Clase que permite modelar el resultado del Evento, es decir, la facultad ganadora
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
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
