package it.uniroma3.diadia.ambienti.parser;

import static org.junit.Assert.*;

import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {
	private Partita partita;
	private final String testCodificaSempliceFile = "Stanze: N10, Biblioteca\nInizio: N10\nVincente: Biblioteca";
	private final String testCodificaSempliceCommentiESpaziFile = "//Prova commento\n\nStanze: N10, Biblioteca\nInizio: N10\n\nVincente: Biblioteca\n";
	private final String testCodificaSempliceConErroriSintassiFile = "Stanze N10, Biblioteca\nInizio: N10\nVincente: Biblioteca";
	private final String testCodificaTipiDiStanzaFile = "//Definizione stanza\nStanze: N10, Biblioteca\nStanzaBloccate: Campus ovest passepartout\n"+
						"StanzaBuie: Atrio lanterna\nStanzaMagiche: N11 1\n//Definizioni condizioni di gioco\nInizio: Atrio";
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}

	@Test
	public void testCodificaSemplice() {
		try{
			CaricatoreLabirinto c = new CaricatoreLabirinto(this.partita, this.testCodificaSempliceFile);
			c.carica();
			assertNotNull(c.getStanzaIniziale());
			assertNotNull(c.getStanzaVincente());
			assertEquals(c.getStanzaIniziale().toString(),"N10", c.getStanzaIniziale().getNome());
			assertEquals(c.getStanzaVincente().toString(), "Biblioteca", c.getStanzaVincente().getNome());
		}catch(Exception ex){
			fail(ex.getStackTrace().toString());
		}
	}
	
	@Test
	public void testCodificaSempliceCommentiESpazi() {
		try{
			CaricatoreLabirinto c = new CaricatoreLabirinto(this.partita, this.testCodificaSempliceCommentiESpaziFile);
			c.carica();
			assertNotNull(c.getStanzaIniziale());
			assertNotNull(c.getStanzaVincente());
			assertEquals(c.getStanzaIniziale().toString(),"N10", c.getStanzaIniziale().getNome());
			assertEquals(c.getStanzaVincente().toString(), "Biblioteca", c.getStanzaVincente().getNome());
		}catch(Exception ex){
			fail(ex.getStackTrace().toString());
		}
	}

	@Test
	public void testCodificaSempliceConErroriSintassi() {
		try{
			CaricatoreLabirinto c = new CaricatoreLabirinto(this.partita, this.testCodificaSempliceConErroriSintassiFile);
			c.carica();
			fail("Decodificato con successo anche in presenza di errori");
		}catch(Exception ex){
			assertTrue(true);
		}
	}
	
	@Test
	public void testCodificaTipiDiStanza(){
		CaricatoreLabirinto c = new CaricatoreLabirinto(this.partita, this.testCodificaTipiDiStanzaFile);
		try {
			c.carica();
		} catch (FormatoFileNonValidoException e) {
			fail(e.getMessage());
		}
		Map<String, Stanza> listaStanze = c.getInsiemeStanza();
		assertNotNull(listaStanze.toString(), listaStanze.get("N10"));
		assertNotNull(listaStanze.toString(), listaStanze.get("Biblioteca"));
		assertNotNull(listaStanze.toString(), listaStanze.get("Campus"));
		assertNotNull(listaStanze.toString(), listaStanze.get("Atrio"));
		assertNotNull(listaStanze.toString(), listaStanze.get("N11"));
		
		assertEquals(listaStanze.toString(), "N10", listaStanze.get("N10").getNome());
		assertEquals(listaStanze.toString(), "Biblioteca", listaStanze.get("Biblioteca").getNome());
		assertEquals(listaStanze.toString(), "Campus", listaStanze.get("Campus").getNome());
		assertEquals(listaStanze.toString(), "Atrio", listaStanze.get("Atrio").getNome());
		assertEquals(listaStanze.toString(), "N11", listaStanze.get("N11").getNome());
	}
}
