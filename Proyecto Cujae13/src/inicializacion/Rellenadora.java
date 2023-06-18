package inicializacion;

import java.io.File;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalTime;

import clasesAuxiliares.UsuarioAdmin;
import clasesAuxiliares.UsuarioEstudiante;
import nucleo.Deporte;
import nucleo.Evento;
import nucleo.EventoFinalizado;
import nucleo.Facultad;
import nucleo.Historia13Marzo;
import nucleo.InfoGeneral;
import nucleo.NombreFacultad;
import nucleo.ResultadoEvento;
import nucleo.Sexo;
import nucleo.TipoEvento;
import nucleo.TipoInfraccion;
import nucleo.TipoSancion;
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
		Universidad u = Universidad.getInstancia(new Historia13Marzo("Esta es la historia de los juegos 13 de marzo"),LocalDate.now().minusDays(20));

		InfoGeneral informacionInfo = new InfoGeneral("Esta es la historia de Ingeniería Informática", "Estas son las curiosidades de Ingeniería Informática");
		Facultad info = new Facultad(NombreFacultad.INFORMATICA, informacionInfo, 90);
		
		InfoGeneral informacionArq = new InfoGeneral("Esta es la historia de Arquitectura", "Estas son las curiosidades de Arquitectura");
		Facultad arq = new Facultad(NombreFacultad.ARQUITECTURA, informacionArq, 80);
		
		InfoGeneral informacionAut = new InfoGeneral("Esta es la historia de Ingeniería Automática", "Estas son las curiosidades de Ingeniería Automática");
		Facultad aubi = new Facultad(NombreFacultad.AUTOMATICA_BIOMEDICA, informacionAut, 70);
		
		InfoGeneral informacionCivil = new InfoGeneral("Esta es la historia de Ingeniería Civil", "Estas son las curiosidades de Ingeniería Civil");
		Facultad civil = new Facultad(NombreFacultad.CIVIL, informacionCivil, 60);
		
		InfoGeneral informacionElect = new InfoGeneral("Esta es la historia de Ingeniería Eléctrica", "Estas son las curiosidades de Ingeniería Eléctrica");
		Facultad elect = new Facultad(NombreFacultad.ELECTRICA, informacionElect, 50);
		
		InfoGeneral informacionIndu = new InfoGeneral("Esta es la historia de Ingeniería Industrial", "Estas son las curiosidades de Ingeniería Industrial");
		Facultad indu = new Facultad(NombreFacultad.INDUSTRIAL, informacionIndu, 40);
		
		InfoGeneral informacionMec = new InfoGeneral("Esta es la historia de Ingeniería Mecánica", "Estas son las curiosidades de Ingeniería Mecánica");
		Facultad mec = new Facultad(NombreFacultad.MECANICA, informacionMec, 30);
		
		InfoGeneral informacionQuim = new InfoGeneral("Esta es la historia de Ingeniería Química", "Estas son las curiosidades de Ingeniería Química");
		Facultad quim = new Facultad(NombreFacultad.QUIMICA, informacionQuim, 20);
		
		InfoGeneral informacionTele = new InfoGeneral("Esta es la historia de Ingeniería en Telecomunicaciones", "Estas son las curiosidades de Ingeniería en Telecomunicaciones");
		Facultad tele = new Facultad(NombreFacultad.TELECOMUNICACIONES, informacionTele, 10);
		
		Deporte d1 = new Deporte("Fútbol", null, Sexo.FEMENINO,null);
		Deporte d2 = new Deporte("Natación", null, Sexo.FEMENINO,null);
		Deporte d3 = new Deporte("Tiro", null, Sexo.FEMENINO,null);
		Deporte d4 = new Deporte("Atletismo", null, Sexo.MASCULINO,null);
		
		u.addDeporte(d1);
		u.addDeporte(d2);
		u.addDeporte(d3);
		u.addDeporte(d4);
		
		d1.addInfraccion(TipoInfraccion.AGRESION_VERBAL, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "+
				"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa", NombreFacultad.INFORMATICA);
		d2.addInfraccion(TipoInfraccion.DECISIONES_ARBITRALES, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa", NombreFacultad.INDUSTRIAL);
		
		info.agregarSancion(TipoSancion.FRAUDE, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "+
				"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa");
		
		indu.agregarSancion(TipoSancion.INDISCIPLINA_GRAVE, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "+
				"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa");
		
		u.addFacultad(info);
		u.addFacultad(arq);
		u.addFacultad(aubi);
		u.addFacultad(civil);
		u.addFacultad(elect);
		u.addFacultad(indu);
		u.addFacultad(mec);
		u.addFacultad(quim);
		u.addFacultad(tele);
		
		u.ingresarEvento(new Evento(d1, info, arq, LocalTime.of(23, 30), TipoEvento.EVT1), LocalDate.now());
		u.ingresarEvento(new Evento(d2, info, quim, LocalTime.of(23, 15), TipoEvento.EVT2), LocalDate.now());
		u.ingresarEvento(new Evento(d3, tele, arq, LocalTime.of(23, 0), TipoEvento.EVT3), LocalDate.now());
		u.ingresarEvento(new Evento(d4, civil, info, LocalTime.of(23, 0), TipoEvento.EVT3), LocalDate.now());
		u.ingresarEvento(new Evento(d4, info, tele, LocalTime.of(22, 10), TipoEvento.EVT2), LocalDate.now().plusDays(1));
		
		
		u.ingresarEventoFinalizado(new EventoFinalizado(d1, mec, tele, LocalTime.of(13, 30), LocalTime.of(23, 30), new ResultadoEvento(tele), null), LocalDate.now().minusDays(2));
		u.ingresarEventoFinalizado(new EventoFinalizado(d2, info, mec, LocalTime.of(13, 30), LocalTime.of(23, 30), new ResultadoEvento(info), null), LocalDate.now());
		u.ingresarEventoFinalizado(new EventoFinalizado(d3, tele, info, LocalTime.of(13, 30), LocalTime.of(23, 30), new ResultadoEvento(tele), null), LocalDate.now().minusDays(1));
		u.ingresarEventoFinalizado(new EventoFinalizado(d4, info, indu, LocalTime.of(13, 30), LocalTime.of(23, 30), new ResultadoEvento(info), null), LocalDate.now());
		u.ingresarEventoFinalizado(new EventoFinalizado(d1, info, aubi, LocalTime.of(13, 30), LocalTime.of(23, 30), new ResultadoEvento(info), null), LocalDate.now());
		
		
		return u;
	}

	private static Usuarios rellenarUsuarios() {
		Usuarios u = Usuarios.getInstancia();

		u.ingresarUsuario(new UsuarioAdmin("admin@ceis.cujae.edu.cu","1234","Admin"));
		u.ingresarUsuario(new UsuarioEstudiante("info@ceis.cujae.edu.cu","1234","Dios de la Cujae"));
		u.ingresarUsuario(new UsuarioEstudiante("tele@telecomunicaciones.cujae.edu.cu","1234","Funcionario de Etecsa"));
		u.ingresarUsuario(new UsuarioEstudiante("arqu@arquitectura.cujae.edu.cu","1234","Gay"));
		u.ingresarUsuario(new UsuarioEstudiante("aubi@automatica.cujae.edu.cu","1234","Frustrado"));
		u.ingresarUsuario(new UsuarioEstudiante("civi@civil.cujae.edu.cu","1234","Albañil"));
		u.ingresarUsuario(new UsuarioEstudiante("elec@electrica.cujae.edu.cu","1234", "Cobrador de la Luz"));
		u.ingresarUsuario(new UsuarioEstudiante("indu@industrial.cujae.edu.cu","1234", "Técnico Medio"));
		u.ingresarUsuario(new UsuarioEstudiante("meca@mecanica.cujae.edu.cu","1234", "Chapista"));
		u.ingresarUsuario(new UsuarioEstudiante("quim@quimica.cujae.edu.cu","1234", "Elaboradora de Novatropin"));

		return u;
	}
	
	public static void borrarDatos() {
		f.delete();
	}
	
}
