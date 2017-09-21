package com.hteph.modules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class Home {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//int Id;

	private Set<Integer> occupants = new HashSet<>();
	private String name;
	private int deedOwner;
	private double workForce;

	// constructor

	public Home() {
		// for persistence
	}

	public Home(String name, Actor builder) {
		this.setName(name);
		this.setDeedOwner(builder);
	}

	// methods

	public void changeOwner(Actor newOwner) {
		setDeedOwner(newOwner);
	}

	public void addOccupant(Actor movingIn) {
		
		occupants.add(movingIn.getId());
		
		System.out.println("living in "+name+" now:"+occupants.size());
		movingIn.setHome(this);

		if (!this.getName().equals("Graveyard")) {
			movingIn.getCuriculum().append("<span> Moved into " + this.getName() + ".</span> ");
		}
	}

	public void remOccupant(Actor movingOut) {
	
		movingOut.setHome(null);
		occupants.remove(movingOut.getId());
		System.out.println("living in "+name+" now:"+occupants.size());
	}

//	public String name() {
//		String A = getName();
//		return A;
//	}

	public String listOccupants() {
		
		StringBuilder lista = new StringBuilder();

		int i=0;
		for (Actor Person : getOccupants()) {
			
			lista.append(Person.getHtmlName() + " ");
			i++;
		}

		String stringlista = lista.toString();
		
		return stringlista;
	}

	// calculates available workforce

//	public void calcWorkForce(double year) {
//		
//		workForce = 0;
//		for (Actor Person : getOccupants()) {
//			//TODO This needs some real attention!! Workforce should perhaps have an attribute that could change due to other obligations
//			
//			double base=0;
//			
//			try {
//				base = Math.pow((Person.getAttrArray()[1][1] + Person.getAttrArray()[2][1] * 2) / 33, 2);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println(this.listOccupants());
//				e.printStackTrace();
//			}
//
//			double childCare = Math.min(120 - Person.qAge(year) * 20, 0);
//
//			workForce += base * 270 - childCare;
//
//		}
//	}

	public void useWorkForce(double Used) {
		
		workForce -= Used;
		
	}

	public double getWorkForce() {
		
		double A = workForce;
		return A;
	}

	public ArrayList<Actor> getOccupants() {

		ArrayList<Actor> occupantslist = new ArrayList<>();
		
		for(int person:occupants) {
			
			System.out.println("id:" + person);
			
			occupantslist.add(Settlement.getSomeone(person));
		}
		return occupantslist;
	}

	public void setOccupants(ArrayList<Actor> occupants) {
		
		for(Actor person:occupants) {
			
			addOccupant(person);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Actor getDeedOwner() {
		return Settlement.getSomeone(deedOwner);
	}

	public void setDeedOwner(Actor deedOwner) {
		this.deedOwner = deedOwner.getId();
	}

}
