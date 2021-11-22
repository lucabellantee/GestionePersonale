package Istituzione;

import java.util.ArrayList;


/*
   Lavorare quando possibile solo con la classe Staff , che fa da cuscinetto tra il main e tutte le altri classi astratte e le
   loro estensioni. Al massimo si potrebbero richiamare dalle classi "più interne" metodi Overridati come getPaga() che restituisce
   un valore double in base alla tipologia del personale: volontario , impiegato o giornaliero.
 
*/


public class Staff {
	
	ArrayList<Personale> p = new ArrayList();
	
	String nomeStaff; 
	
	
	public Staff(String nomeStaff) 
	{
		this.nomeStaff = nomeStaff; 
	}
	

//  Aggiunge, se non presente, nuovo personale  e ritorna true. Ritorna false in ogni altro caso	
	public boolean addPersonale(Personale personale) 
	{
		if(!personale.contains(personale.getNome(), p)) { p.add(personale); return true; }
		   return false; 
	}
	
	
// Rimuove, se presente la persona desiderata e ritorna true. Ritorna false in ogni altro caso ! 
	public boolean removePersonale(String daRimuovere) 
	{
		Personale personale = new Volontario(daRimuovere,"a",0);
		if(personale.contains(daRimuovere, p)) 
		  {
			 p.remove(this.getIndice(daRimuovere));
			 return true;
		  }
		   return false; 
	}
	
	
// Ritorna la stringa di ArrayList ciascuno con il suo metodo Overridato , vedere altre classi, contenti le info del personale
	public ArrayList <String> elencoPersonale() 
	{
		ArrayList<String> daStampare = new ArrayList();
		
		for(Personale personal : this.p) 
		  {
			  daStampare.add(personal.toString()); 
		  }
		
		return daStampare; 
	}
	
	
//  Ritorna true se	la persona è presente nella lista altrimenti ritorna false 
	public boolean findPersona(String daCercare) 
	{
		Personale personale = new Volontario(daCercare,"a",0);
		
		if(personale.contains(daCercare, p)) return true;
		  return false;  
	}
	

// Ritorna -1 se la persona non fa parte dello staff altrimenti torna l'indice corrispondente alla posizione nella lista
	public int getIndice(String nomeDaCercare) 
	{
		if(this.findPersona(nomeDaCercare)) 
		{
			int i=0;
			for(Personale pe : p) 
			{
				if(pe.getNome().equals(nomeDaCercare)) return i;
				 i++ ;
			}
		}
		return -1; 
	}
	
	
//  Ritorna false se lo staff è vuoto	
	public boolean isEmpty() 
	{
		if(this.p.isEmpty()) return true;
		   return false; 
	}
	

	public String infoPersona(String nome) 
	{
	  if(this.findPersona(nome)) 
	  {
		  return p.get(this.getIndice(nome)).infoPersona();
	  }	
	  return "null";
	}
	
	
	// TODO LUCA : Si potrebbe in seguito, pensare di aggiungere un metodo per la promozione di Giornalieri ad impiegati
	//      TODO :  oppure da Volontari a Dipendenti o Giornalieri ! 

}
