package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.Tag;


public class TagInizio extends Tag {

	@Override
	public void elabora(String argomenti) {
		super.setStanzaIniziale(super.getInsiemeStanza().get(argomenti));
	}


}
