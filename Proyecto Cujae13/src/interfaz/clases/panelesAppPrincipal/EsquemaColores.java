package interfaz.clases.panelesAppPrincipal;

import java.awt.Color;

/**
 * Clase que modela la capa de personalización de las facultades. Incluye colores de bordes, letras, 
 * fondos, imágenes, logos, etc.
 * 
 * @version 2023.06.02
 * @author Lilian Rojas
 * @author Eduardo González
 *
 */
public class EsquemaColores {
	//Panel Usuario
	private Color panelUsuarioGradienteInicio;
	private Color panelUsuarioGradienteFin;
	private Color panelUsuarioTexto;
	private Color panelUsuarioBtnTexto;
	private Color panelUsuarioBtnColorEfecto;
	private Color panelUsuarioBtn;
	private Color bordeAvatar;
	private String dirUrlImagenAvatar;
	
	//Panel ContenedorOpciones
	private Color panelContenedorOpciones;
	private Color panelOpcionHover;
	private Color panelOpcionSeleccionado;
	private Color panelOpcionTexto;
	
	//Panel Sup
	private Color panelSupGradienteInicio;
	private Color panelSupGradienteFin;
	private Color panelSupGradienteTexto;
	private String dirUrlBtnAtras;
	private String dirUrlBtnAtrasHover;
	
	//Panel Movil
	private Color panelMovilBase; 
	
	//Paneles General
	private Color bordeLbl;
	private Color seleccionFondoTabla;
	private Color seleccionTextoTabla;
	
	//Componente BtnSeleccionFacultad
	private Color fondoBtnSF;
	private Color hoverBtnSF;
	
	public EsquemaColores(Color panelUsuarioGradienteInicio, Color panelUsuarioGradienteFin, Color panelUsuarioTexto,
			Color panelUsuarioBtnTexto, Color panelUsuarioBtnColorEfecto, Color panelUsuarioBtn, Color bordeAvatar,
			Color panelContenedorOpciones, Color panelOpcionHover, Color panelOpcionSeleccionado,
			Color panelOpcionTexto, Color panelSupGradienteInicio, Color panelSupGradienteFin,
			Color panelSupGradienteTexto, String dirUrlImagenAvatar, Color panelMovilBase, Color bordeLbl, Color fondoBtnSF, Color hoverBtnSF,
			String dirUrlBtnAtras, String dirUrlBtnAtrasHover, Color seleccionFondoTabla, Color seleccionTextoTabla) {
		super();
		this.panelUsuarioGradienteInicio = panelUsuarioGradienteInicio;
		this.panelUsuarioGradienteFin = panelUsuarioGradienteFin;
		this.panelUsuarioTexto = panelUsuarioTexto;
		this.panelUsuarioBtnTexto = panelUsuarioBtnTexto;
		this.panelUsuarioBtnColorEfecto = panelUsuarioBtnColorEfecto;
		this.panelUsuarioBtn = panelUsuarioBtn;
		this.bordeAvatar = bordeAvatar;
		this.panelContenedorOpciones = panelContenedorOpciones;
		this.panelOpcionHover = panelOpcionHover;
		this.panelOpcionSeleccionado = panelOpcionSeleccionado;
		this.panelOpcionTexto = panelOpcionTexto;
		this.panelSupGradienteInicio = panelSupGradienteInicio;
		this.panelSupGradienteFin = panelSupGradienteFin;
		this.panelSupGradienteTexto = panelSupGradienteTexto;
		this.dirUrlImagenAvatar = dirUrlImagenAvatar;
		this.panelMovilBase = panelMovilBase;
		this.bordeLbl = bordeLbl;
		this.fondoBtnSF = fondoBtnSF;
		this.hoverBtnSF = hoverBtnSF;
		this.dirUrlBtnAtras = dirUrlBtnAtras;
		this.dirUrlBtnAtrasHover = dirUrlBtnAtrasHover;
		this.seleccionFondoTabla = seleccionFondoTabla;
		this.seleccionTextoTabla = seleccionTextoTabla;
	}

	public Color getPanelUsuarioGradienteInicio() {
		return panelUsuarioGradienteInicio;
	}

	public void setPanelUsuarioGradienteInicio(Color panelUsuarioGradienteInicio) {
		this.panelUsuarioGradienteInicio = panelUsuarioGradienteInicio;
	}

	public Color getPanelUsuarioGradienteFin() {
		return panelUsuarioGradienteFin;
	}

	public void setPanelUsuarioGradienteFin(Color panelUsuarioGradienteFin) {
		this.panelUsuarioGradienteFin = panelUsuarioGradienteFin;
	}

	public Color getPanelUsuarioTexto() {
		return panelUsuarioTexto;
	}

	public void setPanelUsuarioTexto(Color panelUsuarioTexto) {
		this.panelUsuarioTexto = panelUsuarioTexto;
	}

