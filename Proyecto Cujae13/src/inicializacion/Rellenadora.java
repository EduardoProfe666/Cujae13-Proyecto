package inicializacion;

import java.io.File;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import clasesAuxiliares.UsuarioAdmin;
import clasesAuxiliares.UsuarioEstudiante;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeWeightedVertexNotDirectedGraph;
import nucleo.Facultad;
import nucleo.Historia13Marzo;
import nucleo.HistoricoFacultad;
import nucleo.InfoGeneral;
import nucleo.InicializacionPartidosDeporte;
import nucleo.InicializacionPartidosDeporte.FechaHora;
import nucleo.InicializacionPartidosDeporte.ListadoFechaHora;
import nucleo.Localizacion;
import nucleo.NombreFacultad;
import nucleo.Sexo;
import nucleo.TipoDeporte;
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

		InfoGeneral informacionInfo = new InfoGeneral("Esta es la historia de Ingeniería Informática", "Estas son las curiosidades de Ingeniería Informática");
		Facultad info = new Facultad(NombreFacultad.INFORMATICA, informacionInfo);
		
		InfoGeneral informacionArq = new InfoGeneral("Esta es la historia de Arquitectura", "Estas son las curiosidades de Arquitectura");
		Facultad arq = new Facultad(NombreFacultad.ARQUITECTURA, informacionArq);
		
		InfoGeneral informacionAut = new InfoGeneral("Esta es la historia de Ingeniería Automática", "Estas son las curiosidades de Ingeniería Automática");
		Facultad aubi = new Facultad(NombreFacultad.AUTOMATICA_BIOMEDICA, informacionAut);
		
		InfoGeneral informacionCivil = new InfoGeneral("Esta es la historia de Ingeniería Civil", "Estas son las curiosidades de Ingeniería Civil");
		Facultad civil = new Facultad(NombreFacultad.CIVIL, informacionCivil);
		
		InfoGeneral informacionElect = new InfoGeneral("Esta es la historia de Ingeniería Eléctrica", "Estas son las curiosidades de Ingeniería Eléctrica");
		Facultad elect = new Facultad(NombreFacultad.ELECTRICA, informacionElect);
		
		InfoGeneral informacionIndu = new InfoGeneral("Esta es la historia de Ingeniería Industrial", "Estas son las curiosidades de Ingeniería Industrial");
		Facultad indu = new Facultad(NombreFacultad.INDUSTRIAL, informacionIndu);
		
		InfoGeneral informacionMec = new InfoGeneral("Esta es la historia de Ingeniería Mecánica", "Estas son las curiosidades de Ingeniería Mecánica");
		Facultad mec = new Facultad(NombreFacultad.MECANICA, informacionMec);
		
		InfoGeneral informacionQuim = new InfoGeneral("Esta es la historia de Ingeniería Química", "Estas son las curiosidades de Ingeniería Química");
		Facultad quim = new Facultad(NombreFacultad.QUIMICA, informacionQuim);
		
		InfoGeneral informacionTele = new InfoGeneral("Esta es la historia de Ingeniería en Telecomunicaciones", "Estas son las curiosidades de Ingeniería en Telecomunicaciones");
		Facultad tele = new Facultad(NombreFacultad.TELECOMUNICACIONES, informacionTele);
		
		
		List<HistoricoFacultad> historico = new LinkedList<HistoricoFacultad>(Arrays.asList(new HistoricoFacultad(info, 10),
				new HistoricoFacultad(arq, 9), new HistoricoFacultad(aubi, 8), new HistoricoFacultad(civil, 7), new HistoricoFacultad(elect, 6), 
				new HistoricoFacultad(indu, 5), new HistoricoFacultad(mec, 4), new HistoricoFacultad(quim, 3), new HistoricoFacultad(tele, 2)));
		
		Universidad u = Universidad.getInstancia(new Historia13Marzo(historico,"Esta es la historia de los juegos 13 de marzo"),LocalDate.now().minusDays(20));
		
		//NO ALTERAR EL ORDEN POR LOS LISTENERS
		
		u.addFacultad(info);
		u.addFacultad(arq);
		u.addFacultad(aubi);
		u.addFacultad(civil);
		u.addFacultad(elect);
		u.addFacultad(indu);
		u.addFacultad(mec);
		u.addFacultad(quim);
		u.addFacultad(tele);
		
		u.addDeporte("Bádminton", Sexo.FEMENINO,TipoDeporte.DEPORTE_COLECTIVO);
		u.addDeporte("Karate", Sexo.FEMENINO,TipoDeporte.DEPORTE_INDIVIDUAL);
		u.addDeporte("Fútbol", Sexo.FEMENINO,TipoDeporte.DEPORTE_COLECTIVO);
		u.addDeporte("VolleyBall", Sexo.MASCULINO,TipoDeporte.DEPORTE_COLECTIVO);
		
		u.inicializarTorneoDeporte(new InicializacionPartidosDeporte(u.buscarDeporte("Bádminton"), quim, tele,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.now())),
				u.getListadoFacultades()));
		
		u.inicializarTorneoDeporte(new InicializacionPartidosDeporte(u.buscarDeporte("Karate"), aubi, civil,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.now())),
				u.getListadoFacultades()));
		
		u.inicializarTorneoDeporte(new InicializacionPartidosDeporte(u.buscarDeporte("Fútbol"), indu, mec,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.now())),
				u.getListadoFacultades()));
		
		u.inicializarTorneoDeporte(new InicializacionPartidosDeporte(u.buscarDeporte("VolleyBall"), arq, info,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(2), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()), new FechaHora(LocalDate.now().plusDays(3), LocalTime.now()),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.now())),
				u.getListadoFacultades()));
		
		ILinkedWeightedEdgeWeightedVertexNotDirectedGraph<Localizacion, Boolean, Integer> localizaciones = u.getLocalizaciones();
		
		Localizacion deder = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("Bádminton"))), "Deder","/interfaz/imagenes/avatar_autenticacion.jpg",137,196);
		Localizacion dojo = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("Karate"))), "Dojo","/interfaz/imagenes/avatar_autenticacion.jpg",87,385);
		Localizacion terrenoFutbol = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("Fútbol"))), "Terreno de Fútbol","/interfaz/imagenes/avatar_autenticacion.jpg",780,154);
		Localizacion canchasVolleyBall = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("VolleyBall"))), "Canchas de VolleyBall","/interfaz/imagenes/avatar_autenticacion.jpg",420,430);
		
		localizaciones.insertWVertex(deder, true);
		localizaciones.insertWVertex(dojo, true);
		localizaciones.insertWVertex(terrenoFutbol, true);
		localizaciones.insertWVertex(canchasVolleyBall, true);
		
		localizaciones.insertWEdgeNDG(deder, dojo, 100);
		localizaciones.insertWEdgeNDG(deder, terrenoFutbol, 200);
		localizaciones.insertWEdgeNDG(deder, canchasVolleyBall, 210);
		
		localizaciones.insertWEdgeNDG(dojo, terrenoFutbol, 50);
		localizaciones.insertWEdgeNDG(dojo, canchasVolleyBall, 75);
		
		localizaciones.insertWEdgeNDG(terrenoFutbol, canchasVolleyBall, 130);
		
		u.buscarDeporte("Fútbol").addInfraccion(TipoInfraccion.AGRESION_VERBAL, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "+
				"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa", NombreFacultad.QUIMICA);
		u.buscarDeporte("Bádminton").addInfraccion(TipoInfraccion.DECISIONES_ARBITRALES, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa", NombreFacultad.INDUSTRIAL);
		
		u.buscarFacultad(NombreFacultad.ELECTRICA).agregarSancion(TipoSancion.FRAUDE, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "+
				"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa");
		
		u.buscarFacultad(NombreFacultad.INDUSTRIAL).agregarSancion(TipoSancion.INDISCIPLINA_GRAVE, "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "+
				"aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa "
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa"
				+ "aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa aaaa");
		
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
