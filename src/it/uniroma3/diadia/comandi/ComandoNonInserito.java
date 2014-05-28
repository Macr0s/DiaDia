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
public class ComandoNonInserito extends AbstractComando {

	@Override
	public String esegui() {
		return "Comando non inserito";
	}

}
