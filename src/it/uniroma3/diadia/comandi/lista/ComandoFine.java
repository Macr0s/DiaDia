package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;

/**
 * Questa classe implementa il comando fine
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 *
 */
public class ComandoFine implements Comando {

	@Override
	public void setPartita(Partita p) {

	}

	@Override
	public void setParamentro(String params) {

	}

	@Override
	public String esegui() {
		return "Grazie di aver giocato!";
	}

}
