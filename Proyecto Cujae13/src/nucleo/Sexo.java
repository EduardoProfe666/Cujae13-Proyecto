package nucleo;

/**
 * Enum que permite modelar el sexo admitido en cada deporte
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
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
