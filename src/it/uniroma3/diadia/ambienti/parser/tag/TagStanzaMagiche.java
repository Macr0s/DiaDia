package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;

/**
 * Questa classe gestisce i tag StanzaMagiche
 * 
 * @author matteo
 *
 */
public class TagStanzaMagiche extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String stanza: argomenti.split(", ")){
			String[] caratteristiche = stanza.split(" ");
			super.getInsiemeStanza().put(caratteristiche[0], new StanzaMagica(caratteristiche[0], new Integer(caratteristiche[1]).intValue()));
			super.getInsiemeStanza().get(caratteristiche[0]).setPartita(super.getPartita());
		}
	}

}
