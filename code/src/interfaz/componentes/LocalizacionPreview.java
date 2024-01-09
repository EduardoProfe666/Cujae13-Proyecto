package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.Imagen;
import interfaz.clases.AppPrincipal;

public class LocalizacionPreview extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public LocalizacionPreview(EsquemaColores e, String localizacion, String dirUrlImagen, boolean activo,int x, int y){
		this.setBounds(x, y, 330, 230);
		this.setBorder(new LineBorder(new Color(0,0,0), 2));
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		
		Imagen activoImg = new Imagen(new ImageIcon(AppPrincipal.class.getResource("/interfaz/iconos/"+(activo ? "localizacionActiva.png" : "localizacionNoActiva.png"))));
		activoImg.setBounds(292, 9, 28, 28);
		activoImg.setToolTipText(activo ? "Localización Activa" : "Localización No Activa");
		add(activoImg);
		
		JLabel lblLocalizacion = new JLabel(localizacion);
		lblLocalizacion.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		lblLocalizacion.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		lblLocalizacion.setBounds(10, 11, 310, 26);
		add(lblLocalizacion);
		
		Imagen imagen = new Imagen(new ImageIcon(AppPrincipal.class.getResource(dirUrlImagen)));
		imagen.setBorder(new LineBorder(e.getBordeLbl(),2));
		imagen.setBounds(10, 50, 310, 169);
		add(imagen);
	}
}
