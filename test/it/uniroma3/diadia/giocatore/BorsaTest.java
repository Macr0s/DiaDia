package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	/**
	 * Controlla se il metodo contenuto per peso funziona correttamente
	 */
	@Test
	public void testGetContentutoPerPeso(){
		this.borsa.addAttrezzo(new Attrezzo("blocco di rame",4));
		this.borsa.addAttrezzo(new Attrezzo("redstone",1));
		this.borsa.addAttrezzo(new Attrezzo("blocco d'oro",3));
		List<Attrezzo> confronto = new ArrayList<>();
		confronto.add(new Attrezzo("redstone", 1));
		confronto.add(new Attrezzo("blocco d'oro",3));
		confronto.add(new Attrezzo("blocco di rame",4));
		assertEquals(this.borsa.toString(), confronto, this.borsa.getContentutoPerPeso());
	}
	
	/**
	 * Controlla se il metodo contenuto per nome funziona correttamente
	 */
	@Test
	public void testGetContentutoPerNome(){
		this.borsa.addAttrezzo(new Attrezzo("blocco di rame",4));
		this.borsa.addAttrezzo(new Attrezzo("redstone",1));
		this.borsa.addAttrezzo(new Attrezzo("blocco d'oro",3));
		List<Attrezzo> confronto = new ArrayList<>();
		confronto.add(new Attrezzo("blocco d'oro",3));
		confronto.add(new Attrezzo("blocco di rame",4));
		confronto.add(new Attrezzo("redstone", 1));
		assertEquals(this.borsa.toString(), confronto, this.borsa.getContentutoPerNome());
	}
	
	/**
	 * Controlla se il metodo contenuto raggruppato per peso funziona correttamente
	 */
	@Test
	public void testGetContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> confronto = new HashMap<>();
		Set<Attrezzo> peso1 = new HashSet<>();
		Set<Attrezzo> peso2 = new HashSet<>();
		
		confronto.put(new Integer(1), peso1);
		confronto.put(new Integer(2), peso2);
		
		peso1.add(new Attrezzo("cavolo", 1));
		peso1.add(new Attrezzo("cavolo", 1));
		
		peso2.add(new Attrezzo("sasso", 2));
		peso2.add(new Attrezzo("mattone", 2));
		
		this.borsa.addAttrezzo(new Attrezzo("cavolo", 1));
		this.borsa.addAttrezzo(new Attrezzo("cavolo", 1));
		this.borsa.addAttrezzo(new Attrezzo("sasso", 2));
		this.borsa.addAttrezzo(new Attrezzo("mattone", 2));
		
		assertEquals(this.borsa.toString(), confronto, this.borsa.getContenutoRaggruppatoPerPeso());
	}
}
