package it.uniroma3.diadia.ambienti.parser;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

import java.util.Map;

/**
 * Questa classe astratta unifica tutti i tag dandogli dei supporti
 * 
 * @author Matteo FIlippi, Andrea Salvoni
 * @see CaricatoreLabirinto
 * @see FormatoFileNonValidoException
 * @see Attrezzo
 * @see AbstractPersonaggio
 * @see Stanza
 * @see Partita
 * @version 0.4
 *
 */
public abstract class Tag {
	private CaricatoreLabirinto c;
	
	/**
	 * Metodo astratto che permette di elaborare i tag
	 * 
	 * @param argomenti gli argometi del tag
	 * @throws FormatoFileNonValidoException
	 */
	public abstract void elabora(String argomenti) throws FormatoFileNonValidoException;
	
	/**
	 * Metodo che collega i tag al caricatore del labirinto
	 * 
	 * @param c il caricatore del labirinto
	 */
	public void setCaricatoreLabirinto(CaricatoreLabirinto c){
		this.c = c;
	};
	
	/**
	 * Metodo che restituisce l'insieme degli attrezzi
	 * 
	 * @return l'insieme degli attrezzi
	 */
	public Map<String, Attrezzo> getInsiemeAttrezzo() {
		return this.c.getInsiemeAttrezzo();
	}
	
	/**
	 * Metodo che restituisce l'insieme dei personaggi
	 * 
	 * @return l'insieme dei personaggi
	 */
	public Map<String, AbstractPersonaggio> getInsiemePersonaggio() {
		return this.c.getInsiemePersonaggio();
	}
	
	/**
	 * Metodo che restituisce l'insieme delle stanze
	 * 
	 * @return l'insieme delle stanze
	 */
	public Map<String, Stanza> getInsiemeStanza() {
		return this.c.getInsiemeStanza();
	}
	
	/**
	 * Metodo che imposta la stanza iniziale
	 * 
	 * @param stanzaIniziale la stanza iniziale
	 */
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.c.setStanzaIniziale(stanzaIniziale);
	}
	
	/**
	 * Meotodo che imposta la stanza vincente
	 * 
	 * @param stanzaVincente la stanza vincente
	 */
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.c.setStanzaVincente(stanzaVincente);
	}
	
	/**
	 * Metodo che restistuisce la partita corrente
	 * 
	 * @return la partita corrente
	 */
	public Partita getPartita(){
		return this.c.getPartita();
	}
}
