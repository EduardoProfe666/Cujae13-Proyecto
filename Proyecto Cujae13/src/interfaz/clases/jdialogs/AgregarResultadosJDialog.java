package interfaz.clases.jdialogs;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.BotonAnimacion;
import componentes.BotonHorario;
import horario.TimePicker;
import interfaz.combobox.modelos.NombreFacultadComboBoxModel;
import nucleo.Evento;

public class AgregarResultadosJDialog extends JDialogGeneral{

	private static final long serialVersionUID = 1L;
	private JLabel nombreFacultadLbl;
	private LocalTime hora;
	private BotonAnimacion aceptar;
	private BotonAnimacion cancelar;
	private JComboBox<String> facultad;
	private BotonHorario btnHorario;
	private JLabel horaFin;
	
	public AgregarResultadosJDialog(EsquemaColores e, JFrame padre, Evento eventoPorResultado) {
		super("Agregar Resultados", e, padre);
		hora = LocalTime.now();
		
		
		btnHorario = new BotonHorario(28, 28,LocalTime.now());
		TimePicker t = btnHorario.getHorario();
		t.setForeground(e.getColorHorario());
		btnHorario.setBounds(193, 244, 28, 28);
		panelContenedor.add(btnHorario);
		btnHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.showPopup(rootPane, 100, 100);
			}
		});
		btnHorario.addPropertyChangeListener("exito", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				hora = t.getHoraSeleccionada();
				horaFin.setText("Hora Fin: "+ hora.format(DateTimeFormatter.ofPattern("hh:mm a")));

			}
		});
		
		
		nombreFacultadLbl = new JLabel("Información General");
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		facultad = new JComboBox<String>();
		facultad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		facultad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		facultad.setModel(new NombreFacultadComboBoxModel());
		facultad.setSelectedIndex(0);
		facultad.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		facultad.setBounds(403, 249, 287, 20);
		panelContenedor.add(facultad);
		
		JLabel facultad1 = new JLabel("Facultad 1: Telecomunicaciones");
		facultad1.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad1.setBounds(10, 68, 334, 26);
		panelContenedor.add(facultad1);
		
		JLabel facultad2 = new JLabel("Facultad 2: Inform\u00E1tica");
		facultad2.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad2.setBounds(356, 68, 334, 26);
		panelContenedor.add(facultad2);
		
		JLabel fecha = new JLabel("Fecha: 13/06/2023");
		fecha.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		fecha.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		fecha.setBounds(10, 105, 334, 26);
		panelContenedor.add(fecha);
		
		JLabel horaInicio = new JLabel("Hora Inicio: 11:11 am");
		horaInicio.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaInicio.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaInicio.setBounds(356, 105, 334, 26);
		panelContenedor.add(horaInicio);
		
		JLabel deporte = new JLabel("Deporte: Nataci\u00F3n");
		deporte.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		deporte.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		deporte.setBounds(10, 142, 334, 26);
		panelContenedor.add(deporte);
		
		JLabel tevento = new JLabel("Tipo de Evento: -");
		tevento.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tevento.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tevento.setBounds(356, 142, 334, 26);
		panelContenedor.add(tevento);
		
		JLabel resultado = new JLabel("Resultados a agregar");
		resultado.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		resultado.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		resultado.setBounds(10, 194, 680, 45);
		panelContenedor.add(resultado);
		
		horaFin = new JLabel("Hora Fin: "+ hora.format(DateTimeFormatter.ofPattern("hh:mm a")));
		horaFin.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaFin.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaFin.setBounds(10, 250, 216, 26);
		panelContenedor.add(horaFin);
		
		JLabel factultadG = new JLabel("Facultad Ganadora: ");
		factultadG.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		factultadG.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		factultadG.setBounds(236, 250, 454, 26);
		panelContenedor.add(factultadG);
		
		aceptar = new BotonAnimacion();
		aceptar.setEffectColor(e.getBtnAceptarColorEfecto());
		aceptar.setBackground(e.getBtnAceptar());
		aceptar.setForeground(e.getBtnAceptarTxt());
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		aceptar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		aceptar.setText("Aceptar");
		aceptar.setBounds(560, 407, 130, 26);
		aceptar.setBorder(null);
		panelContenedor.add(aceptar);
		
		cancelar = new BotonAnimacion();
		cancelar.setEffectColor(e.getBtnCancelarColorEfecto());
		cancelar.setBackground(e.getBtnCancelar());
		cancelar.setForeground(e.getBtnCancelarTxt());
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelar.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		cancelar.setText("Cancelar");
		cancelar.setBounds(420, 407, 130, 26);
		cancelar.setBorder(null);
		panelContenedor.add(cancelar);
		
	}

	

}
