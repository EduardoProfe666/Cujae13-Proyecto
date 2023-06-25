package interfaz.clases.panelesAppPrincipalAdmin;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

import clasesAuxiliares.EsquemaColores;
import interfaz.clases.panelesAppPrincipal.PanelBaseAppPrincipal;
import interfaz.componentes.TablaPosiciones;
import interfaz.componentes.TarjetaReporte;
import nucleo.Universidad;

public class PanelInicioAdmin extends PanelBaseAppPrincipal{

	private static final long serialVersionUID = 1L;
	
	public PanelInicioAdmin(EsquemaColores e) {
		
		JLabel adminLbl = new JLabel("Administraci\u00F3n de Cujae13");
		adminLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		adminLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 24));
		adminLbl.setBounds(10, 35, 869, 45);
		add(adminLbl);
		
		JLabel datosLbl = new JLabel("Datos Generales");
		datosLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		datosLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		datosLbl.setBounds(10, 91, 560, 26);
		add(datosLbl);
		
		JLabel tablaPosLbl = new JLabel("Tabla de Posiciones General");
		tablaPosLbl.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		tablaPosLbl.setBorder(new MatteBorder(0, 0, 2, 0, e.getBordeLbl()));
		tablaPosLbl.setBounds(589, 91, 290, 26);
		add(tablaPosLbl);
		
		TablaPosiciones tablaPosGeneral = new TablaPosiciones(Universidad.getInstancia().getTablaPosicionesGlobal(), 
				e.getSeleccionTextoTabla(), e.getSeleccionFondoTabla(),false);
		tablaPosGeneral.setBounds(589, 128, 290, 436);
		add(tablaPosGeneral);
		
		TarjetaReporte partidosPorResultados = new TarjetaReporte(e.getFondoBtnSF(), e.getBordeLbl(), "Partidos Por Resultados", "/interfaz/iconos/resultados.png", Universidad.getInstancia().cantDeportesPorResultado());
		partidosPorResultados.setBounds(10, 149, 260, 180);
		add(partidosPorResultados);
		
		TarjetaReporte amonestaciones = new TarjetaReporte(e.getFondoBtnSF(), e.getBordeLbl(), "Amonestaciones", "/interfaz/iconos/amonestacion01.png", Universidad.getInstancia().getCantidadAmonestaciones());
		amonestaciones.setBounds(310, 149, 260, 180);
		add(amonestaciones);
		
		TarjetaReporte DeportesActivos = new TarjetaReporte(e.getFondoBtnSF(), e.getBordeLbl(), "Deportes Activos", "/interfaz/iconos/deporteBlack.png", Universidad.getInstancia().cantDeportesActivos());
		DeportesActivos.setBounds(161, 358, 260, 180);
		add(DeportesActivos);
		
	}
}
