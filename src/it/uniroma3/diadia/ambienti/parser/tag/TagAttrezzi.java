package it.uniroma3.diadia.ambienti.parser.tag;


import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TagAttrezzi extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String attrezzo: argomenti.split(", ")){
			String[] caratteristiche = attrezzo.split(" ");
			if (caratteristiche.length != 3 && caratteristiche.length != 2) throw new FormatoFileNonValidoException("Errore di sintassi");
			Attrezzo a = new Attrezzo(caratteristiche[0], new Integer(caratteristiche[1]).intValue());
			super.getInsiemeAttrezzo().put(caratteristiche[0], a);
			if (caratteristiche.length == 3)
				super.getInsiemeStanza().get(caratteristiche[2]).addAttrezzo(a);
		}
	}
}
