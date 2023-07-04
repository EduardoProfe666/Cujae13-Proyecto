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
import nucleo.Universidad;

/**
 * Datos de prueba para probar el funcionamiento correcto de la aplicacion
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public final class Rellenadora {
	private Rellenadora() {}
	
	private static File f = new File("datos.dat");
	
	/**
	 * Permite crear un fichero con datos de prueba de la aplicacion en memoria externa
	 * 
	 * @throws Exception Si existe algun problema con los datos en memoria externa
	 */
	public static void rellenarDatos() throws Exception{
		if(f.delete())
			f.createNewFile();

		RandomAccessFile r = new RandomAccessFile(f, "rw");

		Datos d = new Datos(rellenarUniversidad(), rellenarUsuarios());
		byte[] b = Convert.toBytes(d);
		r.writeInt(b.length);
		r.write(b);
		
		//Validacion de Fecha
		b = Convert.toBytes(LocalDate.now());
		r.writeInt(b.length);
		r.write(b);

		r.close();
	}

	/**
	 * 
	 * Permite generar una universidad con datos de prueba
	 * 
	 * @return Universidad u generada
	 */
	private static Universidad rellenarUniversidad() {

		String hcInfo = "La Facultad de Ingeniería Informática en sus inicios se encontraba formando parte de "
				+ "la Facultad de Ingeniería Industrial. En el año 2007 surge como facultad independiente creando"
				+ " su propia identidad.\r\n\n"
				+ "Como todas las facultades, debía escoger un color y una mascota que la representara en los "
				+ "Juegos 13 de Marzo; al no encontrarse dentro de las primeras facultades existentes y surgir "
				+ "luego de seleccionados los colores y mascotas por la mayoría de facultades, no poseía muchas "
				+ "opciones de color por lo que en un principio escogió el naranja, pero en el momento de impresión"
				+ " de los pullover para los juegos este color no se encontraba disponible y tuvo la opción de ser"
				+ " cambiado al reconocido y actual amarillo que representa a la facultad año tras año en el "
				+ "período deportivo. En cuanto a la mascota se tuvo en cuenta que al proceder de la Facultad "
				+ "de Industrial se buscara un animal relacionado con el delfín pero que fuera reconocido por ser"
				+ " más fuerte y poderoso, de ahí que se seleccionara la orca, tipo de delfín conocido por ser el"
				+ " más grande y temido de su especie.\r\n\n"
				+ "Debido a la separación de las facultades, Informática perdió al entrenador y coreografía de la"
				+ " tabla gimnástica que presentaba cada año y obtenía excelentes resultados, para su primera "
				+ "presentación como facultad tuvo que empezar de cero en estos aspectos y es importante destacar"
				+ " que, a pesar de todas las adversidades, ese año la facultad obtuvo el primer lugar en la "
				+ "disciplina de la tabla gimnástica.\r\n\n"
				+ "Otra curiosidad de Informática es que ninguna otra facultad tiene una jefa de administración "
				+ "que radique en el edificio docente y lleve el control de la limpieza y organización de las "
				+ "aulas, así como se ocupe amablemente de resolver cualquier situación a su alcance en relación"
				+ " con los estudiantes y profesores como lo hace Sirenia Lobato.\r\n\n"
				+ "Entre sus tradiciones está la realización de una caldosa para recibir a los estudiantes de"
				+ " nuevo ingreso y motivarlos a la integración e identificación con la facultad.\r\n\n"
				+ "Para finalizar, resaltar que varios de los dirigentes de la universidad son graduados de la "
				+ "carrera de informática, entre ellos se encuentran: el rector Modesto R. Gómez, la vicerrectora "
				+ "primera Marta Dunia Delgado y la vicerrectora docente Anaysa Hernández.\r\n\n"
				+ "";
		InfoGeneral informacionInfo = new InfoGeneral(hcInfo);
		Facultad info = new Facultad(NombreFacultad.INFORMATICA, informacionInfo);
		
		String hcArq = "La Facultad de Arquitectura se encuentra entre las facultades fundadoras de la universidad."
				+ " Para la facultad la elección del color estuvo dada por el desarrollo de un evento que conllevó"
				+ " a la impresión de pullover verdes, por lo que en los juegos al ya tener las prendas con ese "
				+ "color decidieron tomarlo como el color representativo de la facultad. En cuanto a la mascota, "
				+ "surge luego de seleccionado el color, al encontrarse en el dilema de buscar un animal que "
				+ "luciera como buena combinación junto al verde, por lo que se determinó seleccionar el cocodrilo"
				+ " que hoy los representa en cada Juego 13 de Marzo.\r\n\n"
				+ "La facultad cuenta con la fiesta tradicional “La Vela” como recibimiento a los estudiantes de "
				+ "nuevo ingreso, donde se realizan juegos de participación.\r\n\n"
				+ "Es importante destacar que la Facultad de Arquitectura es la facultad con mayor cantidad de "
				+ "Juegos 13 de Marzo perdidos, con un total de 20 juegos perdidos desde 1994.\r\n\n"
				+ "";
		InfoGeneral informacionArq = new InfoGeneral(hcArq);
		Facultad arq = new Facultad(NombreFacultad.ARQUITECTURA, informacionArq);
		
		String hcAut = "La Facultad de Ingeniería Automática en sus inicios se encontraba formando parte de la "
				+ "Facultad de Ingeniería Eléctrica, en el año 2017 surge como facultad independiente creando su"
				+ " propia identidad.\r\n\n"
				+ "Como todas las facultades, debía escoger un color y una mascota que la representara en los "
				+ "Juegos 13 de Marzo; al ser una de las últimas facultades fundadas sus opciones de color eran"
				+ " muy limitadas, se encontraban entre el naranja, el rosado y el marrón; por lo que la decisión"
				+ " de color fue finalmente naranja, por ser el más neutral. En cuanto a la mascota, fue escogida"
				+ " por medio de encuestas y votaciones entre los estudiantes de la facultad que consideraron al"
				+ " tigre como una buena opción para que los representara.\r\n\n"
				+ "La Facultad de Automática tiene dentro a las carreras universitarias Ingeniería Automática e"
				+ " Ingeniería Biomédica; así como 2 Técnicos Superiores: Mantenimiento para Turismo y "
				+ "Metrología.\r\n\n"
				+ " ";
		InfoGeneral informacionAut = new InfoGeneral(hcAut);
		Facultad aubi = new Facultad(NombreFacultad.AUTOMATICA_BIOMEDICA, informacionAut);
		
		String hcCiv = "La Facultad de Ingeniería Civil pertenece a la Universidad Tecnológica de La Habana "
				+ "CUJAE desde el año 1964, siendo una de las facultades más antiguas de la universidad.\r\n\n"
				+ "El primer color que seleccionó la facultad para que la representara en los Juegos 13 de Marzo"
				+ " fue el naranja, pero como Informática, en el momento de imprimir los pullover de los jugadores"
				+ " no se contaba con ese color, por lo que se decidieron por el actual gris que se encontraba "
				+ "disponible, y a su vez es el color del cemento, material esencial en su trabajo. En cuanto a "
				+ "la mascota se eligió por la buena combinación con el gris y la fortaleza que representan los"
				+ " tiburones en su hábitat.\r\n\n"
				+ "La facultad cuenta con una fiesta tradicional conocida como “La Máscara”, donde se realizan"
				+ " juegos de participación y bailes, y cuenta con la característica de que el vestuario portado"
				+ " debe ser elegante y llevar consigo una máscara.\r\n\n"
				+ "La Facultad de Civil tiene dentro a las carreras universitarias Ingeniería Civil, Ingeniería"
				+ " Hidráulica e Ingeniería Geofísica, siendo esta última solo estudiada en la CUJAE a nivel "
				+ "nacional.\r\n\n"
				+ "Es importante destacar que la facultad se encuentra entre las 3 facultades con mayor cantidad"
				+ " de Juegos 13 de Marzo ganados.\r\n\n"
				+ "";
		InfoGeneral informacionCivil = new InfoGeneral(hcCiv);
		Facultad civil = new Facultad(NombreFacultad.CIVIL, informacionCivil);
		
		String hcElec = "La Facultad de Ingeniería Eléctrica se encuentra entre las facultades fundadoras de la"
				+ " universidad. En sus inicios estaba compuesta además por las hoy facultades de Automática y "
				+ "Telecomunicaciones. \r\n\n"
				+ "Al ser de las primeras facultades existentes contaron con más opciones en el momento de elegir "
				+ "el color que lo representaría. La elección del azul estuvo dada porque este color era "
				+ "representativo del sector eléctrico y se terminó asumiendo como representativo de la facultad."
				+ " En cuanto a la mascota, buscaron un animal que los representara según las características "
				+ "propias de la carrera, por lo que se terminó escogiendo la manta raya, conocida por emplear "
				+ "descargas eléctricas para paralizar a sus presas o para defenderse.\r\n\n"
				+ "Es importante destacar que la Facultad de Eléctrica se encuentra entre las 3 facultades con "
				+ "mayor cantidad de Juegos 13 de Marzo ganados, principalmente antes de producirse la separación "
				+ "de las facultades de Automática y Telecomunicaciones.\r\n\n"
				+ "";
		InfoGeneral informacionElect = new InfoGeneral(hcElec);
		Facultad elect = new Facultad(NombreFacultad.ELECTRICA, informacionElect);
		
		String hcInd = "La Facultad de Ingeniería Industrial se encuentra entre las primeras facultades que "
				+ "surgieron en la universidad. En sus inicios estaba compuesta además por la hoy Facultad de "
				+ "Ingeniería Informática.\r\n\n"
				+ "Al ser de las primeras facultades existentes contaron con más opciones en el momento de"
				+ " elegir el color. En un inicio su selección fue el azul pálido, pero cuando se imprimieron "
				+ "los pullover la tonalidad de azul que se encontraba disponible era la de eléctrica que terminó"
				+ " por quedarse totalmente con el color y conllevó a que Industrial tuviera que elegir el blanco,"
				+ " color que se asumió como símbolo de inteligencia y sabiduría, en conjunto con la mascota, "
				+ "seleccionada con esa misma concepción.\r\n\n"
				+ "Es importante destacar que la facultad se encuentra posicionada como la facultad con mayor"
				+ " cantidad de Juegos 13 de Marzo ganados a través de la historia, con un total de 12 juegos"
				+ " ganados desde 1994.\r\n\n"
				+ "";
		InfoGeneral informacionIndu = new InfoGeneral(hcInd);
		Facultad indu = new Facultad(NombreFacultad.INDUSTRIAL, informacionIndu);
		
		String hcMec = "La Facultad de Ingeniería Mecánica se encuentra entre las primeras facultades que "
				+ "surgieron en la universidad.\r\n\n"
				+ "La elección del color y la mascota estuvo dada por unas votaciones que tuvieron lugar en el"
				+ " año 1999, donde resultaron ganadores el color rojo y el león, con el fin de que los "
				+ "representara en los Juegos 13 de Marzo.\r\n\n"
				+ "Es reconocida desde sus inicios por ser la facultad con una matrícula principalmente de "
				+ "varones y que se ha mantenido con esa característica hasta la actualidad.\r\n\n"
				+ "La Facultad de Mecánica tiene dentro a las carreras universitarias Ingeniería Mecánica e"
				+ " Ingeniería en Metalurgia y Materiales; así como el Técnicos Superior de Transporte.\r\n\n"
				+ "La facultad se identifica con la frase: “Ser mecánico es un sentido de la vida”.\r\n\n"
				+ "";
		InfoGeneral informacionMec = new InfoGeneral(hcMec);
		Facultad mec = new Facultad(NombreFacultad.MECANICA, informacionMec);
		
		String hcQuim = "La facultad de Ingeniería Química se encuentra entre las primeras facultades que "
				+ "surgieron en la universidad. Aparece desde el año 1962, cuando la CUJAE era aún una facultad "
				+ "más de la Universidad de La Habana, en ese entonces conocida como la Facultad de Tecnología."
				+ " En sus inicios se dividía en 2 facultades: una estudiaba la Tecnología de los Procesos Químicos"
				+ " y la Tecnología de los procesos Alimentarios y la otra la Tecnología de las Producciones "
				+ "Azucareras.\r\n\n"
				+ "Al encontrarse entre las primeras facultades existentes contó con más posibilidades a la hora"
				+ " de elegir el color; su elección fue el color negro para representarla en los Juegos 13 de "
				+ "Marzo; en correspondencia con este se escogió la mascota, teniendo en cuenta una buena "
				+ "combinación entre estos.\r\n\n"
				+ "La facultad comenzó a realizar en el año 2023 una fiesta tradicional propia a la que "
				+ "denominaron “La Alquimia”, donde se realizan juegos de participación y competencias y cuenta"
				+ " con la particularidad de ser presentada por estudiantes vestidos con batas blancas en "
				+ "representación característica de los químicos.\r\n\n"
				+ "En cuanto a los Juegos 13 de Marzo, la Facultad de Química es la segunda con mayor cantidad "
				+ "de Juegos 13 de Marzo perdidos, con un total de 8 juegos, solo superada por Arquitectura.\r\n\n"
				+ "";
		InfoGeneral informacionQuim = new InfoGeneral(hcQuim);
		Facultad quim = new Facultad(NombreFacultad.QUIMICA, informacionQuim);
		
		String hcTele = "La Facultad de Ingeniería en Telecomunicaciones y Electrónica en sus inicios se encontraba"
				+ " formando parte de la Facultad de Ingeniería Eléctrica, en el año 2017 surge como facultad "
				+ "independiente creando su propia identidad.\r\n\n"
				+ "Como todas las facultades, debía escoger un color y una mascota que la representara en los "
				+ "Juegos 13 de Marzo; al ser una de las últimas facultades fundadas sus opciones de color eran"
				+ " muy limitadas y se terminó por seleccionar el color morado. En cuanto a la mascota, esta se "
				+ "escogió mediante una encuesta que arrojó como finalistas al murciélago y al lobo, por sus "
				+ "capacidades para comunicarse; resultando ganador el lobo que actualmente representa a la "
				+ "facultad y que trajo consigo que los estudiantes pertenecientes a esta facultad se sientan y "
				+ "traten como una manada desde su ingreso a la carrera.\r\n\n"
				+ "La facultad, a pesar de ser fundada recientemente, ya cuenta con un Juego 13 de Marzo ganado y"
				+ " excelentes lugares en las tablas de posiciones desde su surgimiento.\r\n\n"
				+ "";
		InfoGeneral informacionTele = new InfoGeneral(hcTele);
		Facultad tele = new Facultad(NombreFacultad.TELECOMUNICACIONES, informacionTele);
		
		
		List<HistoricoFacultad> historico = new LinkedList<HistoricoFacultad>(Arrays.asList(new HistoricoFacultad(info, 40),
				new HistoricoFacultad(arq, 0), new HistoricoFacultad(aubi, 0), new HistoricoFacultad(civil, 500), new HistoricoFacultad(elect, 650), 
				new HistoricoFacultad(indu, 870), new HistoricoFacultad(mec, 160), new HistoricoFacultad(quim, 0), new HistoricoFacultad(tele, 110)));
		
		Universidad u = Universidad.getInstancia(new Historia13Marzo(historico,"Antes de ser conformada la Universidad"
				+ " Tecnológica de La Habana esta era la Facultad Tecnológica perteneciente a la Universidad de La "
				+ "Habana. Históricamente se celebraban los Juegos Caribe como parte de la vida universitaria. Al"
				+ " surgir la CUJAE como universidad independiente adopta unos juegos deportivos propios, a los "
				+ "cuales denominó Juegos 13 de Marzo, en honor a José Antonio Echeverría, mártir que dio la vida "
				+ "por Cuba el 13 de marzo de 1957 y que forma parte representativa de los universitarios de la "
				+ "CUJAE."),
				LocalDate.now().minusDays(10));
		
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
		
		InicializacionPartidosDeporte inicBad = new InicializacionPartidosDeporte( quim, tele,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.of(12, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)), new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.of(9, 0))),
				u.getListadoFacultades());
		InicializacionPartidosDeporte inicKar = new InicializacionPartidosDeporte(aubi, civil,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1),LocalTime.of(12, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)), new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.of(9, 0))),
				u.getListadoFacultades());
		InicializacionPartidosDeporte inicFut = new InicializacionPartidosDeporte(indu, mec,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.of(12, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)), new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.of(9, 0))),
				u.getListadoFacultades());
		InicializacionPartidosDeporte inicVol = new InicializacionPartidosDeporte(arq, info,
				new ListadoFechaHora(new FechaHora(LocalDate.now().plusDays(1), LocalTime.of(12, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(12, 0)), new FechaHora(LocalDate.now().plusDays(2), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)), new FechaHora(LocalDate.now().plusDays(3), LocalTime.of(9, 0)),
						new FechaHora(LocalDate.now().plusDays(4), LocalTime.of(9, 0))),
				u.getListadoFacultades());
		
		ILinkedWeightedEdgeWeightedVertexNotDirectedGraph<Localizacion, Boolean, Integer> localizaciones = u.getLocalizaciones();
		
		Localizacion dojo = new Localizacion("Dojo","/interfaz/imagenes/L09.jpg",323,301);
		
		Localizacion pistaAtletismo = new Localizacion("Pista de Atletismo","/interfaz/imagenes/L01.jpg",656,343);
		Localizacion terrenoPelota = new Localizacion("Terreno de Pelota","/interfaz/imagenes/L10.jpg",558,427);
		
		Localizacion terrenoFutbol = new Localizacion("Terreno de Fútbol","/interfaz/imagenes/L11.jpg",455,450);
		Localizacion canchas = new Localizacion("Canchas","/interfaz/imagenes/L06.jpg",432,416);
		
		Localizacion canchasBadminton = new Localizacion("Canchas de Bádminton","/interfaz/imagenes/L07.jpg",420,353);
		Localizacion canchasBasketBall =  new Localizacion("Canchas de BasketBall","/interfaz/imagenes/L03.jpg",452,380);
		Localizacion piscinaNatacion =  new Localizacion("Piscina de Natación","/interfaz/imagenes/L02.jpeg",509,328);
		
		Localizacion deder = new Localizacion("DEDER","/interfaz/imagenes/L04.jpg",495,404);
		
		Localizacion localDeder = new Localizacion("Local de Ajedrez","/interfaz/imagenes/L05.jpg",495,439);
		Localizacion bajosArquitectura = new Localizacion("Bajos del Edificio de Arquitectura","/interfaz/imagenes/L08.jpg",101,397);
		
		localizaciones.insertWVertex(dojo, true);
		localizaciones.insertWVertex(pistaAtletismo, true);
		localizaciones.insertWVertex(terrenoPelota, true);
		localizaciones.insertWVertex(terrenoFutbol, true);
		localizaciones.insertWVertex(canchas, true);
		localizaciones.insertWVertex(canchasBadminton, true);
		localizaciones.insertWVertex(canchasBasketBall, true);
		localizaciones.insertWVertex(piscinaNatacion, true);
		localizaciones.insertWVertex(deder, true);
		localizaciones.insertWVertex(localDeder, true);
		localizaciones.insertWVertex(bajosArquitectura, true);
		
		inicializarDistancias(localizaciones);
		
		u.addDeporte("Bádminton", Sexo.FEMENINO,TipoDeporte.DEPORTE_COLECTIVO,inicBad,"Canchas de Bádminton");
		u.addDeporte("Karate", Sexo.FEMENINO,TipoDeporte.DEPORTE_INDIVIDUAL,inicKar,"Dojo");
		u.addDeporte("Fútbol", Sexo.FEMENINO,TipoDeporte.DEPORTE_COLECTIVO,inicFut,"Terreno de Fútbol");
		u.addDeporte("VolleyBall", Sexo.MASCULINO,TipoDeporte.DEPORTE_COLECTIVO,inicVol,"Canchas");
		
		return u;
	}
	
	private static void inicializarDistancias(ILinkedWeightedEdgeWeightedVertexNotDirectedGraph<Localizacion, Boolean, Integer> localizaciones) {
		localizaciones.insertWEdgeNDG(0, 5, 120); //Distancia del Dojo a Canchas de Badminton
		localizaciones.insertWEdgeNDG(0, 7, 200); //Distancia del Dojo a Piscina
		localizaciones.insertWEdgeNDG(0, 10,280); //Distancia del Dojo a Bajos de Arquitectura
		
		localizaciones.insertWEdgeNDG(5, 6, 40); //Distancia de Canchas de Badminton a Canchas de Basket
		localizaciones.insertWEdgeNDG(4, 6, 40); //Distancia de Canchas a Canchas de Basket
		localizaciones.insertWEdgeNDG(4, 8, 60); //Distancia  de Canchas a DEDER
		localizaciones.insertWEdgeNDG(6, 7, 100); //Distancia  de Canchas de Basket a Piscina
		
		localizaciones.insertWEdgeNDG(3, 4, 40); //Distancia de Terreno de Futbol a Canchas
		localizaciones.insertWEdgeNDG(6, 8, 60); //Distancia de Canchas de Basket a DEDER
		localizaciones.insertWEdgeNDG(3, 9, 60); //Distancia de Terreno de Futbol a Local de Ajedrez
		localizaciones.insertWEdgeNDG(8, 9, 40); //Distancia de DEDER a Local de Ajedrez
		
		localizaciones.insertWEdgeNDG(2, 9, 60); //Distancia de Terreno de Pelota a Local de Ajedrez
		localizaciones.insertWEdgeNDG(1, 2, 240); //Distancia de Pista de Atletismo a Terreno de Pelota
		localizaciones.insertWEdgeNDG(1, 8, 180); //Distancia de Pista de Atletismo a DEDER
		localizaciones.insertWEdgeNDG(7, 8, 80); //Distancia de Piscina de Natación a DEDER
	}
	
	/**
	 * Permite generar usuarios de prueba de cada tipo (9 facultades y 1 admin)
	 * 
	 * @return Usuarios u generados
	 */ 
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
	
	/**
	 * Permite borrar los datos de la aplicacion 
	 */
	public static void borrarDatos() {
		f.delete();
	}
	
}
