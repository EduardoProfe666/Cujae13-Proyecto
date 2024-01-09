package clasesAuxiliares;

/**
 * Clase que permite modelar la cuenta de los usuarios administradores.
 * 
 * 
 * @author Lilian Rojas
 * @author Cristian P�ez
 * @author Eduardo Gonz�lez
 *
 */
public class UsuarioAdmin extends Usuario{

	private static final long serialVersionUID = 1L;

	public UsuarioAdmin(String nombreUsuario, String contrasenya, String nombre) {
		super(nombreUsuario, contrasenya, nombre);
	}

}
