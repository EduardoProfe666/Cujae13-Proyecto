package nucleo;

import java.io.Serializable;

public class LocalizacionPeso implements Serializable{
	private static final long serialVersionUID = 1L;
	private Localizacion localizacion;
	private boolean tieneDeportes;
	
	
	public LocalizacionPeso(Localizacion localizacion, boolean tieneDeportes) {
		super();
		this.localizacion = localizacion;
		this.tieneDeportes = tieneDeportes;
	}
	public Localizacion getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(Localizacion localizacion) {
		this.localizacion = localizacion;
	}
	public boolean getTieneDeportes() {
		return tieneDeportes;
	}
	public void setTieneDeportes(boolean tieneDeportes) {
		this.tieneDeportes = tieneDeportes;
	}
	
	
}
