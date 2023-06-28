package inicializacion;

import java.io.File;
import java.io.RandomAccessFile;
import java.time.LocalDate;

import nucleo.Universidad;

public final class Inicializadora {
	private Inicializadora() {}

	private static File f = new File("datos.dat");

	public static void inicializarAplicacion() throws Exception{
		if(!f.exists())
			throw new RuntimeException("No se encuentra el fichero de datos del sistema");

		try {
			RandomAccessFile r = new RandomAccessFile(f,"rw");

			int l = r.readInt();
			byte[] b = new byte[l];
			r.read(b);

			Datos d = (Datos)Convert.toObject(b);
			Universidad.getInstancia(d.getUniversidad());
			Usuarios.getInstancia(d.getUsuarios());
			
			l = r.readInt();
			b = new byte[l];
			r.read(b);
			validarFecha((LocalDate)Convert.toObject(b));
			
			r.close();
			
			guardarDatosAplicacion();
		}catch(Exception e) {
			if(e.getMessage().equals("Viaje en el tiempo"))
				throw new RuntimeException("Viaje en el tiempo");
			
			throw new RuntimeException("El fichero de datos del sistema está corrompido");
		}
	}
	
	public static void validarFecha(LocalDate l) {
		if(l.compareTo(LocalDate.now())>0)
			throw new RuntimeException("Viaje en el tiempo");
	}

	public static void guardarDatosAplicacion() {
		f.delete();
		
		try {
			RandomAccessFile r = new RandomAccessFile(f,"rw");

			Datos d = new Datos(Universidad.getInstancia(),Usuarios.getInstancia());
			byte[] b = Convert.toBytes(d);
			r.writeInt(b.length);
			r.write(b);
			
			//Validacion de Fecha
			b = Convert.toBytes(LocalDate.now());
			r.writeInt(b.length);
			r.write(b);

			r.close();
		} catch(Exception e) {
			
		}
	}

}
