package it.uniroma3.diadia.ambienti.parser.tag;

import it.uniroma3.diadia.ambienti.parser.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.parser.Tag;
import it.uniroma3.diadia.personaggi.Mago;

public class TagMaghi extends Tag {

	@Override
	public void elabora(String argomenti) throws FormatoFileNonValidoException {
		for(String mago: argomenti.split(", ")){
			String[] caratteristiche = mago.split(" ");
			super.getInsiemePersonaggio().put(caratteristiche[0], new Mago(caratteristiche[0], caratteristiche[1],
					super.getInsiemeAttrezzo().get(caratteristiche[2])));
		}
	}

}
