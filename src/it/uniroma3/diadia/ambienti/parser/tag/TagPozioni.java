package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.Pozione;

/**
 * Questa classe gestisce i TagPozioni
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Tag
 * @see FormatoFileNonValidoException
 * @version 0.4
 *
 */
public class TagPozioni extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String pozione: argomenti.split(", ")){
			String[] caratteristiche = pozione.split(" ");
			Attrezzo p = new Pozione(caratteristiche[0], new Integer(caratteristiche[1]).intValue(), new Integer(caratteristiche[2]).intValue());
			super.getInsiemeAttrezzo().put(caratteristiche[0], p);
			if (caratteristiche.length == 4){
				super.getInsiemeStanza().get(caratteristiche[0]).addAttrezzo(p);
			}
		}
	}

}
