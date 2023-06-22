package interfaz.clases.jdialogs;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import nucleo.InicializacionPartidosDeporte.EventoFecha;

public class PartidoJDialog extends JDialogGeneral{

	private static final long serialVersionUID = 1L;
	
	public PartidoJDialog(EsquemaColores e, JFrame padre, EventoFecha evento) {
		super("Información de Partido", e, padre);
		
		
		JLabel nombreFacultadLbl = new JLabel("Información General");
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel facultad1 = new JLabel("Facultad 1: -");
		facultad1.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad1.setBounds(10, 68, 334, 26);
		panelContenedor.add(facultad1);
		
		JLabel facultad2 = new JLabel("Facultad 2: -");
		facultad2.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad2.setBounds(356, 68, 334, 26);
		panelContenedor.add(facultad2);
		
		JLabel fecha = new JLabel("Fecha: -");
		fecha.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		fecha.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		fecha.setBounds(10, 105, 334, 26);
		panelContenedor.add(fecha);
		
		JLabel horaInicio = new JLabel("Hora Inicio: -");
		horaInicio.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaInicio.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaInicio.setBounds(356, 105, 334, 26);
		panelContenedor.add(horaInicio);
		
		JLabel tevento = new JLabel("Tipo de Evento: -");
		tevento.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tevento.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tevento.setBounds(10, 142, 334, 26);
		panelContenedor.add(tevento);
		
		JLabel resultado = new JLabel("Resultados");
		resultado.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		resultado.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		resultado.setBounds(10, 194, 680, 45);
		panelContenedor.add(resultado);
		
		JLabel horaFin = new JLabel("Hora Fin: -");
		horaFin.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaFin.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaFin.setBounds(10, 250, 334, 26);
		panelContenedor.add(horaFin);
		
		JLabel factultadG = new JLabel("Facultad Ganadora: -");
		factultadG.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		factultadG.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		factultadG.setBounds(356, 250, 334, 26);
		panelContenedor.add(factultadG);
		
		
	}

	

}
