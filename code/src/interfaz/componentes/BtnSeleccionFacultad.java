package interfaz.componentes;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.AvatarCircular;
import componentes.PanelBordeOval;
import definiciones.DefinicionesInterfaz;
import nucleo.NombreFacultad;
import utilidades.Archivador;

public class BtnSeleccionFacultad extends PanelBordeOval{
	private static final long serialVersionUID = 1L;
	private JLabel facultadLbl;
	private AvatarCircular avatar;
	
	public BtnSeleccionFacultad(EsquemaColores e, NombreFacultad f, String fac) {
		this(e,f);
		facultadLbl.setText(fac);
	}
	
	public BtnSeleccionFacultad(EsquemaColores e, NombreFacultad f) {
		super(40);
		setLayout(null);
		setBackground(e.getFondoBtnSF());
		setBounds(0, 0, 160, 180);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent x) {
				setBackground(e.getHoverBtnSF());
			}
			@Override
			public void mouseExited(MouseEvent x) {
				setBackground(e.getFondoBtnSF());
			}
		});
		
		facultadLbl = new JLabel(f.toString());
		facultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 17));
		facultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultadLbl.setForeground(e.getPanelUsuarioTexto());
		facultadLbl.setBounds(10, 11, 140, 24);
		add(facultadLbl);
		
		EsquemaColores ex = Archivador.getEsquemaColores(f);
		
		avatar = new AvatarCircular(new ImageIcon(BtnSeleccionFacultad.class.getResource(ex.getDirUrlImagenAvatar())), DefinicionesInterfaz.TAM_BORDE_AVATAR);
		avatar.setForeground(ex.getBordeAvatar());
		avatar.setBounds(25, 49, 110, 110);
		add(avatar);
		
	}
}
