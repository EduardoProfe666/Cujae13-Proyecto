package definiciones;

import java.util.LinkedList;
import java.util.List;

import clasesAuxiliares.NombreFacultad;
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
		
		lista.add(new UsuarioAdmin("admin","1234","Admin"));
		lista.add(new UsuarioEstudiante("info","1234","Dios de la Cujae", NombreFacultad.INFORMATICA));
		lista.add(new UsuarioEstudiante("tele","1234","Funcionario de Etecsa", NombreFacultad.TELECOMUNICACIONES));
		lista.add(new UsuarioEstudiante("arqu","1234","Gay", NombreFacultad.ARQUITECTURA));
		lista.add(new UsuarioEstudiante("aubi","1234","Frustrado", NombreFacultad.AUTOMATICA_BIOMEDICA));
		lista.add(new UsuarioEstudiante("civi","1234","Albañil", NombreFacultad.CIVIL));
		lista.add(new UsuarioEstudiante("elec","1234", "Cobrador de la Luz", NombreFacultad.ELECTRICA));
		lista.add(new UsuarioEstudiante("indu","1234", "Técnico Medio", NombreFacultad.INDUSTRIAL));
		lista.add(new UsuarioEstudiante("meca","1234", "Chapista", NombreFacultad.MECANICA));
		lista.add(new UsuarioEstudiante("quim","1234", "Elaboradora de Novatropin", NombreFacultad.QUIMICA));
		
		return lista;
	}
}
