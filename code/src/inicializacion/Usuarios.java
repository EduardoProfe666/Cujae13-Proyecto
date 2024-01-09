package inicializacion;

import java.io.Serializable;
import java.util.ArrayList;

import clasesAuxiliares.Usuario;

/**
 * Clase que permite almacenar el listado de usuarios admisibles en la aplicación.
 * 
 * 
 * @author Eduardo González
 * @author Cristian Páez
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
	public static Usuarios getInstancia(Usuarios u) {
		if(instancia == null)
			instancia = new Usuarios(u);
		return instancia;
	}
	
	private Usuarios() {
		u = new ArrayList<Usuario>();
	}
	private Usuarios(Usuarios u) {
		this.u = u.getUsuarios();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return new ArrayList<Usuario>(u);
	}
	
	public void ingresarUsuario(Usuario u) {
		if(u!=null)
			this.u.add(u);
	}

}
