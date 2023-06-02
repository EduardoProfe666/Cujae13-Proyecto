package clasesAuxiliares;

import definiciones.DefinicionesInterfaz;
import definiciones.Errores;
import utilidades.Validaciones;

/**
 * Clase abstracta que permite guardar la informaci�n relacionada con la autenticaci�n 
 * del usuario.
 * 
 * @version 2023.05.30
 * 
 * @author Lilian Rojas
 * @author Eduardo Gonz�lez
 *
 */
public abstract class Usuario { 
	private String nombreUsuario;
	private String nombre;
	private String contrasenya;
	
	public Usuario(String nombreUsuario, String contrasenya, String nombre) {
		setNombreUsuario(nombreUsuario);
		setContrasenya(contrasenya);
		setNombre(nombre);
	}
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario) {
		if(Validaciones.validarStringNoVacio(nombreUsuario) && Validaciones.validarStringNoTodoEspacio(nombreUsuario) && Validaciones.validarStringTodoLetra(nombreUsuario) && Validaciones.validarTamString(nombreUsuario, 0, DefinicionesInterfaz.LIMITE_CARACTERES_USUARIO))
			this.nombreUsuario = nombreUsuario;
		else
			throw new IllegalArgumentException(Errores.ERROR_NOMBRE_USUARIO);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		if(nombre!=null)
			this.nombre = nombre;
		else
			throw new IllegalArgumentException(Errores.ERROR_NOMBRE);
	}
	
	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		if(Validaciones.validarStringNoVacio(contrasenya) && Validaciones.validarStringNoTodoEspacio(contrasenya) && Validaciones.validarTamString(contrasenya, 0, DefinicionesInterfaz.LIMITE_CARACTERES_CONTRASENYA))
			this.contrasenya = contrasenya;
		else
			throw new IllegalArgumentException(Errores.ERROR_CONTRASENYA);
	}

}

