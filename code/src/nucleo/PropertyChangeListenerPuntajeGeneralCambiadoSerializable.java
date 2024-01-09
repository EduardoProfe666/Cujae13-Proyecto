package nucleo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * Clase que permite modelar un PropertyChangeListener Serializable para que se actualice la tabla de posiciones general 
 * cuando ocurra un cambio en el puntaje de cada facultad
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 *
 */
public class PropertyChangeListenerPuntajeGeneralCambiadoSerializable implements PropertyChangeListener, Serializable{
	private static final long serialVersionUID = 1L;
	
	public PropertyChangeListenerPuntajeGeneralCambiadoSerializable() {
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Universidad.getInstancia().construirTablaPosiciones();
		
	}

}
