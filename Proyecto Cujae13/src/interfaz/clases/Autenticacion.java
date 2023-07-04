package interfaz.clases;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.formdev.flatlaf.FlatLightLaf;

import clasesAuxiliares.Usuario;
import clasesAuxiliares.UsuarioAdmin;
import clasesAuxiliares.UsuarioEstudiante;
import componentes.AvatarCircular;
import componentes.BotonAnimacion;
import componentes.ImagenAnim;
import componentes.JPasswordFieldModificado;
import componentes.JTextFieldModificado;
import definiciones.DefinicionesInterfaz;
import definiciones.ErroresInterfazGrafica;
import inicializacion.Inicializadora;
import interfaz.componentes.ConfetiJDialog;
import interfaz.componentes.PanelSuperior;
import nucleo.NombreFacultad;
import nucleo.Universidad;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import raven.toast.Notifications;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import utilidades.Archivador;
import utilidades.Auxiliares;

/**
 * JFrame que modela la autenticación de la aplicación
 * 
 * 
 * @author Lilian Rojas
 * @author Katherine Ramírez
 * @author Cristian Páez
 * @author Bryan García
 * @author Eduardo González
 *
 */
public class Autenticacion extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panelBase;
	private PanelSuperior panelSuperior;
	private ImagenAnim imagen;
	private JPanel panelLogin;
	private AvatarCircular avatar;
	private JTextFieldModificado campoUsuario;
	private JPasswordFieldModificado campoContrasenya;
	private JLabel usuarioLabel;
	private JLabel contrasenyaLabel;
	private BotonAnimacion ingresarBtn;
	private JButton contrasenyaBtn;
	private int contadorInd;

	private char echoCharContrasenya;
	private boolean contrasenyaVisible;
	private Usuario usuario;

	public Autenticacion() {
		Notifications.getInstance().setJFrame(this);
		GlassPanePopup.install(this);
		this.setTitle("Cujae13");
		contadorInd = 0;
		FlatLightLaf.setup();
		this.setUndecorated(true);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Autenticacion.class.getResource("/interfaz/iconos/icono.png")));
		this.setBounds(100, 100, DefinicionesInterfaz.DIMENSION_AUTENTICACION.width, DefinicionesInterfaz.DIMENSION_AUTENTICACION.height);
		this.setBackground(new Color(255,255,255,0));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				panelSuperior.getMinimizarBtn().requestFocus();
			}
		});

		panelBase = new JPanel();
		panelBase.setOpaque(false);
		setContentPane(panelBase);

		panelSuperior = new PanelSuperior(DefinicionesInterfaz.COLOR_PANEL_SUPERIOR, this, "Autenticación");

		imagen = new ImagenAnim(3500);
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a01.png")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a02.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a03.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a04.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a05.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a06.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a07.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a08.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a10.jpg")));
		imagen.addImage(new ImageIcon(Autenticacion.class.getResource("/interfaz/imagenes/a09.jpg")));
		
		imagen.iniciarAnimacion();
		imagen.setBackground(Color.WHITE);
		imagen.setBounds(0, 45, 507, 467);
		imagen.setBorder(new MatteBorder(0, 2, 2, 2, (Color) new Color(0, 0, 0)));

		panelLogin = new JPanel();
		panelLogin.setBackground(Color.WHITE);
		panelLogin.setBounds(507, 45, 293, 467);
		panelLogin.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));

		avatar = new AvatarCircular(new ImageIcon(Autenticacion.class.getResource("/interfaz/iconos/13.png")), DefinicionesInterfaz.TAM_BORDE_AVATAR);
		avatar.setBounds(70, 45, 150, 150);
		avatar.setForeground(DefinicionesInterfaz.COLOR_BTN_BASE);

		usuarioLabel = new JLabel("Correo");
		usuarioLabel.setBounds(44, 217, 203, 32);
		usuarioLabel.setForeground(Color.BLACK);
		usuarioLabel.setFont(new Font("Roboto Black", Font.PLAIN, 20));

		campoUsuario = new JTextFieldModificado();
		campoUsuario.setLimite(DefinicionesInterfaz.LIMITE_CARACTERES_USUARIO);
		campoUsuario.setBounds(44, 249, 203, 32);
		campoUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(campoUsuario.getText().equals(DefinicionesInterfaz.CAMPO_USUARIO_TEXTO_BASE)) {
					campoUsuario.setText("");
					campoUsuario.setForeground(Color.BLACK);
					campoUsuario.setBorder(new MatteBorder(0, 0, 2, 0, DefinicionesInterfaz.COLOR_BORDE_USUARIO));
				}
				else
					campoUsuario.setBorder(new MatteBorder(0, 0, 2, 0, DefinicionesInterfaz.COLOR_BORDE_USUARIO));
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(campoUsuario.getText().isEmpty()) {
					campoUsuario.setText(DefinicionesInterfaz.CAMPO_USUARIO_TEXTO_BASE);
					campoUsuario.setForeground(Color.GRAY);
					campoUsuario.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
				}
			}
		});
		campoUsuario.setText(DefinicionesInterfaz.CAMPO_USUARIO_TEXTO_BASE);
		campoUsuario.setOpaque(false);
		campoUsuario.setForeground(Color.GRAY);
		campoUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		campoUsuario.setColumns(10);
		campoUsuario.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));

		contrasenyaLabel = new JLabel("Contrase\u00F1a");
		contrasenyaLabel.setBounds(44, 292, 203, 32);
		contrasenyaLabel.setForeground(Color.BLACK);
		contrasenyaLabel.setFont(new Font("Roboto Black", Font.PLAIN, 20));

		campoContrasenya = new JPasswordFieldModificado();
		campoContrasenya.setLimite(DefinicionesInterfaz.LIMITE_CARACTERES_CONTRASENYA);
		campoContrasenya.setBounds(44, 324, 171, 32);
		campoContrasenya.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(campoContrasenya.getPassword().length==DefinicionesInterfaz.LIMITE_CARACTERES_CONTRASENYA)
					e.consume();
			}
		});
		campoContrasenya.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(campoContrasenya.getPassword()).equals(DefinicionesInterfaz.CAMPO_CONTRASENYA_TEXTO_BASE)) {
					campoContrasenya.setText("");
					campoContrasenya.setForeground(Color.BLACK);
					campoContrasenya.setBorder(new MatteBorder(0, 0, 2, 0, DefinicionesInterfaz.COLOR_BORDE_CONTRASENYA));
					contrasenyaBtn.setBorder(new MatteBorder(0, 0, 2, 0, DefinicionesInterfaz.COLOR_BORDE_CONTRASENYA));
					if(contrasenyaVisible)
						campoContrasenya.setEchoChar((char)0);
					else
						campoContrasenya.setEchoChar(echoCharContrasenya);
				}
				else {
					campoContrasenya.setBorder(new MatteBorder(0, 0, 2, 0, DefinicionesInterfaz.COLOR_BORDE_CONTRASENYA));
					contrasenyaBtn.setBorder(new MatteBorder(0, 0, 2, 0, DefinicionesInterfaz.COLOR_BORDE_CONTRASENYA));
				}

			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(campoContrasenya.getPassword()).isEmpty()) {
					campoContrasenya.setEchoChar(echoCharContrasenya);
					campoContrasenya.setText(DefinicionesInterfaz.CAMPO_CONTRASENYA_TEXTO_BASE);
					campoContrasenya.setForeground(Color.GRAY);
					campoContrasenya.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
					contrasenyaBtn.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
				}
			}
		});
		campoContrasenya.setText(DefinicionesInterfaz.CAMPO_CONTRASENYA_TEXTO_BASE);
		campoContrasenya.setOpaque(false);
		campoContrasenya.setForeground(Color.GRAY);
		campoContrasenya.setFont(new Font("Tahoma", Font.BOLD, 14));
		campoContrasenya.setColumns(10);
		campoContrasenya.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));

		contrasenyaBtn = new JButton("");
		contrasenyaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contrasenyaVisible = !contrasenyaVisible;

				if(!String.valueOf(campoContrasenya.getPassword()).equals(DefinicionesInterfaz.CAMPO_CONTRASENYA_TEXTO_BASE)) {
					if(contrasenyaVisible)
						campoContrasenya.setEchoChar((char)0);
					else
						campoContrasenya.setEchoChar(echoCharContrasenya);
				}

				if(contrasenyaVisible) 
					contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/hideP1.png")));
				else 
					contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/showP1.png")));
			}
		});
		echoCharContrasenya = campoContrasenya.getEchoChar();
		contrasenyaVisible = false;
		contrasenyaBtn.setContentAreaFilled(false);
		contrasenyaBtn.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
		contrasenyaBtn.setBounds(215, 324, 32, 32);
		contrasenyaBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(contrasenyaVisible)
					contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/hideP1.png")));
				else
					contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/showP1.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(contrasenyaVisible)
					contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/hideP0.png")));
				else
					contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/showP0.png")));
			}

		});
		contrasenyaBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contrasenyaBtn.setIcon(Auxiliares.ajustarImagen(new Dimension(32,32), Autenticacion.class.getResource("/interfaz/iconos/showP0.png")));

		ingresarBtn = new BotonAnimacion();
		usuario = null;
		ingresarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean autenticado = true;
				try {
					usuario = Auxiliares.seguridad(campoUsuario.getText(),String.valueOf(campoContrasenya.getPassword()));
				}
				catch(Exception ex) {
					autenticado = false;
					String mensaje = ex.getMessage(); 
					if(mensaje.equals(ErroresInterfazGrafica.ERROR_CAMPO_VACIO)) {
						campoUsuario.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
						campoContrasenya.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
						contrasenyaBtn.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
					}
					else if(mensaje.equals(ErroresInterfazGrafica.ERROR_CORREO_NO_VALIDO) || mensaje.equals(ErroresInterfazGrafica.ERROR_CAMPO_VACIO_USUARIO))
						campoUsuario.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
					else if(mensaje.equals(ErroresInterfazGrafica.ERROR_CONTRASENYA_NO_VALIDA) || mensaje.equals(ErroresInterfazGrafica.ERROR_CAMPO_VACIO_CONTRASENYA)) {
						campoContrasenya.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
						contrasenyaBtn.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
					}
					Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, 3500, mensaje);
				}
				finally{
					if(autenticado) {
						boolean bypass = true;
						if(usuario instanceof UsuarioEstudiante && ((UsuarioEstudiante)usuario).getFacultad().equals(NombreFacultad.INDUSTRIAL)) {
							contadorInd++;
							bypass = contadorInd>=3;
							if(!bypass)
								Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.BOTTOM_RIGHT, 3500, "El término\"Industrial\" no se encuentra dentro del conjunto de Ingenierías... Intentar Nuevamente");
						}

						if(bypass) {
							Option o = OptionConstructor.constructOption(DefinicionesInterfaz.COLOR_PANEL_SUPERIOR, false);
							MessageSinCancel m = new MessageSinCancel("Bienvenido/a", "Bienvenido/a de nuevo "+ usuario.getNombre());
							m.eventOK(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									GlassPanePopup.closePopupLast();
									terminarVentanaLogin(usuario);
								}
							});
							GlassPanePopup.showPopup(m, o);
						}
					}
				}
			}
		});
		ingresarBtn.setBounds(44, 388, 203, 32);
		ingresarBtn.setEffectColor(DefinicionesInterfaz.COLOR_BTN_EFECTO);
		ingresarBtn.setText("Ingresar");
		ingresarBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ingresarBtn.setBackground(DefinicionesInterfaz.COLOR_BTN_HOVER);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				ingresarBtn.setBackground(DefinicionesInterfaz.COLOR_BTN_BASE);
			}

		});
		ingresarBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ingresarBtn.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		ingresarBtn.setBorder(null);
		ingresarBtn.setBackground(DefinicionesInterfaz.COLOR_BTN_BASE);
		panelBase.setLayout(null);
		panelBase.add(panelSuperior);
		panelBase.add(imagen);
		panelBase.add(panelLogin);
		panelLogin.setLayout(null);
		panelLogin.add(avatar);
		panelLogin.add(contrasenyaLabel);
		panelLogin.add(campoUsuario);
		panelLogin.add(usuarioLabel);
		panelLogin.add(ingresarBtn);
		panelLogin.add(campoContrasenya);
		panelLogin.add(contrasenyaBtn);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void terminarVentanaLogin(Usuario usuario) {
		imagen.detenerAnimacion();
		Universidad.getInstancia().actualizar();
		Inicializadora.guardarDatosAplicacion();
		if(usuario instanceof UsuarioEstudiante) {
			AppPrincipal a = new AppPrincipal((UsuarioEstudiante)usuario);
			a.setVisible(true);
			NombreFacultad f = ((UsuarioEstudiante)usuario).getFacultad();
			if(Universidad.getInstancia().juegosFinalizados() && Universidad.getInstancia().facultadGanadora(f)) {
				ConfetiJDialog ventana = new ConfetiJDialog(a.getThis(), true, Archivador.getEsquemaColores(f).getPanelMovilBase());
				ventana.setVisible(true);
			}
				
		}
		else {
			AppPrincipalAdmin b = AppPrincipalAdmin.getInstancia((UsuarioAdmin)usuario);
			b.setVisible(true);
			
		}
		this.dispose();
	}
}
