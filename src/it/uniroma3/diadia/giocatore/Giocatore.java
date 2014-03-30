package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;


public class Giocatore {
	private final static int DEFAULT_MAX_CFU = 20;
	private String nome;
	private String cognome;
	private int cfu;
	private Borsa borsa;
	private Attrezzo equipaggiato;
	
	
	public Giocatore(String nome, String cognome){
		this(nome, cognome, DEFAULT_MAX_CFU);
	}
	
	public Giocatore(String nome, String cognome, int cfu){
		this.nome = nome;
		this.cognome = cognome;
		this.cfu = cfu;
		this.borsa = new Borsa();
	}
	
	public Giocatore(String nome, String cognome, int cfu, Attrezzo equipaggiato){
		this(nome, cognome, cfu);
		this.equipaggiato = equipaggiato;
	}
	
	public String getNome(){
		return this.nome;
	}
    
	public String getCognome(){
		return this.cognome;
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	public Borsa getBorsa(){
		return this.borsa;
	}
	
	public Attrezzo getEquipaggiato() {
		return this.equipaggiato;
	}
	
	public void setEquipaggiato(Attrezzo equipaggiato) {
		this.equipaggiato = equipaggiato;
	}
	
	public int getCFU(){
		return this.cfu;
	}
	
	public void decrementaCFU(){
		this.cfu--;
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("Io sono " + this.nome + " " + this.cognome + "\n");
		s.append("CFU: " + this.cfu + "\n");
		s.append("Equipaggiato: " + ((this.equipaggiato != null)? this.equipaggiato.toString(): "Niente") + "\n");
		s.append(this.borsa.toString());
		return s.toString();
	}
}
