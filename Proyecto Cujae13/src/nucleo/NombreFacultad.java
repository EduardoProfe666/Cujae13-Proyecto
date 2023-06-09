package nucleo;

/**
 *Enum empleado para el manejo de los nombre de las diferentes facultades, tanto a 
 *nivel de lógica, como de interfaz.
 *
 *@version 2023.05.30
 *
 *@author Lilian Rojas
 *@author Eduardo González
 *
 */
public enum NombreFacultad {
	ARQUITECTURA("Arquitectura"), AUTOMATICA_BIOMEDICA("Automática/Biomédica"), CIVIL("Civil"), ELECTRICA("Eléctrica"), 
	INDUSTRIAL("Industrial"), INFORMATICA("Informática"), MECANICA("Mecánica"), QUIMICA("Química"), TELECOMUNICACIONES("Telecomunicaciones");
	
	private String nombre;
	
	private NombreFacultad(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	
}
