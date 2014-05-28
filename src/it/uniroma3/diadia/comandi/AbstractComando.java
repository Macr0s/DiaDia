package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando {
	private Partita p;
	private String parametro;

	@Override
	public void setPartita(Partita p) {
		this.p = p;
	}

	@Override
	public void setParamentro(String params) {
		this.parametro = params;
	}

	@Override
	public abstract String esegui();
	
	public Partita getPartita() {
		return p;
	}
	
	public String getParametro() {
		return parametro;
	}

}
