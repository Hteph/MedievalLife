package com.hteph.utilities;


public class Dice {
	
	// standard d6
	
	    public static int d6()
	    {
	        return 1+(int)(Math.random()*6);
	    }

	    
//test of attribute
	    public static String testD100attr(double attribute) 
	    {
	    	int ental=(int) (Math.random()*10); // 0 - 9 is wanted
	    	int tiotal=(int)(Math.random()*10);
	    	int fate=ental+tiotal*10;
	    	
	    	String result;
	    	double testVal=Math.min(99, Math.max(0, attribute*5));
	    		
	    	if(ental==tiotal){

	    		if(fate>testVal){result="CF";}
	    		else {result="CS";}
	    		return result;
	    	}
         
	    	if(fate>testVal){result="F";}
	    	else {result="S"+tiotal;}
    
	    	return result;   
	    }
	    
	 // standard d100   
	    public static int d100() 
	    {
	    	int fate=1+(int) Math.random()*100;
	    	return fate;
	    }
	    
	    //test of general percentage
	    
	    public static String testD100(double percentage) 
	    {
	    	int ental=(int) (Math.random()*10); // 0 - 9 is wanted
	    	int tiotal=(int)(Math.random()*10);
	    	int fate=ental+tiotal*10;
	    	
	    	String result;
	    	double testVal=Math.min(99, Math.max(0, percentage));
	    		
	    	if(ental==tiotal){

	    		if(fate>testVal){result="CF";}
	    		else {result="CS";}
	    		return result;
	    	}
         
	    	if(fate>testVal){result="F";}
	    	else {result="S"+tiotal;}
    
	    	return result;   
	    }
	    
	    
}
