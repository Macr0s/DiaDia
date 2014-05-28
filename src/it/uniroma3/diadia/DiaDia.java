package it.uniroma3.diadia;

import java.io.FileNotFoundException;
import java.io.IOException;

import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessione;
import it.uniroma3.diadia.io.InterfacciaUtenteConsole;

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
	private InterfacciaUtenteConsole io;
    
    public DiaDia() throws FormatoFileNonValidoException, ClassNotFoundException, IOException {
    	this.io = new InterfacciaUtenteConsole();
    	this.partita = new Partita();
    	
    }

	public void gioca() {
		this.io.mostraMessaggio(this.partita.getMessaggioBenvenuto());
		while (processaIstruzione(this.io.prendiIstruzione())){}
	}   
    
        
	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		FabbricaDiComandi fabbrica = new FabbricaDiComandiRiflessione();
		fabbrica.setIstruzione(istruzione);
		fabbrica.setPartita(this.partita);
		String risultato = fabbrica.esegui();
		
		if (istruzione.startsWith("fine")) return false;
		
		if (this.partita.isFinita()){
			if (this.partita.vinta()){
				this.io.mostraMessaggio("Hai vinto!");
			}else{
				this.io.mostraMessaggio("Hai perso!");
			}
			return false;
		}
		this.io.mostraMessaggio(risultato);
		return true;
	}  

	public static void main(String[] argc){
		try{
			DiaDia gioco = new DiaDia();
			gioco.gioca();
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}