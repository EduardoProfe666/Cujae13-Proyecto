package nucleo;

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
