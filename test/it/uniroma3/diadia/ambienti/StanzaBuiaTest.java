package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * Questa classe verifica il corretto funzionamento
 * della classe StanzaBuia
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class StanzaBuiaTest {
	private Stanza segrete;
	private Attrezzo lanterna;

	@Before
	public void setUp() throws Exception {
		this.segrete = new StanzaBuia("segrete", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 1);
	}
	
	/**
	 * Questo test verifica il corretto funzionamento
	 * del metodo getDescrizione quando nella stanza
	 * non c'è l'oggetto lanterna
	 */
	@Test
	public void testBuiaDescrizione() {
		assertEquals(this.segrete.toString(), "Qui c'è un buio pesto", this.segrete.getDescrizione());
	}
	
	/**
	 * Questo test verifica il corretto funzionamento
	 * del metodo getDescrizione quando nella stanza
	 * c'è l'oggetto lanterna
	 */
	@Test
	public void testBuiaAttrezzoDescrizione() {
		this.segrete.addAttrezzo(this.lanterna);
		assertEquals(this.segrete.toString(), "segrete\nUscite: \nAttrezzi nella stanza: lanterna (1kg) ", this.segrete.getDescrizione());
	}

}
