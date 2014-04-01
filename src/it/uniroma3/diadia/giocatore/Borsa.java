package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

/**
 * Questa classe gestisce la borsa del giocatore e i relativi attrezzi
 * 
 * @author Matteo Filippi, Andrea Salvoni (da un'idea di Michael Kolling and David J. Barnes)
 * @see Attrezzo
 * @version 0.2
 *
 */
public class Borsa {
	private final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa(){
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax){
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}
	/**
	 * Questo metodo serve per aggiungere un attrezzo alla borsa
	 * 
	 * @param attrezzo il nuovo attrezzo della borsa
	 * @return true se l'attrezzo è stato aggiunto alla borsa altrimenti false
	 */
	public boolean addAttrezzo(Attrezzo attrezzo){
		if (attrezzo == null) 
			return false;
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Questo metodo restituisce il massimo peso che può contentere la borsa
	 * 
	 * @return il peso massimo
	 */
	public int getPesoMax(){
		return this.pesoMax;
	}
	
	/**
	 * Questo metodo restituisce un attrezzo contenuto nella borsa
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo contenuto nella borsa
	 * @return se l'attrezzo sta nella borsa restituisce l'attrezzo altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo){
		for(int i = 0; i<this.numeroAttrezzi; i++){
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)){
				return attrezzi[i];
			}
		}
		return null;
	}
	
	/**
	 * Questo metodo restituisce il peso corrente della borsa
	 * 
	 * @return il peso corrente della borsa
	 */
	public int getPeso(){
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++){
			peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}
	
	/**
	 * Questo metodo restituisce un booleano per indicare se la borsa è vuota
	 * 
	 * @return true se la borsa è vuota altrimenti false
	 */
	public boolean isEmpty(){
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Questo metodo restituisce un booleano per indicare se un'attrezzo è contenuto nella borsa
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo
	 * @return tre se è contenuto altrimenti false
	 */
	public boolean hasAttrezzo(String nomeAttrezzo){
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	/**
	 * Questo metodo rimuove un attrezzo dalla borsa e lo restituisce
	 * 
	 * @param nomeAttrezzo il nome dell'attrezzo da rimuovere
	 * @return l'attrezzo rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo){
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo)){
				Attrezzo attrezzo = this.attrezzi[i];
				for (int j = i; j < this.numeroAttrezzi - 1; j++){
					this.attrezzi[j] = this.attrezzi[j+1];
				}
				this.attrezzi[this.numeroAttrezzi- 1] = null;
				this.numeroAttrezzi--;
				return attrezzo;
			}
		return null;
	}
	
	/**
	 * Questo metodo restitusice una rappresentazione stringata della borsa
	 *
	 * @return la rappresentazione stringata della borsa
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()){
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): "); 
				for (int i= 0; i<this.numeroAttrezzi; i++) 
					s.append(attrezzi[i].toString()+" ");
		}else{
			s.append("Borsa vuota");
		}
		return s.toString();
	}
	
	/**
	 * Questo metodo restituisce l'array di attrezzi
	 * 
	 * @return l'array di attrezzi
	 */
	public Attrezzo[] getAttrezzi(){
		return this.attrezzi;
	}
	
	/**
	 * Questo metodo restistuisce il numero di attrezzi contenuti realmente nella borsa
	 * 
	 * @return il numero reale di attrezzi nella borsa
	 */
	public int getNumeroAttrezzi(){
		return this.numeroAttrezzi;
	}
	
	/**
	 * Questo metodo stabilisce se due borse sono uguali
	 * 
	 * @param borsa la borsa da confrontare con quella attuale
	 * @return true se le due borse sono uguali altrimenti false
	 */
	public boolean equals(Borsa borsa){
		if (this.attrezzi.length != borsa.getAttrezzi().length &&
				this.getPeso() != borsa.getPeso() &&
				this.getPesoMax() != borsa.getPesoMax() &&
				this.getNumeroAttrezzi() != borsa.getNumeroAttrezzi()){
			return false;
		}
		
		for(int i = 0; i < this.getNumeroAttrezzi(); i++){
			if (!this.attrezzi[i].equals(borsa.getAttrezzi()[i])){
				return false;
			}
		}
		return true;
	}
}
