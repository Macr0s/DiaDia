package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author Matteo Filippi, Andrea Salvoni (a partire da un'idea di Michael Kolling e David J. Barnes)
 * @see Attrezzo
 * @version 0.2
*/

public class Stanza {
	private String nome;
    protected HashMap<String, Attrezzo> attrezzi;
    private HashMap<String, Stanza> stanzeAdiacenti;
    private Partita partita;
    private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.attrezzi = new HashMap<>();
        this.stanzeAdiacenti = new HashMap<>();
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        this.stanzeAdiacenti.put(direzione, stanza);
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione la direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        return this.stanzeAdiacenti.get((String) direzione);
	}

    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
    	String s = new String();
    	s += this.nome;
    	s += "\nUscite: ";
    	for (String direzioni: this.stanzeAdiacenti.keySet())
    		s += " " + direzioni;
    	s += "\nAttrezzi nella stanza: ";
    	for (Attrezzo attrezzo: this.attrezzi.values()) {	
    		s += attrezzo.toString()+" ";
    	}
    	return s;
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi.values().toArray(new Attrezzo[0]);
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.put(attrezzo.getNome(),attrezzo) == null;
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	return this.getDescrizione();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo Contiene l'oggetto da rimuovere
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo.getNome()) != null;
	}

	/**
	 *	Metodo che restituisce le direzioni disponibili dentro la stanza
	 *	@return String[] di direzioni 
	 */
	public String[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new String[0]);
    }
	
	/**
	 * Metodo che restituisce la partita corrente
	 * 
	 * @return la partita corrente
	 */
	public Partita getPartita() {
		return partita;
	}
	
	/**
	 * Meotod che imposta la partita corrente
	 * 
	 * @param partita la partita corrente
	 */
	public void setPartita(Partita partita) {
		this.partita = partita;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return personaggio;
	}
	
	public void setPersionaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
	}
}