package nucleo;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Clase que permite modelar los eventos o partidos con sus datos
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 *
 */
public class Evento implements Serializable{
	private static final long serialVersionUID = 1L;
	private TipoEvento tipo;
	private Deporte deporte;
	private Facultad facultadPrimera;
	private Facultad facultadSegunda;
	private LocalTime horaInicio;
	private long id;
	
	
	public Evento(Deporte deporte, Facultad facultadPrimera, Facultad facultadSegunda, LocalTime fecha, TipoEvento tipo) {
		super();
		this.deporte = deporte;
		this.facultadPrimera = facultadPrimera;
		this.facultadSegunda = facultadSegunda;
		setHoraInicio(fecha);
		this.tipo = tipo;
		this.id = System.nanoTime();
	}
	
	public TipoEvento getTipo() {
		return tipo;
	}
	
	public Deporte getDeporte() {
		return deporte;
	}
	
	public void setDeporte(Deporte deporte) {
		if(this.deporte==null && deporte!=null) 
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
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	private void setHoraInicio(LocalTime fecha) {
		if(fecha.isAfter(LocalTime.of(7, 59)) && fecha.isBefore(LocalTime.of(17, 1)) ){
			this.horaInicio = fecha;
		} else {
			throw new IllegalArgumentException("La hora de inicio no es v�lida");
		}
	}
	
	/**
	 * Permite conocer si el evento esta indeterminado, es decir, si tiene alguna facultad contrincante por determinar
	 * @return
	 */
	public boolean estaIndeterminado() {
		return facultadPrimera == null || facultadSegunda == null;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean b = false;
		if(o instanceof Evento) {
			Evento e = (Evento) o;
			b = Long.compare(e.id, id)==0;
		}
		return b;
	}
}