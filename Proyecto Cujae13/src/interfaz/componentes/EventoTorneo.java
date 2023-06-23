package interfaz.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.AvatarCircular;
import interfaz.clases.jdialogs.PartidoJDialog;
import nucleo.EventoFinalizado;
import nucleo.Facultad;
import nucleo.InicializacionPartidosDeporte.EventoFecha;
import nucleo.NombreFacultad;
import utilidades.Archivador;

public class EventoTorneo extends JPanel{
	private static final long serialVersionUID = 1L;
	private AvatarCircular facultadPrimera;
	private AvatarCircular facultadSegunda;
	private NombreFacultad facultadGanadora;
	private String dirUrlFacultadGanadora;
	private Color bordeAvatarFacultadGanadora;
	private Color colorBorde;
	
	public EventoTorneo(EsquemaColores e, JFrame padre, EventoFecha evento) {
		colorBorde = Color.PINK;
		String dirUrlFacultadPrimera = "/interfaz/iconos/help0.png";
		String dirUrlFacultadSegunda = "/interfaz/iconos/help0.png";
		dirUrlFacultadGanadora = "/interfaz/iconos/help0.png";
		bordeAvatarFacultadGanadora = Color.WHITE;
		Color bordeAvatarPrimera = Color.WHITE;
		Color bordeAvatarSegunda = Color.WHITE;
		
		Facultad fPrimera = evento.getEvento().getFacultadPrimera();
		Facultad fSegunda = evento.getEvento().getFacultadSegunda();
		
		if(fPrimera!=null) {
			dirUrlFacultadPrimera = Archivador.getEsquemaColores(fPrimera.getNombre()).getDirUrlImagenAvatar();
			bordeAvatarPrimera = Archivador.getEsquemaColores(fPrimera.getNombre()).getBordeAvatar();
		}
		
		if(fSegunda!=null) {
			dirUrlFacultadSegunda = Archivador.getEsquemaColores(fSegunda.getNombre()).getDirUrlImagenAvatar();
			bordeAvatarSegunda = Archivador.getEsquemaColores(fSegunda.getNombre()).getBordeAvatar();
		}
		
		
		if(fPrimera!=null && fSegunda!=null && evento.getEvento() instanceof EventoFinalizado) {
			if(((EventoFinalizado)evento.getEvento()).getResultado().getFacultadGanadora().getNombre().equals(fPrimera.getNombre()))
				facultadGanadora = fPrimera.getNombre();
			else
				facultadGanadora = fSegunda.getNombre();
		}
		else
			facultadGanadora = null;
		
		if(facultadGanadora!=null) {
			colorBorde = Archivador.getEsquemaColores(facultadGanadora).getBordeLbl();
			dirUrlFacultadGanadora = Archivador.getEsquemaColores(facultadGanadora).getDirUrlImagenAvatar();
			bordeAvatarFacultadGanadora = Archivador.getEsquemaColores(facultadGanadora).getBordeAvatar();
		}
		
		setBackground(e.getColorFondoTorneo());
		setPreferredSize(new Dimension(130, 56));
		setBorder(new LineBorder(colorBorde, 2));
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		facultadPrimera = new AvatarCircular(new ImageIcon(EventoTorneo.class.getResource(dirUrlFacultadPrimera)), 3);
		facultadPrimera.setForeground(bordeAvatarPrimera);
		facultadPrimera.setBounds(3, 5, 45, 45);
		add(facultadPrimera);
		
		facultadSegunda = new AvatarCircular(new ImageIcon(EventoTorneo.class.getResource(dirUrlFacultadSegunda)), 3);
		facultadSegunda.setForeground(bordeAvatarSegunda);
		facultadSegunda.setBounds(82, 5, 45, 45);
		add(facultadSegunda);
		
		JLabel lblNewLabel = new JLabel("VS");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(40, 21, 49, 14);
		add(lblNewLabel);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent ev) {
				PartidoJDialog ventana = new PartidoJDialog(e, padre, evento);
				ventana.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		
	}
	
	public NombreFacultad getFacultadGanadora() {
		return facultadGanadora;
	}
	
	public String getDirUrlFacultadGanadora() {
		return dirUrlFacultadGanadora;
	}
	
	public Color getColorBordeAvatarFacultadGanadora() {
		return bordeAvatarFacultadGanadora;
	}
	
	public Color getColorBorde() {
		return colorBorde;
	}
}
