package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Matteo Filippi, Valter Crescenzi (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;

	public Partita(){
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore("Mario", "Biondi");
		this.finita = false;
	}

	public Stanza getStanzaVincente() {
		return this.labirinto.getVincente();
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.setCorrente(stanzaCorrente);
	}

	public Stanza getStanzaCorrente() {
		return this.labirinto.getCorrente();
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCFU() {
		return this.giocatore.getCFU();
	}

	public void decrementaCFU() {
		this.giocatore.decrementaCFU();		
	}	
	
	public Giocatore getGiocatore(){
		return this.giocatore;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(this.giocatore.toString() + "\n\n");
		s.append(this.getStanzaCorrente().toString() + "\n");		
		return s.toString();
	}
}
