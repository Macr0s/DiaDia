package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe gestisce il comando posa dell'utente, cioè posa un oggetto dalla borsa 
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
	public boolean esegui() {
		if (this.nomeAttrezzo == null){
			System.out.println("Quale attrezzo vuoi posare?");
			return true;
		}
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
		if (attrezzo == null){
			System.out.println("Oggetto non trovato in borsa");
			return true;
		}
		
		if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)){
			System.out.println("Attrezzo aggiunto alla stanza");
		}else{
			System.out.println("Capienza della stanza raggiunta");
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		}
		return true;
	}

}
