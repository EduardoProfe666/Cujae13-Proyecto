package inicializacion;

import java.io.Serializable;

import definiciones.Usuarios;
import nucleo.Universidad;

/**
 * Clase que permite almacenar en memoria los datos principales de la aplicación que 
 * se encuentran en memoria externa.
 * 
 * @version 2023.06.02
 * 
 * @author Eduardo González
 *
 */
public class Datos implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Universidad univ;
	private Usuarios usuarios;
	private static Datos instancia;
	
	public static Datos getInstancia(Universidad univ, Usuarios usuarios) {
		if(instancia==null)
			instancia = new Datos(univ, usuarios);
		return instancia;
	}
	
	public static Datos getInstancia() {
		if(instancia==null)
			throw new IllegalArgumentException("Instancia de Datos no Inicializada");
		return instancia;
	}
	
	
	private Datos(Universidad univ, Usuarios usuarios) {
		this.univ = univ;
		this.usuarios = usuarios;
	}
	
	private Datos(Datos d) {
		if(d==null)
			throw new IllegalArgumentException("Los datos son nulos");
		this.univ = d.univ;
		this.usuarios = d.usuarios;
	}
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
	
	public Universidad getUniversidad() {
		return univ;
	}
}
