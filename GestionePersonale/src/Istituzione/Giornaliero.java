package Istituzione;

import java.util.ArrayList;

public class Giornaliero extends Dipendente {

	private int giorniLavoro;
	
	public Giornaliero(String nome, String indirizzo, int numeroTelefono, int codFiscale, int giorniLavoro) 
	{
		super(nome,indirizzo,numeroTelefono,codFiscale);
		this.giorniLavoro = giorniLavoro; 
	}
	
	
	public double getPaga() { return super.getRetribuzioneBase()*this.giorniLavoro; }
	
	
	public String toString() 
	{
	  return "GIORNALIERO ->  "+ "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono() + " PAGA BASE: " + this.getPaga();
	}
	
	
	public boolean equals(Object o) 
	{
		if(o instanceof Giornaliero) return true;
		return false; 
	}
	
	
	public int getGiorniLavoro() { return this.giorniLavoro; }
	
/*	
	public boolean contains(Object o , ArrayList<Personale>p) 
	{
		Giornaliero v;
		if(equals(o)) 
		{
		   v = (Giornaliero)o;
		   
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
		Giornaliero v;
		if(equals(o)) 
		{
			v = (Giornaliero)o;
			
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
