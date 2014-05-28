package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.comandi.AbstractComando;

public class ComandoRegala extends AbstractComando {
	
	@Override
	public String esegui() {
		if (super.getPartita().getStanzaCorrente().getPersonaggio() == null){
			return "Non ci sono personaggi nella stanza";
		}else if (super.getPartita().getGiocatore().getBorsa().hasAttrezzo(super.getParametro())){
			return super.getPartita().getStanzaCorrente().getPersonaggio().riceviRegalo(super.getPartita().getGiocatore().getBorsa().getAttrezzo(super.getParametro()), super.getPartita());
		}else if (super.getPartita().getGiocatore().getEquipaggiato() != null && super.getPartita().getGiocatore().getEquipaggiato().getNome().equals(super.getParametro())){
			return super.getPartita().getStanzaCorrente().getPersonaggio().riceviRegalo(super.getPartita().getGiocatore().getEquipaggiato(), super.getPartita());
		}else{
			return "Attrezzo non trovato";
		}
	}

}
