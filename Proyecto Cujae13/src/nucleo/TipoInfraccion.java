package nucleo;

public enum TipoInfraccion {
	INCOMPARECENCIA_COLECTIVO("Incomparecencia Colectivo",5,"Juego perdido por incomparecencia o no presentación en deportes colectivos",TipoDeporte.DEPORTE_COLECTIVO),
	AGRESION_MENOR("Agresión Menor",5,"Ofender al adversario, intento de agresión o ripostar una agresión",TipoDeporte.AMBOS),
	DECISIONES_ARBITRALES("Decisiones Arbitrales",4,"Protestar las decisiones arbitrales",TipoDeporte.AMBOS),
	AGRESION_VERBAL("Agresión Verbal",3,"Ripostar una agresión verbal",TipoDeporte.AMBOS),
	AGRESION_SEVERA("Agresión Severa",10,"Atleta expulsado por agresión, ofensa a profesores, oficiales del evento u otros",TipoDeporte.AMBOS),
	PARTICIPACION_SIN_INSCRIPCION("Participación sin inscripción",10,"Por participar en los deportes colectivos un atleta que no esté oficialmente inscrito",TipoDeporte.DEPORTE_COLECTIVO),
	INCOMPARECENCIA_INDIVIDUAL("Incomparecencia Individual",10,"Juego perdido por incomparecencia o no presentación en deportes individuales",TipoDeporte.DEPORTE_INDIVIDUAL),
	TARDIA_ENTREGA_PLANILLAS("Tardía Entrega de Planillas",5,"No entrega de las planillas de inscripción en la fecha seleccionada",TipoDeporte.AMBOS),
	PLANILLAS_MAL_COMPROMISO("Planillas con Compromiso Erróneo",1,"Entrega de planillas de inscripción sin correspondencia al compromiso de participación establecido inicialmente para cada una de las especialidades",TipoDeporte.AMBOS),
	NO_PARTICIPACION_CONGRESILLO("No Participación en Congresillo",2,"No participación en los congresillos técnicos",TipoDeporte.AMBOS),
	
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
