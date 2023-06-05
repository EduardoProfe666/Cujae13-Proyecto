package nucleo;

public class ClasificacionDeportePuntuacion extends ClasificacionDeporte{
	private static final long serialVersionUID = 1L;
	private int puntaje;
	
	public ClasificacionDeportePuntuacion(Facultad facultad, int puntaje) {
		super(facultad);
		this.puntaje = puntaje;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
}
