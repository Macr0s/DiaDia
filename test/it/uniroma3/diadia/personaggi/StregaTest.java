package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StregaTest {
	private Partita partita;
	private Attrezzo clava;
	private Strega morgana;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.clava = new Attrezzo("clava", 4);
		this.morgana = new Strega("morgana","la strega che trololollola");
	}

	@Test
	public void testAgisci() {
		assertEquals(this.partita.toString(), "Atrio", this.partita.getStanzaCorrente().getNome());
		this.morgana.agisci(this.partita);
		assertEquals(this.partita.toString(), "Biblioteca", this.partita.getStanzaCorrente().getNome());
		
	}
	@Test
	public void testAgisci_Saluta() {
		this.morgana.saluta();
		assertEquals(this.partita.toString(), "Atrio", this.partita.getStanzaCorrente().getNome());
		this.morgana.agisci(this.partita);
		assertEquals(this.partita.toString(), "N10", this.partita.getStanzaCorrente().getNome());
		
	}

	@Test
	public void testRiceviRegalo() {
		this.partita.getStanzaCorrente().setPersionaggio(this.morgana);
		this.morgana.riceviRegalo(this.clava, this.partita);
		assertNull(this.partita.toString(), this.partita.getStanzaCorrente().getPersonaggio());
	}
}
