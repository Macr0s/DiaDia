package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	private String nome; 
	private String presentazione; 
	private boolean haSalutato; 
	
	public AbstractPersonaggio(String nome, String presentaz) { 
		this.nome = nome; 
	 	this.presentazione = presentaz; 
	 	this.haSalutato = false; 
	} 

	public String getNome() { 
		return this.nome; 
	} 

	public boolean haSalutato() { 
		return this.haSalutato;
	}
	 
	public String saluta() { 
		String risposta = "Ciao, io sono "+this.getNome()+"."; 
		if (!haSalutato) 
			risposta += this.presentazione; 
		else 
			risposta += "Ci siamo gia' presentati.";	 	
		this.haSalutato = true; 
		return risposta; 

	} 

	abstract public String agisci(Partita partita);
	
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	public String toString() { 
		return this.getNome(); 
	}
}
