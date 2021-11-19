package Istituzione;

import java.util.ArrayList;

public class Staff {
	
	ArrayList<Personale> p = new ArrayList();
	
	String nomeStaff; 
	
	
	public Staff(String nomeStaff) 
	{
		this.nomeStaff = nomeStaff; 
	}
	
	
	public boolean addPersonale(Personale personale) 
	{
		if(personale.contains(personale, p)) { p.add(personale); return true; }
		   return false; 
	}
	
	
	public boolean removePersonale(Personale personale) 
	{
		if(!personale.contains(personale, p)) 
		  {
			if(personale.getIndice(personale, p) == -1) return false;
			 p.remove(personale.getIndice(personale, p));
			 return true;
		  }
		   return false; 
	}
	
	
	public ArrayList <String> elencoPersonale() 
	{
		ArrayList<String> daStampare = new ArrayList();
		
		for(Personale personal : this.p) 
		  {
			  daStampare.add(personal.toString()); 
		  }
		
		return daStampare; 
	}
	
	
	
	
	
    // METODI EXTRA : 
	
	
	public boolean findPersona(Personale personale) 
	{
		if(personale.contains(personale, p)) return true;
		  return false; 
	}
	
	
	
	// TODO LUCA : Si potrebbe in seguito, pensare di aggiungere un metodo per la promozione di Giornalieri ad impiegati
	//      TODO :  oppure da Volontari a Dipendenti o Giornalieri ! 

}
