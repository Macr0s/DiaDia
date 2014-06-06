package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.lista.ComandoVai;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	private Partita partita;
	private Comando comandoVai;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comandoVai = new ComandoVai();
		this.comandoVai.setParamentro("ovest");
		this.comandoVai.setPartita(this.partita);
	}

	@Test
	public void testEsegui_ConDirezione() {
		assertEquals(this.partita.toString(), "Atrio", this.partita.getStanzaCorrente().getNome());
		this.comandoVai.esegui();
		assertEquals(this.partita.toString(), "Campus", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEsegui_SenzaDirezione() {
		assertEquals(this.partita.toString(), "Atrio", this.partita.getStanzaCorrente().getNome());
		this.comandoVai.esegui();
		this.comandoVai.setParamentro("nord");
		this.comandoVai.esegui();
		assertEquals(this.partita.toString(), "Campus", this.partita.getStanzaCorrente().getNome());
	}

}
