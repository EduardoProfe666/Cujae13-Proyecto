package inicializacion;

import java.io.File;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalTime;

import clasesAuxiliares.UsuarioAdmin;
import clasesAuxiliares.UsuarioEstudiante;
import nucleo.Deporte;
import nucleo.Evento;
import nucleo.Facultad;
import nucleo.Historia13Marzo;
import nucleo.InfoGeneral;
import nucleo.NombreFacultad;
import nucleo.Sexo;
import nucleo.TipoEvento;
import nucleo.Universidad;

/**
 * PROVISIONAL SOLO PARA IR PROBANDO
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 *
 */
public final class Rellenadora {
	private Rellenadora() {}
	
	private static File f = new File("datos.dat");
	
	public static void rellenarDatos() throws Exception{
		if(f.delete())
			f.createNewFile();

		RandomAccessFile r = new RandomAccessFile(f, "rw");

		Datos d = new Datos(rellenarUniversidad(), rellenarUsuarios());
		byte[] b = Convert.toBytes(d);
		r.writeInt(b.length);
		r.write(b);

		r.close();
	}

	private static Universidad rellenarUniversidad() {
		Universidad u = Universidad.getInstancia(new Historia13Marzo("1234"));

		InfoGeneral informacionInfo = new InfoGeneral("Esta es la historia de Ingenier�a Inform�tica", "Estas son las curiosidades de Ingenier�a Inform�tica");
		Facultad info = new Facultad(NombreFacultad.INFORMATICA, informacionInfo, 90);
		
		InfoGeneral informacionArq = new InfoGeneral("Esta es la historia de Arquitectura", "Estas son las curiosidades de Arquitectura");
		Facultad arq = new Facultad(NombreFacultad.ARQUITECTURA, informacionArq, 80);
		
		InfoGeneral informacionAut = new InfoGeneral("Esta es la historia de Ingenier�a Autom�tica", "Estas son las curiosidades de Ingenier�a Autom�tica");
		Facultad aubi = new Facultad(NombreFacultad.AUTOMATICA_BIOMEDICA, informacionAut, 70);
		
		InfoGeneral informacionCivil = new InfoGeneral("Esta es la historia de Ingenier�a Civil", "Estas son las curiosidades de Ingenier�a Civil");
		Facultad civil = new Facultad(NombreFacultad.CIVIL, informacionCivil, 60);
		
		InfoGeneral informacionElect = new InfoGeneral("Esta es la historia de Ingenier�a El�ctrica", "Estas son las curiosidades de Ingenier�a El�ctrica");
		Facultad elect = new Facultad(NombreFacultad.ELECTRICA, informacionElect, 50);
		
		InfoGeneral informacionIndu = new InfoGeneral("Esta es la historia de Ingenier�a Industrial", "Estas son las curiosidades de Ingenier�a Industrial");
		Facultad indu = new Facultad(NombreFacultad.INDUSTRIAL, informacionIndu, 40);
		
		InfoGeneral informacionMec = new InfoGeneral("Esta es la historia de Ingenier�a Mec�nica", "Estas son las curiosidades de Ingenier�a Mec�nica");
		Facultad mec = new Facultad(NombreFacultad.MECANICA, informacionMec, 30);
		
		InfoGeneral informacionQuim = new InfoGeneral("Esta es la historia de Ingenier�a Qu�mica", "Estas son las curiosidades de Ingenier�a Qu�mica");
		Facultad quim = new Facultad(NombreFacultad.QUIMICA, informacionQuim, 20);
		
		InfoGeneral informacionTele = new InfoGeneral("Esta es la historia de Ingenier�a en Telecomunicaciones", "Estas son las curiosidades de Ingenier�a en Telecomunicaciones");
		Facultad tele = new Facultad(NombreFacultad.TELECOMUNICACIONES, informacionTele, 10);

		u.addFacultad(info);
		u.addFacultad(arq);
		u.addFacultad(aubi);
		u.addFacultad(civil);
		u.addFacultad(elect);
		u.addFacultad(indu);
		u.addFacultad(mec);
		u.addFacultad(quim);
		u.addFacultad(tele);
		
		u.ingresarEvento(new Evento(new Deporte("F�tbol", null, Sexo.FEMENINO,null), info, arq, LocalTime.of(15, 30), TipoEvento.EVT1), LocalDate.of(2023, 06, 11));
		u.ingresarEvento(new Evento(new Deporte("Nataci�n", null, Sexo.FEMENINO,null), info, quim, LocalTime.of(23, 54), TipoEvento.EVT2), LocalDate.of(2023, 06, 11));
		u.ingresarEvento(new Evento(new Deporte("Tiro", null, Sexo.FEMENINO,null), tele, arq, LocalTime.of(22, 15), TipoEvento.EVT3), LocalDate.of(2023, 06, 11));
		u.ingresarEvento(new Evento(new Deporte("Atletismo", null, Sexo.MASCULINO,null), civil, info, LocalTime.of(23, 56), TipoEvento.EVT3), LocalDate.of(2023, 06, 12));
		
		
		return u;
	}

	private static Usuarios rellenarUsuarios() {
		Usuarios u = Usuarios.getInstancia();

		u.ingresarUsuario(new UsuarioAdmin("admin@ceis.cujae.edu.cu","1234","Admin"));
		u.ingresarUsuario(new UsuarioEstudiante("info@ceis.cujae.edu.cu","1234","Dios de la Cujae"));
		u.ingresarUsuario(new UsuarioEstudiante("tele@telecomunicaciones.cujae.edu.cu","1234","Funcionario de Etecsa"));
		u.ingresarUsuario(new UsuarioEstudiante("arqu@arquitectura.cujae.edu.cu","1234","Gay"));
		u.ingresarUsuario(new UsuarioEstudiante("aubi@automatica.cujae.edu.cu","1234","Frustrado"));
		u.ingresarUsuario(new UsuarioEstudiante("civi@civil.cujae.edu.cu","1234","Alba�il"));
		u.ingresarUsuario(new UsuarioEstudiante("elec@electrica.cujae.edu.cu","1234", "Cobrador de la Luz"));
		u.ingresarUsuario(new UsuarioEstudiante("indu@industrial.cujae.edu.cu","1234", "T�cnico Medio"));
		u.ingresarUsuario(new UsuarioEstudiante("meca@mecanica.cujae.edu.cu","1234", "Chapista"));
		u.ingresarUsuario(new UsuarioEstudiante("quim@quimica.cujae.edu.cu","1234", "Elaboradora de Novatropin"));

		return u;
	}
	
	public static void borrarDatos() {
		f.delete();
	}
	
}
