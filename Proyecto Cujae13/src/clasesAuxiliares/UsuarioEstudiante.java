package clasesAuxiliares;

import utilidades.Archivador;

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
	
	private static final long serialVersionUID = 1L;

	public UsuarioEstudiante(String correoUsuario, String contrasenya, String nombre) {
		super(correoUsuario, contrasenya, nombre);
	}
	
	public NombreFacultad getFacultad() {
		return Archivador.getFacultadCorreo(getCorreoUsuario());
	}


}
