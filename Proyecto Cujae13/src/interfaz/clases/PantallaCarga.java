package interfaz.clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;

import componentes.Imagen;
import componentes.PanelAnimacionCurvas;
import definiciones.DefinicionesInterfaz;
import java.awt.Toolkit;

/**
 * JDialog que modela la pantalla de carga de la aplicación Cujae13.
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PantallaCarga extends JDialog {

	private static final long serialVersionUID = 1L;
	private PanelAnimacionCurvas panelBase;
	private Imagen logo;
	private JProgressBar barraProgreso;
	private JLabel estado;


	public PantallaCarga() {
		setTitle("Cujae13");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaCarga.class.getResource("/interfaz/iconos/icono.png")));
		FlatMaterialDeepOceanIJTheme.setup();
		
		this.setBounds(100, 100, DefinicionesInterfaz.DIMENSION_PANTALLA_CARGA.width, DefinicionesInterfaz.DIMENSION_PANTALLA_CARGA.height);
		this.setUndecorated(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent evt) {
				programaEstado();
			}
		});
		
		panelBase = new PanelAnimacionCurvas(DefinicionesInterfaz.COLOR_GRADIENTE_INICIO_PC, DefinicionesInterfaz.COLOR_GRADIENTE_FINAL_PC, DefinicionesInterfaz.COLOR_ANIM_INICIO_PC, DefinicionesInterfaz.COLOR_ANIM_FINAL_PC);
		panelBase.iniciarAnimacion();
		panelBase.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(panelBase);
		
		//logo = new Imagen(new ImageIcon(PantallaCarga.class.getResource("/imagenes/logoMinsap.png")));
		logo = new Imagen(null);
		logo.setImagen(new ImageIcon(PantallaCarga.class.getResource("/interfaz/imagenes/logo1Copia.png")));
		logo.setBounds(118, 30, 276, 249);
		
	    barraProgreso = new JProgressBar();
	    barraProgreso.setForeground(DefinicionesInterfaz.COLOR_BARRA_PROGRESO);
	    barraProgreso.setBounds(149, 285, 223, 17);
		
		estado = new JLabel("Cargando ...");
		estado.setBounds(113, 313, 295, 36);
		estado.setHorizontalAlignment(SwingConstants.CENTER);
		estado.setForeground(Color.BLACK);
		estado.setFont(new Font("Roboto Medium", Font.PLAIN, 19));
		panelBase.setLayout(null);
		panelBase.add(logo);
		panelBase.add(barraProgreso);
		panelBase.add(estado);
		
		this.setLocationRelativeTo(null);
		
	}
	
	private void actualizarEstado(int n) {
		this.estado.setText(estadoImpresion(n));
		this.barraProgreso.setValue(n);
	}
	private void programaEstado() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Random r = new Random();
					for(int n=0;n<=100;n++) {
						Thread.sleep(r.nextInt(11)+(long)20);
						if(r.nextBoolean())
							Thread.sleep(DefinicionesInterfaz.DEMORA_BARRA_PROGRESO_PC);
						actualizarEstado(n);
					}
					Thread.sleep(450);
					terminarVentana();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	private String estadoImpresion(int n) {
		String r = "";
		
		if(n<=20) 
			r = "Cargando Núcleo ...";
		else if(n<=45) 
			r = "Conectando ...";
		else if(n<=68) 
			r = "Sincronizando con la Nube ...";
		else if(n<=90) 
			r = "Inicializando Interfaz ...";
		else 
			r = "Lanzando sistema";
			
		return r;
	}
	private void terminarVentana() {
		try {
			//Datos.getInstancia();
			panelBase.detenerAnimacion();
			this.dispose();
			Autenticacion login = new Autenticacion();
			login.setVisible(true);
		}catch(Exception e) {
			programaEstado();
		}
	}
}
