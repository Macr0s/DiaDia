package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;

/**
 * Questa classe gestisce i Tag Uscite
 * 
 * @author Matteo Filippi
 * @see Tag
 * @see FormatoFileNonValidoException
 * @version 0.4
 *
 */
public class TagUscite extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		String[] uscite = argomenti.split(", ");
		for(String collegamenti: uscite){
			String[] caratteristiche = collegamenti.split(" ");
			if (caratteristiche.length != 3) throw new FormatoFileNonValidoException("Errore sintassi");
			super.getInsiemeStanza().get(caratteristiche[0]).impostaStanzaAdiacente(caratteristiche[1], super.getInsiemeStanza().get(caratteristiche[2]));
		}
	}

}
