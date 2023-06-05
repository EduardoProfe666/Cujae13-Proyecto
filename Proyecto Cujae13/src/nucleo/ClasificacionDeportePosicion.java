package nucleo;

public class ClasificacionDeportePosicion extends ClasificacionDeporte{
	private static final long serialVersionUID = 1L;
	private int posicion;
	
	
	public ClasificacionDeportePosicion(Facultad facultad, int posicion) {
		super(facultad);
		this.posicion = posicion;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	
}
