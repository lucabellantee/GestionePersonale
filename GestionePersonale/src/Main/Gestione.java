package Main;

import Istituzione.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Gestione {

	public static void main(String[] args) throws IOException {
	
		int scelta;
		boolean uscita=true;
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		Staff s = null;
		Personale p= null;
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
			
		    scelta = input.nextInt();
		    input.nextLine();

		    switch(scelta) {
		    
            case 0:
		    	
		    	System.out.println("Inserire il nome del gruppo staff: ");
		    	String nomeStaff=input.nextLine();
		    	s= new Staff(nomeStaff);
		    	
		    	break;
		        
		    case 1:
		    	
		    	if (s==null) { System.out.println("Prima devi creare un gruppo/staff! "); break;}
		    	
		    	String nomeDipendente, indirizzoDipendente;
		    	int numeroDipendente = 0;
		    	String codiceFiscale;
		    	System.out.println("Inserire in nome del dipendente da aggiungere: ");
		    	nomeDipendente=input.nextLine();
// TODO LUCA : Eccezione personalizzata , il nome non puo essere composto da interi , tutto il resto si !
		    	if(s.findPersona(nomeDipendente)) break;
		    	
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoDipendente=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
		    	
				boolean sentinella;
				do {
		    	 sentinella = true;
		    	try {
		    	      numeroDipendente=input.nextInt();
		    	    }
		    	catch(InputMismatchException e) 
		    	    {
		    		   input.nextLine();
		    		   System.out.println("Inserire un numero di telefono valido");
		    		   sentinella = false; 
		    	    }
		      }while(!sentinella);
				
				
		    	System.out.println("Inserire il codice fiscale: ");
		    	codiceFiscale=input2.nextLine();
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
		    	int numeroVolontario=0;
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
		    	      numeroDipendente=input.nextInt();
		    	    }
		    	catch(InputMismatchException e) 
		    	    {
		    		   input.nextLine();
		    		   System.out.println("Inserire un numero di telefono valido");
		    		   sentinella = false; 
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
		    	try {
		  		  PrintWriter file_output = new PrintWriter ( new BufferedWriter (new FileWriter ("log.txt",true)));
		  		  
		  		  if(s == null) { uscita = false; break;  } 
		  		  
		  	    	if(!s.isEmpty()) {
		  	    	       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		  	    	       LocalDate localDate = LocalDate.now();
		  	    	       file_output.println("                      " + dtf.format(localDate));
		  		    	   ArrayList<String> lista = new ArrayList();
		  		    	   lista = s.elencoPersonale();	
		  		    	   System.out.println();
		  		    	   for(String t : lista) file_output.println(t);
		  		    	   file_output.println(" ");
		  		    	   file_output.println(" ");
		  		    	   file_output.println(" ");
		  		    	   file_output.close();
		  		    	   }
		  	    	else System.out.println("La lista è vuota o non è stata generata ! ");
		  	    }
		  	
		  	catch(IOException e) 
		  	   {
		  		  System.out.println("ERRORE NEL LOG DEL SISTEMA");
		  	   }
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