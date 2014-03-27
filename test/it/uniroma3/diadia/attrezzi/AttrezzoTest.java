package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AttrezzoTest {
	private Attrezzo attrezzo;

	@Before
	public void setUp() throws Exception {
		this.attrezzo = new Attrezzo("Penna", 1);
	}

	@Test
	public void testGetNome() {
		assertEquals(this.attrezzo.toString(), "Penna", this.attrezzo.getNome());
	}

	@Test
	public void testGetPeso() {
		assertEquals(this.attrezzo.toString(), 1, this.attrezzo.getPeso());
	}

	@Test
	public void testToString() {
		assertEquals(this.attrezzo.toString(), "Penna (1kg)", this.attrezzo.toString());
	}

}
