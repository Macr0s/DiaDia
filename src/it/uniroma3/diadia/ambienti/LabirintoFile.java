package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.parser.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;

public class LabirintoFile extends Labirinto {
	private CaricatoreLabirinto caricatore;
	private Partita partita;

	public LabirintoFile(Partita partita) throws FileNotFoundException, FormatoFileNonValidoException {
		super(partita);
		this.partita = partita;
		this.caricatore = new CaricatoreLabirinto("labirinto.txt", this.partita);
		this.caricatore.carica();
	}
	
	/**
    * Questo metodo serve per prendere la stanza iniziale
    * 
    * @return La stanza iniziale
    */
   public Stanza getIniziale() {
		return this.caricatore.getStanzaIniziale();
	}
   
   /**
    * Questo metodo serve per prendere la stenza vincente
    * 
    * @return La stanza vincente
    */
   public Stanza getVincente() {
		return this.caricatore.getStanzaVincente();
	}
   
   /**
    * Metodo che restituisce la partita corrente
    * 
    * @return la partita corrente
    */
   public Partita getPartita() {
		return partita;
	}
   
   /**
    * Metodo che imposta la partita corrente
    * 
    * @param partita la partita corrente
    */
   public void setPartita(Partita partita) {
		this.partita = partita;
	}

}
