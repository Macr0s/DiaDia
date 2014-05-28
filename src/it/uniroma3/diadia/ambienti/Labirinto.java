package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Questa classe inizializza il labirinto e memorizza 
 * la stanza iniziale e la stanza vincente
 * 
 * @author  Matteo Filippi, Andrea Salvoni (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @version 0.2
 */
public class Labirinto {
	
	private Stanza iniziale;
	private Stanza vincente;
	private Partita partita;
	private final String MESSAGGIO_BENVENUTO = 
				"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	public Labirinto(Partita partita){
		this.partita = partita;
		this.creaStanze();
	}
	
    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo passepartout = new Attrezzo("passepartout",1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new StanzaBuia("Atrio");
		atrio.setPartita(this.partita);
		Stanza aulaN11 = new StanzaMagica("Aula N11", 1);
		aulaN11.setPartita(this.partita);
		Stanza aulaN10 = new Stanza("Aula N10");
		aulaN10.setPartita(this.partita);
		Stanza laboratorio = new StanzaBloccata("Laboratorio Campus", "ovest", "passepartout");
		laboratorio.setPartita(this.partita);
		Stanza biblioteca = new Stanza("Biblioteca");
		biblioteca.setPartita(this.partita);
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		aulaN11.addAttrezzo(passepartout);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        this.iniziale = atrio;  
		this.vincente = biblioteca;
    }
    
    /**
     * Questo metodo serve per prendere la stanza iniziale
     * 
     * @return La stanza iniziale
     */
    public Stanza getIniziale() {
		return this.iniziale;
	}
    
    /**
     * Questo metodo serve per prendere la stenza vincente
     * 
     * @return La stanza vincente
     */
    public Stanza getVincente() {
		return this.vincente;
	}
    
    /**
     * Questo metodo restituisce il messaggio di benvenuto
     * 
     * @return Il messaggio di Benventuo
     */
    public String getMessaggioBenvenuto(){
    	return this.MESSAGGIO_BENVENUTO;
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
     * Metodo che imposta la partita corrente
     * 
     * @param partita la partita corrente
     */
    public void setPartita(Partita partita) {
		this.partita = partita;
	}
}
