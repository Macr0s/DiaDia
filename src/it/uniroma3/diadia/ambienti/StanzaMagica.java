package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
/**
 * Questa classe gestisce la stanza magico. La stanza
 * Magica è un tipo di stanza dove ogni oggetto 
 * raddoppia il peso e inverte il nome
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see Stanza
 * @see Attrezzo
 *
 */
public class StanzaMagica extends Stanza{
	final static private int SOGLIA_DEFAULT = 3; 
	private int sogliaMagica;
	private int contatoreAttrezziPrelevati;

	public StanzaMagica(String nome) {
		this(nome, SOGLIA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia){
		super(nome);
		this.sogliaMagica = soglia;
		this.contatoreAttrezziPrelevati = 0;
	}
	
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo){
		StringBuilder nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse();
		return new Attrezzo(nomeInvertito.toString(), attrezzo.getPeso()*2);
	}
	
	/**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo){
		if (this.contatoreAttrezziPrelevati > this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		
		return super.addAttrezzo(attrezzo);
	}
	
	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo Contiene l'oggetto da rimuovere
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	@Override
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPrelevati++;
		return super.removeAttrezzo(attrezzo);
	}

}
