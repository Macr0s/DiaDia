package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Test della classe labirinto
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class LabirintoTest {
	private Labirinto labirinto;
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.labirinto = this.partita.getLabirinto();
	}
	
	/**
	 *  Test eseguito sulla stanza iniziale, controlla che sia effettivamente l'Atrio
	 */
	@Test
	public void testGetIniziale() {
		assertEquals("Qui c'è un buio pesto", this.labirinto.getIniziale().toString());
	}
	
	/**
	 * Test eseguito sulla stanza vincente, controlla se è effettivamente la Biblioteca
	 */
	@Test
	public void testGetVincente() {
		assertEquals("Biblioteca\nUscite:  sud\nAttrezzi nella stanza: ", this.labirinto.getVincente().toString());
	}

	/**
	 *  Controlla se il metodo getMessaggioBenvenuto restituisce effettivamente il messaggio corretto
	 */
	@Test
	public void testGetMessaggioBenvenuto() {
		assertEquals("Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
				"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
				"I locali sono popolati da strani personaggi, " +
				"alcuni amici, altri... chissa!\n"+
				"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
				"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
				"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
				"Per conoscere le istruzioni usa il comando 'aiuto'.", this.labirinto.getMessaggioBenvenuto());
	}

}
