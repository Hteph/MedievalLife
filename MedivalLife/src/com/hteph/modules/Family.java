package com.hteph.modules;
import java.util.ArrayList;

public class Family {

	

	private Actor husb;
	private Actor wife;
	private ArrayList<Actor> chil= new ArrayList<Actor>();
	double marriageDate;
	
//constructor
	public Family( Actor one, Actor another, double year){
		
		if (one.qSex().equals("Male")){
		setHusb(one);
		setWife(another);
		}else{
			setHusb(another);
			setWife(one);	
		}
		
		
	}
	
	
	
	
//methods
	public String getGedcom(int nummer){ //the output function
		
		String A="0 @"+nummer+"@ FAM<br />1 HUSB @"+getHusb().qNumber()+"@ <br />2 WIFE @"+getWife().qNumber()+"@ <br />";
		
		for(int i=0;i<getChil().size();i++){
			int n=3+i;
			
			A+=n+" CHIL @"+getChil().get(i).qNumber()+"@<br />";
		}
		
		return A;
	}
	
	
	public void addChild(Actor child){
		getChil().add(child);
	}




	public ArrayList<Actor> getChil() {
		return chil;
	}




	public void setChil(ArrayList<Actor> chil) {
		this.chil = chil;
	}




	public Actor getHusb() {
		return husb;
	}




	public void setHusb(Actor husb) {
		this.husb = husb;
	}




	public Actor getWife() {
		return wife;
	}




	public void setWife(Actor wife) {
		this.wife = wife;
	}
	
}
