package Eccezzioni;

public class CodiceFiscaleException extends Exception{
	
	public CodiceFiscaleException() 
	{
		super("ERRORE NELLA DIGITAZIONE DEL CODICE FISCALE  ");
	}
	
	public String toString() 
	{
		return this.getMessage() + ": Hai inserito un numero troppo elevato di caratteri alfanumerici ! ";
	}
	

}
