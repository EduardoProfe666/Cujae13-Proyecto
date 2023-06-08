package inicializacion;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class Convert {
	private Convert() {}
	
	public static byte[] toBytes(Object o) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o);
		return baos.toByteArray();
	}
	
	public static Object toObject(byte[] b) throws IOException, ClassNotFoundException {
		return new ObjectInputStream(new ByteArrayInputStream(b)).readObject();
	}
}
