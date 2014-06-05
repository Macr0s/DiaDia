package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo. Gli attrezzi possono trovarsi
 * all'interno delle stanze del labirinto. Ogni attrezzo ha un nome ed un peso.
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @see Stanza
 * @version 0.2
 * 
 */
public class Attrezzo implements Comparable<Attrezzo> {
	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * 
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * 
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * 
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome() + " (" + this.getPeso() + "kg)";
	}

	/**
	 * Questo metodo verifica se due attrezzi sono uguali
	 * 
	 * @param o
	 *            l'attrezzo da confrontare
	 * @return true se i due attrezzi sono uguali altrimenti false
	 */
	@Override
	public boolean equals(Object o) {
		return this.equals((Attrezzo) o);
	}

	/**
	 * Questo metodo verifica se due attrezzi sono uguali
	 * 
	 * @param attrezzo
	 *            l'attrezzo da confrontare
	 * @return true se i due attrezzi sono uguali altrimenti false
	 */
	public boolean equals(Attrezzo attrezzo) {
		return this.nome.equals(attrezzo.getNome())
				&& this.peso == attrezzo.getPeso();
	}
	
	/**
	 * Metodo che serve per generare l'hashcode dell'Attrezzo
	 */
	@Override
	public int hashCode() {
		return this.nome.hashCode() + this.peso;
	}

	/**
	 * Metodo che server per comparare due attrezzi in base al nome
	 */
	@Override
	public int compareTo(Attrezzo arg0) {
		return this.getNome().compareTo(arg0.getNome());
	}
	
	/**
	 * Metodo che serve per impostare il peso dell'attrezzo
	 * 
	 * @param peso il nuovo peso dell'alttrezzo
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	/**
	 * Metodo che serve per impostare il nome dell'alttrezzo
	 * 
	 * @param nome il nuovo nome dell'attrezzo
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo che determina se l'attrezzo può essere usato
	 * 
	 * @param parametro i parametri del comando usa
	 * @param p la partita corrente
	 * @return un stringa che rappresenta l'uso dell'attrezzo
	 */
	public String usa(String parametro, Partita p){
		return "Questo oggetto non ha nulla";
	}
}