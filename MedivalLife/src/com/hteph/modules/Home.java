package com.hteph.modules;

import java.util.ArrayList;

public class Home {
	ArrayList<Actor> occupants = new ArrayList<Actor>();
	ArrayList<Buildings> buildings = new ArrayList<Buildings>();
	ArrayList<Field> farmFields = new ArrayList<Field>();
	  String name;
	  Actor deedOwner;
	  double workForce;
	   
	 //constructor
	  public Home(String name, Actor builder)
	  {
	      this.name=name;
	      this.deedOwner=builder;
	  }
	       
	      //methods
	       
	      public void addBuilding(Buildings type)
	      {
	          buildings.add(type);
	      }
	       
	     public void chOwner(Actor newOwner)
	     {
	         deedOwner=newOwner;
	     }
	          
	     public void addOccupant(Actor movingIn)
	     {
	         occupants.add(movingIn);
	         movingIn.home=this;
	         

	        if(!this.name.equals("Graveyard")){movingIn.curiculum.append(" Lives in "+this.name+". ");}
	     }
	     
	     public void remOccupant(Actor movingOut)
	     {
	    	 
	    	 int A=occupants.indexOf(movingOut);
	    	 movingOut.home=null;
	    	 occupants.remove(A);
	     }
	     
	     public String name()
	     {
	    	 String A=name;
	    	 return A;
	     }
	     
	     public String listOccupants()
	     {
	    	 StringBuilder lista =new StringBuilder();
	    		
	    	 for(Actor Person : occupants)
	    	 {	
	    		 lista.append(Person.name+" ");

	    	 }
	    	 
	    	 String stringlista=lista.toString();
	    	 
	    	 return stringlista;
	     }
	     
//calculates available workforce
	     
	     public void calcWorkForce (double year)
	     {
	    	 	workForce=0;
	    	for(Actor Person:occupants){
	    		
	    	
	    		
	    		double base=Math.pow((Person.attrArray[1][1]+Person.attrArray[2][1]*2)/33,2);
	    		
	    		double childCare=Math.min(120-Person.qAge(year)*20,0);
	    		
	    		workForce+=base*270-childCare;
	    		
	    	}
	     }
	     
	     public void chWorkForce(double Used)
	     {
	    	 workForce-=Used;
	     }
	     
	     public double getWorkForce()
	     {
	    	 double A=workForce;
	    	 
	    	 return A;
	     }
	     
}
