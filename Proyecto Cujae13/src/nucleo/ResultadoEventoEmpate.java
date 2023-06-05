package nucleo;

public class ResultadoEventoEmpate extends ResultadoEvento{
	private static final long serialVersionUID = 1L;
	private Facultad segundaFacultadGanadora;
	
	public ResultadoEventoEmpate(Facultad facultadGanadora, int marcadorFacultadPrimera, int marcadorFacultadSegunda,
			int puntajeEvento, Facultad segundaFacultadGanadora) {
		super(facultadGanadora, marcadorFacultadPrimera, marcadorFacultadSegunda, puntajeEvento);
		this.segundaFacultadGanadora = segundaFacultadGanadora;
	}
	public Facultad getSegundaFacultadGanadora() {
		return segundaFacultadGanadora;
	}
	public void setSegundaFacultadGanadora(Facultad segundaFacultadGanadora) {
		this.segundaFacultadGanadora = segundaFacultadGanadora;
	}
	
	
}
