package interfaz.clases.jdialogs;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import nucleo.NombreFacultad;
import nucleo.Universidad;

public class HistoriaCuriosidadesFacultadJDialog extends JDialogGeneral{
	private static final long serialVersionUID = 1L;
	private JLabel nombreFacultadLbl;

	public HistoriaCuriosidadesFacultadJDialog(EsquemaColores e, JFrame padre, NombreFacultad f) {
		super("Historia y Curiosidades", e, padre);
		
		nombreFacultadLbl = new JLabel("Historia y Curiosidades de "+f.toString());
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel historiaLbl = new JLabel("Historia");
		historiaLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		historiaLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		historiaLbl.setBounds(10, 66, 324, 26);
		panelContenedor.add(historiaLbl);
		
		JLabel curiosidadesLbl = new JLabel("Curiosidades");
		curiosidadesLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		curiosidadesLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		curiosidadesLbl.setBounds(366, 66, 324, 26);
		panelContenedor.add(curiosidadesLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 324, 348);
		panelContenedor.add(scrollPane);
		
		JTextArea historia = new JTextArea();
		historia.setWrapStyleWord(true);
		historia.setLineWrap(true);
		historia.setText(Universidad.getInstancia().buscarFacultad(f).getInformacion().getHistoria());
		historia.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		historia.setEditable(false);
		scrollPane.setViewportView(historia);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(366, 92, 324, 348);
		panelContenedor.add(scrollPane_1);
		
		JTextArea curiosidades = new JTextArea();
		curiosidades.setWrapStyleWord(true);
		curiosidades.setLineWrap(true);
		curiosidades.setText(Universidad.getInstancia().buscarFacultad(f).getInformacion().getCuriosidades());
		curiosidades.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		curiosidades.setEditable(false);
		scrollPane_1.setViewportView(curiosidades);
	}
}