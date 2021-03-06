package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;
import it.uniroma3.diadia.personaggi.Strega;

/**
 * Questa classe gestisce i tag Strega
 * 
 * @author Matteo Filipi, Andrea Salvoni
 * @see Tag
 * @see FormatoFileNonValidoException
 * @version 0.4
 *
 */
public class TagStreghe extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String strega: argomenti.split(", ")){
			String[] caratteristiche = strega.split(" ");
			super.getInsiemePersonaggio().put(caratteristiche[0], new Strega(caratteristiche[0], caratteristiche[1]));
		}
	}

}
