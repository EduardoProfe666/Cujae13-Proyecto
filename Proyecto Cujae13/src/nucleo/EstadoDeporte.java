package nucleo;

/**
 * Clase que permite identificar los deportes en <b>finalizados</b> y 
 * <b>en ejecucion</b>
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public enum EstadoDeporte {
	EN_EJECUCION("En ejecución"), FINALIZADO("Finalizado");
	
	public String nombre;
	
	private EstadoDeporte(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
