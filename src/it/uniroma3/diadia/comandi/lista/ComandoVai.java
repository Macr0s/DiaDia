package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.AbstractComando;
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
public class ComandoVai extends AbstractComando{

	@Override
	public String esegui() {
		if(super.getParametro()==null)
			 return "Dove vuoi andare ?";
		 Stanza prossimaStanza = super.getPartita().getStanzaCorrente().getStanzaAdiacente(super.getParametro());
		 if (prossimaStanza == null)
			 return "Direzione inesistente";
		 else {
			super.getPartita().setStanzaCorrente(prossimaStanza);
			super.getPartita().decrementaCFU();
		 }
		 return super.getPartita().getStanzaCorrente().getDescrizione();
	}

}
