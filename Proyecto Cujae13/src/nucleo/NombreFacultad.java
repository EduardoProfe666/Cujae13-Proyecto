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
	INDUSTRIAL("Industrial"), INFORMATICA("Inform�tica"), MECANICA("Mec�nica"), QUIMICA("Qu�mica"), TELECOMUNICACIONES("Telecomunicaciones");
	
	private String nombre;
	
	private NombreFacultad(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	
}