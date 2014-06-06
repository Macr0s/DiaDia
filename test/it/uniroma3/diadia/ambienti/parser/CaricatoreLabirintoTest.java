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
	private final String testCodificaCollegamentiFile = "Stanze: N10, Biblioteca\nInizio: N10\nVincente: Biblioteca\nUscite: N10 nord Biblioteca, Biblioteca sud N10";
	
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
		Map<String, Stanza> mapStanze = c.getInsiemeStanza();
		assertNotNull(mapStanze.toString(), mapStanze.get("N10"));
		assertNotNull(mapStanze.toString(), mapStanze.get("Biblioteca"));
		assertNotNull(mapStanze.toString(), mapStanze.get("Campus"));
		assertNotNull(mapStanze.toString(), mapStanze.get("Atrio"));
		assertNotNull(mapStanze.toString(), mapStanze.get("N11"));
		
		assertEquals(mapStanze.toString(), "N10", mapStanze.get("N10").getNome());
		assertEquals(mapStanze.toString(), "Biblioteca", mapStanze.get("Biblioteca").getNome());
		assertEquals(mapStanze.toString(), "Campus", mapStanze.get("Campus").getNome());
		assertEquals(mapStanze.toString(), "Atrio", mapStanze.get("Atrio").getNome());
		assertEquals(mapStanze.toString(), "N11", mapStanze.get("N11").getNome());
	}
	
	 @Test
	 public void testCodificaCollegamenti(){
		 CaricatoreLabirinto c = new CaricatoreLabirinto(this.partita, this.testCodificaCollegamentiFile);
		 try{
			 c.carica();
		 }catch(Exception ex){
			fail(ex.getMessage());
		 }
		 
		 Map<String, Stanza> mapStanze = c.getInsiemeStanza();
		 
		 assertNotNull(mapStanze.toString(), mapStanze.get("N10"));
		 assertNotNull(mapStanze.toString(), mapStanze.get("Biblioteca"));
		 
		 assertNotNull(mapStanze.toString(), mapStanze.get("N10").getDirezioni());
		 assertNotNull(mapStanze.toString(), mapStanze.get("Biblioteca").getDirezioni());
		 
		 assertNotNull(mapStanze.toString(), mapStanze.get("N10").getStanzaAdiacente("nord"));
		 assertNotNull(mapStanze.toString(), mapStanze.get("Biblioteca").getStanzaAdiacente("sud"));
		 
		 assertEquals(mapStanze.toString(), "Biblioteca", mapStanze.get("N10").getStanzaAdiacente("nord").getNome());
		 assertEquals(mapStanze.toString(), "N10", mapStanze.get("Biblioteca").getStanzaAdiacente("sud").getNome());
	 }
	 
	 
}
