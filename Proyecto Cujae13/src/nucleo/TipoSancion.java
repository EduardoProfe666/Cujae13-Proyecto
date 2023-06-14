package nucleo;

public enum TipoSancion {
	INDISCIPLINA_GRAVE("Indisciplina Grave",10,"Realización de indisciplinas graves tanto en deportes colectivos como individuales"),
	FRAUDE("Fraude",20,"Realización de fraude de cualquier índole");
	private String nombre;
	private int puntaje;
	private String descripcion;
	
	private TipoSancion(String nombre, int puntaje, String descripcion) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.descripcion = descripcion;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	public static TipoSancion fromString(String s) {
		TipoSancion st = null;
		
		TipoSancion[] tipos = values();
		
		for(int i=0;i<tipos.length && st==null;i++) {
			if(tipos[i].nombre.equalsIgnoreCase(s))
				st = tipos[i];
		}
		
		return st;
	}
}
