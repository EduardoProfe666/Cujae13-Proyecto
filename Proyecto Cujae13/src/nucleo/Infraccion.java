package nucleo;

import java.time.LocalDateTime;

public class Infraccion {
	private TipoInfraccion tipo;
	private String descripcion;
	private LocalDateTime fecha;
	private NombreFacultad nombreFacultad;
	
	public Infraccion(TipoInfraccion tipo, String descripcion, NombreFacultad nombreFacultad) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.fecha = LocalDateTime.now();
		this.nombreFacultad = nombreFacultad;
	}
	public TipoInfraccion getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public NombreFacultad getNombreFacultad() {
		return nombreFacultad;
	}
}
