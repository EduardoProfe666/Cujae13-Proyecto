package nucleo;

import java.time.LocalDate;

public class Sancion {
	private TipoSancion tipo;
	private String descripcion;
	private LocalDate fecha;
	
	public Sancion(TipoSancion tipo, String descripcion) {
		super();
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.fecha = LocalDate.now();
	}
	public TipoSancion getTipo() {
		return tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	
	
}
