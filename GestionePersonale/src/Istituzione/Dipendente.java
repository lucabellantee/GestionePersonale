package Istituzione;

public abstract class Dipendente extends Personale{
	
	private int codFiscale;
	private final double retribuzioneBase = 800.50;
	
	public Dipendente(String nome, String indirizzo, int numeroTelefono, int codFiscale) 
	{
		super(nome,indirizzo,numeroTelefono);
		this.codFiscale = codFiscale; 
	}
	
	public double getPaga() { return retribuzioneBase; }
	
	public String toString() 
	{
		return "DIPENDENTE ->  "+ "NOME: " + this.getNome() + " INDIRIZZO: " + this.getIndirizzo() + " NUMERO DI TELEFONO: " + this.getnumeroTelefono();
	}
	
	public boolean equals(Object o) 
	{
		if(o instanceof Dipendente) return true;
		return false;
	}
	
	

}
