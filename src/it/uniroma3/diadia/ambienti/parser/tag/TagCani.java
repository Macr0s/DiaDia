package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;
import it.uniroma3.diadia.personaggi.Cane;

public class TagCani extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String stanza: argomenti.split(", ")){
			String[] caratteristiche = stanza.split(" ");
			super.getInsiemePersonaggio().put(caratteristiche[0], new Cane(caratteristiche[0], 
					caratteristiche[1], 
					caratteristiche[2], 
					super.getInsiemeAttrezzo().get(caratteristiche[3])));
		}

	}

}
