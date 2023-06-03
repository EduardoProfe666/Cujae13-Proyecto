package clasesAuxiliares;

/**
 * Clase que permite modelar la cuenta de los usuarios administradores.
 * 
 * @version 2023.05.30
 * 
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class UsuarioAdmin extends Usuario{

	private static final long serialVersionUID = 1L;

	public UsuarioAdmin(String nombreUsuario, String contrasenya, String nombre) {
		super(nombreUsuario, contrasenya, nombre);
	}

}
