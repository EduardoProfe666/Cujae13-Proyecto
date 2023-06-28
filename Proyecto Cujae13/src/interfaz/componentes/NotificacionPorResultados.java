package interfaz.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class NotificacionPorResultados extends JButton {

    private static final long serialVersionUID = 1L;
    private int alfa;
    private Timer t;
    private boolean sentido;
    
    public NotificacionPorResultados() {
    	sentido = true;
    	alfa = 255;
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setBackground(new Color(255,255,255,alfa));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        t = new Timer(3,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(alfa==255)
					sentido=false;
				else if(alfa==0)
					sentido=true;
				
				if(sentido) {
					setBackground(new Color(255,255,255,alfa++));
				}
				else
					setBackground(new Color(255,255,255,alfa--));
				
			}
		});
    }
    
    public void animar(boolean b) {
    	if(!b) {
    		t.stop();
    		alfa = 255;
    		setBackground(new Color(255,255,255,alfa));
    		setVisible(false);
    	}
    	else {
    		alfa = 255;
    		setBackground(new Color(255,255,255,alfa));
    		setVisible(true);
    		t.start();
    	}
    }
    
    @Override
    public void setText(String text) {
    	
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int ancho = getWidth();
        int alto = getHeight();
        BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, ancho, alto, alto, alto);
        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}

