package clasesAuxiliares;

/**
 * Clase que permite modelar la cuenta de los usuarios estudiantes, que 
 * incluye la información de la facultad a la que pertenecen para lograr 
 * una personalización de la aplicación.
 * 
 * @version 2023.05.30
 * 
 * @author Lilian Rojas
 * @author Eduardo González
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
