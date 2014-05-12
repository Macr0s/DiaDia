package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe implmenenta il comando info
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 *
 */
public class ComandoInfo implements Comando {
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
		System.out.println(this.partita.toString());
		return true;
	}

}
