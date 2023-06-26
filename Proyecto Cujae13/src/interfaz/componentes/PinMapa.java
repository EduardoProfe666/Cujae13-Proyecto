package interfaz.componentes;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import clasesAuxiliares.EsquemaColores;
import cu.edu.cujae.ceis.graph.vertex.WeightedVertex;
import interfaz.clases.AppPrincipal;
import interfaz.clases.jdialogs.ElegirDeporteJDialog;
import nucleo.Localizacion;
import utilidades.Auxiliares;

public class PinMapa extends JButton{
	private static final long serialVersionUID = 1L;
	private LocalizacionPreview preview;
	private boolean activo;
	private int x;
	private int y;

	public PinMapa(EsquemaColores e, WeightedVertex<Localizacion, Boolean> l, JPanel parent, JFrame p, JTabbedPane tab) {
		activo = l.getWeight();
		x = l.getInfo().getCoordenadaX();
		y = l.getInfo().getCoordenadaY();

		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setToolTipText(activo ? "Activa" : "No Activa" );
		setContentAreaFilled(false);
		setBorder(null);
		setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/" + (activo ? "pinActivo01.png" : "pinBlack01.png"))));
		setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/" + (activo ? "pinActivo02.png" : "pinBlack02.png"))));
		setBounds(x, y, 30, 30);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				ElegirDeporteJDialog ventana = new ElegirDeporteJDialog(l.getInfo().getNombre(), e, p, l.getInfo().getDeportes(),tab);
				ventana.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent x) {
				preview.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent x) {
				preview.setVisible(false);
			}
		});

		Coord c = calcularCoordenadasPreview();
		preview = new LocalizacionPreview(e, l.getInfo().getNombre(), l.getInfo().getDirUrlImagen(), activo, c.getX(), c.getY());
		parent.add(preview);
		preview.setVisible(false);

	}

	private Coord calcularCoordenadasPreview() {
		Coord c = null;
		int xC = x-10;
		int yC = y-91;


		//Esquina Superior Izquierda
		if(xC-330>5 && yC-230>5) 
			c = new Coord((xC+10)-330,(yC+91)-230);

		//Esquina Superior Derecha
		else if(xC+30<864 && yC-230>5) 
			c = new Coord((xC+10)+30,(yC+91)-230);

		//Esquina Inferior Izquierda
		else if(xC-330>5 && yC+30+230<468) 
			c = new Coord((xC+10)-330,(yC+91)+30);

		//Esquina Inferior Derecha
		else 
			c = new Coord((xC+10)+30,(yC+91)+30);


		return c;
	}


	private class Coord {
		private int x;
		private int y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}

	public boolean estaActiva() {
		return activo;
	}

}
