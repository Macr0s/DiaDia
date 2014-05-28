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
public class ComandoSconosciuto extends AbstractComando {

	@Override
	public String esegui() {
		return "Comando sconosciuto";
	}

}
