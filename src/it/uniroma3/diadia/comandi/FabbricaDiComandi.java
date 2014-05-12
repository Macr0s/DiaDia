package it.uniroma3.diadia.comandi;

/**
 * Questa interfaccia uniforma tutte le fabbriche dei comandi
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Comando
 *
 */
public interface FabbricaDiComandi extends Comando{
	
	/**
	 * Questo prototipo implementa il fatto di processare una istruzione
	 * 
	 * @param istruzione l'istruzione da processare
	 */
	public void setIstruzione(String istruzione);
	
	/**
	 * Questo prototipo implementa il fatto di poter impostare il comando
	 * 
	 * @param nome il comando
	 */
	public void setComando(String nome);
}
