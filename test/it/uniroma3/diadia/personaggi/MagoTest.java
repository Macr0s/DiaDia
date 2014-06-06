package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class MagoTest {
	private Partita partita;
	private Mago mago;
	private Attrezzo regalo;
	private Attrezzo ascia;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.ascia = new Attrezzo("Ascia del guerriero", 10);
		this.regalo = new Attrezzo("clava", 2);
		this.mago = new Mago("Mago", "Merlino", this.regalo);
	}

	@Test
	public void testAgisci() {
		assertFalse(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo("clava"));
		
		assertEquals(this.partita.toString(), "Sei un vero simpaticone, " + 
				"con una mia magica azione, troverai un nuovo oggetto " + 
				"per il tuo bel borsone!", this.mago.agisci(this.partita));
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo("clava"));
		
		assertEquals(this.partita.toString(), "Mi spiace, ma non ho piu' nulla...", this.mago.agisci(this.partita));
	}

	@Test
	public void testRiceviRegalo() {
		assertEquals(this.partita.toString(), "La magia è fatta", this.mago.riceviRegalo(this.ascia, this.partita));
		
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo("Ascia del guerriero"));
		assertEquals(this.partita.toString(), 5, this.partita.getStanzaCorrente().getAttrezzo("Ascia del guerriero").getPeso());
	}

}
