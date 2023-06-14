package interfaz.clases;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.formdev.flatlaf.FlatLightLaf;

import clasesAuxiliares.EsquemaColores;
import clasesAuxiliares.UsuarioAdmin;
import componentes.AvatarCircular;
import componentes.BotonAnimacion;
import componentes.Imagen;
import componentes.PanelGradienteH;
import componentes.PanelGradienteV;
import componentes.PanelOpcion;
import definiciones.DefinicionesInterfaz;
import interfaz.clases.panelesAppPrincipal.PanelCalendario;
import interfaz.clases.panelesAppPrincipalAdmin.PanelAmonestaciones;
import interfaz.clases.panelesAppPrincipalAdmin.PanelInicioAdmin;
import interfaz.clases.panelesAppPrincipalAdmin.PanelPorResultados;
import interfaz.clases.panelesAppPrincipalAdmin.PanelResultados;
import interfaz.componentes.PanelSuperior;
import nucleo.Universidad;
import utilidades.Archivador;
import utilidades.Auxiliares;

/**
 *JFrame con la sección de Administrador de la aplicación Cujae13.
 * 
 * @author Eduardo González
 *
 */
public class AppPrincipalAdmin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelBase;
	private PanelSuperior panelSuperior;
	private JPanel panelContenedor;
	private PanelGradienteH panelSup;
	private PanelGradienteV panelUsuario;
	private AvatarCircular avatar;
	private JLabel nombreUsuariolbl;
	private JLabel tipoUsuariolbl;
	private BotonAnimacion cerrarSesionBtn;
	private JLabel opcionLbl;
	private JPanel panelContenedorOpciones;
	private UsuarioAdmin u;
	private PanelOpcion panelSeleccionado;
	private PanelOpcion opcionInicio;
	private PanelOpcion opcionAmonestaciones;
	private PanelOpcion opcionPorResultados;
	private PanelOpcion opcionResultados;
	private PanelOpcion opcionCalendario;
	private static JTabbedPane panelPrincipall;
	private JButton botonAtras;
	private static EsquemaColores e;
	private static AppPrincipalAdmin instancia;
	
	public static AppPrincipalAdmin getInstancia(UsuarioAdmin us) {
		if(instancia == null)
			instancia = new AppPrincipalAdmin(us);
		return instancia;
	}
	
	public static AppPrincipalAdmin getInstancia() {
		if(instancia == null)
			throw new RuntimeException();
		return instancia;
	}
	
	private AppPrincipalAdmin(UsuarioAdmin us) {
		this.setTitle("Cujae13");
		u = us;
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Autenticacion.class.getResource("/interfaz/iconos/icono.png")));
		e = Archivador.getEsquemaColoresAdmin();
		FlatLightLaf.setup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, DefinicionesInterfaz.DIMENSION_APP_PRINCIPAL.width, DefinicionesInterfaz.DIMENSION_APP_PRINCIPAL.height);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(255,255,255,0));
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				requestFocus();
			}
		
		});
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.consume();
				if(e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F4) {
					if(JOptionPane.showConfirmDialog(rootPane, DefinicionesInterfaz.PREGUNTA_SALIR, null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
						System.exit(0);
				}
			}
		});
		
		panelBase = new JPanel();
		panelBase.setOpaque(false);
		panelBase.setLayout(null);
		
		panelSuperior = new PanelSuperior(e.getPanelMovilBase(), this, "Cujae13");
		panelSuperior.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0,0,0)));
		
		setContentPane(panelBase);
		panelBase.add(panelSuperior);
		
		panelContenedor = new JPanel();
		panelContenedor.setBounds(0, 45, 1200, 630);
		panelContenedor.setBackground(new Color(Color.LIGHT_GRAY.getRed(),Color.LIGHT_GRAY.getGreen(),Color.LIGHT_GRAY.getBlue(),180));
		panelBase.add(panelContenedor);
		panelContenedor.setLayout(null);
		
		
 	    panelSup = new PanelGradienteH(e.getPanelSupGradienteInicio(), e.getPanelSupGradienteFin());
	 	//panelSup = new PanelGradienteH(Color.LIGHT_GRAY, Color.DARK_GRAY);
	 	panelSup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelSup.requestFocus();
			}
		});
		panelSup.setBorder(new MatteBorder(0, 0, 0, 2, new Color(0,0,0)));
		panelSup.setBounds(300, 0, 900, 55);
		panelContenedor.add(panelSup);
		panelSup.setLayout(null);
		
		opcionLbl = new JLabel("INICIO");
		opcionLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		opcionLbl.setForeground(e.getPanelSupGradienteTexto());
		opcionLbl.setBounds(58, 11, 396, 33);
		panelSup.add(opcionLbl);
		
		botonAtras = new JButton("");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipall.setSelectedIndex(2);
			}
		});
		botonAtras.setVisible(false);
		botonAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botonAtras.setBorder(null);
		botonAtras.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), AppPrincipal.class.getResource(e.getDirUrlBtnAtras())));
		botonAtras.setRolloverIcon(Auxiliares.ajustarImagen(new Dimension(32,32), AppPrincipal.class.getResource(e.getDirUrlBtnAtrasHover())));
		botonAtras.setContentAreaFilled(false);
		botonAtras.setBounds(10, 9, 36, 36);
		panelSup.add(botonAtras);
		
		panelUsuario = new PanelGradienteV(e.getPanelUsuarioGradienteInicio(), e.getPanelUsuarioGradienteFin());
		//panelUsuario = new PanelGradienteV(Color.LIGHT_GRAY, Color.DARK_GRAY);
		panelUsuario.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0,0,0)));
		panelUsuario.setLayout(null);
		panelUsuario.setBounds(0, 0, 300, 211);
		panelContenedor.add(panelUsuario);
		
		avatar = new AvatarCircular(new ImageIcon(Autenticacion.class.getResource("/interfaz/iconos/admin1.png")), DefinicionesInterfaz.TAM_BORDE_AVATAR);
		avatar.setForeground(e.getBordeAvatar());
		avatar.setBounds(95, 5, 110, 110);
		panelUsuario.add(avatar);
		
		nombreUsuariolbl = new JLabel(u.getNombre());
		nombreUsuariolbl.setForeground(e.getPanelUsuarioTexto());
		nombreUsuariolbl.setHorizontalAlignment(SwingConstants.CENTER);
		nombreUsuariolbl.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		nombreUsuariolbl.setBounds(31, 115, 238, 28);
		panelUsuario.add(nombreUsuariolbl);
		
		tipoUsuariolbl = new JLabel("Administrador");
		tipoUsuariolbl.setForeground(e.getPanelUsuarioTexto());
		tipoUsuariolbl.setHorizontalAlignment(SwingConstants.CENTER);
		tipoUsuariolbl.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		tipoUsuariolbl.setBounds(45, 140, 210, 28);
		panelUsuario.add(tipoUsuariolbl);
		
		cerrarSesionBtn = new BotonAnimacion();
		cerrarSesionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(rootPane, DefinicionesInterfaz.PREGUNTA_CERRAR_SESION, null, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					dispose();
					Autenticacion l = new Autenticacion();
					l.setVisible(true);
				}		
			}
		});
		cerrarSesionBtn.setText("Cerrar Sesi\u00F3n");
		cerrarSesionBtn.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		cerrarSesionBtn.setForeground(e.getPanelUsuarioBtnTexto());
		cerrarSesionBtn.setEffectColor(e.getPanelUsuarioBtnColorEfecto());
		cerrarSesionBtn.setBackground(e.getPanelUsuarioBtn());
		cerrarSesionBtn.setBounds(80, 179, 140, 21);
		panelUsuario.add(cerrarSesionBtn);
		
		panelContenedorOpciones = new JPanel();
		panelContenedorOpciones.setBorder(new MatteBorder(0, 2, 2, 0, new Color(0,0,0)));
		panelContenedorOpciones.setLayout(null);
		panelContenedorOpciones.setBackground(e.getPanelContenedorOpciones());
		panelContenedorOpciones.setBounds(0, 211, 300, 419);
		panelContenedor.add(panelContenedorOpciones);
		
		opcionInicio = new PanelOpcion();
		opcionInicio.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0,0,0)));
		opcionInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opcionInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent es) {
				opcionInicio.setBackground(e.getPanelOpcionHover());
			}
			@Override
			public void mouseExited(MouseEvent eS) {
				if(opcionInicio.equals(panelSeleccionado))
					opcionInicio.setBackground(e.getPanelOpcionSeleccionado());
				else
					opcionInicio.setBackground(e.getPanelContenedorOpciones());
			}
			@Override
			public void mouseClicked(MouseEvent es) {
				panelPrincipall.setSelectedIndex(0);
				opcionLbl.setText("INICIO");
				panelSeleccionado.setBackground(e.getPanelContenedorOpciones());
				panelSeleccionado = opcionInicio;
				panelSeleccionado.setBackground(e.getPanelOpcionSeleccionado());
			}
		});
		opcionInicio.setLayout(null);
		opcionInicio.setSeleccionado(true);
		opcionInicio.setOpaque(true);
		opcionInicio.setBackground(e.getPanelContenedorOpciones());
		opcionInicio.setBounds(0, 11, 300, 66);
		panelContenedorOpciones.add(opcionInicio);
		panelSeleccionado = opcionInicio;
		panelSeleccionado.setBackground(e.getPanelOpcionSeleccionado());
		
		Imagen logoInicio = new Imagen(new ImageIcon(AppPrincipal.class.getResource(e.getDirUrlIconoInicio())));
		logoInicio.setBounds(67, 14, 38, 38);
		opcionInicio.add(logoInicio);
		
		JLabel textoInicio = new JLabel("INICIO");
		textoInicio.setForeground(e.getPanelOpcionTexto());
		textoInicio.setHorizontalTextPosition(SwingConstants.CENTER);
		textoInicio.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		textoInicio.setBounds(126, 16, 164, 33);
		opcionInicio.add(textoInicio);
		
		opcionAmonestaciones = new PanelOpcion();
		opcionAmonestaciones.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0,0,0)));
		opcionAmonestaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opcionAmonestaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent es) {
				opcionAmonestaciones.setBackground(e.getPanelOpcionHover());
			}
			@Override
			public void mouseExited(MouseEvent eS) {
				if(opcionAmonestaciones.equals(panelSeleccionado))
					opcionAmonestaciones.setBackground(e.getPanelOpcionSeleccionado());
				else
					opcionAmonestaciones.setBackground(e.getPanelContenedorOpciones());
			}
			@Override
			public void mouseClicked(MouseEvent es) {
				panelPrincipall.setSelectedIndex(1);
				opcionLbl.setText("AMONESTACIONES");
				panelSeleccionado.setBackground(e.getPanelContenedorOpciones());
				panelSeleccionado = opcionAmonestaciones;
				panelSeleccionado.setBackground(e.getPanelOpcionSeleccionado());
			}
		});
		opcionAmonestaciones.setLayout(null);
		opcionAmonestaciones.setSeleccionado(true);
		opcionAmonestaciones.setOpaque(true);
		opcionAmonestaciones.setBackground(e.getPanelContenedorOpciones());
		opcionAmonestaciones.setBounds(0, 77, 300, 66);
		panelContenedorOpciones.add(opcionAmonestaciones);
		
		Imagen logoMapa = new Imagen(new ImageIcon(AppPrincipal.class.getResource("/interfaz/iconos/amonestacion01.png")));
		logoMapa.setBounds(67, 14, 38, 38);
		opcionAmonestaciones.add(logoMapa);
		
		JLabel textoMapa = new JLabel("AMONESTACIONES");
		textoMapa.setForeground(e.getPanelOpcionTexto());
		textoMapa.setHorizontalTextPosition(SwingConstants.CENTER);
		textoMapa.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		textoMapa.setBounds(126, 16, 164, 33);
		opcionAmonestaciones.add(textoMapa);
		
		opcionPorResultados = new PanelOpcion();
		opcionPorResultados.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0,0,0)));
		opcionPorResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opcionPorResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent es) {
				opcionPorResultados.setBackground(e.getPanelOpcionHover());
			}
			@Override
			public void mouseExited(MouseEvent eS) {
				if(opcionPorResultados.equals(panelSeleccionado))
					opcionPorResultados.setBackground(e.getPanelOpcionSeleccionado());
				else
					opcionPorResultados.setBackground(e.getPanelContenedorOpciones());
			}
			@Override
			public void mouseClicked(MouseEvent es) {
				panelPrincipall.setSelectedIndex(2);
				opcionLbl.setText("POR RESULTADOS");
				panelSeleccionado.setBackground(e.getPanelContenedorOpciones());
				panelSeleccionado = opcionPorResultados;
				panelSeleccionado.setBackground(e.getPanelOpcionSeleccionado());
			}
		});
		opcionPorResultados.setLayout(null);
		opcionPorResultados.setSeleccionado(true);
		opcionPorResultados.setOpaque(true);
		opcionPorResultados.setBackground(e.getPanelContenedorOpciones());
		opcionPorResultados.setBounds(0, 143, 300, 66);
		panelContenedorOpciones.add(opcionPorResultados);
		
		Imagen logoFacultad = new Imagen(new ImageIcon(AppPrincipal.class.getResource("/interfaz/iconos/resultados.png")));
		logoFacultad.setBounds(67, 14, 38, 38);
		opcionPorResultados.add(logoFacultad);
		
		JLabel textoFacultad = new JLabel("POR RESULTADOS");
		textoFacultad.setForeground(e.getPanelOpcionTexto());
		textoFacultad.setHorizontalTextPosition(SwingConstants.CENTER);
		textoFacultad.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		textoFacultad.setBounds(126, 16, 164, 33);
		opcionPorResultados.add(textoFacultad);
		
		opcionResultados = new PanelOpcion();
		opcionResultados.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0,0,0)));
		opcionResultados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opcionResultados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent es) {
				opcionResultados.setBackground(e.getPanelOpcionHover());
			}
			@Override
			public void mouseExited(MouseEvent eS) {
				if(opcionResultados.equals(panelSeleccionado))
					opcionResultados.setBackground(e.getPanelOpcionSeleccionado());
				else
					opcionResultados.setBackground(e.getPanelContenedorOpciones());
			}
			@Override
			public void mouseClicked(MouseEvent es) {
				panelPrincipall.setSelectedIndex(3);
				opcionLbl.setText("RESULTADOS");
				panelSeleccionado.setBackground(e.getPanelContenedorOpciones());
				panelSeleccionado = opcionResultados;
				panelSeleccionado.setBackground(e.getPanelOpcionSeleccionado());
			}
		});
		opcionResultados.setLayout(null);
		opcionResultados.setSeleccionado(true);
		opcionResultados.setOpaque(true);
		opcionResultados.setBackground(e.getPanelContenedorOpciones());
		opcionResultados.setBounds(0, 209, 300, 66);
		panelContenedorOpciones.add(opcionResultados);
		
		Imagen logoDeporte = new Imagen(new ImageIcon(AppPrincipal.class.getResource("/interfaz/iconos/historialJuegos01.png")));
		logoDeporte.setBounds(67, 14, 38, 38);
		opcionResultados.add(logoDeporte);
		
		JLabel textoDeporte = new JLabel("RESULTADOS");
		textoDeporte.setForeground(e.getPanelOpcionTexto());
		textoDeporte.setHorizontalTextPosition(SwingConstants.CENTER);
		textoDeporte.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		textoDeporte.setBounds(126, 16, 164, 33);
		opcionResultados.add(textoDeporte);
		
		opcionCalendario = new PanelOpcion();
		opcionCalendario.setBorder(new MatteBorder(0, 2, 0, 0, new Color(0,0,0)));
		opcionCalendario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		opcionCalendario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent es) {
				opcionCalendario.setBackground(e.getPanelOpcionHover());
			}
			@Override
			public void mouseExited(MouseEvent eS) {
				if(opcionCalendario.equals(panelSeleccionado))
					opcionCalendario.setBackground(e.getPanelOpcionSeleccionado());
				else
					opcionCalendario.setBackground(e.getPanelContenedorOpciones());
			}
			@Override
			public void mouseClicked(MouseEvent es) {
				panelPrincipall.setSelectedIndex(4);
				opcionLbl.setText("CALENDARIO");
				panelSeleccionado.setBackground(e.getPanelContenedorOpciones());
				panelSeleccionado = opcionCalendario;
				panelSeleccionado.setBackground(e.getPanelOpcionSeleccionado());
			}
		});
		opcionCalendario.setLayout(null);
		opcionCalendario.setSeleccionado(true);
		opcionCalendario.setOpaque(true);
		opcionCalendario.setBackground(e.getPanelContenedorOpciones());
		opcionCalendario.setBounds(0, 275, 300, 66);
		panelContenedorOpciones.add(opcionCalendario);
		
		Imagen logoCalendario = new Imagen(new ImageIcon(AppPrincipal.class.getResource(e.getDirUrlIconoCalendario())));
		logoCalendario.setBounds(67, 14, 38, 38);
		opcionCalendario.add(logoCalendario);
		
		JLabel textoCalendario = new JLabel("CALENDARIO");
		textoCalendario.setForeground(e.getPanelOpcionTexto());
		textoCalendario.setHorizontalTextPosition(SwingConstants.CENTER);
		textoCalendario.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		textoCalendario.setBounds(126, 16, 164, 33);
		opcionCalendario.add(textoCalendario);
		
		panelPrincipall = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipall.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panelPrincipall.addTab("a", new PanelInicioAdmin(e));
		panelPrincipall.addTab("a", new PanelAmonestaciones(e,this));
		panelPrincipall.addTab("a", new PanelPorResultados(e,this));
		panelPrincipall.addTab("a", new PanelResultados(e));
		panelPrincipall.addTab("a", new PanelCalendario(e));
		panelPrincipall.setBackground(Color.WHITE);
		panelPrincipall.setBounds(300, 0, 900, 630); 
