package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiSemplice;

import java.util.Scanner;

/**
 *  Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 *  Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 *  Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  Matteo Filippi, Andrea Salvoni (da un'idea di Michael Kolling and David J. Barnes)
 * @version 0.2
 */

public class DiaDia {
	private Partita partita;
    
    public DiaDia() {
    	this.partita = new Partita();
    }

	public void gioca() {
		String istruzione; 
	    Scanner scannerDiLinee;

		System.out.println(this.partita.getMessaggioBenvenuto());
	    scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}   
    
        
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		FabbricaDiComandi fabbrica = new FabbricaDiComandiSemplice();
		fabbrica.setIstruzione(istruzione);
		fabbrica.setPartita(this.partita);
		boolean risultato = fabbrica.esegui();
		
		if (this.partita.isFinita() && risultato){
			if (this.partita.vinta()){
				System.out.println("Hai vinto!");
			}else{
				System.out.println("Hai perso!");
			}
			return true;
		}
		return !risultato;
	}  

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}