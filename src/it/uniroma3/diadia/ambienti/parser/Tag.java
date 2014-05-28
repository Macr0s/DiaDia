package it.uniroma3.diadia.ambienti.parser;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

import java.util.Map;

public abstract class Tag {
	private CaricatoreLabirinto c;
	
	public abstract void elabora(String argomenti) throws FormatoFileNonValidoException;
	
	public void setInsiemi(CaricatoreLabirinto c){
		this.c = c;
	};
	
	public Map<String, Attrezzo> getInsiemeAttrezzo() {
		return this.c.getInsiemeAttrezzo();
	}
	
	public Map<String, AbstractPersonaggio> getInsiemePersonaggio() {
		return this.c.getInsiemePersonaggio();
	}
	 
	public Map<String, Stanza> getInsiemeStanza() {
		return this.c.getInsiemeStanza();
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.c.setStanzaIniziale(stanzaIniziale);
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.c.setStanzaVincente(stanzaVincente);
	}
	
	public Partita getPartita(){
		return this.c.getPartita();
	}
}
