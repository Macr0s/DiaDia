package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
/**
 * Classe astratta comando che unifica tutti i comando snellendo il codice
 * dei singoli comandi levando codice ripetitivo
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.3
 * @see Comando
 * @see Partita
 *
 */
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
