package it.uniroma3.diadia.comandi.lista;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.Comando;
/**
 * Quesa classe implementa il comando Aiuo
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 *
 */
public class ComandoAiuto extends AbstractComando{

	@Override
	public String esegui() {
		StringBuilder s = new StringBuilder();
		for(int i=0; i< elencoComandi.length; i++) 
			s.append(elencoComandi[i]+" ");
		s.append("\n");	
		return s.toString();
	}
}
