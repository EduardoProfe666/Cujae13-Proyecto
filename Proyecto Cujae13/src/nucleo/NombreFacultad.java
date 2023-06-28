package nucleo;

/**
 *Enum empleado para el manejo de los nombre de las diferentes facultades, tanto a 
 *nivel de l�gica, como de interfaz.
 *
 *@version 2023.05.30
 *
 *@author Lilian Rojas
 *@author Eduardo Gonz�lez
 *
 */
public enum NombreFacultad {
	ARQUITECTURA("Arquitectura"), AUTOMATICA_BIOMEDICA("Autom�tica/Biom�dica"), CIVIL("Civil"), ELECTRICA("El�ctrica"), 
	INDUSTRIAL("Industrial"), INFORMATICA("Inform�tica"), MECANICA("Mec�nica"), QUIMICA("Qu�mica"), TELECOMUNICACIONES("Telecomunicaciones y Electr�nica");
	
	private String nombre;
	
	private NombreFacultad(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	public static NombreFacultad fromString(String s) {
		NombreFacultad st = null;
		
		NombreFacultad[] tipos = values();
		
		for(int i=0;i<tipos.length && st==null;i++) {
			if(tipos[i].nombre.equalsIgnoreCase(s))
				st = tipos[i];
		}
		
		return st;
	}
}
