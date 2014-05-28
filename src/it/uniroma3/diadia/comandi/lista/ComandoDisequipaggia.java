package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe igestisce il comando disequipaggia dell'utente, cio� posa l'oggetto 
 * equipaggiato nella borsa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Giocatore
 *
 */
public class ComandoDisequipaggia implements Comando {
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
		if (this.partita.getGiocatore().getEquipaggiato() != null){
			if (this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getGiocatore().getEquipaggiato())){
				this.partita.getGiocatore().setEquipaggiato(null);
				return "Oggetto riposto in borsa";
			}else{
				return "Borsa Piena";
			}
		}else{
			return "Non hai niente in mano";
		}
	}

}
