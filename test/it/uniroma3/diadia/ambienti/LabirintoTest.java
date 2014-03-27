package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	private Labirinto labirinto;
	
	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
	}

	@Test
	public void testGetIniziale() {
		assertEquals("Atrio\nUscite:  nord est sud ovest\nAttrezzi nella stanza: osso (1kg) ", this.labirinto.getIniziale().toString());
	}

	@Test
	public void testGetVincente() {
		assertEquals("Biblioteca\nUscite:  sud\nAttrezzi nella stanza: ", this.labirinto.getVincente().toString());
	}

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
