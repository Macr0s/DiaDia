package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe implementa il fatto che il comando sia sconosciuto
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 *
 */
public class ComandoSconosciuto implements Comando {

	@Override
	public void setPartita(Partita p) {
		
	}

	@Override
	public void setParamentro(String params) {
		
	}

	@Override
	public String esegui() {
		return "Comando sconosciuto";
	}

}
