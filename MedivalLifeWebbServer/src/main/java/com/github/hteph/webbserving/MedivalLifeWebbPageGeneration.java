package com.github.hteph.webbserving;

import java.util.ArrayList;

import com.hteph.MedievalLife.CountingTheDays;
import com.hteph.modules.Actor;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;
import com.hteph.utilities.Gedcom;
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
		Village.setFounder(Pop.getHtmlName());

		Village.addHousehold(Graveyard);
		Village.addHousehold(Camp);

		Camp.addOccupant(Pop);

		// Simulation!!

		CountingTheDays.simulation(yearsToSimulate, Village);

		// Simulation end, compiling text

		Village.setChronicle(createChronicle(Village).toString());

		return Village;

	}

	private static StringBuilder createChronicle(Settlement Village) {
		StringBuilder chronicle = new StringBuilder();
		
		chronicle.append("<!DOCTYPE html><html lang='en'><head>");
		chronicle.append("<link rel='stylesheet' href='resources/css/medievalStyle.css'>");
		chronicle.append("<title>A Medieval Heritage Tree</title></head><body>");
		chronicle.append("<header><h1>A Medieval Heritage Tree</h1>");
		chronicle.append("<span class='subtitle'>In the year of " + (int) Village.getFoundingYear() + " " + Village.getFounder()
				+ " took to the woods to start a new life as his own man.");
		chronicle.append("This is his clan at the year of " + (int)Village.getCurrentYear()+"</span></header>");

		for (Home HouseH : Village.getHousehold()) {

			int sizeOfHouse = HouseH.getOccupants().size();
			
			System.out.println("household:"+sizeOfHouse);
			
			if (sizeOfHouse > 0) {

				ArrayList<Actor> census = new ArrayList<Actor>();
				census.addAll(HouseH.getOccupants());

				chronicle.append("<h2>At " + HouseH.getName() + "</h2>");
				chronicle.append("<section class='household' id='"+HouseH.getName()+"'>");

				for (Actor Person : census) {

					if (Person.isAlive()) {
						chronicle.append("<header class='living person'><h3 id='id"+Person.qNumber()+"'>"+Person.getName() + "</h3><p class='factoid'> (" + Person.qSex() + ")(" + (int) Person.getBirthYear() + "- "
								+ ")</p></header>");
					} else {
						chronicle.append("<header class='dead person'><h3 id='id"+Person.qNumber()+"'>"+Person.getHtmlName() + "</h3><p class='factoid'>(" + (int) Person.getBirthYear() + "- "
								+ (int) Person.getDeathYear() + ")</p></header>");
					}
					chronicle.append("<article class='chronicletext'>"+Person.getCuriculum().toString());

					if (Person.getKenning().size() > 0 && Person.isAlive()) {

						chronicle.append("<p class='kenning'>(aka: " + Person.getKenning().toString() + ")</p>");

					}
					chronicle.append("</article>");


				}
				
				chronicle.append("</section>");
			}
			
			
		}
		//chronicle.append(Gedcom.writer(Village));
		chronicle.append("<aside id='utilities'> <button type='button'>Readability</button></aside>");
		
		chronicle.append("</body></html>");
		return chronicle;
	}

}
