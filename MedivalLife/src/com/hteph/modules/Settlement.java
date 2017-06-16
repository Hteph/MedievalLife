package com.hteph.modules;



import java.util.ArrayList;

public class Settlement {

	ArrayList<Home> household = new ArrayList<Home>();
	ArrayList<Family> families= new ArrayList<Family>();
	
	String name;
	
	//constructor
	
	public Settlement(String name)
	{
		this.name =name;
	}
	
	
	//methods
	
	public void addHousehold(Home houseH)
	{
		household.add(houseH);
	}
	
	public int countHousehold()
	{
		int A=household.size();
		return A;
	}
	
	public Home getHome(int i)
	{
		Home A=household.get(i);
		return A;
	}
	
	public void addFamily(Family family){
		families.add(family);
	}
	
}
