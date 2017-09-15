package com.hteph.modules;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.hteph.MedievalLife.ImpConstant;

public class Trait{
 
	int nrOfAttr=ImpConstant.nrOfAttr;
	
	double [][] traitArray = new double[nrOfAttr][2];
	String name;
	String description;
	
	
	public Trait(String traitName){
		
		String filePath = "traitsList.txt";
		 
		try {
		    BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
		    String lineText = null;
		    Scanner scan =new Scanner(lineText);
		    
		    boolean foundIt=false;
		    
		    while ((lineText = lineReader.readLine()) != null && !foundIt) {
		    	
		    	
		    	String header = scan.next();
		    	
		    	if(header.equals("add"+traitName)){
		    		foundIt=true;
		    		name=header;
		    		
		    		// read add statline
		    		for(int i=0;i<nrOfAttr;i++){traitArray[i][0]=scan.nextInt();}
		    		
		    		description=scan.next();
		    		
		    		lineText=lineReader.readLine();
		    		
		    		//read remove statline
		    		for(int i=0;i<nrOfAttr;i++){traitArray[i][1]=scan.nextInt();}
		    		
		    	}
		    	
		    	
		    }
		    scan.close();
		    lineReader.close();
		} catch (IOException ex) {
		    System.err.println(ex);
		}

		
	
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*     
     
     
     //method    
      
void applyTrait(String trait)
        {
            switch(trait)
            {
            case "traitname":
                //loop through addTrait-vector and apply to attrArray
                // add trait to ArrayList in Person
            }
                 
            void removeTrait(Actor Person Strin trait){
            	// opposite above, loop through removeTrait-vector etc        
           

*/
}
