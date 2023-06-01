package clasesAuxiliares;

public enum NombreFacultad {
	INFORMATICA("Informática"), TELECOMUNICACIONES("Telecomunicaciones"), ARQUITECTURA("Arquitectura"), 
	QUIMICA("Química"), AUTOMATICA_BIOMEDICA("Automática/Biomédica"), CIVIL("Civil"), 
	ELECTRICA("Eléctrica"), INDUSTRIAL("Industrial"), MECANICA("Mecánica");
	
	private String nombre;
	
	private NombreFacultad(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
