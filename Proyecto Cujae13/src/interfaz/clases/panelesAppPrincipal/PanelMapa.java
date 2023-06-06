package interfaz.clases.panelesAppPrincipal;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clasesAuxiliares.EsquemaColores;

/**
 * JPanel que modela la pantalla de Mapa de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Eduardo González
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelMapa extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	public PanelMapa(EsquemaColores e) {
			
		JLabel lblNewLabel = new JLabel("Mapa");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblNewLabel.setBounds(119, 174, 661, 227);
		add(lblNewLabel);

	}

}
