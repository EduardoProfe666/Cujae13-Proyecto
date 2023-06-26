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
import nucleo.Deporte;
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
		
		
		List<HistoricoFacultad> historico = new LinkedList<HistoricoFacultad>(Arrays.asList(new HistoricoFacultad(info, 40),
				new HistoricoFacultad(arq, 0), new HistoricoFacultad(aubi, 0), new HistoricoFacultad(civil, 500), new HistoricoFacultad(elect, 650), 
				new HistoricoFacultad(indu, 870), new HistoricoFacultad(mec, 160), new HistoricoFacultad(quim, 0), new HistoricoFacultad(tele, 110)));
		
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
		
		Localizacion dojo = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("Karate"))), "Dojo","/interfaz/imagenes/avatar_autenticacion.jpg",323,301);
		
		Localizacion bajos19 = new Localizacion(new LinkedList<Deporte>(),"Bajos del Edificio 19 de Informática","/interfaz/imagenes/avatar_autenticacion.jpg",144,206);
		Localizacion pistaAtletismo = new Localizacion(new LinkedList<Deporte>(),"Pista de Atletismo","/interfaz/imagenes/avatar_autenticacion.jpg",656,343);
		Localizacion terrenoPelota = new Localizacion(new LinkedList<Deporte>(),"Terreno de Pelota","/interfaz/imagenes/avatar_autenticacion.jpg",558,427);
		
		Localizacion terrenoFutbol = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("Fútbol"))), "Terreno de Fútbol","/interfaz/imagenes/avatar_autenticacion.jpg",455,450);
		Localizacion canchasVolleyBall1 = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("VolleyBall"))), "Canchas de VolleyBall 1","/interfaz/imagenes/avatar_autenticacion.jpg",432,416);
		
		Localizacion canchasVolleyBall2 = new Localizacion(new LinkedList<Deporte>(),"Canchas de VolleyBall 2","/interfaz/imagenes/avatar_autenticacion.jpg",420,353);
		Localizacion canchasBasketBall =  new Localizacion(new LinkedList<Deporte>(),"Canchas de BasketBall","/interfaz/imagenes/avatar_autenticacion.jpg",452,380);
		Localizacion piscinaNatacion =  new Localizacion(new LinkedList<Deporte>(),"Piscina de Natación","/interfaz/imagenes/avatar_autenticacion.jpg",509,328);
		
		Localizacion deder = new Localizacion(u.getDeportes(new LinkedList<String>(Arrays.asList("Bádminton"))), "DEDER","/interfaz/imagenes/avatar_autenticacion.jpg",495,404);
		
		Localizacion localDeder = new Localizacion(new LinkedList<Deporte>(),"Local del DEDER","/interfaz/imagenes/avatar_autenticacion.jpg",495,439);
		Localizacion bajosArquitectura = new Localizacion(new LinkedList<Deporte>(),"Bajos del Edificio de Arquitectura","/interfaz/imagenes/avatar_autenticacion.jpg",101,397);
		
		localizaciones.insertWVertex(dojo, true);
		localizaciones.insertWVertex(bajos19, true);
		localizaciones.insertWVertex(pistaAtletismo, true);
		localizaciones.insertWVertex(terrenoPelota, true);
		localizaciones.insertWVertex(terrenoFutbol, true);
		localizaciones.insertWVertex(canchasVolleyBall1, true);
		localizaciones.insertWVertex(canchasVolleyBall2, true);
		localizaciones.insertWVertex(canchasBasketBall, true);
		localizaciones.insertWVertex(piscinaNatacion, true);
		localizaciones.insertWVertex(deder, true);
		localizaciones.insertWVertex(localDeder, true);
		localizaciones.insertWVertex(bajosArquitectura, true);
		
		inicializarDistancias(localizaciones);
		
		return u;
	}
	
	private static void inicializarDistancias(ILinkedWeightedEdgeWeightedVertexNotDirectedGraph<Localizacion, Boolean, Integer> localizaciones) {
		//Distancias de Dojo
		localizaciones.insertWEdgeNDG(0, 1, 100);
		localizaciones.insertWEdgeNDG(0, 2, 100);
		localizaciones.insertWEdgeNDG(0, 3, 100);
		localizaciones.insertWEdgeNDG(0, 4, 100);
		localizaciones.insertWEdgeNDG(0, 5, 100);
		localizaciones.insertWEdgeNDG(0, 6, 100);
		localizaciones.insertWEdgeNDG(0, 7, 100);
		localizaciones.insertWEdgeNDG(0, 8, 100);
		localizaciones.insertWEdgeNDG(0, 9, 100);
		localizaciones.insertWEdgeNDG(0, 10, 100);
		localizaciones.insertWEdgeNDG(0, 11, 100);
		
		//Distancia de Bajos del 19 de Informática
		localizaciones.insertWEdgeNDG(1, 2, 100);
		localizaciones.insertWEdgeNDG(1, 3, 100);
		localizaciones.insertWEdgeNDG(1, 4, 100);
		localizaciones.insertWEdgeNDG(1, 5, 100);
		localizaciones.insertWEdgeNDG(1, 6, 100);
		localizaciones.insertWEdgeNDG(1, 7, 100);
		localizaciones.insertWEdgeNDG(1, 8, 100);
		localizaciones.insertWEdgeNDG(1, 9, 100);
		localizaciones.insertWEdgeNDG(1, 10, 100);
		localizaciones.insertWEdgeNDG(1, 11, 100);
		
		//Distancia de Pista de Atletismo
		localizaciones.insertWEdgeNDG(2, 3, 100);
		localizaciones.insertWEdgeNDG(2, 4, 100);
		localizaciones.insertWEdgeNDG(2, 5, 100);
		localizaciones.insertWEdgeNDG(2, 6, 100);
		localizaciones.insertWEdgeNDG(2, 7, 100);
		localizaciones.insertWEdgeNDG(2, 8, 100);
		localizaciones.insertWEdgeNDG(2, 9, 100);
		localizaciones.insertWEdgeNDG(2, 10, 100);
		localizaciones.insertWEdgeNDG(2, 11, 100);
		
		//Distancia de Terreno de Pelota
		localizaciones.insertWEdgeNDG(3, 4, 100);
		localizaciones.insertWEdgeNDG(3, 5, 100);
		localizaciones.insertWEdgeNDG(3, 6, 100);
		localizaciones.insertWEdgeNDG(3, 7, 100);
		localizaciones.insertWEdgeNDG(3, 8, 100);
		localizaciones.insertWEdgeNDG(3, 9, 100);
		localizaciones.insertWEdgeNDG(3, 10, 100);
		localizaciones.insertWEdgeNDG(3, 11, 100);
		
		//Distancia de Terreno de Fútbol
		localizaciones.insertWEdgeNDG(4, 5, 100);
		localizaciones.insertWEdgeNDG(4, 6, 100);
		localizaciones.insertWEdgeNDG(4, 7, 100);
		localizaciones.insertWEdgeNDG(4, 8, 100);
		localizaciones.insertWEdgeNDG(4, 9, 100);
		localizaciones.insertWEdgeNDG(4, 10, 100);
		localizaciones.insertWEdgeNDG(4, 11, 100);
		
		//Distancia de Canchas de VolleyBall 1
		localizaciones.insertWEdgeNDG(5, 6, 100);
		localizaciones.insertWEdgeNDG(5, 7, 100);
		localizaciones.insertWEdgeNDG(5, 8, 100);
		localizaciones.insertWEdgeNDG(5, 9, 100);
		localizaciones.insertWEdgeNDG(5, 10, 100);
		localizaciones.insertWEdgeNDG(5, 11, 100);
		
		//Distancia de Canchas de VolleyBall 2
		localizaciones.insertWEdgeNDG(6, 7, 100);
		localizaciones.insertWEdgeNDG(6, 8, 100);
		localizaciones.insertWEdgeNDG(6, 9, 100);
		localizaciones.insertWEdgeNDG(6, 10, 100);
		localizaciones.insertWEdgeNDG(6, 11, 100);
		
		//Distancia de Canchas de BasketBall
		localizaciones.insertWEdgeNDG(7, 8, 100);
		localizaciones.insertWEdgeNDG(7, 9, 100);
		localizaciones.insertWEdgeNDG(7, 10, 100);
		localizaciones.insertWEdgeNDG(7, 11, 100);
		
		//Distancia de Piscina de Natación
		localizaciones.insertWEdgeNDG(8, 9, 100);
		localizaciones.insertWEdgeNDG(8, 10, 100);
		localizaciones.insertWEdgeNDG(8, 11, 100);
		
		//Distancia de DEDER
		localizaciones.insertWEdgeNDG(9, 10, 100);
		localizaciones.insertWEdgeNDG(9, 11, 100);
		
		//Distancia de Local del DEDER
		localizaciones.insertWEdgeNDG(10, 11, 100);
		
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
