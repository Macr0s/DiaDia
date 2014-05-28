package it.uniroma3.diadia.io;

import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {
	private Scanner scanner;
	
	public InterfacciaUtenteConsole(){
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	@Override
	public String prendiIstruzione() {	
		return this.scanner.nextLine();
	}

	
}
