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
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
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

		String hcInfo = "La Facultad de Ingenier�a Inform�tica en sus inicios se encontraba formando parte de "
				+ "la Facultad de Ingenier�a Industrial. En el a�o 2007 surge como facultad independiente creando"
				+ " su propia identidad.\r\n\n"
				+ "Como todas las facultades, deb�a escoger un color y una mascota que la representara en los "
				+ "Juegos 13 de Marzo; al no encontrarse dentro de las primeras facultades existentes y surgir "
				+ "luego de seleccionados los colores y mascotas por la mayor�a de facultades, no pose�a muchas "
				+ "opciones de color por lo que en un principio escogi� el naranja, pero en el momento de impresi�n"
				+ " de los pullover para los juegos este color no se encontraba disponible y tuvo la opci�n de ser"
				+ " cambiado al reconocido y actual amarillo que representa a la facultad a�o tras a�o en el "
				+ "per�odo deportivo. En cuanto a la mascota se tuvo en cuenta que al proceder de la Facultad "
				+ "de Industrial se buscara un animal relacionado con el delf�n pero que fuera reconocido por ser"
				+ " m�s fuerte y poderoso, de ah� que se seleccionara la orca, tipo de delf�n conocido por ser el"
				+ " m�s grande y temido de su especie.\r\n\n"
				+ "Debido a la separaci�n de las facultades, Inform�tica perdi� al entrenador y coreograf�a de la"
				+ " tabla gimn�stica que presentaba cada a�o y obten�a excelentes resultados, para su primera "
				+ "presentaci�n como facultad tuvo que empezar de cero en estos aspectos y es importante destacar"
				+ " que, a pesar de todas las adversidades, ese a�o la facultad obtuvo el primer lugar en la "
				+ "disciplina de la tabla gimn�stica.\r\n\n"
				+ "Otra curiosidad de Inform�tica es que ninguna otra facultad tiene una jefa de administraci�n "
				+ "que radique en el edificio docente y lleve el control de la limpieza y organizaci�n de las "
				+ "aulas, as� como se ocupe amablemente de resolver cualquier situaci�n a su alcance en relaci�n"
				+ " con los estudiantes y profesores como lo hace Sirenia Lobato.\r\n\n"
				+ "Entre sus tradiciones est� la realizaci�n de una caldosa para recibir a los estudiantes de"
				+ " nuevo ingreso y motivarlos a la integraci�n e identificaci�n con la facultad.\r\n\n"
				+ "Para finalizar, resaltar que varios de los dirigentes de la universidad son graduados de la "
				+ "carrera de inform�tica, entre ellos se encuentran: el rector Modesto R. G�mez, la vicerrectora "
				+ "primera Marta Dunia Delgado y la vicerrectora docente Anaysa Hern�ndez.\r\n\n"
				+ "";
		InfoGeneral informacionInfo = new InfoGeneral(hcInfo);
		Facultad info = new Facultad(NombreFacultad.INFORMATICA, informacionInfo);
		
		String hcArq = "La Facultad de Arquitectura se encuentra entre las facultades fundadoras de la universidad."
				+ " Para la facultad la elecci�n del color estuvo dada por el desarrollo de un evento que conllev�"
				+ " a la impresi�n de pullover verdes, por lo que en los juegos al ya tener las prendas con ese "
				+ "color decidieron tomarlo como el color representativo de la facultad. En cuanto a la mascota, "
				+ "surge luego de seleccionado el color, al encontrarse en el dilema de buscar un animal que "
				+ "luciera como buena combinaci�n junto al verde, por lo que se determin� seleccionar el cocodrilo"
				+ " que hoy los representa en cada Juego 13 de Marzo.\r\n\n"
				+ "La facultad cuenta con la fiesta tradicional �La Vela� como recibimiento a los estudiantes de "
				+ "nuevo ingreso, donde se realizan juegos de participaci�n.\r\n\n"
				+ "Es importante destacar que la Facultad de Arquitectura es la facultad con mayor cantidad de "
				+ "Juegos 13 de Marzo perdidos, con un total de 20 juegos perdidos desde 1994.\r\n\n"
				+ "";
		InfoGeneral informacionArq = new InfoGeneral(hcArq);
		Facultad arq = new Facultad(NombreFacultad.ARQUITECTURA, informacionArq);
		
		String hcAut = "La Facultad de Ingenier�a Autom�tica en sus inicios se encontraba formando parte de la "
				+ "Facultad de Ingenier�a El�ctrica, en el a�o 2017 surge como facultad independiente creando su"
				+ " propia identidad.\r\n\n"
				+ "Como todas las facultades, deb�a escoger un color y una mascota que la representara en los "
				+ "Juegos 13 de Marzo; al ser una de las �ltimas facultades fundadas sus opciones de color eran"
				+ " muy limitadas, se encontraban entre el naranja, el rosado y el marr�n; por lo que la decisi�n"
				+ " de color fue finalmente naranja, por ser el m�s neutral. En cuanto a la mascota, fue escogida"
				+ " por medio de encuestas y votaciones entre los estudiantes de la facultad que consideraron al"
				+ " tigre como una buena opci�n para que los representara.\r\n\n"
				+ "La Facultad de Autom�tica tiene dentro a las carreras universitarias Ingenier�a Autom�tica e"
				+ " Ingenier�a Biom�dica; as� como 2 T�cnicos Superiores: Mantenimiento para Turismo y "
				+ "Metrolog�a.\r\n\n"
				+ " ";
		InfoGeneral informacionAut = new InfoGeneral(hcAut);
		Facultad aubi = new Facultad(NombreFacultad.AUTOMATICA_BIOMEDICA, informacionAut);
		
		String hcCiv = "La Facultad de Ingenier�a Civil pertenece a la Universidad Tecnol�gica de La Habana "
				+ "CUJAE desde el a�o 1964, siendo una de las facultades m�s antiguas de la universidad.\r\n\n"
				+ "El primer color que seleccion� la facultad para que la representara en los Juegos 13 de Marzo"
				+ " fue el naranja, pero como Inform�tica, en el momento de imprimir los pullover de los jugadores"
				+ " no se contaba con ese color, por lo que se decidieron por el actual gris que se encontraba "
				+ "disponible, y a su vez es el color del cemento, material esencial en su trabajo. En cuanto a "
				+ "la mascota se eligi� por la buena combinaci�n con el gris y la fortaleza que representan los"
				+ " tiburones en su h�bitat.\r\n\n"
				+ "La facultad cuenta con una fiesta tradicional conocida como �La M�scara�, donde se realizan"
				+ " juegos de participaci�n y bailes, y cuenta con la caracter�stica de que el vestuario portado"
				+ " debe ser elegante y llevar consigo una m�scara.\r\n\n"
				+ "La Facultad de Civil tiene dentro a las carreras universitarias Ingenier�a Civil, Ingenier�a"
				+ " Hidr�ulica e Ingenier�a Geof�sica, siendo esta �ltima solo estudiada en la CUJAE a nivel "
				+ "nacional.\r\n\n"
				+ "Es importante destacar que la facultad se encuentra entre las 3 facultades con mayor cantidad"
				+ " de Juegos 13 de Marzo ganados.\r\n\n"
				+ "";
		InfoGeneral informacionCivil = new InfoGeneral(hcCiv);
		Facultad civil = new Facultad(NombreFacultad.CIVIL, informacionCivil);
		
		String hcElec = "La Facultad de Ingenier�a El�ctrica se encuentra entre las facultades fundadoras de la"
				+ " universidad. En sus inicios estaba compuesta adem�s por las hoy facultades de Autom�tica y "
				+ "Telecomunicaciones. \r\n\n"
				+ "Al ser de las primeras facultades existentes contaron con m�s opciones en el momento de elegir "
				+ "el color que lo representar�a. La elecci�n del azul estuvo dada porque este color era "
				+ "representativo del sector el�ctrico y se termin� asumiendo como representativo de la facultad."
				+ " En cuanto a la mascota, buscaron un animal que los representara seg�n las caracter�sticas "
				+ "propias de la carrera, por lo que se termin� escogiendo la manta raya, conocida por emplear "
				+ "descargas el�ctricas para paralizar a sus presas o para defenderse.\r\n\n"
				+ "Es importante destacar que la Facultad de El�ctrica se encuentra entre las 3 facultades con "
				+ "mayor cantidad de Juegos 13 de Marzo ganados, principalmente antes de producirse la separaci�n "
				+ "de las facultades de Autom�tica y Telecomunicaciones.\r\n\n"
				+ "";
		InfoGeneral informacionElect = new InfoGeneral(hcElec);
		Facultad elect = new Facultad(NombreFacultad.ELECTRICA, informacionElect);
		
		String hcInd = "La Facultad de Ingenier�a Industrial se encuentra entre las primeras facultades que "
				+ "surgieron en la universidad. En sus inicios estaba compuesta adem�s por la hoy Facultad de "
				+ "Ingenier�a Inform�tica.\r\n\n"
				+ "Al ser de las primeras facultades existentes contaron con m�s opciones en el momento de"
				+ " elegir el color. En un inicio su selecci�n fue el azul p�lido, pero cuando se imprimieron "
				+ "los pullover la tonalidad de azul que se encontraba disponible era la de el�ctrica que termin�"
				+ " por quedarse totalmente con el color y conllev� a que Industrial tuviera que elegir el blanco,"
				+ " color que se asumi� como s�mbolo de inteligencia y sabidur�a, en conjunto con la mascota, "
				+ "seleccionada con esa misma concepci�n.\r\n\n"
				+ "Es importante destacar que la facultad se encuentra posicionada como la facultad con mayor"
				+ " cantidad de Juegos 13 de Marzo ganados a trav�s de la historia, con un total de 12 juegos"
				+ " ganados desde 1994.\r\n\n"
				+ "";
		InfoGeneral informacionIndu = new InfoGeneral(hcInd);
		Facultad indu = new Facultad(NombreFacultad.INDUSTRIAL, informacionIndu);
		
		String hcMec = "La Facultad de Ingenier�a Mec�nica se encuentra entre las primeras facultades que "
				+ "surgieron en la universidad.\r\n\n"
				+ "La elecci�n del color y la mascota estuvo dada por unas votaciones que tuvieron lugar en el"
				+ " a�o 1999, donde resultaron ganadores el color rojo y el le�n, con el fin de que los "
				+ "representara en los Juegos 13 de Marzo.\r\n\n"
				+ "Es reconocida desde sus inicios por ser la facultad con una matr�cula principalmente de "
				+ "varones y que se ha mantenido con esa caracter�stica hasta la actualidad.\r\n\n"
				+ "La Facultad de Mec�nica tiene dentro a las carreras universitarias Ingenier�a Mec�nica e"
				+ " Ingenier�a en Metalurgia y Materiales; as� como el T�cnicos Superior de Transporte.\r\n\n"
				+ "La facultad se identifica con la frase: �Ser mec�nico es un sentido de la vida�.\r\n\n"
				+ "";
		InfoGeneral informacionMec = new InfoGeneral(hcMec);
		Facultad mec = new Facultad(NombreFacultad.MECANICA, informacionMec);
		
		String hcQuim = "La facultad de Ingenier�a Qu�mica se encuentra entre las primeras facultades que "
				+ "surgieron en la universidad. Aparece desde el a�o 1962, cuando la CUJAE era a�n una facultad "
				+ "m�s de la Universidad de La Habana, en ese entonces conocida como la Facultad de Tecnolog�a."
				+ " En sus inicios se divid�a en 2 facultades: una estudiaba la Tecnolog�a de los Procesos Qu�micos"
				+ " y la Tecnolog�a de los procesos Alimentarios y la otra la Tecnolog�a de las Producciones "
				+ "Azucareras.\r\n\n"
				+ "Al encontrarse entre las primeras facultades existentes cont� con m�s posibilidades a la hora"
				+ " de elegir el color; su elecci�n fue el color negro para representarla en los Juegos 13 de "
				+ "Marzo; en correspondencia con este se escogi� la mascota, teniendo en cuenta una buena "
				+ "combinaci�n entre estos.\r\n\n"
				+ "La facultad comenz� a realizar en el a�o 2023 una fiesta tradicional propia a la que "
				+ "denominaron �La Alquimia�, donde se realizan juegos de participaci�n y competencias y cuenta"
				+ " con la particularidad de ser presentada por estudiantes vestidos con batas blancas en "
				+ "representaci�n caracter�stica de los qu�micos.\r\n\n"
				+ "En cuanto a los Juegos 13 de Marzo, la Facultad de Qu�mica es la segunda con mayor cantidad "
				+ "de Juegos 13 de Marzo perdidos, con un total de 8 juegos, solo superada por Arquitectura.\r\n\n"
				+ "";
		InfoGeneral informacionQuim = new InfoGeneral(hcQuim);
		Facultad quim = new Facultad(NombreFacultad.QUIMICA, informacionQuim);
		
		String hcTele = "La Facultad de Ingenier�a en Telecomunicaciones y Electr�nica en sus inicios se encontraba"
				+ " formando parte de la Facultad de Ingenier�a El�ctrica, en el a�o 2017 surge como facultad "
				+ "independiente creando su propia identidad.\r\n\n"
				+ "Como todas las facultades, deb�a escoger un color y una mascota que la representara en los "
				+ "Juegos 13 de Marzo; al ser una de las �ltimas facultades fundadas sus opciones de color eran"
				+ " muy limitadas y se termin� por seleccionar el color morado. En cuanto a la mascota, esta se "
				+ "escogi� mediante una encuesta que arroj� como finalistas al murci�lago y al lobo, por sus "
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
				+ " Tecnol�gica de La Habana esta era la Facultad Tecnol�gica perteneciente a la Universidad de La "
				+ "Habana. Hist�ricamente se celebraban los Juegos Caribe como parte de la vida universitaria. Al"
				+ " surgir la CUJAE como universidad independiente adopta unos juegos deportivos propios, a los "
				+ "cuales denomin� Juegos 13 de Marzo, en honor a Jos� Antonio Echeverr�a, m�rtir que dio la vida "
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
		
		Localizacion terrenoFutbol = new Localizacion("Terreno de F�tbol","/interfaz/imagenes/L11.jpg",455,450);
		Localizacion canchas = new Localizacion("Canchas","/interfaz/imagenes/L06.jpg",432,416);
		
		Localizacion canchasBadminton = new Localizacion("Canchas de B�dminton","/interfaz/imagenes/L07.jpg",420,353);
		Localizacion canchasBasketBall =  new Localizacion("Canchas de BasketBall","/interfaz/imagenes/L03.jpg",452,380);
		Localizacion piscinaNatacion =  new Localizacion("Piscina de Nataci�n","/interfaz/imagenes/L02.jpeg",509,328);
		
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
		
		u.addDeporte("B�dminton", Sexo.FEMENINO,TipoDeporte.DEPORTE_COLECTIVO,inicBad,"Canchas de B�dminton");
		u.addDeporte("Karate", Sexo.FEMENINO,TipoDeporte.DEPORTE_INDIVIDUAL,inicKar,"Dojo");
		u.addDeporte("F�tbol", Sexo.FEMENINO,TipoDeporte.DEPORTE_COLECTIVO,inicFut,"Terreno de F�tbol");
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
		localizaciones.insertWEdgeNDG(7, 8, 80); //Distancia de Piscina de Nataci�n a DEDER
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
		u.ingresarUsuario(new UsuarioEstudiante("civi@civil.cujae.edu.cu","1234","Alba�il"));
		u.ingresarUsuario(new UsuarioEstudiante("elec@electrica.cujae.edu.cu","1234", "Cobrador de la Luz"));
		u.ingresarUsuario(new UsuarioEstudiante("indu@industrial.cujae.edu.cu","1234", "T�cnico Medio"));
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
