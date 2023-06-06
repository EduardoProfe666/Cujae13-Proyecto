package nucleo;

public enum TipoSancion {
	;
	private String nombre;
	
	private TipoSancion(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
