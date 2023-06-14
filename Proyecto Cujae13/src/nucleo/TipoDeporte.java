package nucleo;

public enum TipoDeporte {
	DeporteIndividual("Deporte Individual"), DeporteColectivo("Deporte Colectivo");
	private String nombre;

	private TipoDeporte(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
