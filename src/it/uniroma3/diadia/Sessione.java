package it.uniroma3.diadia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Sessione {
	
	public boolean verificaSessione(){
		File f = new File("parita.dat");
		return f.exists();
	}
	
	public Partita caricaSessione() throws FileNotFoundException{
		try{
			ObjectInputStream buff = new ObjectInputStream(new FileInputStream("parita.dat"));
			Partita p = (Partita) buff.readObject();
			buff.close();
			return p;
		}catch(Exception e){
			return null;
		}
	}
	
	public Partita salvaSession(Partita p){
		try{
			ObjectOutputStream buff = new ObjectOutputStream(new FileOutputStream("parita.dat"));
			buff.writeObject(p);
			buff.close();
			return p;
		}catch(Exception e){
			return null;
		}
	}
}
