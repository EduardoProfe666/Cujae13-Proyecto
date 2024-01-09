package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import componentes.Imagen;
import componentes.PanelBordeOval;
import javax.swing.SwingConstants;

public class TarjetaReporte extends PanelBordeOval{
	private static final long serialVersionUID = 1L;

	public TarjetaReporte(Color colorFondo, Color colorBorde, String lbl, String urlImagen, int num) {
		super(40);
		setBackground(colorFondo);
		setBounds(10, 149, 260, 180);
		setLayout(null);
		
		JLabel label = new JLabel(lbl);
		label.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		label.setBorder(new MatteBorder(0, 0, 2, 0, colorBorde));
		label.setBounds(10, 11, 240, 26);
		add(label);
		
		Imagen imagen = new Imagen(new ImageIcon(TarjetaReporte.class.getResource(urlImagen)));
		imagen.setBounds(170, 58, 80, 80);
		add(imagen);
		
		JLabel lblNewLabel = new JLabel(num+"");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto Medium", Font.BOLD, 29));
		lblNewLabel.setBounds(10, 74, 131, 49);
		add(lblNewLabel);
		
	}
}
