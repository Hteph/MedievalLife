package com.github.hteph.webbserving;

import com.hteph.MedievalLife.CountingTheDays;
import com.hteph.modules.Actor;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;
import com.hteph.utilities.NameGenerator;

public class MedivalLifeWebbPageGeneration {

	static Settlement Village;

	public static Settlement generate() {

		int startingYear = 1000;
		int yearsToSimulate = 50 + (int) (Math.random() * 50);

		// Namegenerator
		NameGenerator RandName = new NameGenerator();

		// Create a Village list of households
		Village = new Settlement("Village",startingYear);

		// The heritage of the first Settlers
		Actor grandMomPop = new Actor(RandName.compose(3), "Female", startingYear-40);
		Actor grandFatherPop = new Actor(RandName.compose(3), "Male", startingYear-40);
		
		Home Farawayplace = new Home("Distant Town", grandFatherPop);
		Farawayplace.addOccupant(grandMomPop);

		Actor Pop = new Actor(RandName.compose(3), "Male", startingYear);

		Pop.setFather(grandFatherPop);
		Pop.setMother(grandMomPop);

		// The starting households
		Home Graveyard = new Home("Graveyard", Pop);
		Home Camp = new Home("Camp", Pop);
		Village.setFounder(Pop.getName());
		Settlement.addPopulation(Pop);
		Village.addHousehold(Graveyard);
		Village.addHousehold(Camp);

		Camp.addOccupant(Pop);

		// Simulation!!

		CountingTheDays.simulation(yearsToSimulate, Village);

		// Simulation end, compiling text



		return Village;

	}



}
