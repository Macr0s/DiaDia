package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;

/**
 * Questa classe gestisce il comando posa dell'utente, cio� posa un oggetto dalla borsa 
 * e lo aggiunge alla stanza
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Attrezzo
 * @see Giocatore
 *
 */
public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	private Partita partita;
	
	@Override
	public void setPartita(Partita p) {
		this.partita = p;
	}

	@Override
	public void setParamentro(String params) {
		this.nomeAttrezzo = params;
	}

	@Override
	public String esegui() {
		if (this.nomeAttrezzo == null){
			return "Quale attrezzo vuoi posare?";
		}
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
		if (attrezzo == null){
			return "Oggetto non trovato in borsa";
		}
		
		if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)){
			return "Attrezzo aggiunto alla stanza";
		}else{
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			return "Capienza della stanza raggiunta";			
		}
	}

}
