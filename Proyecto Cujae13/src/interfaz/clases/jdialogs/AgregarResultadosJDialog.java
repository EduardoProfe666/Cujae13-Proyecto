package interfaz.clases.jdialogs;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import componentes.BotonAnimacion;
import componentes.BotonHorario;
import horario.TimePicker;
import interfaz.clases.AppPrincipalAdmin;
import interfaz.combobox.modelos.NombreFacultadComboBoxModel;
import nucleo.InicializacionPartidosDeporte.EventoFecha;
import raven.glasspanepopup.GlassPanePopup;
import raven.glasspanepopup.Option;
import raven.toast.Notifications;
import sample.message.MessageSinCancel;
import sample.message.OptionConstructor;
import nucleo.NombreFacultad;
import nucleo.Universidad;

public class AgregarResultadosJDialog extends JDialogGeneral{

	private static final long serialVersionUID = 1L;
	private EventoFecha ev;
	private JLabel nombreFacultadLbl;
	private LocalTime hora;
	private BotonAnimacion aceptar;
	private BotonAnimacion cancelar;
	private JComboBox<String> facultad;
	private BotonHorario btnHorario;
	private JLabel horaFin;
	
	public AgregarResultadosJDialog(EsquemaColores e, JFrame padre, EventoFecha eventoPorResultado) {
		super("Agregar Resultados", e, padre);
		ev = eventoPorResultado;
		JDialogGeneral j = this;
		
		LocalTime horaActual = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
		
		LocalTime horaMin = eventoPorResultado.getEvento().getHoraInicio().plusMinutes(15);
		horaMin = LocalTime.of(horaMin.getHour(), horaMin.getMinute());
		LocalTime horaMax;
		if(eventoPorResultado.getFecha().equals(LocalDate.now())) {
			if(horaActual.compareTo(LocalTime.of(19, 0))<=0)
				horaMax = horaActual;
			else
				horaMax = LocalTime.of(19, 0);
		}
		else {
			horaMax = LocalTime.of(19, 0);
		}
		hora = horaMin;
		
		btnHorario = new BotonHorario(28, 28,horaMin,horaMax);
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
		
		facultad = new JComboBox<String>();
		facultad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		facultad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				facultad.putClientProperty("JComponent.outline", null);
			}
		});
		facultad.setModel(new NombreFacultadComboBoxModel());
		((NombreFacultadComboBoxModel)facultad.getModel()).eliminarFacultades(facultadesAEliminar());
		facultad.setSelectedIndex(0);
		facultad.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
		facultad.setBounds(403, 249, 287, 20);
		panelContenedor.add(facultad);
		
		
		nombreFacultadLbl = new JLabel("Información General");
		nombreFacultadLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		nombreFacultadLbl.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
		nombreFacultadLbl.setBounds(10, 10, 680, 45);
		panelContenedor.add(nombreFacultadLbl);
		
		JLabel facultad1 = new JLabel("Facultad 1: " + eventoPorResultado.getEvento().getFacultadPrimera().getNombre());
		facultad1.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad1.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad1.setBounds(10, 68, 334, 26);
		panelContenedor.add(facultad1);
		
		JLabel facultad2 = new JLabel("Facultad 2: " + eventoPorResultado.getEvento().getFacultadSegunda().getNombre());
		facultad2.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		facultad2.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		facultad2.setBounds(356, 68, 334, 26);
		panelContenedor.add(facultad2);
		
		JLabel fecha = new JLabel("Fecha: " + eventoPorResultado.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		fecha.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		fecha.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		fecha.setBounds(10, 105, 334, 26);
		panelContenedor.add(fecha);
		
		JLabel horaInicio = new JLabel("Hora Inicio: " + eventoPorResultado.getEvento().getHoraInicio().format(DateTimeFormatter.ofPattern("hh:mm a")));
		horaInicio.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		horaInicio.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		horaInicio.setBounds(356, 105, 334, 26);
		panelContenedor.add(horaInicio);
		
		JLabel deporte = new JLabel("Deporte: " + eventoPorResultado.getEvento().getDeporte().getNombre());
		deporte.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		deporte.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		deporte.setBounds(10, 142, 334, 26);
		panelContenedor.add(deporte);
		
		JLabel tevento = new JLabel("Tipo de Evento: " + eventoPorResultado.getEvento().getTipo());
		tevento.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tevento.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tevento.setBounds(356, 142, 334, 26);
		panelContenedor.add(tevento);
		
		JLabel resultado = new JLabel("Resultados a agregar");
		resultado.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
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
			public void actionPerformed(ActionEvent ev) {
				if(validarResultado()) {
					String fac = (String)facultad.getSelectedItem();
					NombreFacultad f = NombreFacultad.fromString(fac);
					int facultadGanadora = f.equals(eventoPorResultado.getEvento().getFacultadPrimera().getNombre()) ? 1 : 2;
					
					Universidad.getInstancia().agregarResultadoEvento(eventoPorResultado, facultadGanadora, hora);
					dispose();
					AppPrincipalAdmin.actualizar();
					Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.BOTTOM_RIGHT, 2500, "Se ha agregado el resultado correctamente");
				}else {
					Option o = OptionConstructor.constructOption(e.getPanelMovilBase(), false);
					MessageSinCancel m = new MessageSinCancel("Error", "Compruebe los datos de los campos señalados");
					m.eventOK(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							GlassPanePopup.closePopupLast();
							j.setVisible(true);
						}
					});
					GlassPanePopup.showPopup(m, o);
					j.setVisible(false);
				}
				
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

	private List<NombreFacultad> facultadesAEliminar() {
		List<NombreFacultad> fac = new LinkedList<NombreFacultad>(Arrays.asList(NombreFacultad.values()));
		
		Iterator<NombreFacultad> iter = fac.iterator();
		while(iter.hasNext()) {
			NombreFacultad n = iter.next();
			if(n.equals(ev.getEvento().getFacultadPrimera().getNombre()) || n.equals(ev.getEvento().getFacultadSegunda().getNombre()))
				iter.remove();
		}
		
		return fac;
		
	}
	
	private boolean validarResultado() {
		boolean validada = true;
		
		if(facultad.getSelectedIndex() < 1) {
			validada = false;
			facultad.putClientProperty("JComponent.outline", "error");
		}
		
		return validada;
	}

}
