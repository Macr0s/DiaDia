package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * Test della classe Stanza
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */

public class StanzaTest {
	private Stanza stanza;
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.stanza = new Stanza("N16");
		this.attrezzo = new Attrezzo("zaino", 1);
	}

	/**
	 *  Controlla se l'attrezzo è stato aggiunto, e lo dimostra nel messaggio allegato al metodo
	 */
	@Test
	public void testAddAttrezzo() {
		assertTrue(this.stanza.toString(), this.stanza.addAttrezzo(this.attrezzo));
	}

	/**
	 *  Controlla se il toString stampa in modo corretto
	 */
	@Test
	public void testToString() {
		assertEquals(this.stanza.toString(), "N16\nUscite: \nAttrezzi nella stanza: ", this.stanza.toString());
	}
	
	/**
	 *  Controlla se l'attrezzo aggiunto è stato rimosso correttamente, e lo dimostra nel messaggio allegato al metodo
	 */
	@Test
	public void testRemoveAttrezzo() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertTrue(this.stanza.removeAttrezzo(this.attrezzo));
	}

}
