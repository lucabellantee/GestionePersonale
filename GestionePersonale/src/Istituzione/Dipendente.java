package Istituzione;

import java.util.ArrayList;

public abstract class Dipendente extends Personale{
	
	private String codFiscale;
	private final double retribuzioneBase = 800.50;
	
	public Dipendente(String nome, String indirizzo, int numeroTelefono, String codFiscale) 
	{
		super(nome,indirizzo,numeroTelefono);
		this.codFiscale = codFiscale; 
	}
	
	
	public double getPaga() { return retribuzioneBase; }
	
	
	public String toString() 
	{
		return "DIPENDENTE ->  "+ "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono() + " PAGA BASE: " + this.getPaga();
	}
	
	
	public boolean equals(Object o) 
	{
		if(o instanceof Dipendente) return true;
		return false;
	}
	
	
	public double getRetribuzioneBase() { return retribuzioneBase; }
	
/*	
	public boolean contains(Object o , ArrayList<Personale>p) 
	{
		Dipendente v;
		if(equals(o)) 
		{
		   v = (Dipendente)o;
		   
		   for(Personale personale : p) 
		      {
			     if(v.getNome().equals(personale.getNome()) )
			    	 return true;
		      }
		}
		return false;
	}
	
*/
	
	
	public int getIndice(Object o , ArrayList<Personale>p) 
	{
		Dipendente v;
		if(equals(o)) 
		{
			v = (Dipendente)o;
			
			int i=0;
		    for(Personale personale : p) 
			   {
				  if(v.getNome().equals(personale.getNome()) )
				     return i;
				  i++;
			   }
			
			
		}
		return -1; 
	}
	
	
	
	

}
