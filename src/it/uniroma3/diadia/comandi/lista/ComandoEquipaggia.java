package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe gestisce il comando equipaggia dell'utente, cioè prende un oggetto dalla 
 * borsa e lo equipaggia effettuando uno scambio se già è stato equipaggiato qualcosa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Attrezzo
 * @see Giocatore
 *
 */
public class ComandoEquipaggia extends AbstractComando {

	@Override
	public String esegui() {
		if (super.getParametro() == null){
			return "Quale attrezzo vuoi equipaggiare?";
		}
		Attrezzo attrezzo = super.getPartita().getGiocatore().getBorsa().removeAttrezzo(super.getParametro());
		if (attrezzo != null){
			if (super.getPartita().getGiocatore().getEquipaggiato() != null &&
					!super.getPartita().getGiocatore().getBorsa().addAttrezzo(super.getPartita().getGiocatore().getEquipaggiato())){
				super.getPartita().getGiocatore().getBorsa().addAttrezzo(attrezzo);
				return "Attrzzo non equipaggiato perchè l'attrezzo equipaggiato non entra in borsa";
			}else{
				super.getPartita().getGiocatore().setEquipaggiato(attrezzo);
				return "Oggetto equipaggiato";
			}
		}else{
			return "Oggetto non trovato in borsa";
		}
	}

}
