package interfaz.clases.panelesAppPrincipal;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clasesAuxiliares.EsquemaColores;

/**
 * JPanel que modela la pantalla de Deporte de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Brayan García
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelDeporte extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;

	public PanelDeporte(EsquemaColores e) {
		
		JLabel lblNewLabel = new JLabel("Deporte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblNewLabel.setBounds(119, 174, 661, 227);
		add(lblNewLabel);

	}

}
