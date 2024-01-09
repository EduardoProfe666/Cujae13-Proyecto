package interfaz.componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.Timer;

public class ConfettiAnim extends JComponent{
	private static final long serialVersionUID = 1L;
	private Timer t;
	private Timer tDestructor;
	private int contador;

	public ConfettiAnim() {
		setLayout(null);
		setBackground(new Color(255,255,255,0));
		setOpaque(false);

		t = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 9;
				while(i-->0) {
					add(new Confeti(randomColor(), 10, getWidth(), getHeight(), false));
					add(new Confeti(randomColor(), 10, getWidth(), getHeight(), true));
				}
			}

		});
		tDestructor = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(contador++>2) {
					Component[] c = getComponents();
					for(int i=0;i<c.length/3;i++) {
						remove(0);
					}
				}
			}
		});
	}

	public void iniciarAnim(){
		contador=0;
		t.start();
		tDestructor.start();
	}

	public void detenerAnim() {
		t.stop();
		tDestructor.stop();
		this.removeAll();
	}

	private Color randomColor() {
		LinkedList<Color> colores = new LinkedList<>();

		colores.add(new Color(239,241,67));
		colores.add(new Color(187,32,46));
		colores.add(new Color(16,118,180));
		colores.add(new Color(96,44,149));
		colores.add(new Color(7,7,7));
		colores.add(new Color(251,87,39));
		colores.add(new Color(119,128,125));
		colores.add(new Color(246,244,246));
		colores.add(new Color(0,104,48));



		return colores.get(new Random().nextInt(colores.size()));
	}



























}
