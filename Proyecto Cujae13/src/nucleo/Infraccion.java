package nucleo;

import java.time.LocalDate;

public class Infraccion {
	private TipoInfraccion tipo;
	private String descripcion;
	private LocalDate fecha;
	
	public Infraccion(TipoInfraccion tipo, String descripcion) {
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
	
}
