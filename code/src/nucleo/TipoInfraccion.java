package nucleo;

/**
 * Enum que permite modelar los tipos de infracciones con los puntos restados, una descripcion y el tipo de deporte vinculado
 * 
 * @author Eduardo Gonzalez
 * @author Lilian Rojas
 * @author Katherine Ram�rez
 * @author Cristian P�ez
 * @author Bryan Garc�a
 *
 */
public enum TipoInfraccion {
	INCOMPARECENCIA_COLECTIVO("Incomparecencia Colectivo",5,"Juego perdido por incomparecencia o no presentaci�n en deportes colectivos",TipoDeporte.DEPORTE_COLECTIVO),
	AGRESION_MENOR("Agresi�n Menor",5,"Ofender al adversario, intento de agresi�n o ripostar una agresi�n",TipoDeporte.AMBOS),
	DECISIONES_ARBITRALES("Decisiones Arbitrales",4,"Protestar las decisiones arbitrales",TipoDeporte.AMBOS),
	AGRESION_VERBAL("Agresi�n Verbal",3,"Ripostar una agresi�n verbal",TipoDeporte.AMBOS),
	AGRESION_SEVERA("Agresi�n Severa",10,"Atleta expulsado por agresi�n, ofensa a profesores, oficiales del evento u otros",TipoDeporte.AMBOS),
	PARTICIPACION_SIN_INSCRIPCION("Participaci�n sin inscripci�n",10,"Por participar en los deportes colectivos un atleta que no est� oficialmente inscrito",TipoDeporte.DEPORTE_COLECTIVO),
	INCOMPARECENCIA_INDIVIDUAL("Incomparecencia Individual",10,"Juego perdido por incomparecencia o no presentaci�n en deportes individuales",TipoDeporte.DEPORTE_INDIVIDUAL),
	TARDIA_ENTREGA_PLANILLAS("Tard�a Entrega de Planillas",5,"No entrega de las planillas de inscripci�n en la fecha seleccionada",TipoDeporte.AMBOS),
	PLANILLAS_MAL_COMPROMISO("Planillas con Compromiso Err�neo",1,"Entrega de planillas de inscripci�n sin correspondencia al compromiso de participaci�n establecido inicialmente para cada una de las especialidades",TipoDeporte.AMBOS),
	NO_PARTICIPACION_CONGRESILLO("No Participaci�n en Congresillo",2,"No participaci�n en los congresillos t�cnicos",TipoDeporte.AMBOS),
	
	;
	
	private String nombre;
	private int puntaje;
	private String descripcion;
	private TipoDeporte tipo;
	
	private TipoInfraccion(String nombre, int puntaje, String descripcion, TipoDeporte tipo) {
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public TipoDeporte getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	public static TipoInfraccion fromString(String s) {
		TipoInfraccion st = null;
		
		TipoInfraccion[] tipos = values();
		
		for(int i=0;i<tipos.length && st==null;i++) {
			if(tipos[i].nombre.equalsIgnoreCase(s))
				st = tipos[i];
		}
		
		return st;
	}
}