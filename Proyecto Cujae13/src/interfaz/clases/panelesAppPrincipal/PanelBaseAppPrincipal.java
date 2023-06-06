package interfaz.clases.panelesAppPrincipal;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 * JPanel que permite generalizar la información base de todas las pantallas 
 * en forma de JPanel de la aplicación. 
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public abstract class PanelBaseAppPrincipal extends JPanel{
	private static final long serialVersionUID = 1L;
	
	protected PanelBaseAppPrincipal() {
		setBounds(300, 55, 900, 575);
		setBackground(Color.WHITE);
		setLayout(null);
		setBorder(new MatteBorder(0, 0, 2, 2, new Color(0,0,0)));
	}

}
