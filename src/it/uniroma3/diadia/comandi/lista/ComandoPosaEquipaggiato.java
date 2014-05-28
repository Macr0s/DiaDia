package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;

/**
 * Questa classe gestisce il comando posaEquipaggiato, cioè posa l'attrezzo equipaggiato 
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
public class ComandoPosaEquipaggiato extends AbstractComando {

	@Override
	public String esegui() {
		Attrezzo attrezzo = super.getPartita().getGiocatore().getEquipaggiato();
		if (attrezzo == null){
			return "Non hai niente in mano";
		}
		
		if (super.getPartita().getStanzaCorrente().addAttrezzo(attrezzo)){
			super.getPartita().getGiocatore().setEquipaggiato(null);
			return "Attrezzo aggiunto alla stanza";
		}else{
			return "Capienza della stanza raggiunta";
		}
	}

}
