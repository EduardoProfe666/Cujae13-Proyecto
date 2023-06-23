package interfaz.componentes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class LineaTorneo extends JComponent{
	private static final long serialVersionUID = 1L;
	
	public static final int ORIENTACION_VERTICAL = 0;
	public static final int ORIENTACION_HORIZONTAL = 1;
	public static final int ORIENTACION_DIAGONAL_DERECHA = 2;
	public static final int ORIENTACION_DIAGONAL_IZQUIERDA = 3;
	
	private Color color;
	private int grosor;
	private int orientacion;
	
	public LineaTorneo(Color color, int grosor, int orientacion) {
		setBounds(0,0,50,50);
		this.color = color;
		this.grosor = grosor;
		this.orientacion = orientacion;
		repaint();
	}
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x,y,width,height);
		repaint();
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		repaint();
	}
	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		this.grosor = grosor;
		repaint();
	}
	public int getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(int orientacion) {
		this.orientacion = orientacion;
		repaint();
	}



	@Override
	protected void paintComponent(Graphics g) {
		RenderingHints pistaRenderizacion = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION,RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		pistaRenderizacion.put(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		pistaRenderizacion.put(RenderingHints.KEY_COLOR_RENDERING,RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		pistaRenderizacion.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		pistaRenderizacion.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHints(pistaRenderizacion);
		super.paintComponent(g2);
		
		g2.setColor(color);
		g2.setStroke(new BasicStroke(grosor,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
		
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;
		
		Rectangle r = getBounds();
		
		switch(orientacion) {
		case ORIENTACION_VERTICAL:
			x1 = 0;
			y1 = 0;
			x2 = 0;
			y2 = r.height;
			break;
		case ORIENTACION_HORIZONTAL:
			x1 = 0;
			y1 = 0;
			x2 = r.width;
			y2 = 0;
			break;
		case ORIENTACION_DIAGONAL_DERECHA:
			x1 = 0;
			y1 = r.height;
			x2 = r.width;
			y2 = 0;
			break;
		case ORIENTACION_DIAGONAL_IZQUIERDA:
			x1 = 0;
			y1 = 0;
			x2 = r.width;
			y2 = r.height;
			break;
		default:
			break;	
		}
		
		g2.drawLine(x1, y1, x2, y2);
	}
}
