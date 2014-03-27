package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {
	private Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}

	@Test
	public void testIsFinita() {
		assertFalse(this.partita.getStanzaCorrente().toString(),this.partita.isFinita());
	}

	@Test
	public void testGetCFU() {
		assertEquals(this.partita.toString(), 20, this.partita.getCFU());
	}

	@Test
	public void testDecrementaCFU() {
		this.partita.decrementaCFU();
		assertEquals(this.partita.toString(), 19, this.partita.getCFU());
	}
	
	@Test
	public void testToString(){
		assertEquals("Io sono Mario Biondi\nCFU: 20\nEquipaggiato: Niente\nBorsa vuota\n\nAtrio\nUscite:  nord est sud ovest\nAttrezzi nella stanza: osso (1kg) \n", this.partita.toString());
	}

}
