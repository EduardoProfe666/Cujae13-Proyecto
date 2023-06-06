package nucleo;

public class ResultadoEventoEmpate extends ResultadoEvento{
	private static final long serialVersionUID = 1L;
	private Facultad segundaFacultadGanadora;
	
	public ResultadoEventoEmpate(Facultad facultadGanadora, Facultad segundaFacultadGanadora) {
		super(facultadGanadora);
		this.segundaFacultadGanadora = segundaFacultadGanadora;
	}
	public Facultad getSegundaFacultadGanadora() {
		return segundaFacultadGanadora;
	}
	
}
