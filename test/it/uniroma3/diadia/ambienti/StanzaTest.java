package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		this.stanza = new Stanza("N16");
		this.attrezzo = new Attrezzo("zaino", 1);
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(this.stanza.toString(), this.stanza.addAttrezzo(this.attrezzo));
	}

	@Test
	public void testToString() {
		assertEquals(this.stanza.toString(), "N16\nUscite: \nAttrezzi nella stanza: ", this.stanza.toString());
	}

	@Test
	public void testRemoveAttrezzo() {
		this.stanza.addAttrezzo(this.attrezzo);
		assertTrue(this.stanza.removeAttrezzo(this.attrezzo));
	}

}
