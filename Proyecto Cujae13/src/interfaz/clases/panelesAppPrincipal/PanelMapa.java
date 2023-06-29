package interfaz.clases.panelesAppPrincipal;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import interfaz.componentes.LineaRuta;
import interfaz.componentes.PinMapa;
import interfaz.componentes.PinRuta;
import nucleo.Localizacion;
import nucleo.NombreFacultad;
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
	private boolean modoRuta;
	private int estadoRuta; //0->Seleccionar Inicio, 1->Seleccionar Final y Mostrar Ruta
	private LinkedList<PinMapa> pines;
	private LinkedList<PinRuta> pinesRuta;
	private LinkedList<LineaRuta> lineasRuta;
	private JTabbedPane tab;
	private JButton dijkstraBtn;
	private JButton cancelarDijkstraBtn;
	private JButton infoDijkstraBtn;
	private EsquemaColores e;
	private String mensajeInfoTitulo;
	private String mensajeInfo;
	private NombreFacultad f;

	public PanelMapa(EsquemaColores e, JFrame padre, JTabbedPane tab, NombreFacultad f) {
		this.f = f;
		tipoMapa = true;
		modoRuta = false;
		this.tab = tab;
		estadoRuta = 0;
		this.e = e;
		mensajeInfoTitulo = "";
		mensajeInfo = "";

		botonAyuda = new JButton();
		botonAyuda.setToolTipText("Ayuda");
		botonAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
				MessageSinCancel m = new MessageSinCancel("Ayuda", "Seleccione cualquiera de las localizaciones disponibles. Si no está en color rojo "
						+ "significa que la localización no presenta deportes con partidos activos hoy. Ponga el puntero del mouse en la localización "
						+ "deseada para conocer el nombre del lugar y una previsualización del mismo en forma de fotografía. Haga click en la localización "
						+ "deseada para poder acceder a la ventana de <Selección de Deportes>. Haga click en el botón de Capas para cambiar el tipo de "
						+ "mapa mostrado. Haga click en el botón de Ruta para cambiar al Modo Ruta.");
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
		crearLocalizacionesRuta(padre);
		incluirLocalizaciones();
		dibujarLocalizaciones();
		crearLineasRuta();
		dibujarLineas();

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

		dijkstraBtn = new JButton();
		dijkstraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(modoRuta) {
					modoRuta = false;
					capaBtn.setEnabled(true);
					cancelarDijkstraBtn.doClick();
					cancelarDijkstraBtn.setVisible(false);
					dibujarLocalizaciones();
					esconderLineas();
					
				}else {
					modoRuta = true;
					if(!tipoMapa)
						capaBtn.doClick();
					capaBtn.setEnabled(false);
					//cancelarDijkstraBtn.setVisible(true);
					dibujarLocalizacionesRuta();
					mostrarLineas();
					estadoRuta = 0;

					Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
					MessageSinCancel m = new MessageSinCancel("Modo Ruta", "Seleccione una localización inicial y una final haciendo click en cada "
							+ "una de ellas. El sistema presentará la ruta más "
							+ "corta entre ambas localizaciones. Para desmarcar las localizaciones y seleccionar otras una vez que se ha trazado un camino, "
							+ "haga click en el botón <Cancelar> en la esquina superior derecha. Las líneas trazadas no son el camino a seguir, sino una manera de enlazar las localizaciones "
							+ "de la ruta en el orden correcto. Para salir del modo ruta, vuelva a dar click en el botón Modo Ruta.");
					m.eventOK(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							GlassPanePopup.closePopupLast();
						}
					});
					GlassPanePopup.showPopup(m, o);
				}

			}
		});
		dijkstraBtn.setToolTipText("Modo Ruta");
		dijkstraBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dijkstraBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/DijkstraB01.png")));
		dijkstraBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/DijkstraB02.png")));
		dijkstraBtn.setContentAreaFilled(false);
		dijkstraBtn.setBorder(null);
		dijkstraBtn.setBounds(130, 464, 64, 64);
		add(dijkstraBtn);

		cancelarDijkstraBtn = new JButton();
		cancelarDijkstraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				estadoRuta=0;
				infoDijkstraBtn.setVisible(false);
				dibujarLocalizacionesRuta();
				mostrarLineas();
				cancelarDijkstraBtn.setVisible(false);
			}
		});
		cancelarDijkstraBtn.setToolTipText("Cancelar");
		cancelarDijkstraBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cancelarDijkstraBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(42,42), AppPrincipal.class.getResource("/interfaz/iconos/cancelar01.png")));
		cancelarDijkstraBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(42,42), AppPrincipal.class.getResource("/interfaz/iconos/cancelar02.png")));
		cancelarDijkstraBtn.setContentAreaFilled(false);
		cancelarDijkstraBtn.setBorder(null);
		cancelarDijkstraBtn.setBounds(817, 111, 42, 42);
		cancelarDijkstraBtn.setVisible(false);
		add(cancelarDijkstraBtn);
		
		infoDijkstraBtn = new JButton();
		infoDijkstraBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				mostrarMensajeRuta();
			}
		});
		infoDijkstraBtn.setToolTipText("Información de Ruta");
		infoDijkstraBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		infoDijkstraBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(42,42), AppPrincipal.class.getResource("/interfaz/iconos/infor02.png")));
		infoDijkstraBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(42,42), AppPrincipal.class.getResource("/interfaz/iconos/infor01.png")));
		infoDijkstraBtn.setContentAreaFilled(false);
		infoDijkstraBtn.setBorder(null);
		infoDijkstraBtn.setBounds(817, 153, 42, 42);
		infoDijkstraBtn.setVisible(false);
		add(infoDijkstraBtn);
		
		mapa = new Imagen(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/mapa01.png")));
		mapa.setBorder(new LineBorder(e.getBordeLbl(), 2));
		mapa.setBounds(10, 91, 869, 473);
		add(mapa);

	}	

	private void cambiarMapaFisico() {
		//Btn Capas
		capaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasWhite01.png")));
		capaBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasWhite02.png")));

		//Btn Dijkstra
		dijkstraBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/DijkstraW01.png")));
		dijkstraBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/DijkstraW02.png")));

		//Mapa
		mapa.setImagen(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/mapa02.png")));
		mapa.repaint();

		//Pines
		Iterator<PinMapa> iter = pines.iterator();
		while(iter.hasNext()) {
			PinMapa p = iter.next();
			if(!p.estaActiva()) {
				p.setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinF01.png")));
				p.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinF02.png")));
			}
		}
	}

	private void cambiarMapaVirtual() {
		//Btn Capas
		capaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasBlack01.png")));
		capaBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/capasBlack02.png")));

		//Btn Dijkstra
		dijkstraBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/DijkstraB01.png")));
		dijkstraBtn.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(62,62), AppPrincipal.class.getResource("/interfaz/iconos/DijkstraB02.png")));

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

		Iterator<Vertex<Localizacion>> iter = Universidad.getInstancia().getLocalizaciones().getVerticesList().iterator();

		while(iter.hasNext()) {
			WeightedVertex<Localizacion, Boolean> v = (WeightedVertex<Localizacion, Boolean>)iter.next();
			pines.add(new PinMapa(e,v,this,p,tab,f));
		}
	}

	private void crearLocalizacionesRuta(JFrame p) {
		pinesRuta = new LinkedList<>();

		Iterator<Vertex<Localizacion>> iter = Universidad.getInstancia().getLocalizaciones().getVerticesList().iterator();

		while(iter.hasNext()) {
			WeightedVertex<Localizacion, Boolean> v = (WeightedVertex<Localizacion, Boolean>)iter.next();
			pinesRuta.add(new PinRuta(v,this,p));
		}
	}

	private void incluirLocalizaciones() {
		Iterator<PinMapa> iter = pines.iterator();
		while(iter.hasNext()) {
			this.add(iter.next());
		}
		
		Iterator<PinRuta> iter1 = pinesRuta.iterator();
		while(iter1.hasNext()) {
			PinRuta r = iter1.next();
			r.addPropertyChangeListener("Seleccionado", new PropertyChangeListener() {
				
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					if(estadoRuta==0) {
						cancelarDijkstraBtn.setVisible(true);
						estadoRuta=1;
						r.setEstado(1);
						r.setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinActivo01.png")));
						r.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinActivo01.png")));
					}
					else if(estadoRuta==1){
						estadoRuta = 2;
						r.setEstado(2);
						r.setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinActivo01.png")));
						r.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinActivo01.png")));
						iniciarRuta();
					}
				}
			});
			this.add(r);
		}
	}
	
	private void iniciarRuta() {
		Localizacion inicio = getLocalizacionInicio();
		Localizacion finall = getLocalizacionFinal();
		
		LinkedList<Vertex<Localizacion>> ruta = Universidad.getInstancia().getLocalizaciones().shortestPathDijkstra(inicio, finall); 
		int rutaDistancia = Universidad.getInstancia().getLocalizaciones().shortestPathDijkstraDistance(inicio, finall); 
		
		dibujarLineas(crearRutaNodos(ruta));
		infoDijkstraBtn.setVisible(true);
		mostrarMensajeRuta(rutaDistancia, ruta);
		
	}
	
	private Localizacion getLocalizacionInicio() {
		Localizacion l = null;
		Iterator<PinRuta> iter = pinesRuta.iterator();
		while(iter.hasNext() && l==null) {
			PinRuta r = iter.next();
			if(r.getEstado()==1)
				l = r.getLocalizacion();
		}
		return l;
	}
	
	private Localizacion getLocalizacionFinal() {
		Localizacion l = null;
		Iterator<PinRuta> iter = pinesRuta.iterator();
		while(iter.hasNext() && l==null) {
			PinRuta r = iter.next();
			if(r.getEstado()==2)
				l = r.getLocalizacion();
		}
		return l;
	}
	
	private LinkedList<PinRuta> crearRutaNodos(LinkedList<Vertex<Localizacion>> ruta) {
		LinkedList<PinRuta> lista = new LinkedList<>();
		Iterator<Vertex<Localizacion>> iter = ruta.iterator();
		while(iter.hasNext()) {
			Localizacion l = iter.next().getInfo();
			boolean b = false;
			Iterator<PinRuta> iterRuta = pinesRuta.iterator();
			while(iterRuta.hasNext() && !b) {
				PinRuta p = iterRuta.next();
				if(p.getLocalizacion().getNombre().equals(l.getNombre())) {
					b = true;
					lista.add(p);
				}
			}
		}
		
		ocultarNodos(lista);
		
		
		return lista;
	}
	
	private void ocultarNodos(LinkedList<PinRuta> lista) {
		Iterator<PinRuta> iter = pinesRuta.iterator();
		while(iter.hasNext()) {
			PinRuta p = iter.next();
			if(lista.contains(p) && lista.indexOf(p)!=0 && lista.indexOf(p)!=lista.size()-1) {
				p.setEstado(3);
				p.setIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack01.png")));
				p.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(30,30), AppPrincipal.class.getResource("/interfaz/iconos/pinBlack01.png")));
			}
			else if(lista.indexOf(p)!=0 && lista.indexOf(p)!=lista.size()-1){
				p.setVisible(false);
			}
		}
	}
	
	private void dibujarLineas(LinkedList<PinRuta> rutaPin) {
		esconderLineas();
		Iterator<PinRuta> iter = rutaPin.iterator();
		PinRuta p1 = iter.next();
		while(iter.hasNext()) {
			PinRuta p2 = iter.next();
			Iterator<LineaRuta> iterL = lineasRuta.iterator();
			while(iterL.hasNext()) {
				LineaRuta l = iterL.next();
				if(l.comparacion(p1.getLocalizacion(), p2.getLocalizacion()))
					l.setVisible(true);
			}
			p1 = p2;
		}
	}
	
	private void mostrarLineas() {
		Iterator<LineaRuta> iter = lineasRuta.iterator();
		while(iter.hasNext())
			iter.next().setVisible(true);
	}
	
	private void esconderLineas() {
		Iterator<LineaRuta> iter = lineasRuta.iterator();
		while(iter.hasNext())
			iter.next().setVisible(false);
	}

	
	private void mostrarMensajeRuta() {
		Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
		MessageSinCancel m = new MessageSinCancel(mensajeInfoTitulo, mensajeInfo);
		m.eventOK(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GlassPanePopup.closePopupLast();
			}
		});
		GlassPanePopup.showPopup(m, o);
	}
	
	private void mostrarMensajeRuta(int distancia, LinkedList<Vertex<Localizacion>> ruta) {
		String mensaje = "La ruta más corta presenta una distancia de "+distancia+" metros. Las localizaciones de la ruta en orden son:\n";
		int contador = 1;
		Iterator<Vertex<Localizacion>> iter = ruta.iterator();
		while(iter.hasNext()) {
			mensaje = mensaje.concat((contador++)+"-"+iter.next().getInfo().getNombre()+"\n");
		}
		
		String titulo = "Ruta más corta entre " + ruta.get(0).getInfo().getNombre()+" y "
				+ ruta.get(ruta.size()-1).getInfo().getNombre() +"";
		
		this.mensajeInfo = mensaje;
		this.mensajeInfoTitulo = titulo;
		
		Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
		MessageSinCancel m = new MessageSinCancel(titulo, mensaje);
		m.eventOK(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GlassPanePopup.closePopupLast();
			}
		});
		GlassPanePopup.showPopup(m, o);
	}
	
	
	private void dibujarLocalizaciones() {
		Iterator<PinRuta> iter = pinesRuta.iterator();
		while(iter.hasNext()) {
			iter.next().setVisible(false);
		}
		
		Iterator<PinMapa> iter1 = pines.iterator();
		while(iter1.hasNext()) {
			iter1.next().setVisible(true);
		}
	}
	
	
	private void dibujarLocalizacionesRuta() {
		Iterator<PinMapa> iter = pines.iterator();
		while(iter.hasNext()) {
			iter.next().setVisible(false);
		}
		
		
		Iterator<PinRuta> iter1 = pinesRuta.iterator();
		while(iter1.hasNext()) {
			PinRuta r = iter1.next();
			r.reiniciar();
			r.setVisible(true);
		}
	}
	
	private void dibujarLineas() {
		Iterator<LineaRuta> iter = lineasRuta.iterator();
		while(iter.hasNext()) {
			LineaRuta l = iter.next();
			l.setVisible(false);
			this.add(l);
		}
	}
	
	
	private void crearLineasRuta() {
		this.lineasRuta = new LinkedList<>();
		
		LineaRuta dojo_canchasBadminton = new LineaRuta(3,"Dojo","Canchas de Bádminton");
		dojo_canchasBadminton.setBounds(338,331,97,52);
		LineaRuta dojo_Piscina = new LineaRuta(3,"Dojo","Piscina de Natación");
		dojo_Piscina.setBounds(338,331,186,27);
		LineaRuta dojo_bajosArquitectura = new LineaRuta(2,"Dojo","Bajos del Edificio de Arquitectura");
		dojo_bajosArquitectura.setBounds(116,331,222,96);
		
		LineaRuta canchasBasket_piscina = new LineaRuta(2,"Canchas de BasketBall","Piscina de Natación");
		canchasBasket_piscina.setBounds(467,358,57,52);
		LineaRuta canchasBadminton_canchasBasket = new LineaRuta(3,"Canchas de Bádminton","Canchas de BasketBall");
		canchasBadminton_canchasBasket.setBounds(435,383,32,27);
		LineaRuta canchas_canchasBasket = new LineaRuta(2,"Canchas","Canchas de BasketBall");
		canchas_canchasBasket.setBounds(447,410,20,36);
		LineaRuta canchas_Deder = new LineaRuta(2,"Canchas","DEDER");
		canchas_Deder.setBounds(447,434,63,12);
		
		LineaRuta terrenoFutbol_canchas = new LineaRuta(3,"Terreno de Fútbol","Canchas");
		terrenoFutbol_canchas.setBounds(447,446,23,34);
		LineaRuta canchasBasket_Deder = new LineaRuta(3,"Canchas de BasketBall","DEDER");
		canchasBasket_Deder.setBounds(467,410,43,24);
		LineaRuta terrenoFutbol_localAjedrez = new LineaRuta(2,"Terreno de Fútbol","Local de Ajedrez");
		terrenoFutbol_localAjedrez.setBounds(470,469,40,11);
		LineaRuta deder_localAjedrez = new LineaRuta(0,"DEDER","Local de Ajedrez");
		deder_localAjedrez.setBounds(506,434,50,35);
		
		LineaRuta terrenoPelota_LocalAjedrez = new LineaRuta(2,"Terreno de Pelota","Local de Ajedrez");
		terrenoPelota_LocalAjedrez.setBounds(510,457,63,12);
		LineaRuta pistaAtletismo_TerrenoPelota = new LineaRuta(2,"Pista de Atletismo","Terreno de Pelota");
		pistaAtletismo_TerrenoPelota.setBounds(573,373,98,84);
		LineaRuta pistaAtletismo_Deder = new LineaRuta(2,"Pista de Atletismo","DEDER");
		pistaAtletismo_Deder.setBounds(510,373,161,61);
		LineaRuta piscina_deder = new LineaRuta(2,"Piscina de Natación","DEDER");
		piscina_deder.setBounds(510,358,14,76);
		
		lineasRuta.add(dojo_canchasBadminton);
		lineasRuta.add(dojo_Piscina);
		lineasRuta.add(dojo_bajosArquitectura);
		
		lineasRuta.add(canchasBasket_piscina);
		lineasRuta.add(canchasBadminton_canchasBasket);
		lineasRuta.add(canchas_canchasBasket);
		lineasRuta.add(canchas_Deder);
		
		lineasRuta.add(terrenoFutbol_canchas);
		lineasRuta.add(canchasBasket_Deder);
		lineasRuta.add(terrenoFutbol_localAjedrez);
		lineasRuta.add(deder_localAjedrez);
		
		lineasRuta.add(terrenoPelota_LocalAjedrez);
		lineasRuta.add(pistaAtletismo_TerrenoPelota);
		lineasRuta.add(pistaAtletismo_Deder);
		lineasRuta.add(piscina_deder);
		
	}
}
