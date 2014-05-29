package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.Tag;

/**
 * Questa classe gestisce i tag Inizio
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Tag
 * @version 0.4
 *
 */
public class TagInizio extends Tag {

	@Override
	public void elabora(String argomenti) {
		super.setStanzaIniziale(super.getInsiemeStanza().get(argomenti));
	}


}
