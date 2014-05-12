package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.ambienti.*;

/**
 * Questa classe gestisce il comando prendi dell'utente, cioè viene preso 
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
public class ComandoPrendi implements Comando {
	private Partita partita;
	private String nomeAttrezzo;

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
			System.out.println("Quale attrezzo vuoi prendere?");
			return true;
		}
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (attrezzo == null){
			System.out.println("Attezzo non presente nella stanza");
			return true;
		}
		
		if (this.partita.getGiocatore().getEquipaggiato() == null){
			this.partita.getGiocatore().setEquipaggiato(attrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			System.out.println("Attrezzo equipaggiato");
		}else if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)){
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			System.out.println("Attrezzo messo in borsa");
		}else{
			System.out.println("Borsa piena");
		}
		return true;
	}

}
