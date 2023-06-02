package clasesAuxiliares;

/**
 * Clase que permite modelar la cuenta de los usuarios estudiantes, que 
 * incluye la informaci�n de la facultad a la que pertenecen para lograr 
 * una personalizaci�n de la aplicaci�n.
 * 
 * @version 2023.05.30
 * 
 * @author Lilian Rojas
 * @author Eduardo Gonz�lez
 *
 */
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
