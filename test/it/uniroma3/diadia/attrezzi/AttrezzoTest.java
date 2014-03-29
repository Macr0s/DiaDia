package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test della classe Attrezzo
 * 
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class AttrezzoTest {
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.attrezzo = new Attrezzo("Penna", 1);
	}

	/**
	 * Controlla se il metodo confronta correttamente i nomi
	 */
	@Test
	public void testGetNome() {
		assertEquals(this.attrezzo.toString(), "Penna", this.attrezzo.getNome());
	}

	/**
	 *  Controlla se il metodo confronta correttamente i pesi, e stampa i risultato
	 */
	@Test
	public void testGetPeso() {
		assertEquals(this.attrezzo.toString(), 1, this.attrezzo.getPeso());
	}

	/**
	 *  Controlla se il metodo toString funziona correttamente
	 */
	@Test
	public void testToString() {
		assertEquals(this.attrezzo.toString(), "Penna (1kg)", this.attrezzo.toString());
	}

}
