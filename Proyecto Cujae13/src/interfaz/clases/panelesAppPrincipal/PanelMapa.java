package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.Imagen;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.graph.vertex.WeightedVertex;
import interfaz.clases.AppPrincipal;
import interfaz.clases.Autenticacion;
import interfaz.componentes.PinMapa;
import nucleo.Localizacion;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Auxiliares;

/**
 * JPanel que modela la pantalla de Mapa de la aplicación.<br><br>
 * 
 * <b>RESPONSABILIDAD: </b>Eduardo González
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class PanelMapa extends PanelBaseAppPrincipal{
	private static final long serialVersionUID = 1L;
	private JLabel seleccionarLocalizacionLbl;
	private JButton botonAyuda;
	private JButton capaBtn;
	private Imagen mapa;
	private boolean tipoMapa;
	private LinkedList<PinMapa> pines;
	private JTabbedPane tab;
	
	public PanelMapa(EsquemaColores e, JFrame padre, JTabbedPane tab) {
		tipoMapa = true;
		this.tab = tab;
		
		botonAyuda = new JButton();
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Seleccione cualquiera de las localizaciones disponibles. Si no está en color rojo "
						+ "significa que la localización no presenta deportes con partidos activos hoy. Ponga el puntero del mouse en la localización "
						+ "deseada para conocer el nombre del lugar y una previsualización del mismo en forma de fotografía. Haga click en la localización "
						+ "deseada para poder acceder a la ventana de <Selección de Deportes>. Haga click en el botón de capas para cambiar el tipo de "
						+ "mapa mostrado.");
				m.eventOK(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						GlassPanePopup.closePopupLast();
					}
				});
				GlassPanePopup.showPopup(m, o);
				
			}
		});
		botonAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAyuda.setIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help0.png")));
		botonAyuda.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(36,36), AppPrincipal.class.getResource("/interfaz/iconos/help1.png")));
		botonAyuda.setContentAreaFilled(false);
		botonAyuda.setBorder(null);
		botonAyuda.setBounds(843, 42, 36, 36);
		add(botonAyuda);
		
		seleccionarLocalizacionLbl = new JLabel("Seleccionar Localización");
		seleccionarLocalizacionLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		seleccionarLocalizacionLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		//nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		seleccionarLocalizacionLbl.setBounds(10, 35, 869, 45);
		add(seleccionarLocalizacionLbl);
		
		crearLocalizaciones(e,padre);
		dibujarLocalizaciones();
		
		capaBtn = new JButton();
		capaBtn.setToolTipText("Capas del Mapa");
		capaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tipoMapa) {
					tipoMapa = false;
					cambiarMapaFisico();
				}
				else {
					tipoMapa = true;
					cambiarMapaVirtual();
				}
			}
		});
		capaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		capaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasBlack01.png")));
		capaBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasBlack02.png")));
		capaBtn.setContentAreaFilled(false);
		capaBtn.setBorder(null);
		capaBtn.setBounds(56, 464, 64, 64);
		add(capaBtn);
		
		mapa = new Imagen(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/mapa01.png")));
		mapa.setBorder(new LineBorder(e.getBordeLbl(), 2));
		mapa.setBounds(10, 91, 869, 473);
		add(mapa);
		
	}	
	
	private void cambiarMapaFisico() {
		//Btn Capas
		capaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasWhite01.png")));
		capaBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasWhite02.png")));
		
		//Mapa
		mapa.setImagen(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/mapa02.png")));
		mapa.repaint();
		
		//Pines
		Iterator<PinMapa> iter = pines.iterator();
		while(iter.hasNext()) {
			PinMapa p = iter.next();
			if(!p.estaActiva()) {
				p.setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinWhite01.png")));
				p.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinWhite02.png")));
			}
		}
	}
	
	private void cambiarMapaVirtual() {
		//Btn Capas
		capaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasBlack01.png")));
		capaBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasBlack02.png")));
	
		//Mapa
		mapa.setImagen(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/mapa01.png")));
		mapa.repaint();
		
		//Pines
		Iterator<PinMapa> iter = pines.iterator();
		while(iter.hasNext()) {
			PinMapa p = iter.next();
			if(!p.estaActiva()) {
				p.setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack01.png")));
				p.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack02.png")));
			}
		}
	}
	
	private void crearLocalizaciones(EsquemaColores e, JFrame p) {
		pines = new LinkedList<>();
		
		//SUPER PROVISIONAL
//		LinkedList<LocalizacionPeso> l = new LinkedList<LocalizacionPeso>();
//		l.add(new LocalizacionPeso(new Localizacion(null,"Dojo","/interfaz/imagenes/avatar_autenticacion.jpg",323,301),true));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Bajos del Edificio 19 de Informática","/interfaz/imagenes/avatar_autenticacion.jpg",144,206), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Pista de Atletismo","/interfaz/imagenes/avatar_autenticacion.jpg",656,343), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Terreno de Pelota","/interfaz/imagenes/avatar_autenticacion.jpg",558,427), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Terreno de Fútbol","/interfaz/imagenes/avatar_autenticacion.jpg",455,450), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Canchas de VolleyBall 1","/interfaz/imagenes/avatar_autenticacion.jpg",432,416), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Canchas de VolleyBall 2","/interfaz/imagenes/avatar_autenticacion.jpg",420,353), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Canchas de BasketBall","/interfaz/imagenes/avatar_autenticacion.jpg",452,380), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Piscina de Natación","/interfaz/imagenes/avatar_autenticacion.jpg",509,328), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"DEDER","/interfaz/imagenes/avatar_autenticacion.jpg",495,404), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Local del DEDER","/interfaz/imagenes/avatar_autenticacion.jpg",495,439), false));
//		l.add(new LocalizacionPeso(new Localizacion(null,"Bajos del Edificio de Arquitectura","/interfaz/imagenes/avatar_autenticacion.jpg",101,397), false));
		
		Iterator<Vertex<Localizacion>> iter = Universidad.getInstancia().getLocalizaciones().getVerticesList().iterator();
		
		while(iter.hasNext()) {
			WeightedVertex<Localizacion, Boolean> v = (WeightedVertex<Localizacion, Boolean>)iter.next();
			pines.add(new PinMapa(e,v,this,p,tab));
		}
	}
	
	private void dibujarLocalizaciones() {
		Iterator<PinMapa> iter = pines.iterator();
		
		while(iter.hasNext()) {
			this.add(iter.next());
		}
	}
}
