package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	private HashMap<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoCorrente;
	
	private class Nome implements Comparator<Attrezzo>{
		@Override
		public int compare(Attrezzo o1, Attrezzo o2) {
			return o1.getNome().compareTo(o2.getNome());
		}
	}
	
	private class Peso implements Comparator<Attrezzo>{
		@Override
		public int compare(Attrezzo o1, Attrezzo o2) {
			if (o1.getPeso() - o2.getPeso() == 0){
				return o1.compareTo(o2);
			}else{
				return o1.getPeso() - o2.getPeso();
			}
		}
	}
	
	public Borsa(){
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax){
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
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
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
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
		return this.attrezzi.get(nomeAttrezzo);
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
		return this.attrezzi.remove(nomeAttrezzo);
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
			for (Attrezzo a: this.attrezzi.values()) 
				s.append(a.toString()+" ");
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
		return this.attrezzi.values().toArray(new Attrezzo[0]);
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
		if (this.hashCode() != borsa.hashCode()){
			return false;
		}
		
		for(Attrezzo attrezzo: borsa.getAttrezzi()){
			if (attrezzo != null && !this.attrezzi.containsValue((Attrezzo) attrezzo)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Metodo che calcola hashCode della borsa
	 * 
	 * @return l'hasdcode della borsa
	 */
	@Override
	public int hashCode(){
		return this.attrezzi.hashCode() + this.getPeso() + this.getPesoMax() + this.attrezzi.size();
	}
	
	/**
	 * Metodo che restituisce il contenuto della borsa in un determinato ordine
	 * 
	 * @param c il comparator che serve per ordinare il contenuto della borsa
	 * @return il contenuto della borsa sottoforma di lista
	 */
	public List<Attrezzo>  getContenutoPer(Comparator<Attrezzo> c){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, c);
		return l;
	}
	
	/**
	 * Metodo che restituisce il contenuto della borsa ordinata per peso
	 * 
	 * @return il contenuto della borsa sottoforma di lista
	 */
	public List<Attrezzo> getContentutoPerPeso(){
		return this.getContenutoPer(new Peso());
	}
	
	/**
	 * Metodo che restituisce il contenuto della borsa ordinata per nome
	 * 
	 * @return il contenuto della borsa sottoforma di lista
	 */
	public List<Attrezzo> getContentutoPerNome(){
		return this.getContenutoPer(new Nome());
	}
	
	/**
	 * Metodo che restituisce il contenuto della borsa raggruppato per peso
	 * 
	 * @return il contenuto della borsa raggruppato per peso sottoforma di mappa
	 */
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		HashMap<Integer, Set<Attrezzo>> m = new HashMap<>();
		Set<Attrezzo> s = null;
		
		for(Attrezzo a: this.attrezzi.values()){
			if(m.containsKey(new Integer(a.getPeso())))
				s = m.get(new Integer(a.getPeso()));
			else
				s = new HashSet<Attrezzo>();
			s.add(a);
			m.put(new Integer(a.getPeso()), s);
		}
		return m;
	}
}
