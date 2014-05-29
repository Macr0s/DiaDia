package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.parser.CaricatoreLabirinto;
import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
/**
 * Questa classe inizializza il labirinto da un file e memorizza 
 * la stanza iniziale e la stanza vincente
 * 
 * @author  Matteo Filippi, Andrea Salvoni (da un'idea di Michael Kolling and David J. Barnes)
 * @see Stanza
 * @see CaricatoreLabirinto
 * @version 0.3
 */
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
	@Override
   public Stanza getIniziale() {
		return this.caricatore.getStanzaIniziale();
	}
   
   /**
    * Questo metodo serve per prendere la stenza vincente
    * 
    * @return La stanza vincente
    */
	@Override
   public Stanza getVincente() {
		return this.caricatore.getStanzaVincente();
	}
   
   /**
    * Metodo che restituisce la partita corrente
    * 
    * @return la partita corrente
    */
	@Override
   public Partita getPartita() {
		return partita;
	}
   
   /**
    * Metodo che imposta la partita corrente
    * 
    * @param partita la partita corrente
    */
	@Override
   public void setPartita(Partita partita) {
		this.partita = partita;
	}

}