//		panelPrincipall.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				int n = panelPrincipall.getSelectedIndex();
//				
//				if(n>5) {
//					botonAtras.setVisible(true);
//					botonAtras.removeActionListener(botonAtras.getActionListeners()[0]);
//				}
//				switch(n) {
//					case 6:
//						botonAtras.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent e) {
//								panelPrincipall.setSelectedIndex(2);
//							}
//						});
//						break;
//					case 7:
//						botonAtras.addActionListener(new ActionListener() {
//							public void actionPerformed(ActionEvent e) {
//								panelPrincipall.setSelectedIndex(3);
//							}
//						});
//						break;
//					default:
//						botonAtras.setVisible(false);
//						break;
//				}
//				
//			}
//		});
		panelContenedor.add(panelPrincipall);
		
	}
	
	public static void actualizar() {
		Universidad.getInstancia().actualizar();
		panelPrincipall.setComponentAt(0, new PanelInicioAdmin(e));
		panelPrincipall.setComponentAt(1, new PanelAmonestaciones(e,instancia));
		panelPrincipall.setComponentAt(2, new PanelPorResultados(e,instancia));
		panelPrincipall.setComponentAt(3, new PanelResultados(e));
		panelPrincipall.setComponentAt(4, new PanelCalendario(e));
	}
}

