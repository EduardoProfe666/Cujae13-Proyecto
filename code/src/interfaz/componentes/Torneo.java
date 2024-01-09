package interfaz.componentes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clasesAuxiliares.EsquemaColores;
import componentes.AvatarCircular;
import cu.edu.cujae.ceis.tree.binary.BinaryTree;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import nucleo.InicializacionPartidosDeporte.EventoFecha;
import nucleo.Universidad;
import componentes.Imagen;
import javax.swing.Icon;

public class Torneo extends JPanel{
	private static final long serialVersionUID = 1L;
	private LineaTorneo lineaSemi1;
	private LineaTorneo lineaSemi2;
	private LineaTorneo lineaCuartos1;
	private LineaTorneo lineaCuartos2;
	private LineaTorneo lineaCuartos3;
	private LineaTorneo lineaCuartos4;
	private LineaTorneo lineaOctavos;
	private EventoTorneo eliminatoria;
	private EventoTorneo cuartos4;
	private EventoTorneo cuartos3;
	private EventoTorneo cuartos2;
	private EventoTorneo cuartos1;
	private EventoTorneo semi1;
	private EventoTorneo semi2;
	private EventoTorneo finall;
	private AvatarCircular ganadorAvatar;
	
	public Torneo(BinaryTree<EventoFecha> torneo, JFrame padre, EsquemaColores e) {
		BinaryTreeNode<EventoFecha> raiz = (BinaryTreeNode<EventoFecha>)torneo.getRoot();
		
		setBounds(10, 128, 569, 436);
		setBackground(Color.WHITE);
		setLayout(null);
		
		String urlInd = "/interfaz/iconos/indeterminado01.png";
		
		Imagen indeterminadoE = new Imagen((Icon) null);
		indeterminadoE.setVisible(false);
		indeterminadoE.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoE.setBounds(539, 357, 30, 30);
		add(indeterminadoE);
		
		Imagen indeterminadoC1 = new Imagen((Icon) null);
		indeterminadoC1.setVisible(false);
		indeterminadoC1.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoC1.setBounds(121, 267, 30, 30);
		add(indeterminadoC1);
		
		Imagen indeterminadoC2 = new Imagen((Icon) null);
		indeterminadoC2.setVisible(false);
		indeterminadoC2.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoC2.setBounds(262, 267, 30, 30);
		add(indeterminadoC2);
		
		Imagen indeterminadoC3 = new Imagen((Icon) null);
		indeterminadoC3.setVisible(false);
		indeterminadoC3.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoC3.setBounds(402, 267, 30, 30);
		add(indeterminadoC3);
		
		Imagen indeterminadoC4 = new Imagen((Icon) null);
		indeterminadoC4.setVisible(false);
		indeterminadoC4.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoC4.setBounds(539, 267, 30, 30);
		add(indeterminadoC4);
		
		Imagen indeterminadoF = new Imagen((Icon) null);
		indeterminadoF.setVisible(false);
		indeterminadoF.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoF.setBounds(333, 104, 30, 30);
		add(indeterminadoF);
		
		Imagen indeterminadoS2 = new Imagen((Icon) null);
		indeterminadoS2.setVisible(false);
		indeterminadoS2.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoS2.setBounds(476, 180, 30, 30);
		add(indeterminadoS2);
		
		Imagen indeterminadoS1 = new Imagen((Icon) null);
		indeterminadoS1.setVisible(false);
		indeterminadoS1.setImagen(new ImageIcon(Torneo.class.getResource(urlInd)));
		indeterminadoS1.setBounds(62, 180, 30, 30);
		add(indeterminadoS1);
		
		eliminatoria = new EventoTorneo(e, padre, raiz.getRight().getRight().getRight().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(eliminatoria.getEvento().getEvento(), eliminatoria.getEvento().getFecha())==1)
			indeterminadoE.setVisible(true);
		eliminatoria.setBounds(429, 369, 130, 56);
		add(eliminatoria);
		
		cuartos1 = new EventoTorneo(e, padre, raiz.getLeft().getLeft().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(cuartos1.getEvento().getEvento(), cuartos1.getEvento().getFecha())==1)
			indeterminadoC1.setVisible(true);
		cuartos1.setBounds(9, 281, 130, 56);
		add(cuartos1);
		
		cuartos2 = new EventoTorneo(e, padre, raiz.getLeft().getRight().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(cuartos2.getEvento().getEvento(), cuartos2.getEvento().getFecha())==1)
			indeterminadoC2.setVisible(true);
		cuartos2.setBounds(148, 281, 130, 56);
		add(cuartos2);
		
		cuartos3 = new EventoTorneo(e, padre, raiz.getRight().getLeft().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(cuartos3.getEvento().getEvento(), cuartos3.getEvento().getFecha())==1)
			indeterminadoC3.setVisible(true);
		cuartos3.setBounds(287, 281, 130, 56);
		add(cuartos3);
		
		cuartos4 = new EventoTorneo(e, padre, raiz.getRight().getRight().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(cuartos4.getEvento().getEvento(), cuartos4.getEvento().getFecha())==1)
			indeterminadoC4.setVisible(true);
		cuartos4.setBounds(426, 281, 130, 56);
		add(cuartos4);
		
		semi1 = new EventoTorneo(e, padre, raiz.getLeft().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(semi1.getEvento().getEvento(), semi1.getEvento().getFecha())==1)
			indeterminadoS1.setVisible(true);
		semi1.setBounds(76, 195, 130, 56);
		add(semi1);
		
		semi2 = new EventoTorneo(e, padre, raiz.getRight().getInfo());
		if(Universidad.getInstancia().getEstadoEvento(semi2.getEvento().getEvento(), semi2.getEvento().getFecha())==1)
			indeterminadoS2.setVisible(true);
		semi2.setBounds(361, 195, 130, 56);
		add(semi2);
		
		finall = new EventoTorneo(e, padre, (raiz.getInfo()));
		if(Universidad.getInstancia().getEstadoEvento(finall.getEvento().getEvento(), finall.getEvento().getFecha())==1)
			indeterminadoF.setVisible(true);
		finall.setBounds(219, 118, 130, 56);
		add(finall);
		
		ganadorAvatar = new AvatarCircular(new ImageIcon(Torneo.class.getResource(finall.getDirUrlFacultadGanadora())), 3);
		ganadorAvatar.setToolTipText("Ganador");
		ganadorAvatar.setForeground(finall.getColorBordeAvatarFacultadGanadora());
		ganadorAvatar.setBounds(237, 11, 95, 96);
		add(ganadorAvatar);
		
		lineaSemi1 = new LineaTorneo(semi1.getColorBorde(), 2, 2);
		lineaSemi1.setBounds(203, 172, 18, 24);
		add(lineaSemi1);
		
		lineaSemi2 = new LineaTorneo(semi2.getColorBorde(), 2, 3);
		lineaSemi2.setBounds(346, 172, 17, 24);
		add(lineaSemi2);
		
		lineaCuartos1 = new LineaTorneo(cuartos1.getColorBorde(), 2, 2);
		lineaCuartos1.setBounds(86, 250, 65, 31);
		add(lineaCuartos1);
		
		lineaCuartos2 = new LineaTorneo(cuartos2.getColorBorde(), 2, 3);
		lineaCuartos2.setBounds(143, 250, 69, 31);
		add(lineaCuartos2);
		
		lineaCuartos3 = new LineaTorneo(cuartos3.getColorBorde(), 2, 2);
		lineaCuartos3.setBounds(351, 250, 73, 31);
		add(lineaCuartos3);
		
		lineaCuartos4 = new LineaTorneo(cuartos4.getColorBorde(), 2, 3);
		lineaCuartos4.setBounds(426, 250, 69, 31);
		add(lineaCuartos4);
		
		lineaOctavos = new LineaTorneo(eliminatoria.getColorBorde(), 2, 2);
		lineaOctavos.setBounds(490, 336, 38, 33);
		add(lineaOctavos);
		
		rellenar();
	}
	
	private void rellenar() {
		
	}
}
