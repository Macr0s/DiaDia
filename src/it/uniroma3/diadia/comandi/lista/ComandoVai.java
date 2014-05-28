package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;

/**
 * Questa classe implementa il comando vai
 * 
 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
 * e ne stampa il nome, altrimenti stampa un messaggio di errore
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 * @see Stanza
 *
 */
public class ComandoVai implements Comando{
	String direzione;
	Partita partita;

	@Override
	public void setPartita(Partita p) {
		this.partita = p;
	}

	@Override
	public void setParamentro(String params) {
		this.direzione = params;
	}

	@Override
	public String esegui() {
		if(this.direzione==null)
			 return "Dove vuoi andare ?";
		 Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		 if (prossimaStanza == null)
			 return "Direzione inesistente";
		 else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.partita.decrementaCFU();
		 }
		 return partita.getStanzaCorrente().getDescrizione();
	}

}
