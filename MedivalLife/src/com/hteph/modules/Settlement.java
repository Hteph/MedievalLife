package com.hteph.modules;



import java.util.ArrayList;

public class Settlement {

	private ArrayList<Home> household = new ArrayList<Home>();
	private ArrayList<Family> families= new ArrayList<Family>();
	
	String name;
	
	//constructor
	
	public Settlement(String name)
	{
		this.name =name;
	}
	
	
	//methods
	
	public void addHousehold(Home houseH)
	{
		getHousehold().add(houseH);
	}
	
	public int countHousehold()
	{
		int A=getHousehold().size();
		return A;
	}
	
	public Home getHome(int i)
	{
		Home A=getHousehold().get(i);
		return A;
	}
	
	public void addFamily(Family family){
		getFamilies().add(family);
	}


	public ArrayList<Home> getHousehold() {
		return household;
	}


	public void setHousehold(ArrayList<Home> household) {
		this.household = household;
	}


	public ArrayList<Family> getFamilies() {
		return families;
	}


	public void setFamilies(ArrayList<Family> families) {
		this.families = families;
	}
	
}
