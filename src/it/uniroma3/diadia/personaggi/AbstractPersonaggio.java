package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Quesa classe astratta serve per unificare e per rimuovere il codice copia
 * dalle varie classi che rappresentano i personaggi
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.3
 *
 */
public abstract class AbstractPersonaggio {
	private String nome; 
	private String presentazione; 
	private boolean haSalutato; 
	
	public AbstractPersonaggio(String nome, String presentaz) { 
		this.nome = nome; 
	 	this.presentazione = presentaz; 
	 	this.haSalutato = false; 
	} 
	
	/**
	 * Questo metodo serve per prendere il nome del personaggio
	 * 
	 * @return il nome del personaggio
	 */
	public String getNome() { 
		return this.nome; 
	} 
	
	/**
	 * Questo metodo server per determinare se il giocatore ha già salutato il personaggio 
	 * oppure no
	 * 
	 * @return true se il giocatore ha già salutato il personaggio altrimenti false
	 */
	public boolean haSalutato() { 
		return this.haSalutato;
	}
	
	/**
	 * Questo metodo serve per salutare il personaggio
	 * 
	 * @return il saluto del personaggio
	 */
	public String saluta() { 
		String risposta = "Ciao, io sono "+this.getNome()+"."; 
		if (!haSalutato) 
			risposta += this.presentazione; 
		else 
			risposta += "Ci siamo gia' presentati.";	 	
		this.haSalutato = true; 
		return risposta; 

	} 
	/**
	 * Questo metodo astratto permette di interagire con il personaggio
	 * 
	 * @param partita la partita corrente
	 * @return una stringa che rappresenta l'interazione con il personaggio
	 */
	abstract public String agisci(Partita partita);
	
	/**
	 * Questo metodo astratto permette di dare un regalo al personaggio
	 * 
	 * @param attrezzo il regalo
	 * @param partita la partita corrente
	 * @return una stringa che rappresenta la reazione del personaggio al regalo
	 */
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	public String toString() { 
		return this.getNome(); 
	}
}
