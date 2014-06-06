package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.comandi.AbstractComando;

/**
 * Questa classe implementa il comando usa
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see AbstractComando
 * @version 0.3
 *
 */
public class ComandoUsa extends AbstractComando {

	@Override
	public String esegui() {
		if(super.getPartita().getGiocatore().getEquipaggiato()!=null){
			return super.getPartita().getGiocatore().getEquipaggiato().usa(super.getParametro(), super.getPartita());
		}
		return "Non ha nessun attrezzo equipaggiato";
	}

}
