package clasesAuxiliares;

import java.io.Serializable;

import definiciones.DefinicionesInterfaz;
import definiciones.Errores;
import utilidades.Archivador;
import utilidades.Validaciones;

/**
 * Clase abstracta que permite guardar la información relacionada con la autenticación 
 * del usuario.
 * 
 * 
 * @author Lilian Rojas
 * @author Cristian Páez
 * @author Eduardo González
 *
 */
public abstract class Usuario implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String correoUsuario;
	private String nombre;
	private String contrasenya;
	
	public Usuario(String correoUsuario, String contrasenya, String nombre) {
		setCorreoUsuario(correoUsuario);
		setContrasenya(contrasenya);
		setNombre(nombre);
	}
	
	
	public String getCorreoUsuario() {
		return correoUsuario;
	}
	
	public void setCorreoUsuario(String correoUsuario) {
		if(Validaciones.validarStringNoVacio(correoUsuario) && Validaciones.validarStringNoTodoEspacio(correoUsuario) && Validaciones.validarTamString(correoUsuario, 0, DefinicionesInterfaz.LIMITE_CARACTERES_USUARIO) && Archivador.getFacultadCorreo(correoUsuario)!=null)
			this.correoUsuario = correoUsuario;
		else
			throw new IllegalArgumentException(Errores.ERROR_CORREO_USUARIO);
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

