package clasesAuxiliares;

import nucleo.NombreFacultad;
import utilidades.Archivador;

/**
 * Clase que permite modelar la cuenta de los usuarios estudiantes, que 
 * incluye la informaci�n de la facultad a la que pertenecen para lograr 
 * una personalizaci�n de la aplicaci�n.
 * 
 * 
 * @author Lilian Rojas
 * @author Cristian P�ez
 * @author Eduardo Gonz�lez
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
