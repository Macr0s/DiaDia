package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * Questa classe di test verifica il corretto funzionamento
 * della classe StanzaBloccata
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class StanzaBloccataTest {
	
	private StanzaBloccata bloccata;
	private Stanza stanza;
	private Attrezzo chiave;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.bloccata = new StanzaBloccata("bagno", "est", "chiave");
		this.bloccata.setPartita(this.partita);
		this.stanza = new Stanza("stanza");
		this.bloccata.impostaStanzaAdiacente("est", this.stanza);
		this.chiave = new Attrezzo("chiave", 1);
	}
	
	/**
	 * Questa classe verifica il corretto funzionamento
	 * del metodo getStanzaAdiacente nel caso che nella
	 * stanza non c'è l'oggetto chiave
	 */
	@Test
	public void testDirezioneBloccata_StanzaAdiacente() {
		assertEquals(this.bloccata.toString(), this.bloccata.toString(),this.bloccata.getStanzaAdiacente("est").toString());
	}
	
	/**
	 * Questa classe verifica il corretto funzionamento
	 * del metodo getStanzaAdiacente nel caso che nella
	 * stanza c'è l'oggetto chiave
	 */
	@Test
	public void testDirezioneBloccataAttrezzo_StanzaAdiacente() {
		this.bloccata.addAttrezzo(this.chiave);
		assertEquals(this.bloccata.toString(), this.stanza.toString(), this.bloccata.getStanzaAdiacente("est").toString());
	}
	
	/**
	 * Questa classe verifica il corretto funzionamento
	 * del metodo getDescrizione nel caso che nella
	 * stanza non c'è l'oggetto chiave
	 */
	@Test
	public void testDirezioneBloccata_Descrizione() {
		assertEquals(this.bloccata.toString(),"Qui qualcosa non va, le porte non sono porte" , this.bloccata.getDescrizione());
	}
	
	/**
	 * Questa classe verifica il corretto funzionamento
	 * del metodo getDescrizione nel caso che nella
	 * stanza c'è l'oggetto chiave
	 */
	@Test
	public void testDirezioneBloccataAttrezzo_Descrizione() {
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.chiave);
		assertEquals(this.bloccata.toString(), "bagno\nUscite:  est\nAttrezzi nella stanza: ", this.bloccata.getDescrizione());
	}

}
