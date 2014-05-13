package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoCorrente;
	
	public Borsa(){
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax){
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
		this.pesoCorrente = 0;
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
		this.attrezzi.add(attrezzo);
		this.pesoCorrente += attrezzo.getPeso();
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
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		Attrezzo attrezzoCorrente = null;
		while(i.hasNext()){
			attrezzoCorrente = i.next();
			if (attrezzoCorrente.getNome().equals(nomeAttrezzo)){
				return attrezzoCorrente;
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
		return this.pesoCorrente;
	}
	
	/**
	 * Questo metodo restituisce un booleano per indicare se la borsa è vuota
	 * 
	 * @return true se la borsa è vuota altrimenti false
	 */
	public boolean isEmpty(){
		return this.attrezzi.isEmpty();
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
		Iterator<Attrezzo> i = this.attrezzi.iterator();
		Attrezzo attrezzoCorrente = null;
		while (i.hasNext()){
			attrezzoCorrente = i.next();
			if (attrezzoCorrente.getNome().equals(nomeAttrezzo)){
				this.attrezzi.remove((Attrezzo) attrezzoCorrente);
				return attrezzoCorrente;
			}
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
			Iterator<Attrezzo> i = this.attrezzi.iterator();
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): "); 
				while (i.hasNext()) 
					s.append(i.next().toString()+" ");
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
		return this.attrezzi.toArray(new Attrezzo[0]);
	}
	
	/**
	 * Questo metodo restistuisce il numero di attrezzi contenuti realmente nella borsa
	 * 
	 * @return il numero reale di attrezzi nella borsa
	 */
	public int getNumeroAttrezzi(){
		return this.attrezzi.size();
	}
	
	/**
	 * Questo metodo stabilisce se due borse sono uguali
	 * 
	 * @param o la borsa da confrontare con quella attuale
	 * @return true se le due borse sono uguali altrimenti false
	 */
	@Override
	public boolean equals(Object o){
		return this.equals((Borsa) o);
	}
	
	/**
	 * Questo metodo stabilisce se due borse sono uguali
	 * 
	 * @param borsa la borsa da confrontare con quella attuale
	 * @return true se le due borse sono uguali altrimenti false
	 */
	public boolean equals(Borsa borsa){
		if (this.hashCode() == borsa.hashCode()){
			return false;
		}
		
		for(Attrezzo attrezzo: borsa.getAttrezzi()){
			if (attrezzo != null && !this.attrezzi.contains((Attrezzo) attrezzo)){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode(){
		return this.attrezzi.hashCode() + this.getPeso() + this.getPesoMax() + this.attrezzi.size();
	}
}
