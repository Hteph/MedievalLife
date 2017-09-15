package com.hteph.modules;

import java.util.ArrayList;

//@Entity
public class Home {

	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//int Id;

	private ArrayList<Actor> occupants = new ArrayList<Actor>();
	private String name;
	private Actor deedOwner;
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

	public void chOwner(Actor newOwner) {
		setDeedOwner(newOwner);
	}

	public void addOccupant(Actor movingIn) {
		getOccupants().add(movingIn);
		movingIn.setHome(this);

		if (!this.getName().equals("Graveyard")) {
			movingIn.getCuriculum().append(" Lives in " + this.getName() + ". ");
		}
	}

	public void remOccupant(Actor movingOut) {

		
		movingOut.setHome(null);
		getOccupants().remove(movingOut);
	}

	public String name() {
		String A = getName();
		return A;
	}

	public String listOccupants() {
		StringBuilder lista = new StringBuilder();

		for (Actor Person : getOccupants()) {
			lista.append(Person.getHtmlName() + " ");

		}

		String stringlista = lista.toString();

		return stringlista;
	}

	// calculates available workforce

	public void calcWorkForce(double year) {
		workForce = 0;
		for (Actor Person : getOccupants()) {

			double base = Math.pow((Person.getAttrArray()[1][1] + Person.getAttrArray()[2][1] * 2) / 33, 2);

			double childCare = Math.min(120 - Person.qAge(year) * 20, 0);

			workForce += base * 270 - childCare;

		}
	}

	public void useWorkForce(double Used) {
		workForce -= Used;
	}

	public double getWorkForce() {
		double A = workForce;

		return A;
	}

	public ArrayList<Actor> getOccupants() {

		// escaping reference, but this is used in methods designed to manipulating the
		// occupation situation ... so it is OK i think...
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

	public Actor getDeedOwner() {
		return deedOwner;
	}

	public void setDeedOwner(Actor deedOwner) {
		this.deedOwner = deedOwner;
	}

}
