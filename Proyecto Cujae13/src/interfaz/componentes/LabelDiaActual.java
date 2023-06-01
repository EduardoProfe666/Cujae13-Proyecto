package interfaz.componentes;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class LabelDiaActual extends JLabel {
	private static final long serialVersionUID = 1L;
	
	public LabelDiaActual(Color colorBorde) {
		String texto = "Día Actual: ";
		LocalDate l = LocalDate.now();
		
		texto = texto.concat(convertirNumeroString(l.getDayOfMonth())+"/"+convertirNumeroString(l.getMonthValue())+"/"+convertirNumeroString(l.getYear()));
		
		setText(texto);
		setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		setBorder(new MatteBorder(0, 0, 2, 0, colorBorde));
		setBounds(15, 67, 569, 26);
	}
	
	private String convertirNumeroString(Integer n) {
		String s = n.toString();
		
		if(n<10)
			s = "0"+n.toString();
		
		return s;
	}
}
