package nucleo;

import java.util.HashMap;

/**
 * Enum que permite modelar cada tipo deporte, junto con los puntos sumados a la tabla de posiciones de deporte al ganar un partido y 
 * los puntos sumados a la tabla de posiciones general al terminar el deporte en dependencia del lugar que se coja
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public enum TipoDeporte {
	DEPORTE_INDIVIDUAL("Deporte Individual",crearArchivadorSistemaPuntuacionDepIndiv(),3), DEPORTE_COLECTIVO("Deporte Colectivo",crearArchivadorSistemaPuntuacionDepColec(),7), AMBOS("Ambos", null, 0);
	private String nombre;
	private HashMap<Integer, Integer> sistemaPuntuacion;
	private int puntuacionPartidoGanado;

	private TipoDeporte(String nombre, HashMap<Integer, Integer> sistemaPuntuacion, int p) {
		this.nombre = nombre;
		this.sistemaPuntuacion = sistemaPuntuacion;
		this.puntuacionPartidoGanado = p;
	}

	public HashMap<Integer, Integer> getSistemaPuntuacion(){
		return this.sistemaPuntuacion;
	}
	
	public int getPuntuacionPartidoGanado() {
		return puntuacionPartidoGanado;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

	private static HashMap<Integer, Integer> crearArchivadorSistemaPuntuacionDepIndiv() {
		HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();
		
		a.put(1, 15);
		a.put(2, 13);
		a.put(3, 11);
		a.put(4, 9);
		a.put(5, 7);
		a.put(6, 5);
		a.put(7, 3);
		a.put(8, 2);
		a.put(9, 1);
		
		return a;
	}

	private static HashMap<Integer, Integer> crearArchivadorSistemaPuntuacionDepColec() {
		HashMap<Integer, Integer> a = new HashMap<Integer, Integer>();

		a.put(1, 17);
		a.put(2, 15);
		a.put(3, 13);
		a.put(4, 11);
		a.put(5, 9);
		a.put(6, 7);
		a.put(7, 5);
		a.put(8, 3);
		a.put(9, 1);
		
		return a;
	}
}

