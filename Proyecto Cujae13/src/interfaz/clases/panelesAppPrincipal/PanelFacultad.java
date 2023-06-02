package interfaz.clases.panelesAppPrincipal;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * JPanel que modela la pantalla de Facultad de la aplicaci�n.
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo Gonz�lez
 *
 */
public class PanelFacultad extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;

	public PanelFacultad() {

		JLabel lblNewLabel = new JLabel("Facultad");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblNewLabel.setBounds(119, 174, 661, 227);
		add(lblNewLabel);

	}
}
