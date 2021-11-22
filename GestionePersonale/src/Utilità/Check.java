package Utilità;
import Main.Gestione;

public class Check {
	
	
	
	public boolean checkNumberCodiceFiscale(String codiceFiscale) 
	{		
		
		int conta = 0;
		for(int i = 0 ; i<codiceFiscale.length() ; i++) 
		{
			char carattere = codiceFiscale.charAt(i);

			if(Character.isDigit(carattere)) conta++;
		}

		if(conta == 7 && codiceFiscale.length() == 16) return true;
		
		return false;
	}
	
	
	
	
	public boolean checkLettersCodiceFiscale(String codiceFiscale) 
	{
		
		int conta = 0;
		for(int i=0 ; i<codiceFiscale.length() ; i++) 
		{
			char carattere = codiceFiscale.charAt(i);

			if(!Character.isDigit(carattere))
			   conta++;
			
		}
		
		if(conta == 9) return true;
		
		return false;
	}

}
