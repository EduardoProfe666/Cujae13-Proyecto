package inicializacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase que otorga las funciones para el trabajo con ficheros binarios en memoria externa
 * 
 * @author Lilian Rojas
 * @author Eduardo González
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public final class Convert {
	private Convert() {}
	
	/**
	 * Permite convertir un objeto a arreglo de bytes para escribir ficheros binarios en 
	 * memoria externa
	 * 
	 * @param o Object a convertir a bytes
	 * @return byte[] El objeto convertido a arreglo de bytes
	 * @throws IOException Si existe algún error con el Object
	 */
	public static byte[] toBytes(Object o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		return baos.toByteArray();
	}
	
	/**
	 * Permite convertir un arreglo de bytes a objeto para leer ficheros binarios en memoria 
	 * externa
	 * 
	 * @param b byte[] El arreglo de bytes con el objeto codificado
	 * @return Object El objeto después de ser convertido
	 * @throws IOException Si existe algún error con el Object
	 * @throws ClassNotFoundException Si no se encuentra la clase del objeto almacenado
	 */
	public static Object toObject(byte[] b) throws IOException, ClassNotFoundException {
		return new ObjectInputStream(new ByteArrayInputStream(b)).readObject();
	}
}
