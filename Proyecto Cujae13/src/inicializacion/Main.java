package inicializacion;

import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import interfaz.clases.PantallaCarga;

/**
 * Inicializaci�n de la aplicaci�n Cujae13
 * 
 * @version 2023.05.19
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 * @author Eduardo Gonz�lez
 *
 */
public class Main {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("es"));
		FlatLightLaf.setup();
		
		try {
			//Provisional
			Rellenadora.borrarDatos();
			Rellenadora.rellenarDatos();
			
			Inicializadora.inicializarAplicacion();
			
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
