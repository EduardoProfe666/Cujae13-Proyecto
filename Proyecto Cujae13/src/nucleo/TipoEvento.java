package nucleo;

import java.io.Serializable;

/**
 * Ni idea para que coño se puso esto. Posiblemente no sirva para nada al 
 * final, por ahora se queda así por si acaso...
 *
 */
public enum TipoEvento implements Serializable{
	OCTAVO("Octavo de Final"), CUARTO("Cuarto de Final"), SEMIFINAL("Semifinal"), FINAL("Final");
	
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
