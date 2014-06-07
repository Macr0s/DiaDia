package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe gestisce i tipi di attrezzo Pozione
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Attrezzo
 * @see Partita
 * @version 0.3
 *
 */
public class Pozione extends Attrezzo {
	private static final int DEFAULT_SOMMA = 2;
	private int somma;
	
	public Pozione(String nome, int peso) {
		this(nome, peso, DEFAULT_SOMMA);
	}
	
	public Pozione(String nome, int peso, int somma){
		super(nome, peso);
		this.somma = somma;
	}
	
	@Override
	public String usa(String usa, Partita p){
		p.setCFU(p.getCFU() + this.somma);
		return "Cavolo è successo qualcosa hai miei CPU";
	}

}
