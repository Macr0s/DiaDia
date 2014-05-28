package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.Tag;

public class Vincente extends Tag {

	@Override
	public void elabora(String argomenti) {
		super.setStanzaVincente(super.getInsiemeStanza().get(argomenti));
	}
}
