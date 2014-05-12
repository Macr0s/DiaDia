package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

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
	public boolean esegui() {
		if(this.direzione==null)
			 System.out.println("Dove vuoi andare ?");
		 Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
		 if (prossimaStanza == null)
			 System.out.println("Direzione inesistente");
		 else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.partita.decrementaCFU();
		 }
		 System.out.println(partita.getStanzaCorrente().getDescrizione());
		 return true;
	}

}
