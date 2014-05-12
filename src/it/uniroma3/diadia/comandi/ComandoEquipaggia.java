package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
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
	public boolean esegui() {
		if (this.nomeAttrezzo == null){
			System.out.println("Quale attrezzo vuoi equipaggiare?");
			return true;
		}
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo);
		if (attrezzo != null){
			if (this.partita.getGiocatore().getEquipaggiato() != null &&
					!this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getGiocatore().getEquipaggiato())){
				this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				System.out.println("Attrzzo non equipaggiato perchè l'attrezzo equipaggiato non entra in borsa");
			}else{
				this.partita.getGiocatore().setEquipaggiato(attrezzo);
				System.out.println("Oggetto equipaggiato");
			}
		}else{
			System.out.println("Oggetto non trovato in borsa");
		}
		return true;
	}

}
