package nucleo;

/**
 * Clase que permite identificar los deportes en <b>finalizados</b> y 
 * <b>en ejecucion</b>
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 *
 */
public enum EstadoDeporte {
	EN_EJECUCION("En ejecuci�n"), FINALIZADO("Finalizado");
	
	public String nombre;
	
	private EstadoDeporte(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
