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
		
		do {
	
	// Rivisitazione menu ! 
			System.out.println("      MENU      ");
			System.out.println("Che cosa vuoi fare? ");
			System.out.println("0) Per creare un gruppo/staff: ");
			System.out.println("1) Aggiungere un dipendente: ");
			System.out.println("2) Aggiungere un volontario: ");
			System.out.println("3) Avere le info di un membro: ");
			System.out.println("4) Calcolare la paga di un membro: ");
			System.out.println("5) Elencare i membri di un gruppo di staff: ");
			System.out.println("6) Uscire dal programma. ");
			
		    scelta = input.nextInt();
		    input.nextLine();

		    switch(scelta) {
		        
		    case 1:
		    	
		    	String nomeDipendente, indirizzoDipendente;
		    	int numeroDipendente, codiceFiscale;
		    	System.out.println("Inserire in nome del dipendente da aggiungere: ");
		    	nomeDipendente=input.nextLine();
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoDipendente=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
		    	numeroDipendente=input.nextInt();
		    	System.out.println("Inserire il codice fiscale: ");
		    	codiceFiscale=input.nextInt();
		    	
		    	System.out.println("Il dipendente è giornaliero o un impiegato? ");
		    	String Opzione=input.next();
		    	if(Opzione.equals("giornaliero")) 
		    	{
		    	 
		    	 int giorniLavoro;
		    	 System.out.println("Quante giornate lavorative ha fatto? ");
		    	 giorniLavoro=input.nextInt();
		    	 
		    	 Personale p= new Giornaliero(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, giorniLavoro);
		    		
		    	}
		    	else
		    	{
		    		
		    	 int bonusMaturati;
		    	 System.out.println("Quanti bonus ha maturato? (senza euro) ");
		    	 bonusMaturati=input.nextInt();
		    	 
		    	 Personale p= new Impiegato(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, bonusMaturati);
		    		
		    	}
		    		    	
		    	
		    	break;
		    	
		    case 2:
		    	  
		    	String nomeVolontario, indirizzoVolontario;
		    	int numeroVolontario;
		    	System.out.println("Inserire in nome del volontario da aggiungere: ");
		    	nomeVolontario=input.nextLine();
		    	System.out.println("Inserire l'indirizzo: ");
		    	indirizzoVolontario=input.nextLine();
		    	System.out.println("Inserire il numero di telefono: ");
		    	numeroVolontario=input.nextInt();		    	
		    	Personale p= new Volontario (nomeVolontario,indirizzoVolontario,numeroVolontario);
		    	
		    	break;
		    	
		    case 3: //TODO: vedere se effettivamente è un membro
		    	
		    	System.out.println("Di chi vuoi avere le info? ");
		    	
		    	
		    	break;
		    	
		    case 4: //TODO: vedere se effettivamente è un membro
		    	
		    	System.out.println("Di chi vuoi sapere la paga? ");
		    	
		    	break;

		    	
		    case 5:
		    	
		    	System.out.println("Inserire il nome del gruppo staff: ");
		    	String nomeStaff=input.next();
		    	s= new Staff(nomeStaff);
		    	
		    	break;
		    	
		    case 6: //TODO: controllo dell'esistenza del membro
		    	
		    	if( s == null) { System.out.println("Non c'è nessun gruppo di staff!"); break; }
		    	
		    	System.out.println("Il membro da inserire è un volonatario o un dipendente? (v/d) " );
		    	String VD = input.next();
		    	if (VD.equals("v")) {
		    		System.out.println("Inserire in nome del volontario da aggiungere: ");
			    	nomeVolontario=input2.nextLine();
			    	System.out.println("Inserire l'indirizzo: ");
			    	indirizzoVolontario=input2.nextLine();
			    	System.out.println("Inserire il numero di telefono: ");
			    	numeroVolontario=input.nextInt();		    	
			    	Personale pe= new Volontario (nomeVolontario,indirizzoVolontario,numeroVolontario);
			    	
			    	s.addPersonale(pe);		    			    		
		    	}
		    	else { System.out.println("Il dipendente è giornaliero o impiegato? (g/i) ");
		    	
		    	String GI = input.next();
		    	
		    	if(GI.equals("g")) {
		    		
		    		System.out.println("Inserire in nome del dipendente da aggiungere: ");
			    	nomeDipendente=input2.nextLine();
			    	System.out.println("Inserire l'indirizzo: ");
			    	indirizzoDipendente=input2.nextLine();
			    	System.out.println("Inserire il numero di telefono: ");
			    	numeroDipendente=input.nextInt();
			    	System.out.println("Inserire il codice fiscale: ");
			    	codiceFiscale=input2.nextInt();
			    	System.out.println("Quante giornate lavorative ha fatto? ");
			    	int giorniLavoro=input.nextInt();
			    	Personale pe= new Giornaliero(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, giorniLavoro);
			    	
			    	s.addPersonale(pe);
		    		
		    	}
		        else {
		        	
		        	System.out.println("Inserire in nome del dipendente da aggiungere: ");
			    	nomeDipendente=input2.nextLine();
			    	System.out.println("Inserire l'indirizzo: ");
			    	indirizzoDipendente=input2.nextLine();
			    	System.out.println("Inserire il numero di telefono: ");
			    	numeroDipendente=input.nextInt();
			    	System.out.println("Inserire il codice fiscale: ");
			    	codiceFiscale=input2.nextInt();
			    	System.out.println("Quanti bonus ha maturato? (senza euro) ");
			    	int bonusMaturati=input.nextInt();
			    	Personale pe= new Impiegato(nomeDipendente, indirizzoDipendente, numeroDipendente, codiceFiscale, bonusMaturati);
			    	
		        	s.addPersonale(pe);		        	
		        }
		    	}
		    			    	
		    	break;
		    	
		    case 7:
		    	
		    	if( s == null) { System.out.println("Non c'è nessun gruppo di staff!"); break; }
		    	
		    	break;
		    	
		    case 8:
		    	
		    	if( s == null) { System.out.println("Non c'è nessun gruppo di staff!"); break; }
		    	
		    	break;
		    	
		    case 9: //non va
		    	
		    	if( s == null) { System.out.println("Non c'è nessun gruppo di staff!"); break; }
		    	   
		    	   ArrayList<String> lista = s.elencoPersonale();
		    	   
		    	   for(String t : lista) System.out.println(t);
		    	
		    	break;
		    	
		    case 10:
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
