package interfaz.clases.panelesAppPrincipal;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public abstract class PanelBaseAppPrincipal extends JPanel{
	private static final long serialVersionUID = 1L;
	
	protected PanelBaseAppPrincipal() {
		setBounds(300, 55, 900, 575);
		setBackground(Color.WHITE);
		setLayout(null);
		setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
	}

}
