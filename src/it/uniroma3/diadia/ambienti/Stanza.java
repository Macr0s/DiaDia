package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

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
    protected List<Attrezzo> attrezzi;
    private HashMap<String, Stanza> stanzeAdiacenti;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.attrezzi = new ArrayList<>();
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
    	Iterator<String> direzioni = this.stanzeAdiacenti.keySet().iterator();
    	while (direzioni.hasNext())
    		s += " " + direzioni.next();
    	s += "\nAttrezzi nella stanza: ";
    	Iterator<Attrezzo> attrezzi = this.attrezzi.iterator();
    	while (attrezzi.hasNext()) {	
    		s += attrezzi.next().toString()+" ";
    	}
    	return s;
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi.toArray(new Attrezzo[0]);
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        return this.attrezzi.add(attrezzo);
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
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		while (i.hasNext()) {
			if (i.next().getNome().equals(nomeAttrezzo))
				return true;
		}
		return false;
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato= null;
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		Attrezzo attrezzoTemp;
		while (i.hasNext()) {
			attrezzoTemp = i.next();
			if (attrezzoTemp.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzoTemp;
		}
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo Contiene l'oggetto da rimuovere
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove((Attrezzo) attrezzo);
	}

	/**
	 *	Metodo che restituisce le direzioni disponibili dentro la stanza
	 *	@return String[] di direzioni 
	 */
	public String[] getDirezioni() {
		return this.stanzeAdiacenti.keySet().toArray(new String[0]);
    }
}