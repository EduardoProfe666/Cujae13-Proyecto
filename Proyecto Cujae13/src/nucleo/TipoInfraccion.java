package nucleo;

public enum TipoInfraccion {
	;
	private String nombre;
	
	private TipoInfraccion(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
