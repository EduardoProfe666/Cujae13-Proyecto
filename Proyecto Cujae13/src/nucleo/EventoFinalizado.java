package nucleo;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class EventoFinalizado extends Evento {
	private static final long serialVersionUID = 1L;
	private LocalDateTime fechaFinalizado;
	private ResultadoEvento resultado;
	
	public EventoFinalizado(Deporte deporte, Facultad facultadPrimera, Facultad facultadSegunda, LocalTime fecha,
			LocalDateTime fechaFinalizado, ResultadoEvento resultado, TipoEvento tipo) {
		super(deporte, facultadPrimera, facultadSegunda, fecha, tipo);
		this.fechaFinalizado = fechaFinalizado;
		this.resultado = resultado;
	}

	public LocalDateTime getFechaFinalizado() {
		return fechaFinalizado;
	}

	public void setFechaFinalizado(LocalDateTime fechaFinalizado) {
		this.fechaFinalizado = fechaFinalizado;
	}

	public ResultadoEvento getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEvento resultado) {
		this.resultado = resultado;
	}
	
	
}
