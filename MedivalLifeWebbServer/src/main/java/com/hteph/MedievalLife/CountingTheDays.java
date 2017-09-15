package com.hteph.MedievalLife;

import java.util.ArrayList;

import com.hteph.modules.Actor;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;

public class CountingTheDays {

	public static void simulation(int yearsToSimulate, Settlement village) {

		double endYear = village.getCurrentYear() + yearsToSimulate;
		
		double startYear = village.getCurrentYear();

		for (double year= startYear ; year < endYear; year++) {

			village.setCurrentYear(year);
			


			for (Home HouseH : village.getHousehold()) {

				if (HouseH.getName() != "Graveyard") { // The graveyard is inert ... for now ...
					
					int sizeOfHouse = HouseH.getOccupants().size();
					
					if (sizeOfHouse > 0) {
						
						HouseH.calcWorkForce(year);

						ArrayList<Actor> census = new ArrayList<Actor>();

						census.addAll(HouseH.getOccupants());

						for (Actor Person : census) {
							
							ComingOfAge.countingTheDays(Person, year);

							Passions.VirtueKenning(Person, year);

							Person.DeathCheck(village); // Did they die? In that case move to Graveyard

							Person.gettingChild(year); //TODO if a child dies rigth after birth it is not buried if the simulation ends that year!
														// resulting in an erronous existence in house and death date of -1 displayed!
							Person.getApartner(year, village);

						}
					}
				}
			}
		}
	}
}
