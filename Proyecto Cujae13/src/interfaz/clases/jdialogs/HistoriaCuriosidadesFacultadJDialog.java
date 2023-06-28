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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 680, 378);
		panelContenedor.add(scrollPane);
		
		JTextArea historia = new JTextArea();
		historia.setWrapStyleWord(true);
		historia.setLineWrap(true);
		historia.setText(Universidad.getInstancia().buscarFacultad(f).getInformacion().getHistoriaYCuriosidades());
		historia.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		historia.setEditable(false);
		scrollPane.setViewportView(historia);
		

	}
}