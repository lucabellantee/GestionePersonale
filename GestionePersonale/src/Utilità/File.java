/*
   Questa classe serve a gestire la fase di scrittura o di log del programma
 */




package Utilità;
import Istituzione.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class File {
	
	String nomeFile;
	
	
	public File(String nomeFile) 
	{
		this.nomeFile = nomeFile;
	}
	
	
	
	
	public String getNome() { return this.nomeFile; }
	
	
	
	
	public boolean ScriviSuFile(Staff s) 
	{
		try {
	  		  PrintWriter file_output = new PrintWriter ( new BufferedWriter (new FileWriter (this.nomeFile,true)));
	  		  
	  		  if(s == null) return false ; 
	  		  
	  	    	if(!s.isEmpty()) {
	  	    	       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	  	    	       LocalDate localDate = LocalDate.now();
	  	    	       file_output.println( "NOME TEAM: "+ "             " + s.getNome() +"             " + dtf.format(localDate));
	  		    	   ArrayList<String> lista = new ArrayList();
	  		    	   lista = s.elencoPersonale();	
	  		    	   System.out.println();
	  		    	   for(String t : lista) file_output.println(t);
	  		    	   file_output.println(" ");
	  		    	   file_output.println(" ");
	  		    	   file_output.println(" ");
	  		    	   file_output.close();
	  		    	   return true;
	  		    	   }
	  	    	else return false;
	  	    }
	  	
	  	catch(IOException e) 
	  	   {
	  		  System.out.println("ERRORE NEL LOG DEL SISTEMA");
	  	   }
		return false;
	}

}
