package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;

/**
 * Questa classe gestisce i tag StanzeBuie
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Tag
 * @see FormatoFileNonValidoException
 * @version 0.4
 *
 */
public class TagStanzaBuie extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String stanza: argomenti.split(", ")){
			String[] caratteristiche = stanza.split(" ");
			super.getInsiemeStanza().put(caratteristiche[0], new StanzaBuia(caratteristiche[0], caratteristiche[1]));
		}
	}

}
