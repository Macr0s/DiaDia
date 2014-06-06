package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private String cibo;
	private Attrezzo regalo;
	private boolean ricevutoRegalo = false;
	
	public Cane(String nome, String presentaz, String cibo, Attrezzo regalo) {
		super(nome, presentaz);
		this.cibo = cibo;
		this.regalo = regalo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.decrementaCFU();
		return "Aiah il cane mi ha morso :( Nota personale: Non toccatre il cane che morde";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome().equals(this.cibo) && !this.ricevutoRegalo){
			partita.getStanzaCorrente().addAttrezzo(this.regalo);
			this.ricevutoRegalo = true;
			return "Il cane apprezza il cibo e ti fa un regalo... Guarda in terra";
		}else{
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return "Il cane rifiuta il mio regalo e lo lascia in terra";
		}
		
	}

}
