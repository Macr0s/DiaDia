package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Questa classe gestisce un tipo di stanza che prende
 * il nome di stanza bloocata. La stanza bloocata è una 
 * stanza che ha una direzione blocccata e può essere
 * aperta solo se nella stanza c'è un determinato oggetto
 * 
 * @author Matteo FIlippi, Andrea Salvoni
 * @version 0.2
 * @see Stanza
 * @see StringBuilder
 *
 */
public class StanzaBloccata extends Stanza{
	private static final String DEFAULT_DIREZIONE = "nord";
	private static final String DEFAULT_CHIAVE = "passepartout";
	private String direzioneNascosta;
	private String direzioneChiave;
	
	public StanzaBloccata(String nome){
		this(nome, DEFAULT_DIREZIONE, DEFAULT_CHIAVE);
	}
	
	public StanzaBloccata(String nome, String direzioneNascosta, String direzioneChiave){
		super(nome);
		this.direzioneChiave = direzioneChiave;
		this.direzioneNascosta = direzioneNascosta;
	}
	
	/**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
	@Override
	public String getDescrizione(){
		StringBuilder s = new StringBuilder();
    	if (!this.getPartita().getGiocatore().getBorsa().hasAttrezzo(this.direzioneChiave)){
			s.append("Qui qualcosa non va, le porte non sono porte");
		}else{
			s.append(super.getNome());
	    	s.append("\nUscite: ");
	    	for (String direzione : super.getDirezioni())
	    		if (direzione!=null){
	    			s.append(" " + direzione);	
	    	}
	    	s.append("\nAttrezzi nella stanza: ");
	    	for (Attrezzo attrezzo : this.getAttrezzi()) {
	    		if (attrezzo != null)	
	    			s.append(attrezzo.toString()+" ");
	    	}
		}
    	return s.toString();
	}
	
	/**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione la direzione
     */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione.equals(this.direzioneNascosta) && !this.hasAttrezzo(this.direzioneChiave)){
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
}
