package nucleo;

import java.time.LocalTime;

public class EventoFinalizado extends Evento {
	private static final long serialVersionUID = 1L;
	private LocalTime horaFin;
	private ResultadoEvento resultado;
	
	public EventoFinalizado(Deporte deporte, Facultad facultadPrimera, Facultad facultadSegunda, LocalTime fecha,
			LocalTime fechaFinalizado, ResultadoEvento resultado, TipoEvento tipo) {
		super(deporte, facultadPrimera, facultadSegunda, fecha, tipo);
		setHoraFin(fechaFinalizado);
		setResultado(resultado);
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	private void setHoraFin(LocalTime fechaFinalizado) {
		if(fechaFinalizado.isAfter(LocalTime.of(8, 9)) && fechaFinalizado.isBefore(LocalTime.of(18, 1)) ){
			this.horaFin = fechaFinalizado;
		} else {
			throw new IllegalArgumentException("La hora de fin no es válida");
		}
	}

	public ResultadoEvento getResultado() {
		return resultado;
	}

	private void setResultado(ResultadoEvento resultado) {
		if(resultado != null){
			this.resultado = resultado;
		} else {
			throw new IllegalArgumentException("El resultado de un evento finalizado no debe estar vacío");
		}
	}
}