package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe implementa la gestione dei comandi
 * 
 * @author Matteo Filippi, Andrea Salvoni
 * @version 0.2
 * @see FabbricaDiComandi
 * @see Comando
 * @see Partita
 *
 */
public class FabbricaDiComandiRiflessione implements FabbricaDiComandi {
	private Partita partita;
	private String nome;
	private String parametro;

	@Override
	public void setPartita(Partita p) {
		this.partita = p;
	}

	@Override
	public void setParamentro(String params) {
		this.parametro = params;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String esegui() {
		Comando comando;
		if (this.nome != null){
			StringBuilder s = new StringBuilder(this.nome);
			s.setCharAt(0, (char) (this.nome.charAt(0) -  32));
			try {
				Class<Comando> temp = (Class<Comando>) Class.forName("it.uniroma3.diadia.comandi.lista.Comando"+s.toString());
				comando = temp.newInstance();
			} catch (Exception e) {
				comando = new ComandoSconosciuto();
			}
		}else
			comando = new ComandoNonInserito();
		
		comando.setParamentro(this.parametro);
		comando.setPartita(this.partita);
		return comando.esegui();
	}

	@Override
	public void setIstruzione(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);

		// prima parola: nome del comando
		if (scannerDiParole.hasNext())
			this.nome = scannerDiParole.next(); 

		// seconda parola: eventuale parametro
		if (scannerDiParole.hasNext())
			this.parametro = scannerDiParole.next();
		scannerDiParole.close();
	}

	@Override
	public void setComando(String nome) {
		this.nome = nome;
	}

}
