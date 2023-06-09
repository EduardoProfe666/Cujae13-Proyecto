package utilidades;

import java.awt.Color;
import java.util.HashMap;

import clasesAuxiliares.EsquemaColores;
import definiciones.DefinicionesInterfaz;
import nucleo.NombreFacultad;

/**
 * Clase de utilidades que incluye los diferentes archivadores empleados en la aplicación.
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public final class Archivador {
	private Archivador() {}
	
	private static HashMap<NombreFacultad,EsquemaColores> archivadorColores = crearArchivadorColores();
	private static HashMap<Integer,String> archivadorMedallas = crearArchivadorMedallas();
	
	private static HashMap<NombreFacultad,EsquemaColores> crearArchivadorColores() {
		HashMap<NombreFacultad,EsquemaColores> archivador = new HashMap<NombreFacultad,EsquemaColores>();
		
		EsquemaColores informatica = new EsquemaColores(DefinicionesInterfaz.A5, DefinicionesInterfaz.A9, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.A4, DefinicionesInterfaz.A1, DefinicionesInterfaz.A10, DefinicionesInterfaz.COLOR_OFICIAL_INF, 
				DefinicionesInterfaz.A6, DefinicionesInterfaz.A3, Color.BLACK, DefinicionesInterfaz.A5, DefinicionesInterfaz.A9, 
				Color.BLACK, "/interfaz/imagenes/logo_info.png", DefinicionesInterfaz.A8, DefinicionesInterfaz.COLOR_OFICIAL_INF,
				DefinicionesInterfaz.A8, DefinicionesInterfaz.A4, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.A2, Color.BLACK,"/interfaz/iconos/inicioBlack.png","/interfaz/iconos/facultadBlack.png",
				"/interfaz/iconos/deporteBlack.png","/interfaz/iconos/mapaBlack.png","/interfaz/iconos/historiaBlack.png",
				"/interfaz/iconos/calendarioBlack.png");
		
		EsquemaColores tele = new EsquemaColores(DefinicionesInterfaz.M5, DefinicionesInterfaz.M9, Color.BLACK, Color.WHITE,
				DefinicionesInterfaz.M8, DefinicionesInterfaz.M2, DefinicionesInterfaz.M2, DefinicionesInterfaz.COLOR_OFICIAL_TELE, 
				DefinicionesInterfaz.M6, DefinicionesInterfaz.M4, Color.WHITE, DefinicionesInterfaz.M5, DefinicionesInterfaz.M9, 
				Color.BLACK, "/interfaz/imagenes/logo_tele.png", DefinicionesInterfaz.M5, DefinicionesInterfaz.COLOR_OFICIAL_TELE,
				DefinicionesInterfaz.M5, DefinicionesInterfaz.M6, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.M5, Color.BLACK,"/interfaz/iconos/inicioWhite.png","/interfaz/iconos/facultadWhite.png",
				"/interfaz/iconos/deporteWhite.png","/interfaz/iconos/mapaWhite.png","/interfaz/iconos/historiaWhite.png",
				"/interfaz/iconos/calendarioWhite.png");
		
		EsquemaColores arquitectura = new EsquemaColores(DefinicionesInterfaz.V13, DefinicionesInterfaz.V12, Color.BLACK, Color.WHITE,
				DefinicionesInterfaz.V1, DefinicionesInterfaz.V6, DefinicionesInterfaz.V6, DefinicionesInterfaz.COLOR_OFICIAL_ARQ, 
				DefinicionesInterfaz.V3, DefinicionesInterfaz.V10, Color.WHITE, DefinicionesInterfaz.V13, DefinicionesInterfaz.V12, 
				Color.BLACK, "/interfaz/imagenes/logo_arqu.png", DefinicionesInterfaz.V11, DefinicionesInterfaz.COLOR_OFICIAL_ARQ,
				DefinicionesInterfaz.V13, DefinicionesInterfaz.V2, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.V13, Color.BLACK,"/interfaz/iconos/inicioWhite.png","/interfaz/iconos/facultadWhite.png",
				"/interfaz/iconos/deporteWhite.png","/interfaz/iconos/mapaWhite.png","/interfaz/iconos/historiaWhite.png",
				"/interfaz/iconos/calendarioWhite.png");
		
		EsquemaColores quimica = new EsquemaColores(DefinicionesInterfaz.N6, DefinicionesInterfaz.N8, Color.WHITE, Color.WHITE,
				DefinicionesInterfaz.N5, DefinicionesInterfaz.N1, DefinicionesInterfaz.N6, DefinicionesInterfaz.COLOR_OFICIAL_QUIM, 
				DefinicionesInterfaz.N2, DefinicionesInterfaz.N4, Color.WHITE, DefinicionesInterfaz.N6, DefinicionesInterfaz.N8, 
				Color.WHITE, "/interfaz/imagenes/logo_quim.png", DefinicionesInterfaz.N2, DefinicionesInterfaz.COLOR_OFICIAL_QUIM,
				DefinicionesInterfaz.N6, DefinicionesInterfaz.N5, "/interfaz/iconos/backWhite01.png", "/interfaz/iconos/backWhite02.png",
				DefinicionesInterfaz.N4, Color.WHITE,"/interfaz/iconos/inicioWhite.png","/interfaz/iconos/facultadWhite.png",
				"/interfaz/iconos/deporteWhite.png","/interfaz/iconos/mapaWhite.png","/interfaz/iconos/historiaWhite.png",
				"/interfaz/iconos/calendarioWhite.png");
		
		EsquemaColores aubio = new EsquemaColores(DefinicionesInterfaz.AB7, DefinicionesInterfaz.AB10, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.AB4, DefinicionesInterfaz.AB2, DefinicionesInterfaz.AB2, DefinicionesInterfaz.COLOR_OFICIAL_AUT, 
				DefinicionesInterfaz.AB8, DefinicionesInterfaz.AB7, Color.BLACK, DefinicionesInterfaz.AB7, DefinicionesInterfaz.AB10, 
				Color.BLACK, "/interfaz/imagenes/logo_aubi.png", DefinicionesInterfaz.AB7, DefinicionesInterfaz.COLOR_OFICIAL_AUT,
				DefinicionesInterfaz.AB7, DefinicionesInterfaz.AB8, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.AB7, Color.BLACK,"/interfaz/iconos/inicioBlack.png","/interfaz/iconos/facultadBlack.png",
				"/interfaz/iconos/deporteBlack.png","/interfaz/iconos/mapaBlack.png","/interfaz/iconos/historiaBlack.png",
				"/interfaz/iconos/calendarioBlack.png");
		
		EsquemaColores civil = new EsquemaColores(DefinicionesInterfaz.G8, DefinicionesInterfaz.G1, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.G5, DefinicionesInterfaz.G8, DefinicionesInterfaz.G2, DefinicionesInterfaz.G2, 
				DefinicionesInterfaz.G5, DefinicionesInterfaz.G3, Color.BLACK, DefinicionesInterfaz.G8, DefinicionesInterfaz.G1, 
				Color.BLACK, "/interfaz/imagenes/logo_civi.jpg", DefinicionesInterfaz.G8, DefinicionesInterfaz.G3,
				DefinicionesInterfaz.G8, DefinicionesInterfaz.G2, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.G3, Color.BLACK,"/interfaz/iconos/inicioBlack.png","/interfaz/iconos/facultadBlack.png",
				"/interfaz/iconos/deporteBlack.png","/interfaz/iconos/mapaBlack.png","/interfaz/iconos/historiaBlack.png",
				"/interfaz/iconos/calendarioBlack.png");
		
		EsquemaColores elec = new EsquemaColores(DefinicionesInterfaz.Az8, DefinicionesInterfaz.Az12, Color.BLACK, Color.BLACK,
				 DefinicionesInterfaz.COLOR_OFICIAL_ELECT,DefinicionesInterfaz.Az10, DefinicionesInterfaz.Az10, DefinicionesInterfaz.COLOR_OFICIAL_ELECT, 
				DefinicionesInterfaz.Az10, DefinicionesInterfaz.Az1, Color.BLACK, DefinicionesInterfaz.Az8, DefinicionesInterfaz.Az12, 
				Color.BLACK, "/interfaz/imagenes/logo_elec.png", DefinicionesInterfaz.Az1, DefinicionesInterfaz.COLOR_OFICIAL_ELECT,
				DefinicionesInterfaz.Az1, DefinicionesInterfaz.Az8, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.Az8, Color.BLACK,"/interfaz/iconos/inicioBlack.png","/interfaz/iconos/facultadBlack.png",
				"/interfaz/iconos/deporteBlack.png","/interfaz/iconos/mapaBlack.png","/interfaz/iconos/historiaBlack.png",
				"/interfaz/iconos/calendarioBlack.png");
		
		EsquemaColores ind = new EsquemaColores(DefinicionesInterfaz.B7, DefinicionesInterfaz.B1, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.B1, DefinicionesInterfaz.B7, DefinicionesInterfaz.B1, DefinicionesInterfaz.COLOR_OFICIAL_IND, 
				DefinicionesInterfaz.B3, DefinicionesInterfaz.B1, Color.BLACK, DefinicionesInterfaz.B7, DefinicionesInterfaz.B1, 
				Color.BLACK, "/interfaz/imagenes/logo_indu.png", DefinicionesInterfaz.B7, DefinicionesInterfaz.B1,
				DefinicionesInterfaz.B4, DefinicionesInterfaz.B5, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.B1, Color.BLACK,"/interfaz/iconos/inicioBlack.png","/interfaz/iconos/facultadBlack.png",
				"/interfaz/iconos/deporteBlack.png","/interfaz/iconos/mapaBlack.png","/interfaz/iconos/historiaBlack.png",
				"/interfaz/iconos/calendarioBlack.png");
		
		EsquemaColores mec = new EsquemaColores(DefinicionesInterfaz.R5, DefinicionesInterfaz.R9, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.R7, DefinicionesInterfaz.R4, DefinicionesInterfaz.R10, DefinicionesInterfaz.COLOR_OFICIAL_MEC, 
				DefinicionesInterfaz.R5, DefinicionesInterfaz.R4, Color.BLACK, DefinicionesInterfaz.R5, DefinicionesInterfaz.R9, 
				Color.BLACK, "/interfaz/imagenes/logo_meca.png", DefinicionesInterfaz.R5, DefinicionesInterfaz.COLOR_OFICIAL_MEC,
				DefinicionesInterfaz.R5, DefinicionesInterfaz.R6, "/interfaz/iconos/backBlack01.png", "/interfaz/iconos/backBlack02.png",
				DefinicionesInterfaz.R5, Color.BLACK,"/interfaz/iconos/inicioBlack.png","/interfaz/iconos/facultadBlack.png",
				"/interfaz/iconos/deporteBlack.png","/interfaz/iconos/mapaBlack.png","/interfaz/iconos/historiaBlack.png",
				"/interfaz/iconos/calendarioBlack.png");
		
		
		archivador.put(NombreFacultad.INFORMATICA, informatica);
		archivador.put(NombreFacultad.TELECOMUNICACIONES, tele);
		archivador.put(NombreFacultad.ARQUITECTURA, arquitectura);
		archivador.put(NombreFacultad.QUIMICA, quimica);
		archivador.put(NombreFacultad.AUTOMATICA_BIOMEDICA, aubio);
		archivador.put(NombreFacultad.CIVIL, civil);
		archivador.put(NombreFacultad.ELECTRICA, elec);
		archivador.put(NombreFacultad.INDUSTRIAL, ind);
		archivador.put(NombreFacultad.MECANICA, mec);
		
		return archivador;
	}
	
	public static EsquemaColores getEsquemaColores(NombreFacultad f) {
		return archivadorColores.get(f);
	}
	
	public static NombreFacultad getFacultadCorreo(String correo) {
		NombreFacultad nombre = null;
		
		if(correo.contains("@ceis.cujae.edu.cu"))
			nombre = NombreFacultad.INFORMATICA;
		else if(correo.contains("@arquitectura.cujae.edu.cu"))
			nombre = NombreFacultad.ARQUITECTURA; 
		else if(correo.contains("@automatica.cujae.edu.cu"))
			nombre = NombreFacultad.AUTOMATICA_BIOMEDICA;
		else if(correo.contains("@civil.cujae.edu.cu"))
			nombre = NombreFacultad.CIVIL;
		else if(correo.contains("@electrica.cujae.edu.cu"))
			nombre = NombreFacultad.ELECTRICA; 
		else if(correo.contains("@industrial.cujae.edu.cu"))
			nombre = NombreFacultad.INDUSTRIAL; 
		else if(correo.contains("@mecanica.cujae.edu.cu"))
			nombre = NombreFacultad.MECANICA;
		else if(correo.contains("@quimica.cujae.edu.cu"))
			nombre = NombreFacultad.QUIMICA; 
		else if(correo.contains("@telecomunicaciones.cujae.edu.cu"))
			nombre = NombreFacultad.TELECOMUNICACIONES;
		
		return nombre;
	}
	
	public static HashMap<Integer,String> crearArchivadorMedallas(){
		HashMap<Integer,String> archivador = new HashMap<Integer,String>();
		
		archivador.put(1, "/interfaz/iconos/1stMedal.png");
		archivador.put(2, "/interfaz/iconos/2ndMedal.png");
		archivador.put(3, "/interfaz/iconos/3rdMedal.png");
		archivador.put(4, "/interfaz/iconos/4thMedal.png");
		archivador.put(5, "/interfaz/iconos/5thMedal.png");
		archivador.put(6, "/interfaz/iconos/6thMedal.png");
		archivador.put(7, "/interfaz/iconos/7thMedal.png");
		archivador.put(8, "/interfaz/iconos/8thMedal.png");
		archivador.put(9, "/interfaz/iconos/9thMedal.png");
		
		return archivador;
	}
	
	public static String getDirUrlMedalla(int pos) {
		return archivadorMedallas.get(pos);
	}
}
