package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;

public class ComandoUsa implements Comando {
	private Partita p;
	private String paramentro;
	
	@Override
	public void setPartita(Partita p) {
		this.p = p;
	}

	@Override
	public void setParamentro(String params) {
		this.paramentro = params;
	}

	@Override
	public String esegui() {
		// TODO Auto-generated method stub
		return null;
	}

}
