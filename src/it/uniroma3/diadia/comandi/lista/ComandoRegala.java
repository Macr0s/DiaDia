package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;

public class ComandoRegala implements Comando {
	private Partita partita;
	private String paramentro;

	@Override
	public void setPartita(Partita p) {
		this.partita = p;
	}

	@Override
	public void setParamentro(String params) {
		this.paramentro = params;
	}
	
	@Override
	public String esegui() {
		if (this.partita.getStanzaCorrente().getPersonaggio() == null){
			return "Non ci sono personaggi nella stanza";
		}else if (this.partita.getGiocatore().getBorsa().hasAttrezzo(this.paramentro)){
			return this.partita.getStanzaCorrente().getPersonaggio().riceviRegalo(this.partita.getGiocatore().getBorsa().getAttrezzo(this.paramentro), this.partita);
		}else if (this.partita.getGiocatore().getEquipaggiato() != null && this.partita.getGiocatore().getEquipaggiato().getNome().equals(this.paramentro)){
			return this.partita.getStanzaCorrente().getPersonaggio().riceviRegalo(this.partita.getGiocatore().getEquipaggiato(), this.partita);
		}else{
			return "Attrezzo non trovato";
		}
	}

}
