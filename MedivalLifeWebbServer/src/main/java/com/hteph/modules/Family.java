package com.hteph.modules;

import java.util.ArrayList;

//@Entity
public class Family {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	int Id;


	double marriageDate;
	
	ArrayList<Integer> children = new ArrayList<>();
	int husband;
	int wife;


	// constructor

	public Family() {
		// for persistence
	}

	public Family(Actor one, Actor another, double year) {

		if (one.qSex().equals("Male")) {
			setHusband(one);
			setWife(another);
		} else {
			setHusband(another);
			setWife(one);
		}

	}

	// methods
	public String getGedcom(int nummer) { // the output function

		String A = "0 @" + nummer + "@ FAM<br />1 HUSB @" + husband + "@ <br />2 WIFE @"+ wife + "@ <br />";

		for (int i = 0; i < children.size(); i++) {
			int n = 3 + i;

			A += n + " CHIL @" + children.get(i) + "@<br />";
		}

		return A;
	}

	public void addChild(Actor child) {
		System.out.println("Adding child:" + child.toString());
		children.add(child.getId());
	}

	public double getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(double marriageDate) {
		this.marriageDate = marriageDate;
	}

	public ArrayList<Actor> getChildren() {
		
		
		ArrayList<Actor> list = new ArrayList<>();
		
		for(int person:children) {
			
			list.add(Settlement.getSomeone(person));
		}
		return list;
	}

	public void setChildren(ArrayList<Integer> children) {
		this.children = children;
	}

	public Actor getHusband() {
		return Settlement.getSomeone(husband);
	}

	public void setHusband(Actor husband) {
		
		this.husband = husband.getId();
	}

	public void setWife(Actor wife) {
		this.wife = wife.getId();
	}

	public Actor getWife() {
		return Settlement.getSomeone(wife);
	}

}
