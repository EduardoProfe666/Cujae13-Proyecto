package nucleo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class PropertyChangeListenerPuntajeGeneralCambiadoSerializable implements PropertyChangeListener, Serializable{
	private static final long serialVersionUID = 1L;
	
	public PropertyChangeListenerPuntajeGeneralCambiadoSerializable() {
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Universidad.getInstancia().construirTablaPosiciones();
		
	}

}
