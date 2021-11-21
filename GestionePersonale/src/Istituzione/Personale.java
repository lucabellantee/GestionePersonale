package Istituzione;

import java.util.ArrayList;

public abstract class Personale {
// nome indirizzo numero di telefono 
	
	private String nome;
	private String indirizzo;
	private int numeroTelefono;
	
	public Personale(String nome, String indirizzo, int numeroTelefono) 
	{
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.numeroTelefono = numeroTelefono;
	}
	
	
	public String getNome() { return this.nome; }
	public String getIndirizzo() { return this.indirizzo; }
	public int getnumeroTelefono() { return this.numeroTelefono; }
	
	
	public String toString() 
	{
		return "NOME: " + this.nome + " INDIRIZZO: " + this.indirizzo + " NUMERO DI TELEFONO: " + this.numeroTelefono;
	}
	
	public abstract double getPaga();
	
	public abstract boolean equals(Object o); 
	
	
// Ritorna false se l'oggetto non è contenuto nella lista , true se è contenuto nella lista , in base al NOME
	public  boolean contains(String nomePersona , ArrayList<Personale>p) 
	{

			for(Personale personale : p) 
			{
				if(personale.getNome().equals(nomePersona)) return true; 
			}
			return false;
	}
	
	public abstract int getIndice(Object o , ArrayList<Personale>p);
	
	
}
