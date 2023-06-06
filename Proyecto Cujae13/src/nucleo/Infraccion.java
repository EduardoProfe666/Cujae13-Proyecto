package nucleo;

import java.time.LocalDate;

public class Infraccion {
	private TipoInfraccion tipo;
	private String descripcion;
	private LocalDate fecha;
	private String nombreFacultad;
	
	public Infraccion(TipoInfraccion tipo, String descripcion, String nombreFacultad) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.fecha = LocalDate.now();
	}
	public TipoInfraccion getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public String getNombreFacultad() {
		return nombreFacultad;
	}
}
