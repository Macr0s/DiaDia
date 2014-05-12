package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * Questa classe di test verifica il funzionaemnto
 * della classe StanzaMagica
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class StanzaMagicaTest {
	private Stanza magica;
	private Attrezzo penna;
	private Attrezzo pennaTrasformato;

	@Before
	public void setUp() throws Exception {
		this.magica = new StanzaMagica("magica", 0);
		this.penna = new Attrezzo("penna",1);
		this.pennaTrasformato = new Attrezzo("annep", 2);
		
	}
	
	/**
	 * Questo test verifica il corretto funzionamento
	 * della StanzaMagica
	 */
	@Test
	public void testAttrezzoTrasformato() {
		assertTrue(this.magica.toString(), this.magica.addAttrezzo(this.penna));
		assertEquals(this.penna.toString(), this.penna, this.magica.getAttrezzo("penna"));
		assertTrue(this.magica.toString(), this.magica.removeAttrezzo(this.penna));
		assertTrue(this.magica.toString(), this.magica.addAttrezzo(this.penna));
		assertEquals(this.penna.toString(), this.pennaTrasformato, this.magica.getAttrezzo("annep"));
	}

}
