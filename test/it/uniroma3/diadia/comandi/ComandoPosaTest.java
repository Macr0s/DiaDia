package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe di test per il comando Posa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Partita
 * @see Comando
 * @see Attrezzo
 * @see ComandoPosa
 *
 */
public class ComandoPosaTest {
	private Partita partita;
	private Attrezzo clava;
	private Comando comandoPosa;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.clava = new Attrezzo("clava", 2);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.clava);
		this.comandoPosa = new ComandoPosa();
		this.comandoPosa.setParamentro("clava");
		this.comandoPosa.setPartita(this.partita);
	}

	@Test
	public void testEsegui() {
		this.comandoPosa.esegui();
		assertTrue(this.partita.toString(), this.partita.getStanzaCorrente().hasAttrezzo("clava"));
	}

}
