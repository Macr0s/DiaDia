package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando {
	private String messaggio;

	@Override
	public String esegui() {
		AbstractPersonaggio personaggio; 
		personaggio = super.getPartita().getStanzaCorrente().getPersonaggio(); 
		this.messaggio = personaggio.agisci(super.getPartita()); 
		return this.messaggio;
	}
	
	public String getMessaggio(){
		return this.messaggio;
	}
}
