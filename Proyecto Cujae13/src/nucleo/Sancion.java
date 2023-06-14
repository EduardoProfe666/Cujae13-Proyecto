package nucleo;

import java.time.LocalDateTime;

public class Sancion {
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
