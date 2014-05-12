package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
/**
 * Quesa classe implementa il comando Aiuo
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 * @see Partita
 *
 */
public class ComandoAiuto implements Comando{
	
	@Override
	public void setPartita(Partita p) {
		
	}

	@Override
	public boolean esegui() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();	
		return true;
	}

	@Override
	public void setParamentro(String params) {
		
	}
}
