package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe implementa il comando non inserito
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 *
 */
public class ComandoNonInserito implements Comando {

	@Override
	public void setPartita(Partita p) {
		
	}

	@Override
	public void setParamentro(String params) {
		
	}

	@Override
	public boolean esegui() {
		System.out.println("Comando non inserito");
		return true;
	}

}
