package it.uniroma3.diadia.io;

/**
 * Questa interfaccia unifica tutta la gestione dell'I/O
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.3
 *
 */
public interface InterfacciaUtente {
	
	public void mostraMessaggio(String messaggio);
	
	public String prendiIstruzione();
	
}
