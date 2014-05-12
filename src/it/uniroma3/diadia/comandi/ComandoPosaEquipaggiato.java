package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

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
	public boolean esegui() {
		Attrezzo attrezzo = this.partita.getGiocatore().getEquipaggiato();
		if (attrezzo == null){
			System.out.println("Non hai niente in mano");
			return true;
		}
		
		if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)){
			System.out.println("Attrezzo aggiunto alla stanza");
			this.partita.getGiocatore().setEquipaggiato(null);
		}else{
			System.out.println("Capienza della stanza raggiunta");
		}
		return true;
	}

}
