package interfaz.componentes;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cu.edu.cujae.ceis.graph.vertex.WeightedVertex;
import interfaz.clases.AppPrincipal;
import nucleo.Localizacion;
import utilidades.Auxiliares;

public class PinRuta extends JButton{
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private Localizacion localizacion;
	private int estado;
	
	public PinRuta(WeightedVertex<Localizacion, Boolean> l, JPanel parent, JFrame p) {
		x = l.getInfo().getCoordenadaX();
		y = l.getInfo().getCoordenadaY();
		localizacion = l.getInfo();
		this.estado = 0;
		
		setToolTipText(localizacion.getNombre());
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setContentAreaFilled(false);
		setBorder(null);
		setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack01.png")));
		setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack02.png")));
		setBounds(x, y, 30, 30);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent x) {
				if(estado==0)
					firePropertyChange("Seleccionado",1,2);
			}
			@Override
			public void mouseEntered(MouseEvent x) {
				
			}
			@Override
			public void mouseExited(MouseEvent x) {
				
			}
		});

	}
	
	public Localizacion getLocalizacion() {
		return localizacion;
	}
	
	/**
	 * 
	 * @return 0->No Especial, 1->Nodo Inicial, 2->Nodo Final, 3->Nodo Medio
	 */
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public void reiniciar() {
		estado = 0;
		setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack01.png")));
		setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack02.png")));
	}


}
