package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.Comando;

/**
 * Questa classe gestisce il comando posaEquipaggiato, cio� posa l'attrezzo equipaggiato 
 * nella stanza
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Attrezzo
 * @see Stanza
 *
 */
public class ComandoPosaEquipaggiato implements Comando {
	private Partita partita;

	@Override
	public void setPartita(Partita p) {
		this.partita = p;
	}

	@Override
	public void setParamentro(String params) {
		
	}

	@Override
	public String esegui() {
		Attrezzo attrezzo = this.partita.getGiocatore().getEquipaggiato();
		if (attrezzo == null){
			return "Non hai niente in mano";
		}
		
		if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)){
			this.partita.getGiocatore().setEquipaggiato(null);
			return "Attrezzo aggiunto alla stanza";
		}else{
			return "Capienza della stanza raggiunta";
		}
	}

}
