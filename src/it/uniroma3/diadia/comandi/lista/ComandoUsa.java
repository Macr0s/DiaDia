package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.comandi.AbstractComando;

public class ComandoUsa extends AbstractComando {

	@Override
	public String esegui() {
		if(super.getPartita().getGiocatore().getEquipaggiato()!=null){
			return super.getPartita().getGiocatore().getEquipaggiato().usa(super.getParametro(), super.getPartita());
		}
		return "Non ha nessun attrezzo equipaggiato";
	}

}
