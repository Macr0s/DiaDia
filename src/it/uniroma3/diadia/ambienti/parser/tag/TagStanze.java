package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.parser.Tag;

/**
 * Questa classe gestisce i tag Stanze
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Tag
 * @version 0.4
 *
 */
public class TagStanze extends Tag {

	@Override
	public void elabora(String argomenti) {
		for(String nome: argomenti.split(", ")){
			super.getInsiemeStanza().put(nome, new Stanza(nome));
			super.getInsiemeStanza().get(nome).setPartita(super.getPartita());
		}
	}

}
