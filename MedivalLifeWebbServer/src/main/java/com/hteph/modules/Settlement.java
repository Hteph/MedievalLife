package com.hteph.modules;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//@Entity
@XmlRootElement
public class Settlement {
	
//	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//int Id;

	private ArrayList<Home> household = new ArrayList<Home>();

	private ArrayList<Family> families= new ArrayList<Family>();
	
	public static Map<Integer,Actor> population = new HashMap<>();
 	
	private String name;
	private double foundingYear;
	private double currentYear;
	private String founder;
	private String chronicle;
	
	//constructor
	
	public Settlement() {
		//for persistence
	}
	
	public Settlement(String name, double foundingYear)
	{
		this.name =name;
		this.foundingYear = foundingYear;
		this.currentYear = foundingYear;
	}
	
	
	//methods
	
	public void addPopulation(int id, Actor someone) {
		Settlement.population.put(someone.qNumber(), someone);
		
	}
	
	public Actor getSomeone(int id) {
		
		return population.get(id);
	}
	
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

//	public int getId() {
//		return Id;
//	}
//
//	public void setId(int id) {
//		Id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChronicle() {
		return chronicle;
	}

	public void setChronicle(String chronicle) {
		this.chronicle = chronicle;
	}

	public double getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(double foundingYear) {
		this.foundingYear = foundingYear;
	}

	public double getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(double currentYear) {
		this.currentYear = currentYear;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public Map<Integer, Actor> getPopulation() {
		
		
		//TODO Escaping reference!!
		return population;
	}

	public void setPopulation(Map<Integer, Actor> population) {
		Settlement.population = population;
	}
	
}
