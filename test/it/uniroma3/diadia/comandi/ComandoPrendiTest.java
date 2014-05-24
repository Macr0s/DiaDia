package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Classe per eseguire i test sul comando Prendi
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Partita
 * @see Comando
 * @see Attrezzo
 * @see Giocatore
 * @see ComandoPrendi
 *
 */
public class ComandoPrendiTest {
	private Partita partita;
	private Comando comandoPrendi;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setPartita(this.partita);
		this.comandoPrendi.setParamentro("osso");
	}

	@Test
	public void testEsegui() {
		this.comandoPrendi.esegui();
		assertTrue(this.partita.toString(),this.partita.getGiocatore().getEquipaggiato().getNome().equals("osso"));
	}

}
