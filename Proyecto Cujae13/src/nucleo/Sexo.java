package nucleo;

public enum Sexo {
	FEMENINO("Femenino"), MASCULINO("Masculino"), MIXTO("Mixto");
	
	private String nombre;
	
	private Sexo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}
