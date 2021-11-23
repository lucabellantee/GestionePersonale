package Main;

import Istituzione.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import Eccezzioni.CodiceFiscaleException;
import Utilità.*;
import Utilità.File;


public class Gestione {

	public static void main(String[] args) throws IOException , CodiceFiscaleException{
	
		int scelta = -1;
		long numeroVolontario = 0 , numeroDipendente = 0 ;
		boolean uscita=true , booLog;
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		Staff s = null;
		Personale p= null;
		
		File fileLog = new File("log.txt");
		
		
		do {
	
			System.out.println("      MENU      ");
			System.out.println("Che cosa vuoi fare? ");
			System.out.println("0) Per creare un gruppo/staff: ");
			System.out.println("1) Aggiungere un dipendente: ");
			System.out.println("2) Aggiungere un volontario: "); 
			System.out.println("3) Rimuovere un membro dello staff: ");
			System.out.println("4) Avere tutte le info di un membro: ");
			System.out.println("5) Elencare i membri di un gruppo di staff: ");
			System.out.println("6) Uscire dal programma e salvare su file ");

		  
		  boolean controllo;
		  do {   
			  controllo = true;
		      try {
		    	  scelta = input.nextInt();;
		          }
		     catch(InputMismatchException ie) 
		          {
		    	    input.nextLine();
			        System.out.println("Non puoi inserire caratteri !");
			        controllo = false;
		          }
		     }while(!controllo);
		   
		    if(s == null) booLog = false;
		       else booLog = true;
		    
		    switch(scelta) {
		    
            case 0:
		    if(booLog)	
            	if(fileLog.ScriviSuFile(s)) System.out.println("Salvataggio , effettuato, pronto per un nuovo staff !");
		    	  else System.out.println(" ERRORE ! Qualcosa è andato storto durante il salvataggio !"); 
		    	
		        input.nextLine();
		        
		        System.out.println("Inserire il nome del gruppo staff: ");
		    	String nomeStaff=input.nextLine();
		    	s= new Staff(nomeStaff);
		    	
		    	break;
		        
		    case 1:
		    	
		    	if (s==null) { System.out.println("Prima devi creare un gruppo/staff! "); break;}
		    	
		    	String nomeDipendente, indirizzoDipendente;
		    	String codiceFiscale = null;
		    	System.out.println("Inserire in nome del dipendente da aggiungere: ");
		    	nomeDipendente=input.nextLine();
		    	if(s.findPersona(nomeDipendente)) break;
		    	
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoDipendente=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
		    	
				boolean sentinella;
				do {
		    	 sentinella = true;
		    	try {
		    	      numeroDipendente = input.nextLong();
		    	    }
		    	catch(InputMismatchException e) 
		    	    {
		    		   input.nextLine();
		    		   System.out.println("Inserire un numero di telefono valido");
		    		   sentinella = false; 
		    	    }
		      }while(!sentinella);
				
				
		    	System.out.println("Inserire il codice fiscale: ");
		     	
		       Check c = new Check();		       
		       boolean condizione;
		       do{
			      condizione = true;
		       try {	
		    	    codiceFiscale=input2.next();
		    	   if(!c.checkLettersCodiceFiscale(codiceFiscale) || !c.checkNumberCodiceFiscale(codiceFiscale))
		    	      throw new CodiceFiscaleException();
		           }
		       catch(CodiceFiscaleException cfe) 
		           {
		    	     condizione = false;
		    	     System.out.println(cfe);
		    	     System.out.println("Digita di nuovo il codice ma stai più attento !");
		           }
		     }while(!condizione);
		   
		       System.out.println("Il dipendente è giornaliero o un impiegato? ");
		    	String Opzione = input.next();
	
		    	if(Opzione.equals("giornaliero")) 
		    	{
		    	 
		    	 int giorniLavoro;
		    	 System.out.println("Quante giornate lavorative ha fatto? ");
		    	 giorniLavoro=input.nextInt();
		    	 
		    	 p= new Giornaliero(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, giorniLavoro);
		    	 s.addPersonale(p);
		    	 
		    	}
		    	else if(Opzione.equals("impiegato"))
		    	{
		    		
		    	 int bonusMaturati;
		    	 System.out.println("Quanti bonus ha maturato? (senza euro) ");
		    	 bonusMaturati=input.nextInt();
		    	 
		    	 p= new Impiegato(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, bonusMaturati);
		    	 s.addPersonale(p);	
		    	}
		        
		    	else System.out.println("Tipologia di personale non riconosciuta");
		    	
		    	break;
		    	
		    case 2:
		    	
		    	if (s==null) { System.out.println("Prima devi creare un gruppo/staff! "); break;}
		    	  
		    	String nomeVolontario, indirizzoVolontario;
		        
		    	input.nextLine();
		    	System.out.println("Inserire in nome del volontario da aggiungere: ");
		    	nomeVolontario=input.nextLine();
		    	
		    	if(s.findPersona(nomeVolontario)) break;
		    	
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoVolontario=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
				boolean sentinellaa;
				do {
		    	 sentinellaa = true;
		    	try {
		    	      numeroVolontario=input.nextLong();
		    	    }
		    	catch(InputMismatchException e) 
		    	    {
		    		   input.nextLine();
		    		   System.out.println("Inserire un numero di telefono valido");
		    		   sentinellaa = false; 
		    	    }
		      }while(!sentinellaa);
				
		    	p = new Volontario (nomeVolontario,indirizzoVolontario,numeroVolontario);
		    	s.addPersonale(p);
		    	
		    	break;
		    	
		    case 3:
		    	
		    	if (s==null) { System.out.println("Prima devi creare un gruppo/staff! "); break;}
		    	if (s.isEmpty()) { System.out.println("La lista è vuota!"); break; }
		    	
		    	System.out.println("Chi vuoi rimuovere? ");
		    	String nomeDaRimuovere = input.nextLine();
		    	
		    	if(s.removePersonale(nomeDaRimuovere)) 
		    	{ 		    		
		    	 System.out.println( nomeDaRimuovere + " è stato rimosso dallo staff ");		    		
		    	}
		    	else 
		    	{		    	
		    	System.out.println( nomeDaRimuovere + " non è presente nello staff"); 		    		
		    	}
		    	break;
		    	
		    case 4:
		    	
		    	if (s==null) { System.out.println("Prima devi creare un gruppo/staff! "); break;}
		    	if (s.isEmpty()) { System.out.println("La lista è vuota!"); break; }
		    	
		    	System.out.println("Di chi vuoi avere le info? ");
		    	String nomeInfo = input.nextLine();
		    	
		    	if(s.findPersona(nomeInfo))
		    	{
		    		System.out.println(s.infoPersona(nomeInfo));
		    				    	  
		    		
		    	} 
		    	else { System.out.println( nomeInfo + " non è presente nello staff"); }
		    	
		    	break;

 		    	
		    case 5: 
		    	
		    	if (s==null) { System.out.println("Prima devi creare un gruppo/staff! "); break;}		    	
		    	else
		    	{
		    	//System.out.println("lol");
		    	if(!s.isEmpty()) {
		    	   ArrayList<String> lista = new ArrayList();
		    	   lista = s.elencoPersonale();		    	   
		    	   for(String t : lista) System.out.println(t);
		    	   break;
		    	   }
		    	else {System.out.println("La lista è vuota!"); }
		    	break;
		    	}
		    	
		    case 6:
		    	   if(fileLog.ScriviSuFile(s)) System.out.println("Salvataggio avvenuto con successo !");
		    	     else System.out.println(" ERRORE ! Qualcosa è andato storto durante il salvataggio !");
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