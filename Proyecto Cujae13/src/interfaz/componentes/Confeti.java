package interfaz.componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.Timer;

public class Confeti extends JComponent{
	private static final long serialVersionUID = 1L;
	private Timer t;
	private int yFin;
	private double pendiente;
	private int ancho;
	
	//Orientacion: true>SupIzq, false>SupDer
	public Confeti(Color c, int diametro, int anchoPantalla, int largoPantalla, boolean orientacion) {
		setBounds(orientacion ? 0 : anchoPantalla,0,diametro,diametro);
		setBackground(c);
		yFin = largoPantalla;
		
		
		ancho = anchoPantalla;
		pendiente = pendienteRandom();
		
		t = new Timer(3, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = getX();
				int y = getY();
				
				if(y==yFin || getBackground().getAlpha()==0) {
					setVisible(false);
					t.stop();
				}
				if(orientacion) {
					setBounds((x+1), y(x), diametro, diametro);
				}
				else {
					setBounds(x-1,yN(x),diametro,diametro);
				}
				if(y>=100)
					setBackground(new Color(getBackground().getRed(),getBackground().getGreen(),getBackground().getBlue(),(int)(getBackground().getAlpha()*99.0/100.0)));
			}
		});
		t.start();
	}
	
	private static double pendienteRandom() {
		LinkedList<Double> pendientes = new LinkedList<Double>();
		pendientes.add(1.0);
		pendientes.add(1.1);
		pendientes.add(1.2);
		pendientes.add(1.3);
		pendientes.add(1.5);
		pendientes.add(1.7);
		pendientes.add(1.8);
		pendientes.add(2.0);
		pendientes.add(3.0);
		pendientes.add(4.0);
		
		pendientes.add(0.9);
		pendientes.add(0.8);
		pendientes.add(0.7);
		pendientes.add(0.6);
		pendientes.add(0.5);
		pendientes.add(0.4);
		pendientes.add(0.3);
		
		return pendientes.get(new Random().nextInt(pendientes.size()));
	}
	
	private int y(int x) {
		return (int)(x*pendiente);
	}
	
	private int yN(int x) {
		return (int)((-pendiente*x)+(pendiente*ancho));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		int ancho = getWidth();
        int alto = getHeight();
        BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, ancho, alto, alto, alto);
        g2.dispose();
        g.drawImage(img, 0, 0, null);
        super.paintComponent(g);
	}

}
