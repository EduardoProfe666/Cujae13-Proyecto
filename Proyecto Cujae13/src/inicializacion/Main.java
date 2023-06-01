package inicializacion;

import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.JOptionPane;

import interfaz.clases.PantallaCarga;

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

	public static void main(String[] args) {
		Locale.setDefault(new Locale("es"));
		try {
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
