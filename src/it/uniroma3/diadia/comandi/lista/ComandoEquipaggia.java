package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.giocatore.*;

/**
 * Questa classe gestisce il comando equipaggia dell'utente, cio� prende un oggetto dalla 
 * borsa e lo equipaggia effettuando uno scambio se gi� � stato equipaggiato qualcosa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Attrezzo
 * @see Giocatore
 *
 */
public class ComandoEquipaggia implements Comando {
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
	public String esegui() {
		if (this.nomeAttrezzo == null){
			return "Quale attrezzo vuoi equipaggiare?";
		}
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
		if (attrezzo != null){
			if (this.partita.getGiocatore().getEquipaggiato() != null &&
					!this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getGiocatore().getEquipaggiato())){
				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				return "Attrzzo non equipaggiato perch� l'attrezzo equipaggiato non entra in borsa";
			}else{
				this.partita.getGiocatore().setEquipaggiato(attrezzo);
				return "Oggetto equipaggiato";
			}
		}else{
			return "Oggetto non trovato in borsa";
		}
	}

}
