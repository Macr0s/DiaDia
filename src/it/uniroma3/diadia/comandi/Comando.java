package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa interfaccia unifica tutti i comandi
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Partita
 * @see FabbricaDiComandi
 *
 */
public interface Comando {	
	
	/**
	 * Questa variabile gestisce l'elenco dei comandi
	 */
	public static String[] elencoComandi = {"vai", "aiuto", "fine", "info", "prendi", "posa", "equipaggia","posaEquipaggiato", "disequipaggia","interagisci","saluta", "regala", "usa"};
	
	/**
	 * Questo prototipo permette di impostare la partita
	 * 
	 * @param p la partita
	 */
	public void setPartita(Partita p);
	
	/**
	 * Questo prototipo permette di impostare il parametro del comando
	 * 
	 * @param params il parametro
	 */
	public void setParamentro(String params);
	
	/**
	 * Questo prototipo permette di eseguire il comando
	 */
	public String esegui();
}
