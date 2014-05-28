package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " + 
			"con una mia magica azione, troverai un nuovo oggetto " + 
			"per il tuo bel borsone!";
	private Attrezzo attrezzo;
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	public Mago(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg; 
		if (attrezzo!=null) { 
			partita.getStanzaCorrente().addAttrezzo(attrezzo); 
			this.attrezzo = null; 
			msg = MESSAGGIO_DONO; 
		}else { 
			msg = MESSAGGIO_SCUSE; 
		} 
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		attrezzo.setPeso((int)(attrezzo.getPeso()/2));
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		return "La magia è fatta";
	}

}
