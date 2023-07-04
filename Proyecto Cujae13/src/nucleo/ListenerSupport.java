package nucleo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Clase que permite dotar a las clases hijas de las funcionalidades del Property Change Listener
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 *
 */
public abstract class ListenerSupport implements Serializable{
	private static final long serialVersionUID = 1L;
	private PropertyChangeSupport pcs;

	protected ListenerSupport() {
		pcs = new PropertyChangeSupport(this);
	}

	protected void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(propertyName, listener);
	}

	protected void firePropertyChange(String propertyName) {
		pcs.firePropertyChange(propertyName, 1, 2);
	}
	
	protected void firePropertyChange(String propertyName, int valor) {
		pcs.firePropertyChange(propertyName, Integer.MIN_VALUE, valor);	
	}
	
	public void imprimirListeners() {
		System.out.println(pcs.getPropertyChangeListeners().length);
	}

}
