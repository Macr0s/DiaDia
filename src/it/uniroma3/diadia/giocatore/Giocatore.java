package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

/**
 * Questa classe serve gestire il giocatore memorizzando
 * i cfu, il suo nome, il suo cognome e la borsa
 * 
 * @author Matteo Filippi, Andrea Salvoni (da un'idea di Michael Kolling and David J. Barnes)
 * @version 0.1
 * @see Borsa
 * @see Attrezzo
 */
public class Giocatore {
	private final static int DEFAULT_MAX_CFU = 20;
	private String nome;
	private String cognome;
	private int cfu;
	private Borsa borsa;
	private Attrezzo equipaggiato;
	
	
	public Giocatore(String nome, String cognome){
		this(nome, cognome, DEFAULT_MAX_CFU);
	}
	
	public Giocatore(String nome, String cognome, int cfu){
		this.nome = nome;
		this.cognome = cognome;
		this.cfu = cfu;
		this.borsa = new Borsa();
	}
	
	public Giocatore(String nome, String cognome, int cfu, Attrezzo equipaggiato){
		this(nome, cognome, cfu);
		this.equipaggiato = equipaggiato;
	}
	
	/**
	 * Questo metodo restituisce il nome del giocatore
	 * 
	 * @return il nome del giocatore
	 */
	public String getNome(){
		return this.nome;
	}
    
	/**
	 * Questo metodo restituisce il cognome del giocatore
	 * 
	 * @return il cognome del giocatore
	 */
	public String getCognome(){
		return this.cognome;
	}
	
	/**
	 * Questo metodo serve per impostare la borsa dell'utente
	 * 
	 * @param borsa la nuova borsa
	 */
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	/**
	 * Qusto metodo restitusice la borsa dell'utente
	 * 
	 * @return la borsa dell'utente
	 */
	public Borsa getBorsa(){
		return this.borsa;
	}
	
	/**
	 * Questo metodo restituisce l'attrezzo equipaggiato
	 * 
	 * @return l'oggetto equipaggiato
	 */
	public Attrezzo getEquipaggiato() {
		return this.equipaggiato;
	}
	
	/**
	 * Questo metodo imposta l'attrezzo equipaggiato
	 * 
	 * @param equipaggiato l'attrezzo da equipaggiare
	 */
	public void setEquipaggiato(Attrezzo equipaggiato) {
		this.equipaggiato = equipaggiato;
	}
	
	/**
	 * Questo metodo restituisce il numero di CFU
	 * 
	 * @return il numero di CFU correnti
	 */
	public int getCFU(){
		return this.cfu;
	}
	
	/**
	 * Questo metodo decremente di uno il numero di CFU
	 * 
	 */
	public void decrementaCFU(){
		this.cfu--;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("Io sono " + this.nome + " " + this.cognome + "\n");
		s.append("CFU: " + this.cfu + "\n");
		s.append("Equipaggiato: " + ((this.equipaggiato != null)? this.equipaggiato.toString(): "Niente") + "\n");
		s.append(this.borsa.toString());
		return s.toString();
	}
}
