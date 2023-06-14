package nucleo;

import java.time.LocalTime;

public class EventoFinalizado extends Evento {
	private static final long serialVersionUID = 1L;
	private LocalTime fechaFinalizado;
	private ResultadoEvento resultado;
	
	public EventoFinalizado(Deporte deporte, Facultad facultadPrimera, Facultad facultadSegunda, LocalTime fecha,
			LocalTime fechaFinalizado, ResultadoEvento resultado, TipoEvento tipo) {
		super(deporte, facultadPrimera, facultadSegunda, fecha, tipo);
		this.fechaFinalizado = fechaFinalizado;
		this.resultado = resultado;
	}

	public LocalTime getFechaFinalizado() {
		return fechaFinalizado;
	}

	public void setFechaFinalizado(LocalTime fechaFinalizado) {
		this.fechaFinalizado = fechaFinalizado;
	}

	public ResultadoEvento getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEvento resultado) {
		this.resultado = resultado;
	}
	
	
}
