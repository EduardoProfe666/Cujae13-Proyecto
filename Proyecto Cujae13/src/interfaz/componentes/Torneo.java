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

public class Torneo extends JPanel{
	private static final long serialVersionUID = 1L;
	private LineaTorneo lineaSemi1;
	private LineaTorneo lineaSemi2;
	private LineaTorneo lineaCuartos1;
	private LineaTorneo lineaCuartos2;
	private LineaTorneo lineaCuartos3;
	private LineaTorneo lineaCuartos4;
	private LineaTorneo lineaOctavos;
	private EventoTorneo octavos;
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
		
		octavos = new EventoTorneo(e, padre, raiz.getRight().getRight().getRight().getInfo());
		octavos.setBounds(429, 369, 130, 56);
		add(octavos);
		
		cuartos1 = new EventoTorneo(e, padre, raiz.getLeft().getLeft().getInfo());
		cuartos1.setBounds(9, 281, 130, 56);
		add(cuartos1);
		
		cuartos2 = new EventoTorneo(e, padre, raiz.getLeft().getRight().getInfo());
		cuartos2.setBounds(148, 281, 130, 56);
		add(cuartos2);
		
		cuartos3 = new EventoTorneo(e, padre, raiz.getRight().getLeft().getInfo());
		cuartos3.setBounds(287, 281, 130, 56);
		add(cuartos3);
		
		cuartos4 = new EventoTorneo(e, padre, raiz.getRight().getRight().getInfo());
		cuartos4.setBounds(426, 281, 130, 56);
		add(cuartos4);
		
		semi1 = new EventoTorneo(e, padre, raiz.getLeft().getInfo());
		semi1.setBounds(76, 195, 130, 56);
		add(semi1);
		
		semi2 = new EventoTorneo(e, padre, raiz.getRight().getInfo());
		semi2.setBounds(361, 195, 130, 56);
		add(semi2);
		
		finall = new EventoTorneo(e, padre, (raiz.getInfo()));
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
		
		lineaOctavos = new LineaTorneo(octavos.getColorBorde(), 2, 2);
		lineaOctavos.setBounds(490, 336, 38, 33);
		add(lineaOctavos);
		
		rellenar();
	}
	
	private void rellenar() {
		
	}
}
