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
public class FabbricaDiComandiSemplice implements FabbricaDiComandi {
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

	@Override
	public boolean esegui() {
		Comando comando;
		if (this.nome != null)
			switch(this.nome){
				case "fine":
					comando = new ComandoFine();
					break;
				case "vai":
					comando = new ComandoVai();
					break;
				case "aiuto":
					comando = new ComandoAiuto();
					break;
				case "info":
					comando = new ComandoInfo();
					break;
				case "posa":
					comando = new ComandoPosa();
					break;
				case "prendi":
					comando = new ComandoPrendi();
					break;
				case "equipaggia":
					comando = new ComandoEquipaggia();
					break;
				case "posaEquipaggiato":
					comando = new ComandoPosaEquipaggiato();
					break;
				case "disequipaggia":
					comando = new ComandoDisequipaggia();
					break;
				default:
					comando = new ComandoSconosciuto();
			}
		else
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
