package interfaz.clases.jdialogs;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import clasesAuxiliares.EsquemaColores;
import definiciones.DefinicionesInterfaz;
import interfaz.componentes.PanelSuperiorJDialog;

/**
 * Clase que permitirá generalizar la clase JDialog con las características necesarias 
 * en la aplicación para este tipo de pantallas modales.
 * 
 * @version 2023.06.06
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public abstract class JDialogGeneral extends JDialog{
	private static final long serialVersionUID = 1L;
	protected JPanel panelBase;
	protected PanelSuperiorJDialog panelSuperior;
	protected JPanel panelContenedor;
	
	protected JDialogGeneral(String titulo,EsquemaColores e,JFrame padre){
		super(padre, true);
		this.setUndecorated(true);
		this.setBounds(100, 100, DefinicionesInterfaz.DIMENSION_DIALOGOS.width, DefinicionesInterfaz.DIMENSION_DIALOGOS.height);
		this.setBackground(new Color(255,255,255,0));
		
		panelBase = new JPanel();
		panelBase.setOpaque(false);
		setContentPane(panelBase);
		panelBase.setLayout(null);
		
//		panelSuperior = new PanelSuperiorJDialog(e.getPanelMovilBase(), this, titulo);
		panelSuperior = new PanelSuperiorJDialog(Color.BLACK, this, titulo);
		setContentPane(panelBase);
		panelBase.add(panelSuperior);
		
		panelContenedor = new JPanel();
		panelContenedor.setBorder(new LineBorder(new Color(0,0,0), 2));
		panelContenedor.setBounds(0, 45, DefinicionesInterfaz.DIMENSION_DIALOGOS.width, DefinicionesInterfaz.DIMENSION_DIALOGOS.height-45);
		panelContenedor.setLayout(null);
		panelContenedor.setBackground(Color.WHITE);
		panelBase.add(panelContenedor);
		
		this.setLocationRelativeTo(null);
	}

}
