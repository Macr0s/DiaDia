package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.attrezzi.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Test della classe Giocatore
 * 
 * @author Matteo Filippi, Andrea Salvoni
 *
 */
public class GiocatoreTest {

	private Giocatore giocatore;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore("Mario", "Biondi", 20, this.attrezzo);
		this.attrezzo = new Attrezzo("Penna", 1);
	}

	/**
	 *  Controlla se il metodo restituisce effettivamente l'oggetto desiderato
	 */
	@Test
	public void testGetBorsa() {
		assertEquals(this.giocatore.getBorsa().toString() , new Borsa(), this.giocatore.getBorsa());
	}

	/**
	 *  Controlla se il metodo restituisce l'oggetto desiderato, il fallimento di questo test implica l'inaffidabilità
	 *  del risultato del metodo testSetEquipaggiato
	 */
	@Test
	public void testGetEquipaggiato() {
		assertEquals(this.attrezzo, this.giocatore.getEquipaggiato());
	}
	
	/**
	 *  Controlla se il metodo salva correttamente l'attrezzo dentro l'oggetto Giocatore
	 */
	@Test
	public void testSetEquipaggiato() {
		Attrezzo nuovoAttrezzo = new Attrezzo("palla", 2);
		this.giocatore.setEquipaggiato(nuovoAttrezzo);
		assertEquals(this.attrezzo, this.giocatore.getEquipaggiato());
	}

}
