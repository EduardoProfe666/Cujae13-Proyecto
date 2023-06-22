package nucleo;

import java.io.Serializable;
import java.time.LocalTime;

public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	private TipoEvento tipo;
	private Deporte deporte;
	private Facultad facultadPrimera;
	private Facultad facultadSegunda;
	private LocalTime fecha;
	
	
	public Evento(Deporte deporte, Facultad facultadPrimera, Facultad facultadSegunda, LocalTime fecha, TipoEvento tipo) {
		super();
		this.deporte = deporte;
		this.facultadPrimera = facultadPrimera;
		this.facultadSegunda = facultadSegunda;
		this.fecha = fecha;
		this.tipo = tipo;
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
	public LocalTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalTime fecha) {
		this.fecha = fecha;
	}
	
	public boolean estaIndeterminado() {
		return facultadPrimera==null || facultadSegunda==null;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if(o instanceof Evento) {
			Evento e = (Evento) o;
			b = e.deporte.getNombre().equals(deporte.getNombre()) && 
					e.facultadPrimera.getNombre().equals(facultadPrimera.getNombre()) &&
					e.facultadSegunda.getNombre().equals(facultadSegunda.getNombre()) &&
					e.tipo.equals(tipo) && e.fecha.compareTo(fecha)==0;
		}
		return b;
	}
}
