package interfaz.clases.panelesAppPrincipal;

import java.awt.Color;
import java.util.HashMap;

import clasesAuxiliares.NombreFacultad;
import definiciones.DefinicionesInterfaz;

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
	
	private static HashMap<NombreFacultad,EsquemaColores> archivador = crearArchivador();
	
	private static HashMap<NombreFacultad,EsquemaColores> crearArchivador() {
		HashMap<NombreFacultad,EsquemaColores> archivador = new HashMap<NombreFacultad,EsquemaColores>();
		
		EsquemaColores informatica = new EsquemaColores(DefinicionesInterfaz.A5, DefinicionesInterfaz.A9, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.A4, DefinicionesInterfaz.A1, DefinicionesInterfaz.A10, DefinicionesInterfaz.COLOR_OFICIAL_INF, 
				DefinicionesInterfaz.A6, DefinicionesInterfaz.A3, Color.BLACK, DefinicionesInterfaz.A5, DefinicionesInterfaz.A9, 
				Color.BLACK, "/interfaz/imagenes/logo_info.png", DefinicionesInterfaz.A8, null);
		
		EsquemaColores tele = new EsquemaColores(DefinicionesInterfaz.M5, DefinicionesInterfaz.M9, Color.BLACK, Color.WHITE,
				DefinicionesInterfaz.M8, DefinicionesInterfaz.M2, DefinicionesInterfaz.M2, DefinicionesInterfaz.COLOR_OFICIAL_TELE, 
				DefinicionesInterfaz.M6, DefinicionesInterfaz.M4, Color.WHITE, DefinicionesInterfaz.M5, DefinicionesInterfaz.M9, 
				Color.BLACK, "/interfaz/imagenes/logo_tele.png", DefinicionesInterfaz.M5, null);
		
		EsquemaColores arquitectura = new EsquemaColores(DefinicionesInterfaz.V13, DefinicionesInterfaz.V12, Color.BLACK, Color.WHITE,
				DefinicionesInterfaz.V1, DefinicionesInterfaz.V6, DefinicionesInterfaz.V6, DefinicionesInterfaz.COLOR_OFICIAL_ARQ, 
				DefinicionesInterfaz.V3, DefinicionesInterfaz.V10, Color.WHITE, DefinicionesInterfaz.V13, DefinicionesInterfaz.V12, 
				Color.BLACK, "/interfaz/imagenes/logo_arqu.png", DefinicionesInterfaz.V11, null);
		
		EsquemaColores quimica = new EsquemaColores(DefinicionesInterfaz.N6, DefinicionesInterfaz.N8, Color.WHITE, Color.WHITE,
				DefinicionesInterfaz.N5, DefinicionesInterfaz.N1, DefinicionesInterfaz.N6, DefinicionesInterfaz.COLOR_OFICIAL_QUIM, 
				DefinicionesInterfaz.N2, DefinicionesInterfaz.N4, Color.WHITE, DefinicionesInterfaz.N6, DefinicionesInterfaz.N8, 
				Color.WHITE, "/interfaz/imagenes/logo_quim.png", DefinicionesInterfaz.N2, null);
		
		EsquemaColores aubio = new EsquemaColores(DefinicionesInterfaz.AB7, DefinicionesInterfaz.AB10, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.AB4, DefinicionesInterfaz.AB2, DefinicionesInterfaz.AB2, DefinicionesInterfaz.COLOR_OFICIAL_AUT, 
				DefinicionesInterfaz.AB8, DefinicionesInterfaz.AB7, Color.BLACK, DefinicionesInterfaz.AB7, DefinicionesInterfaz.AB10, 
				Color.BLACK, "/interfaz/imagenes/logo_aubi.png", DefinicionesInterfaz.AB7, null);
		
		EsquemaColores civil = new EsquemaColores(DefinicionesInterfaz.G8, DefinicionesInterfaz.G1, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.G5, DefinicionesInterfaz.G8, DefinicionesInterfaz.G2, DefinicionesInterfaz.G2, 
				DefinicionesInterfaz.G5, DefinicionesInterfaz.G3, Color.BLACK, DefinicionesInterfaz.G8, DefinicionesInterfaz.G1, 
				Color.BLACK, "/interfaz/imagenes/logo_civi.jpg", DefinicionesInterfaz.G8, null);
		
		EsquemaColores elec = new EsquemaColores(DefinicionesInterfaz.Az8, DefinicionesInterfaz.Az12, Color.BLACK, Color.BLACK,
				 DefinicionesInterfaz.COLOR_OFICIAL_ELECT,DefinicionesInterfaz.Az10, DefinicionesInterfaz.Az10, DefinicionesInterfaz.COLOR_OFICIAL_ELECT, 
				DefinicionesInterfaz.Az10, DefinicionesInterfaz.Az1, Color.BLACK, DefinicionesInterfaz.Az8, DefinicionesInterfaz.Az12, 
				Color.BLACK, "/interfaz/imagenes/logo_elec.png", DefinicionesInterfaz.Az1, null);
		
		EsquemaColores ind = new EsquemaColores(DefinicionesInterfaz.B7, DefinicionesInterfaz.B1, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.B1, DefinicionesInterfaz.B7, DefinicionesInterfaz.B1, DefinicionesInterfaz.COLOR_OFICIAL_IND, 
				DefinicionesInterfaz.B3, DefinicionesInterfaz.B1, Color.BLACK, DefinicionesInterfaz.B7, DefinicionesInterfaz.B1, 
				Color.BLACK, "/interfaz/imagenes/logo_indu.png", DefinicionesInterfaz.B7, null);
		
		EsquemaColores mec = new EsquemaColores(DefinicionesInterfaz.R5, DefinicionesInterfaz.R9, Color.BLACK, Color.BLACK,
				DefinicionesInterfaz.R7, DefinicionesInterfaz.R1, DefinicionesInterfaz.R10, DefinicionesInterfaz.COLOR_OFICIAL_MEC, 
				DefinicionesInterfaz.R5, DefinicionesInterfaz.R4, Color.BLACK, DefinicionesInterfaz.R5, DefinicionesInterfaz.R9, 
				Color.BLACK, "/interfaz/imagenes/logo_meca.png", DefinicionesInterfaz.R5, null);
		
		
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
		return archivador.get(f);
	}
}
