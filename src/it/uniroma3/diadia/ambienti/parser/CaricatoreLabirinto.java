package it.uniroma3.diadia.ambienti.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
/**
 * Questa classe gestisce il caricamento di un labirinto da file
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Stanza
 * @see Map
 * @see HashMap
 * @see Formato FileNonValidoException
 * @see Partita
 * @see Attrezzo
 * @see AbstractPersonaggio
 * @version 0.4
 *
 */
public class CaricatoreLabirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private Map<String, Attrezzo> insiemeAttrezzo;
	private Map<String, Stanza> insiemeStanza;
	private Map<String, AbstractPersonaggio> insiemePersonaggio;
	private Partita partita;
	private Scanner scanner;
	
	public CaricatoreLabirinto(String file, Partita partita) throws FileNotFoundException{
		this.scanner = new Scanner(new BufferedReader(new FileReader(file)));
		this.insiemeAttrezzo = new HashMap<>();
		this.insiemePersonaggio = new HashMap<>();
		this.insiemeStanza = new HashMap<>();
		this.partita = partita;
	}
	
	public CaricatoreLabirinto(Partita partita, String contenuto){
		this.insiemeAttrezzo = new HashMap<>();
		this.insiemePersonaggio = new HashMap<>();
		this.insiemeStanza = new HashMap<>();
		this.partita = partita;
		this.scanner = new Scanner(contenuto);
		
	}
	
	@SuppressWarnings("unchecked")
	private void processaRiga(String riga, int numeroRiga) throws FormatoFileNonValidoException{
		if (riga.startsWith("//") || riga.equals("")) return ;
		String[] s = riga.split(": ");
		if (s.length == 2){
			try{
				Class<Tag> c = (Class<Tag>) Class.forName("it.uniroma3.diadia.ambienti.parser.tag.Tag"+s[0]);
				Tag tag = c.newInstance();
				tag.setCaricatoreLabirinto(this);
				tag.elabora(s[1]);
			}catch(Exception e){
				throw new FormatoFileNonValidoException(e.getMessage() + " alla riga " + numeroRiga);
			}
		}else{
			throw new FormatoFileNonValidoException("Errore nella formattazione nella riga " + numeroRiga);
		}
	}
	
	public void carica() throws FormatoFileNonValidoException{
		int numeroRiga = 1;
		try{
			while (this.scanner.hasNext()){
				this.processaRiga(this.scanner.nextLine(), numeroRiga);
				numeroRiga++;
			}
		}finally{
			this.scanner.close();
		}
	}
	
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}
	
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public Map<String, Attrezzo> getInsiemeAttrezzo() {
		return insiemeAttrezzo;
	}
	
	public Map<String, AbstractPersonaggio> getInsiemePersonaggio() {
		return insiemePersonaggio;
	}
	
	public Map<String, Stanza> getInsiemeStanza() {
		return insiemeStanza;
	}
	
	public Partita getPartita() {
		return partita;
	}
}
