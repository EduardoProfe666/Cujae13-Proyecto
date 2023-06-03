package definiciones;

import java.util.LinkedList;
import java.util.List;

import clasesAuxiliares.Usuario;
import clasesAuxiliares.UsuarioAdmin;
import clasesAuxiliares.UsuarioEstudiante;

/**
 * Clase de definiciones generales de lógica de la aplicación
 * 
 * @version 2023.05.30
 * 
 * @author Eduardo González
 *
 */
public final class DefinicionesLogica {
	private DefinicionesLogica() {}
	
	public static final int CANT_MIN_FACULTADES = 9;
	public static final List<Usuario> usuarios = usuarios();
	
	private static List<Usuario> usuarios(){ //Provisional
		LinkedList<Usuario> lista = new LinkedList<>();
		
		lista.add(new UsuarioAdmin("admin@ceis.cujae.edu.cu","1234","Admin"));
		lista.add(new UsuarioEstudiante("info@ceis.cujae.edu.cu","1234","Dios de la Cujae"));
		lista.add(new UsuarioEstudiante("tele@telecomunicaciones.cujae.edu.cu","1234","Funcionario de Etecsa"));
		lista.add(new UsuarioEstudiante("arqu@arquitectura.cujae.edu.cu","1234","Gay"));
		lista.add(new UsuarioEstudiante("aubi@automatica.cujae.edu.cu","1234","Frustrado"));
		lista.add(new UsuarioEstudiante("civi@civil.cujae.edu.cu","1234","Albañil"));
		lista.add(new UsuarioEstudiante("elec@electrica.cujae.edu.cu","1234", "Cobrador de la Luz"));
		lista.add(new UsuarioEstudiante("indu@industrial.cujae.edu.cu","1234", "Técnico Medio"));
		lista.add(new UsuarioEstudiante("meca@mecanica.cujae.edu.cu","1234", "Chapista"));
		lista.add(new UsuarioEstudiante("quim@quimica.cujae.edu.cu","1234", "Elaboradora de Novatropin"));
		
		return lista;
	}
}
