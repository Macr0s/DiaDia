package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {
	private String messaggio;

	@Override
	public String esegui() {
		AbstractPersonaggio personaggio; 
		personaggio = this.getPartita().getStanzaCorrente().getPersonaggio(); 
		this.messaggio = personaggio.saluta(); 
		return this.messaggio;
	}
	
	public String getMessaggio(){
		return this.messaggio;
	}
}
