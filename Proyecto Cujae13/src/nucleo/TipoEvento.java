package nucleo;

import java.io.Serializable;

/**
 * Enum que permite modelar cada tipo de evento o etapa de los mismos
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public enum TipoEvento implements Serializable{
	ELIMINATORIA("Eliminatoria"), CUARTO("Cuarto de Final"), SEMIFINAL("Semifinal"), FINAL("Final");
	
	private String nombre;
	
	private TipoEvento(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	public static TipoEvento fromString(String s) {
		TipoEvento st = null;
		
		TipoEvento[] tipos = values();
		
		for(int i=0;i<tipos.length && st==null;i++) {
			if(tipos[i].nombre.equalsIgnoreCase(s))
				st = tipos[i];
		}
		
		return st;
	}
}
