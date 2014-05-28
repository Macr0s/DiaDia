package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;

public class ComandoUsa extends AbstractComando {

	@Override
	public String esegui() {
		if(super.getPartita().getGiocatore().getEquipaggiato()!=null){
			return super.getPartita().getGiocatore().getEquipaggiato().usa(super.getParametro(), super.getPartita());
		}
		return "Non ha nessun attrezzo equipaggiato";
	}

}
