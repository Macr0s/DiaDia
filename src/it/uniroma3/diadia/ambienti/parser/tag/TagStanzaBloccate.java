package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;

/**
 * Questa classe gestisce il Tag Bloccate
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Tag
 * @see FormatoFileNonValidoException
 * @version 0.4
 *
 */
public class TagStanzaBloccate extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String stanza: argomenti.split(", ")){
			String[] caratteristiche = stanza.split(" ");
			this.getInsiemeStanza().put(caratteristiche[0], new StanzaBloccata(caratteristiche[0], caratteristiche[1], caratteristiche[1]));
		}
	}

}
