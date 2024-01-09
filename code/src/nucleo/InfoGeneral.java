package nucleo;

import java.io.Serializable;

import utilidades.Validaciones;

/**
 * Clase que permite modelar la informacion general de las facultades
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public class InfoGeneral implements Serializable{
	private static final long serialVersionUID = 1L;
	private String historiaYCuriosidades;
	
	public InfoGeneral(String historiaCuriosidades) {
		setHistoriaYCuriosidades(historiaCuriosidades);
	}
	
	public String getHistoriaYCuriosidades() {
		return historiaYCuriosidades;
	}
	
	public void setHistoriaYCuriosidades(String historia) {
		if(Validaciones.validarStringNoVacio(historia)){
			this.historiaYCuriosidades = historia;
		} else {
			throw new IllegalArgumentException("La historia no debe estar vacía");
		}
	}
	
}
