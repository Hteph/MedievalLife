package com.hteph.modules;

import java.util.ArrayList;

public class Home {
	private ArrayList<Actor> occupants = new ArrayList<Actor>();
	ArrayList<Buildings> buildings = new ArrayList<Buildings>();
	ArrayList<Field> farmFields = new ArrayList<Field>();
	  private String name;
	  Actor deedOwner;
	  double workForce;
	   
	 //constructor
	  public Home(String name, Actor builder)
	  {
	      this.setName(name);
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
	         getOccupants().add(movingIn);
	         movingIn.home=this;
	         

	        if(!this.getName().equals("Graveyard")){movingIn.getCuriculum().append(" Lives in "+this.getName()+". ");}
	     }
	     
	     public void remOccupant(Actor movingOut)
	     {
	    	 
	    	 int A=getOccupants().indexOf(movingOut);
	    	 movingOut.home=null;
	    	 getOccupants().remove(A);
	     }
	     
	     public String name()
	     {
	    	 String A=getName();
	    	 return A;
	     }
	     
	     public String listOccupants()
	     {
	    	 StringBuilder lista =new StringBuilder();
	    		
	    	 for(Actor Person : getOccupants())
	    	 {	
	    		 lista.append(Person.getName()+" ");

	    	 }
	    	 
	    	 String stringlista=lista.toString();
	    	 
	    	 return stringlista;
	     }
	     
//calculates available workforce
	     
	     public void calcWorkForce (double year)
	     {
	    	 	workForce=0;
	    	for(Actor Person:getOccupants()){
	    		
	    	
	    		
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

		public ArrayList<Actor> getOccupants() {
			return occupants;
		}

		public void setOccupants(ArrayList<Actor> occupants) {
			this.occupants = occupants;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	     
}
