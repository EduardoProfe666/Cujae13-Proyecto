package interfaz.clases.jdialogs;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import nucleo.Evento;
import nucleo.EventoFinalizado;
import nucleo.Facultad;
import nucleo.InicializacionPartidosDeporte.EventoFecha;

public class PartidoJDialog extends JDialogGeneral{

	private static final long serialVersionUID = 1L;
	private EventoFecha evento;
	
	public PartidoJDialog(EsquemaColores e, JFrame padre, EventoFecha evento) {
		super("Información de Partido", e, padre);
		this.evento = evento;
		
		JLabel nombreFacultadLbl = new JLabel("Información General");
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel facultad1 = new JLabel("Facultad 1: " + obtenerNombreFacultad1());
		facultad1.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad1.setBounds(10, 68, 334, 26);
		panelContenedor.add(facultad1);
		
		JLabel facultad2 = new JLabel("Facultad 2: " + obtenerNombreFacultad2());
		facultad2.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad2.setBounds(356, 68, 334, 26);
		panelContenedor.add(facultad2);
		
		JLabel fecha = new JLabel("Fecha: " + evento.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		fecha.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		fecha.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		fecha.setBounds(10, 105, 334, 26);
		panelContenedor.add(fecha);
		
		JLabel horaInicio = new JLabel("Hora Inicio: " + obtenerHoraInicio());
		horaInicio.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaInicio.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaInicio.setBounds(356, 105, 334, 26);
		panelContenedor.add(horaInicio);
		
		JLabel tevento = new JLabel("Tipo de Evento: " + evento.getEvento().getTipo());
		tevento.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tevento.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tevento.setBounds(10, 142, 334, 26);
		panelContenedor.add(tevento);
		
		JLabel resultado = new JLabel("Resultados");
		resultado.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		resultado.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		resultado.setBounds(10, 194, 680, 45);
		panelContenedor.add(resultado);
		
		JLabel horaFin = new JLabel("Hora Fin: " + obtenerHoraFin());
		horaFin.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaFin.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaFin.setBounds(10, 250, 334, 26);
		panelContenedor.add(horaFin);
		
		JLabel factultadG = new JLabel("Facultad Ganadora: " + obtenerFacultadGanadora());
		factultadG.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		factultadG.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		factultadG.setBounds(356, 250, 334, 26);
		panelContenedor.add(factultadG);
		
		
	}
	
	private String obtenerNombreFacultad1() {
		String nombreFacultad1 = "Por Determinar";
		Facultad facultad1 = evento.getEvento().getFacultadPrimera();
		
		if(facultad1 != null) {
			nombreFacultad1 = facultad1.getNombre().toString();
		} 
		
		return nombreFacultad1;
	}
	
	
	private String obtenerNombreFacultad2() {
		String nombreFacultad2 = "Por Determinar";
		Facultad facultad2 = evento.getEvento().getFacultadSegunda();
		
		if(facultad2 != null) {
			nombreFacultad2 = facultad2.getNombre().toString();
		} 
		
		return nombreFacultad2;
	}
	
	
	private String obtenerHoraInicio() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm a");
		LocalTime hora = evento.getEvento().getHoraInicio();
		
		return hora.format(formato);
	}
	

	private String obtenerHoraFin() {
		String horaFin = "-";
		Evento e = evento.getEvento();
		
		if(e instanceof EventoFinalizado) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("hh:mm a");
			LocalTime hora = ((EventoFinalizado)e).getHoraFin();
			horaFin = hora.format(formato);
		}
		
		return horaFin;
	}
	
	
	private String obtenerFacultadGanadora() {
		String facultadGanadora = "-";
		Evento e = evento.getEvento();
		
		if(e instanceof EventoFinalizado) {
			facultadGanadora = ((EventoFinalizado)e).getResultado().getFacultadGanadora().getNombre().toString();
		}
		
		return facultadGanadora;
	}

	

}
