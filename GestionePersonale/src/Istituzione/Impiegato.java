package Istituzione;

import java.util.ArrayList;

public class Impiegato extends Dipendente {
	
	private int bonusMaturati;
	
	public Impiegato(String nome, String indirizzo, long numeroTelefono, String codFiscale, int bonusMaturati) 
	{
		super(nome,indirizzo,numeroTelefono,codFiscale);
		this.bonusMaturati = bonusMaturati;
	}
	
	
	public double getPaga() { return super.getPaga()*this.bonusMaturati; }
	
	
	public String toString() 
	{
		return "IMPIEGATO ->  " + "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono() + " PAGA BASE: " + this.getPaga();
	}
	
	
	public boolean equals(Object o) 
	{
		if(o instanceof Impiegato) return true;
		return false; 
	}
	
	
	public int getBonusMaturati() { return this.bonusMaturati; }
	
/*	
	public boolean contains(Object o , ArrayList<Personale>p) 
	{
		Impiegato v;
		if(equals(o)) 
		{
		   v = (Impiegato)o;
		   
		   for(Personale personale : p) 
		      {
			     if(v.getNome().equals(personale.getNome()))
			    	 return true;
		      }
		}
		return false;
	}
	
*/
	
	
	public int getIndice(Object o , ArrayList<Personale>p) 
	{
		Impiegato v;
		if(equals(o)) 
		{
			v = (Impiegato)o;
			
			int i=0;
		    for(Personale personale : p) 
			   {
				  if(v.getNome().equals(personale.getNome()))
				     return i;
				  i++;
			   }
			
			
		}
		return -1; 
	}
	
	
	public String infoPersona() 
	{
		return "IMPIEGATO ->  " + "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono() + " PAGA BASE: " + this.getPaga() + " BONUS MATURATI: " + this.getBonusMaturati();	
	}

}
