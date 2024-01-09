package inicializacion;

import java.io.Serializable;

import nucleo.Universidad;

/**
 * Clase que permite almacenar en memoria externa los datos principales de la aplicaci�n.
 * 
 * 
 * @author Eduardo Gonz�lez
 *
 */
public class Datos implements Serializable{
	private static final long serialVersionUID = 1L;	
	private Universidad univ;
	private Usuarios usuarios;
	
	
	public Datos(Universidad univ, Usuarios usuarios) {
		this.univ = univ;
		this.usuarios = usuarios;
	}
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
	
	public Universidad getUniversidad() {
		return univ;
	}
}
