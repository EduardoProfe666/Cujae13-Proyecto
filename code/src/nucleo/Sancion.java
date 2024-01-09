package nucleo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase que permite modelar la sancion que tributa a la tabla de posiciones general
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public class Sancion implements Serializable{
	private static final long serialVersionUID = 1L;
	private TipoSancion tipo;
	private String descripcion;
	private LocalDateTime fecha;
	
	public Sancion(TipoSancion tipo, String descripcion) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.fecha = LocalDateTime.now();
	}
	public TipoSancion getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	
	
}
