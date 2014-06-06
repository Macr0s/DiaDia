package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class CaneTest {
	private Cane cane;
	private Partita partita;
	private Attrezzo regalo;
	private Attrezzo pane;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.regalo = new Attrezzo("Sonno", 4);
		this.pane = new Attrezzo("pane", 5);
		this.cane = new Cane("Bracco", "Un cane tutto nero", "pane", this.regalo);
		this.partita.getStanzaCorrente().setPersionaggio(this.cane);
	}

	@Test
	public void testAgisci() {
		assertEquals(this.partita.toString(), 20, this.partita.getCFU());
		
		assertEquals(this.partita.toString(), "Aiah il cane mi ha morso :( Nota personale: Non toccatre il cane che morde", this.cane.agisci(this.partita));
		assertEquals(this.partita.toString(), 19, this.partita.getCFU());

		assertEquals(this.partita.toString(), "Aiah il cane mi ha morso :( Nota personale: Non toccatre il cane che morde", this.cane.agisci(this.partita));
		assertEquals(this.partita.toString(), 18, this.partita.getCFU());
	}

	@Test
	public void testRiceviRegalo_Correntto() {
		assertFalse(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.pane.getNome()));
		
		assertEquals(this.partita.toString(),"Il cane apprezza il cibo e ti fa un regalo... Guarda in terra", this.cane.riceviRegalo(this.pane, this.partita));
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));		
	}
	
	@Test
	public void testRiceviRegalo_Scorrentto() {
		assertEquals(this.partita.toString(),"Il cane rifiuta il mio regalo e lo lascia in terra", this.cane.riceviRegalo(this.regalo, this.partita));
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
	}
	
	@Test
	public void testRiceviRegalo_SecodoRegalo() {
		assertFalse(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.pane.getNome()));
		
		assertEquals(this.partita.toString(),"Il cane apprezza il cibo e ti fa un regalo... Guarda in terra", this.cane.riceviRegalo(this.pane, this.partita));
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.regalo.getNome()));
		
		this.partita.getStanzaCorrente().removeAttrezzo(this.pane);
		
		assertEquals(this.partita.toString(),"Il cane rifiuta il mio regalo e lo lascia in terra", this.cane.riceviRegalo(this.pane, this.partita));
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo(this.pane.getNome()));
	}
}
