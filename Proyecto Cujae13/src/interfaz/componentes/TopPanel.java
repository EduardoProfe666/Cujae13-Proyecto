package interfaz.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import componentes.PanelBordeOval;
import definiciones.DefinicionesInterfaz;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.Message;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

/**
 * Componente gráfico que modela el panel superior movible de la aplicación Cujae13
 * 
 * @version 2023.06.02
 * @author Eduardo González
 *
 */
public class TopPanel extends PanelBordeOval{
	private static final long serialVersionUID = 1L;
	private Color colorBase;
	private Color colorPresionado;
	private int xMouseDrag;
	private int yMouseDrag;
	private JLabel etiqueta;
	private JButton salirBtn;
	private JButton minimizarBtn;
	private boolean b;

	public TopPanel(Color color, JFrame raiz, String etiqueta) {
		super(DefinicionesInterfaz.ESQUINA_BORDE_OVAL_PS, DefinicionesInterfaz.ESQUINA_BORDE_OVAL_PS,0,0);
		if(raiz==null)
			throw new RuntimeException("La raiz no puede ser null");
		
		colorBase = new Color(color.getRed(),color.getGreen(),color.getBlue(),150);
		colorPresionado = new Color(color.getRed(),color.getGreen(),color.getBlue(),200);
		
		this.setBounds(0, 0, raiz.getBounds().width, 45);
		this.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		this.setBackground(colorBase);
		
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				raiz.setLocation(x-xMouseDrag,y-yMouseDrag);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorPresionado);
				xMouseDrag = e.getX();
				yMouseDrag = e.getY();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				setBackground(colorBase);
			}
		});
		
		this.etiqueta = new JLabel(etiqueta);
		this.etiqueta.setBounds(16, 6, 400, 38);
		this.etiqueta.setFont(new Font("Roboto Black", Font.PLAIN, 21));
		
		salirBtn = new JButton("");
		b = false;
		salirBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Option o = OptionConstructor.constructOption(color, false);
				Message m = new Message("Salida de la Aplicación", DefinicionesInterfaz.PREGUNTA_SALIR);
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
						System.exit(0);
						b = true;
					}
				});
				
				GlassPanePopup.showPopup(m, o);
				if(!b)
					salirBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/exit0.png")));
				
					
			}
		});
		salirBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				salirBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/exit1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				salirBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/exit0.png")));
			}
		});
		salirBtn.setContentAreaFilled(false);
		salirBtn.setBounds(raiz.getBounds().width-43, 4, 36, 36);
		salirBtn.setHorizontalAlignment(SwingConstants.CENTER);
		salirBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		salirBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salirBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/exit0.png")));
	
		minimizarBtn = new JButton("");
		minimizarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				raiz.setState(Frame.ICONIFIED);
			}
		});
		minimizarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizarBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/minimize1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimizarBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/minimize0.png")));
			}
		});
		minimizarBtn.setContentAreaFilled(false);
		minimizarBtn.setBounds(raiz.getBounds().width-80, 4, 36, 36);
		minimizarBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		minimizarBtn.setHorizontalAlignment(SwingConstants.CENTER);
		minimizarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		minimizarBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), TopPanel.class.getResource("/interfaz/iconos/minimize0.png")));
		
		this.setLayout(null);
		this.add(this.etiqueta);
		this.add(salirBtn);
		this.add(minimizarBtn);
	}
	
	public JButton getMinimizarBtn() {
		return minimizarBtn;
	}
	

}
