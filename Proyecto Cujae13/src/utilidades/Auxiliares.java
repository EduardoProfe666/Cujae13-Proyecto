package utilidades;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import clasesAuxiliares.Usuario;
import definiciones.DefinicionesInterfaz;
import definiciones.DefinicionesLogica;
import definiciones.ErroresInterfazGrafica;

/**
 * Clase de utilidades que incluye diferentes métodos de uso tanto en lógica, como en interfaz.
 * 
 * @version 2023.06.02
 * 
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public final class Auxiliares {
	private Auxiliares() {}
	
	public static Icon ajustarImagen(Dimension dimCmp, URL urlImg) {
		ImageIcon imagen = new ImageIcon(urlImg);
		
		return new ImageIcon(imagen.getImage().getScaledInstance(dimCmp.width, dimCmp.height, Image.SCALE_SMOOTH));
	}
	
	public static Usuario seguridad(String usuario,String contrasenya) {
		
		boolean usuarioNoVacio = Validaciones.validarStringNoVacio(usuario) && !usuario.equals(DefinicionesInterfaz.CAMPO_USUARIO_TEXTO_BASE);
		boolean contrasenyaNoVacia = Validaciones.validarStringNoVacio(contrasenya) && !contrasenya.equals(DefinicionesInterfaz.CAMPO_CONTRASENYA_TEXTO_BASE);
		
		if(!usuarioNoVacio) {
			if(!contrasenyaNoVacia)
				throw new IllegalArgumentException(ErroresInterfazGrafica.ERROR_CAMPO_VACIO);
			else
				throw new IllegalArgumentException(ErroresInterfazGrafica.ERROR_CAMPO_VACIO_USUARIO);
		}
		else if(!contrasenyaNoVacia)
			throw new IllegalArgumentException(ErroresInterfazGrafica.ERROR_CAMPO_VACIO_CONTRASENYA);
			
		Usuario u = null;
		//MEJORAR CON ITERADORES
		for(int i=0;i<DefinicionesLogica.usuarios.size() && u==null;i++) {
			if(DefinicionesLogica.usuarios.get(i).getCorreoUsuario().equals(usuario)) {
				u = DefinicionesLogica.usuarios.get(i);
			}
		}
		
		if(u==null)
			throw new IllegalArgumentException(ErroresInterfazGrafica.ERROR_CORREO_NO_VALIDO);
		
		if(!u.getContrasenya().equals(contrasenya))
			throw new IllegalArgumentException(ErroresInterfazGrafica.ERROR_CONTRASENYA_NO_VALIDA);
			
		return u;
	}
}
