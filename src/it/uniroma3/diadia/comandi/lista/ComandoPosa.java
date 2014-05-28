package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.AbstractComando;
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
public class ComandoPosa extends AbstractComando {

	@Override
	public String esegui() {
		if (this.getParametro() == null){
			return "Quale attrezzo vuoi posare?";
		}
		Attrezzo attrezzo = super.getPartita().getGiocatore().getBorsa().removeAttrezzo(super.getParametro());
		if (attrezzo == null){
			return "Oggetto non trovato in borsa";
		}
		
		if (super.getPartita().getStanzaCorrente().addAttrezzo(attrezzo)){
			return "Attrezzo aggiunto alla stanza";
		}else{
			super.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
			return "Capienza della stanza raggiunta";			
		}
	}

}
