package interfaz.clases.panelesAppPrincipal;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelDeporte extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;

	public PanelDeporte() {

		JLabel lblNewLabel = new JLabel("Deporte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 60));
		lblNewLabel.setBounds(119, 174, 661, 227);
		add(lblNewLabel);

	}

}
