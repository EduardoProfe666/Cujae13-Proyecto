package inicializacion;

import java.io.Serializable;
import java.util.ArrayList;

import clasesAuxiliares.Usuario;

/**
 * Clase que permite almacenar el listado de usuarios admisibles en la aplicación.
 * 
 * @version 2023.06.02
 * 
 * @author Eduardo González
 *
 */
public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Usuario> u;
	private static Usuarios instancia;
	
	public static Usuarios getInstancia() {
		if(instancia == null)
			instancia = new Usuarios();
		return instancia;
	}
	
	private Usuarios() {
		u = new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return new ArrayList<Usuario>();
	}
	
	public void ingresarUsuario(Usuario u) {
		if(u!=null)
			this.u.add(u);
	}

}
