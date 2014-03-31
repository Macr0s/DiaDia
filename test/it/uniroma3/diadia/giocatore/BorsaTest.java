package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Test della classe Borsa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class BorsaTest {

	private Borsa borsa;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.attrezzo = new Attrezzo("Penna", 1);
	}

	/**
	 *  Controlla se aggiunge correttamente l'attrezzo
	 */
	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.toString(), this.borsa.addAttrezzo(this.attrezzo));
	}

	/**
	 *  Controlla se il peso massimo della Borsa è quello corretto
	 */
	@Test
	public void testGetPesoMax() {
		assertEquals(10, this.borsa.getPesoMax());
	}

	/**
	 *  Controlla se la borsa conteggia il peso al suo interno correttamente
	 */
	@Test
	public void testGetPeso() {
		this.borsa.addAttrezzo(this.attrezzo);
		this.borsa.addAttrezzo(this.attrezzo);
		assertEquals(2,this.borsa.getPeso());
	}

}
