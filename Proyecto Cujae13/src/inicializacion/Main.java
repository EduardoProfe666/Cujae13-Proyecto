package inicializacion;

import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import interfaz.clases.PantallaCarga;
import nucleo.Universidad;

/**
 * Inicialización de la aplicación Cujae13
 * 
 * @version 2023.05.19
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 * @author Eduardo González
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		Locale.setDefault(new Locale("es"));
		FlatLightLaf.setup();
		
		try {
			//Provisional	
			
			Rellenadora.borrarDatos();
			Rellenadora.rellenarDatos();
			
			Inicializadora.inicializarAplicacion();
			
			Universidad.getInstancia().actualizar();
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					PantallaCarga p = new PantallaCarga();
					p.setVisible(true);
				}
			});
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error Fatal", JOptionPane.ERROR_MESSAGE);
		}
	}

}
