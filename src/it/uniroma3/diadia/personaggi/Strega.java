package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		
	}
	
	private Stanza massimoNumeroAttrezzi(Stanza s){
		int massimo = -1;
		Stanza destinazione = null;
		for(String direzione: s.getDirezioni()){
			if (s != null && massimo < s.getStanzaAdiacente(direzione).getAttrezzi().length){
					destinazione = s.getStanzaAdiacente(direzione);
			}
		}
		return destinazione;
	}
	
	private Stanza minimoNumeroAttrezzi(Stanza s){
		int minimo = 0;
		Stanza destinazione = null;
		boolean primo = true;
		for(String direzione: s.getDirezioni()){
			if (s != null && (primo || minimo > s.getStanzaAdiacente(direzione).getAttrezzi().length)){
				destinazione = s.getStanzaAdiacente(direzione);
				primo = false;
			}
		}
		return destinazione;
	}
	
	@Override
	public String agisci(Partita partita) {
		if (super.haSalutato()){
			partita.setStanzaCorrente(this.massimoNumeroAttrezzi(partita.getStanzaCorrente()));
		}else{
			partita.setStanzaCorrente(this.minimoNumeroAttrezzi(partita.getStanzaCorrente()));
		}
		return "Giuda ballerino... la strega mi ha trasportato in una stanza vicino";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getStanzaCorrente().setPersionaggio(null);
		return "La strega ride: 'Trololololollollolo' e scompare nel nulla";
	}

}
