package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Matteo Filippi, Andrea Salvoni (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza corrente;
	
	/**
	 *	Crea la partita istanziando labirinto e giocatore 
	 */
	public Partita(){
		this.labirinto = new Labirinto();
		this.corrente = this.labirinto.getVincente();
		this.giocatore = new Giocatore("Mario", "Biondi");
		this.finita = false;
	}
	
	/**
	 * Metodo che restituisce la stanza vincente
	 * 
	 * @return Restituisce la stanza vincente
	 */
	public Stanza getStanzaVincente() {
		return this.labirinto.getVincente();
	}
	
	/**
	 * Metodo che imposta la stanza corrente
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.corrente = stanzaCorrente ;
	}
	
	/**
	 * Metodo che restituisce la stanza corrente
	 * 
	 * @return Restituisce la stanza corrente
	 */
	public Stanza getStanzaCorrente() {
		return this.corrente;
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
	
	/**
	 * Metodo che restituisce il numero di CFU correnti del giocatore
	 * 
	 * @return Un intero che rappresenta il numero di CFU del giocatore
	 */
	public int getCFU() {
		return this.giocatore.getCFU();
	}
	/**
	 * Metodo che descrementa i CFU del giocatore
	 */
	public void decrementaCFU() {
		this.giocatore.decrementaCFU();		
	}	
	/**
	 * Metodo che restituisce il giocatore
	 * 
	 * @return Il giocatore
	 */
	public Giocatore getGiocatore(){
		return this.giocatore;
	}
	
	/**
	 * Metodo che crea una rappresentazione della partita sotto-forma
	 * di stringa stampando  le infomazioni del giocatore e quelle della stanza
	 * 
	 * @return La rappresentazione stringa
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(this.giocatore.toString() + "\n\n");
		s.append(this.getStanzaCorrente().toString() + "\n");		
		return s.toString();
	}
	
	/**
	 * Metodo che restituisce il messaggio di benvento del labirinto
	 * 
	 * @return Il messaggio di benvenuto
	 */
	public String getMessaggioBenvenuto(){
		return this.labirinto.getMessaggioBenvenuto();
	}
}
