package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta implements Comando {
	private Partita partita;
	private String parametro;
	private String messaggio;

	@Override
	public void setPartita(Partita p) {
		this.partita = p;
	}

	@Override
	public void setParamentro(String params) {
		this.parametro = params;
	}

	@Override
	public String esegui() {
		AbstractPersonaggio personaggio; 
		personaggio = partita.getStanzaCorrente().getPersonaggio(); 
		this.messaggio = personaggio.saluta(); 
		return this.messaggio;
	}
	
	public String getMessaggio(){
		return this.messaggio;
	}
	
	public String getParametro() {
		return parametro;
	}
	
	public Partita getPartita() {
		return partita;
	}

}
