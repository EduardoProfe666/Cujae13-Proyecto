package clasesAuxiliares;

public class UsuarioEstudiante extends Usuario{
	private NombreFacultad facultad;
	
	public UsuarioEstudiante(String nombreUsuario, String contrasenya, String nombre, NombreFacultad facultad) {
		super(nombreUsuario, contrasenya, nombre);
		this.facultad = facultad;
	}
	
	public NombreFacultad getFacultad() {
		return facultad;
	}


}
