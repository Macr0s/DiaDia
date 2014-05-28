package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe igestisce il comando disequipaggia dell'utente, cioè posa l'oggetto 
 * equipaggiato nella borsa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Giocatore
 *
 */
public class ComandoDisequipaggia extends AbstractComando {
	@Override
	public String esegui() {
		if (super.getPartita().getGiocatore().getEquipaggiato() != null){
			if (super.getPartita().getGiocatore().getBorsa().addAttrezzo(super.getPartita().getGiocatore().getEquipaggiato())){
				super.getPartita().getGiocatore().setEquipaggiato(null);
				return "Oggetto riposto in borsa";
			}else{
				return "Borsa Piena";
			}
		}else{
			return "Non hai niente in mano";
		}
	}

}
