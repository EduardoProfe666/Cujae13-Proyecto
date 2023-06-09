package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

/**
 * Componente gráfico que modela un JLabel con el formato: "Día Actual: dd+mm+yyyy".
 * 
 * @version 2023.05.29
 * @author Eduardo González
 *
 */
public class LabelDiaActual extends JLabel {
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String texto;
	
	public LabelDiaActual(Color colorBorde) {
		texto = "Día Actual:";
		fecha = crearFecha(LocalDate.now());
		actualizarTexto();
		
		setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		setBorder(new MatteBorder(0, 0, 2, 0, colorBorde));
		setBounds(15, 67, 569, 26);
	}
	public LabelDiaActual(String texto, Color colorBorde) {
		this(colorBorde);
		this.texto = texto;
		actualizarTexto();
	}
	
	private String convertirNumeroString(Integer n) {
		String s = n.toString();
		
		if(n<10)
			s = "0"+n.toString();
		
		return s;
	}
	
	private String crearFecha(LocalDate l) {
		return convertirNumeroString(l.getDayOfMonth())+"/"+convertirNumeroString(l.getMonthValue())+"/"+convertirNumeroString(l.getYear());
	}
	
	public void cambiarFecha(LocalDate l) {
		if(l!=null) {
			fecha = crearFecha(l);
			actualizarTexto();
		}
	}
	
	private void actualizarTexto() {
		setText(texto+" "+fecha);
	}
}
