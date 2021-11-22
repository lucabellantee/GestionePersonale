package Istituzione;

import java.util.ArrayList;

public class Volontario extends Personale{
	
	public Volontario(String nome, String indirizzo, int numeroTelefono) 
	{
		super(nome,indirizzo,numeroTelefono);
	}
	
	
	public double getPaga() { return 0; }
	
	
	public String toString() 
	{
		return "VOLONTARIO --> "+ "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono();
	}
	
	
	public boolean equals(Object o) 
	{
		if(o instanceof Volontario) return true;
		return false; 
	}
	
/*	
	public boolean contains(Object o , ArrayList<Personale>p) 
	{
		Volontario v;
		if(equals(o)) 
		{
		   v = (Volontario)o;
		   
		   for(Personale personale : p) 
		      {
			     if(v.getNome().equals(personale.getNome()) && v.getIndirizzo().equals(personale.getIndirizzo()) && v.getnumeroTelefono()==personale.getnumeroTelefono())
			    	 return true;
		      }
		}
		return false;
	}
*/	
	
	public int getIndice(Object o , ArrayList<Personale>p) 
	{
		Volontario v;
		if(equals(o)) 
		{
			v = (Volontario)o;
			
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
	
	
	public String infoPersona() 
	{
		return "VOLONTARIO --> "+ "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono();
	}

}
