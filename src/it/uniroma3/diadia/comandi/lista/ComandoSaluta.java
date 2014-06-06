package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

/**
 * Questa classe implemente il comando Saluta
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see AbstractComando
 * @see AbstractPersonaggoi
 * @version 0.3
 *
 */
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
