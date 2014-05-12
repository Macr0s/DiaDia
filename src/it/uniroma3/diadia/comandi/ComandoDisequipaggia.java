package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
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
	public boolean esegui() {
		if (this.partita.getGiocatore().getEquipaggiato() != null){
			if (this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getGiocatore().getEquipaggiato())){
				this.partita.getGiocatore().setEquipaggiato(null);
				System.out.println("Oggetto riposto in borsa");
			}else{
				System.out.println("Borsa Piena");
			}
		}else{
			System.out.println("Non hai niente in mano");
		}
		return true;
	}

}
