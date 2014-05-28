package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;

/**
 * Questa classe gestisce il comando prendi dell'utente, cio� viene preso 
 * un oggetto dalla stanza e se non hai qualcosa equipaggiato lo equipaggia direttamente 
 * oppure se hai qualcosa equipaggiato lo mette in borsa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Attrezzo
 * @see Stanza
 * @see Giocatore
 *
 */
public class ComandoPrendi extends AbstractComando {

	@Override
	public String esegui() {
		if (super.getParametro() == null){
			return "Quale attrezzo vuoi prendere?";
		}
		Attrezzo attrezzo = super.getPartita().getStanzaCorrente().getAttrezzo(super.getParametro());
		if (attrezzo == null){
			return "Attezzo non presente nella stanza";
		}
		
		if (super.getPartita().getGiocatore().getEquipaggiato() == null){
			super.getPartita().getGiocatore().setEquipaggiato(attrezzo);
			super.getPartita().getStanzaCorrente().removeAttrezzo(attrezzo);
			return "Attrezzo equipaggiato";
		}else if (super.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo)){
			super.getPartita().getStanzaCorrente().removeAttrezzo(attrezzo);
			return "Attrezzo messo in borsa";
		}else{
			return "Borsa piena";
		}
	}

}
