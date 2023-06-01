package nucleo;

public class InfoGeneral {
	private String historia;
	private String curiosidades;
	
	public InfoGeneral(String historia, String curiosidades) {
		setHistoria(historia);
		setCuriosidades(curiosidades);
	}
	
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		if(historia == null)
			throw new IllegalArgumentException();
		this.historia = historia;
	}
	public String getCuriosidades() {
		return curiosidades;
	}
	public void setCuriosidades(String curiosidades) {
		if(curiosidades==null)
			throw new IllegalArgumentException();
		this.curiosidades = curiosidades;
	}
	
	
}
