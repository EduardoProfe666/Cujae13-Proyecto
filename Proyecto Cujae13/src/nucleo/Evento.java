package nucleo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	private TipoEvento tipo;
	private Deporte deporte;
	private Facultad facultadPrimera;
	private Facultad facultadSegunda;
	private LocalDateTime fecha;
	
	
	public Evento(Deporte deporte, Facultad facultadPrimera, Facultad facultadSegunda, LocalDateTime fecha) {
		super();
		this.deporte = deporte;
		this.facultadPrimera = facultadPrimera;
		this.facultadSegunda = facultadSegunda;
		this.fecha = fecha;
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	public Deporte getDeporte() {
		return deporte;
	}
	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}
	public Facultad getFacultadPrimera() {
		return facultadPrimera;
	}
	public void setFacultadPrimera(Facultad facultadPrimera) {
		this.facultadPrimera = facultadPrimera;
	}
	public Facultad getFacultadSegunda() {
		return facultadSegunda;
	}
	public void setFacultadSegunda(Facultad facultadSegunda) {
		this.facultadSegunda = facultadSegunda;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
}
