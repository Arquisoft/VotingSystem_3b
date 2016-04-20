package es.uniovi.asw.model;

public class TipoVotoForm {
	
	private String tipoVoto;	
	
	public TipoVotoForm(){}
	
	public TipoVotoForm(String tipoVoto) {
		super();
		this.tipoVoto = tipoVoto;
	}
	
	public String getTipoVoto() {
		return tipoVoto;
	}
	public void setTipoVoto(String tipoVoto) {
		this.tipoVoto = tipoVoto;
	}
	
}
