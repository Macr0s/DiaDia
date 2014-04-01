package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;

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
    private static String[] elencoComandi = {"vai", "aiuto", "fine", "info", "prendi", "posa", "equipaggia","posaEquipaggiato", "disequipaggia"};

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
		Comando comandoDaEseguire = new Comando(istruzione);
		
		switch(comandoDaEseguire.getNome()){
			case "fine":
				this.fine(); 
				return true;
			case "vai":
				this.vai(comandoDaEseguire.getParametro());
				break;
			case "aiuto":
				this.aiuto();
				break;
			case "info":
				System.out.println(this.partita.toString());
				break;
			case "posa":
				this.posa(comandoDaEseguire.getParametro());
				break;
			case "prendi":
				this.prendi(comandoDaEseguire.getParametro());
				break;
			case "equipaggia":
				this.equipaggia(comandoDaEseguire.getParametro());
				break;
			case "posaEquipaggiato":
				this.posaEquipaggiato();
				break;
			case "disequipaggia":
				this.disequipaggia();
				break;
			default:
				System.out.println("Comando sconosciuto");
		}
		
		if (this.partita.isFinita()){
			if (this.partita.vinta()){
				System.out.println("Hai vinto!");
			}else{
				System.out.println("Hai perso!");
			}
			return true;
		}
		return false;
	}   
    
    // implementazioni dei comandi dell'utente:

    /**
     * Stampa informazioni di aiuto.
     */
    private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	    }

    /**
     * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
     * e ne stampa il nome, altrimenti stampa un messaggio di errore
     */
	 private void vai(String direzione) {
		 if(direzione==null)
			 System.out.println("Dove vuoi andare ?");
		 Stanza prossimaStanza = null;
		 prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		 if (prossimaStanza == null)
			 System.out.println("Direzione inesistente");
		 else {
			this.partita.setStanzaCorrente(prossimaStanza);
			this.partita.decrementaCFU();
		 }
		 System.out.println(partita.getStanzaCorrente().getDescrizione());
	 }

    /**
     * Comando "Fine".
     */
    private void fine() {
    	System.out.println("Grazie di aver giocato!");  // si desidera smettere
    }
    
    /**
     * Questo metodo gestisce il comando prendi dell'utente, cioè viene preso 
     * un oggetto dalla stanza e se non hai qualcosa equipaggiato lo equipaggia direttamente 
     * oppure se hai qualcosa equipaggiato lo mette in borsa
     * 
     * @param nomeAttrezzo il nome dell'attrezzo da prendere
     */
	public void prendi(String nomeAttrezzo){
		Attrezzo attrezzo = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if (attrezzo == null){
			System.out.println("Attezzo non presente nella stanza");
			return ;
		}
		
		if (this.partita.getGiocatore().getEquipaggiato() == null){
			this.partita.getGiocatore().setEquipaggiato(attrezzo);
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			System.out.println("Attrezzo equipaggiato");
		}else if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)){
			this.partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			System.out.println("Attrezzo messo in borsa");
		}else{
			System.out.println("Borsa piena");
		}
			
	}
	
	/**
	 * Questo metodo gestisce il comando equipaggia dell'utente, cioè prende un oggetto dalla 
	 * borsa e lo equipaggia effettuando uno scambio se già è stato equipaggiato qualcosa
	 * 
	 * @param nomeAttrezzo l'oggetto da equipaggiare
	 */
	public void equipaggia(String nomeAttrezzo){
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if (attrezzo != null){
			this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getGiocatore().getEquipaggiato());
			this.partita.getGiocatore().setEquipaggiato(attrezzo);
			System.out.println("Oggetto equipaggiato");
		}else{
			System.out.println("Oggetto non trovato in borsa");
		}
	}
	
	/**
	 * Questo metodo gestisce il comando posa dell'utente, cioè posa un oggetto dalla borsa 
	 * e lo aggiunge alla stanza
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo da posare
	 */
	public void posa(String nomeAttrezzo){
		Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		if (attrezzo == null){
			System.out.println("Oggetto non trovato in borsa");
			return ;
		}
		
		if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)){
			System.out.println("Attrezzo aggiunto alla stanza");
		}else{
			System.out.println("Capienza della stanza raggiunta");
			this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		}
	}
	
	/**
	 * Questo metodo gestisce il comando posaEquipaggiato, cioè posa l'attrezzo equipaggiato 
	 * nella stanza
	 */
	public void posaEquipaggiato(){
		Attrezzo attrezzo = this.partita.getGiocatore().getEquipaggiato();
		if (attrezzo == null){
			System.out.println("Non hai niente in mano");
			return ;
		}
		
		if (this.partita.getStanzaCorrente().addAttrezzo(attrezzo)){
			System.out.println("Attrezzo aggiunto alla stanza");
			this.partita.getGiocatore().setEquipaggiato(null);
		}else{
			System.out.println("Capienza della stanza raggiunta");
		}
	}
	
	/**
	 * Questo metodo gestisce il comando disequipaggia dell'utente, cioè posa l'oggetto 
	 * equipaggiato nella borsa
	 */
	public void disequipaggia(){
		if (this.partita.getGiocatore().getEquipaggiato() != null){
			if (this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getGiocatore().getEquipaggiato())){
				this.partita.getGiocatore().setEquipaggiato(null);
				System.out.println("Oggetto riposto in borsa");
			}else{
				System.out.println("Borsa Piena");
			}
		}else{
			System.out.println("Non hai niente in mano");
		}
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}