package Main;

import Istituzione.*;
import java.util.*;


public class Gestione {

	public static void main(String[] args) {
		
		int scelta;
		boolean uscita=true;
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Staff s = null;
		Personale p= null;
		do {
	
	// Rivisitazione menu ! 
			System.out.println("      MENU      ");
			System.out.println("Che cosa vuoi fare? ");
			System.out.println("0) Per creare un gruppo/staff: ");
			System.out.println("1) Aggiungere un dipendente: ");
			System.out.println("2) Aggiungere un volontario: "); 
			System.out.println("3) Avere le info di un membro: "); // s.elencoPersonale().get(s.getIndice(nomeDaVisualizzare));
			System.out.println("4) Calcolare la paga di un membro: ");
			System.out.println("5) Elencare i membri di un gruppo di staff: ");
			System.out.println("6) Uscire dal programma. ");
			
		    scelta = input.nextInt();
		    input.nextLine();

		    switch(scelta) {
		    
            case 0:
		    	
		    	System.out.println("Inserire il nome del gruppo staff: ");
		    	String nomeStaff=input.next();
		    	s= new Staff(nomeStaff);
		    	
		    	break;
		        
		    case 1:
		    	
		    	String nomeDipendente, indirizzoDipendente;
		    	int numeroDipendente;
		    	String codiceFiscale;
		    	System.out.println("Inserire in nome del dipendente da aggiungere: ");
		    	nomeDipendente=input.nextLine();
		    	
		    	if(s.findPersona(nomeDipendente)) break;
		    	
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoDipendente=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
		    	numeroDipendente=input.nextInt();
		    	System.out.println("Inserire il codice fiscale: ");
		    	codiceFiscale=input2.nextLine();
		    	
		    	System.out.println("Il dipendente � giornaliero o un impiegato? ");
		    	String Opzione=input.next();
		    	if(Opzione.equals("giornaliero")) 
		    	{
		    	 
		    	 int giorniLavoro;
		    	 System.out.println("Quante giornate lavorative ha fatto? ");
		    	 giorniLavoro=input.nextInt();
		    	 
		    	 p= new Giornaliero(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, giorniLavoro);
		    	 s.addPersonale(p);
		    	 
		    	}
		    	else
		    	{
		    		
		    	 int bonusMaturati;
		    	 System.out.println("Quanti bonus ha maturato? (senza euro) ");
		    	 bonusMaturati=input.nextInt();
		    	 
		    	 p= new Impiegato(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, bonusMaturati);
		    	 s.addPersonale(p);	
		    	}
		    		    	
		    	
		    	break;
		    	
		    case 2:
		    	  
		    	String nomeVolontario, indirizzoVolontario;
		    	int numeroVolontario;
		    	System.out.println("Inserire in nome del volontario da aggiungere: ");
		    	nomeVolontario=input.nextLine();
		    	
		    	if(s.findPersona(nomeVolontario)) break;
		    	
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoVolontario=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
		    	numeroVolontario=input.nextInt();		    	
		    	p = new Volontario (nomeVolontario,indirizzoVolontario,numeroVolontario);
		    	s.addPersonale(p);
		    	
		    	break;
		    	
		    case 3:
		    	
		    	System.out.println("Di chi vuoi avere le info? ");
		    	
		    	
		    	break;
		    	
		    case 4:
		    	
		    	System.out.println("Di chi vuoi sapere la paga? ");
		    	
		    	break;

 		    	
		    case 5: //non va
		    	
		    	if( s == null) {	
		    		System.out.println("Non c'� nessun gruppo/staff!");
		    		break;	    	   		    	   
		    	}		    	
		    	else
		    	{
		    	//System.out.println("lol");
		    	if(!s.isEmpty()) {
		    	   ArrayList<String> lista = new ArrayList();
		    	   lista = s.elencoPersonale();		    	   
		    	   for(String t : lista) System.out.println(t);
		    	   break;
		    	   }
		    	else {System.out.println("La lista � vuota!"); }
		    	break;
		    	}
		    	
		    case 6:
		    	uscita=false;
		    	break;
		    	
		    default:
		        System.out.println("Usare solo un carattere consentito!");
		        break;
		    
		    };
		    
		    System.out.println("");
		    System.out.println("");
		    System.out.println("");
		    
		}while(uscita);
		

	}

}