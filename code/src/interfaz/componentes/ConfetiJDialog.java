package interfaz.componentes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

import componentes.Imagen;
import interfaz.clases.AppPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ConfetiJDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	private ConfettiAnim confettiAnim;
	private AudioClip audio;
	
	public ConfetiJDialog(JFrame padre, boolean medalla, Color color) {
		super(padre, true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				confettiAnim.detenerAnim();
				audio.stop();
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				confettiAnim.detenerAnim();
				audio.stop();
				dispose();
			}
		});
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				confettiAnim.detenerAnim();
				audio.stop();
				dispose();
			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_F4)
					e.consume();
			}
		});
		setUndecorated(true);
		this.setBackground(new Color(color.getRed(),color.getGreen(),color.getBlue(),100));
		this.setBounds(0,0,1200,675);
		getContentPane().setLayout(null);
		
		audio = Applet.newAudioClip(AppPrincipal.class.getResource("/audio/aplausos.wav"));
		//audio.play();
		audio.loop();
		
		PanelRedondeado panelRedondeado = new PanelRedondeado();
		panelRedondeado.setBounds(300, 162, 600, 350);
		getContentPane().add(panelRedondeado);
		
		JLabel lblNewLabel = new JLabel("Felicidades Ganador");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 263, 476, 49);
		panelRedondeado.add(lblNewLabel);
		
		Imagen imagen = new Imagen(new ImageIcon(AppPrincipal.class.getResource("/interfaz/iconos/"+(medalla ? "trofeo.png" : "premio.png"))));
		imagen.setBounds(225, 75, 150, 150);
		panelRedondeado.add(imagen);
		
		confettiAnim = new ConfettiAnim();
		confettiAnim.setBounds(0, 4, 600, 346);
		confettiAnim.iniciarAnim();
		panelRedondeado.add(confettiAnim);
		
		this.setLocationRelativeTo(padre);
	}
}