	public Color getPanelUsuarioBtnTexto() {
		return panelUsuarioBtnTexto;
	}

	public void setPanelUsuarioBtnTexto(Color panelUsuarioBtnTexto) {
		this.panelUsuarioBtnTexto = panelUsuarioBtnTexto;
	}

	public Color getPanelUsuarioBtnColorEfecto() {
		return panelUsuarioBtnColorEfecto;
	}

	public void setPanelUsuarioBtnColorEfecto(Color panelUsuarioBtnColorEfecto) {
		this.panelUsuarioBtnColorEfecto = panelUsuarioBtnColorEfecto;
	}

	public Color getPanelUsuarioBtn() {
		return panelUsuarioBtn;
	}

	public void setPanelUsuarioBtn(Color panelUsuarioBtn) {
		this.panelUsuarioBtn = panelUsuarioBtn;
	}

	public Color getBordeAvatar() {
		return bordeAvatar;
	}

	public void setBordeAvatar(Color bordeAvatar) {
		this.bordeAvatar = bordeAvatar;
	}

	public Color getPanelContenedorOpciones() {
		return panelContenedorOpciones;
	}

	public void setPanelContenedorOpciones(Color panelContenedorOpciones) {
		this.panelContenedorOpciones = panelContenedorOpciones;
	}

	public Color getPanelOpcionHover() {
		return panelOpcionHover;
	}

	public void setPanelOpcionHover(Color panelOpcionHover) {
		this.panelOpcionHover = panelOpcionHover;
	}

	public Color getPanelOpcionSeleccionado() {
		return panelOpcionSeleccionado;
	}

	public void setPanelOpcionSeleccionado(Color panelOpcionSeleccionado) {
		this.panelOpcionSeleccionado = panelOpcionSeleccionado;
	}

	public Color getPanelOpcionTexto() {
		return panelOpcionTexto;
	}

	public void setPanelOpcionTexto(Color panelOpcionTexto) {
		this.panelOpcionTexto = panelOpcionTexto;
	}

	public Color getPanelSupGradienteInicio() {
		return panelSupGradienteInicio;
	}

	public void setPanelSupGradienteInicio(Color panelSupGradienteInicio) {
		this.panelSupGradienteInicio = panelSupGradienteInicio;
	}

	public Color getPanelSupGradienteFin() {
		return panelSupGradienteFin;
	}

	public void setPanelSupGradienteFin(Color panelSupGradienteFin) {
		this.panelSupGradienteFin = panelSupGradienteFin;
	}

	public Color getPanelSupGradienteTexto() {
		return panelSupGradienteTexto;
	}

	public void setPanelSupGradienteTexto(Color panelSupGradienteTexto) {
		this.panelSupGradienteTexto = panelSupGradienteTexto;
	}

	public String getDirUrlImagenAvatar() {
		return dirUrlImagenAvatar;
	}

	public void setDirUrlImagenAvatar(String dirUrlImagenAvatar) {
		this.dirUrlImagenAvatar = dirUrlImagenAvatar;
	}

	public Color getPanelMovilBase() {
		return panelMovilBase;
	}

	public void setPanelMovilBase(Color panelMovilBase) {
		this.panelMovilBase = panelMovilBase;
	}

	public Color getBordeLbl() {
		return bordeLbl;
	}

	public Color getFondoBtnSF() {
		return fondoBtnSF;
	}

	public void setFondoBtnSF(Color fondoBtnSF) {
		this.fondoBtnSF = fondoBtnSF;
	}

	public Color getHoverBtnSF() {
		return hoverBtnSF;
	}

	public void setHoverBtnSF(Color hoverBtnSF) {
		this.hoverBtnSF = hoverBtnSF;
	}

	public void setBordeLbl(Color bordeLbl) {
		this.bordeLbl = bordeLbl;
	}

	public String getDirUrlBtnAtras() {
		return dirUrlBtnAtras;
	}

	public void setDirUrlBtnAtras(String dirUrlBtnAtras) {
		this.dirUrlBtnAtras = dirUrlBtnAtras;
	}

	public String getDirUrlBtnAtrasHover() {
		return dirUrlBtnAtrasHover;
	}

	public void setDirUrlBtnAtrasHover(String dirUrlBtnAtrasHover) {
		this.dirUrlBtnAtrasHover = dirUrlBtnAtrasHover;
	}

	public Color getSeleccionFondoTabla() {
		return seleccionFondoTabla;
	}

	public void setSeleccionFondoTabla(Color seleccionFondoTabla) {
		this.seleccionFondoTabla = seleccionFondoTabla;
	}

	public Color getSeleccionTextoTabla() {
		return seleccionTextoTabla;
	}

	public void setSeleccionTextoTabla(Color seleccionTextoTabla) {
		this.seleccionTextoTabla = seleccionTextoTabla;
	}

	
	
	
}
