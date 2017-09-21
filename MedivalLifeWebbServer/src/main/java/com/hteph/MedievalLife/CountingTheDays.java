package com.hteph.MedievalLife;

import java.util.ArrayList;

import com.hteph.modules.Actor;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;
import com.hteph.utilities.Chronicler;

public class CountingTheDays {

	public static void simulation(int yearsToSimulate, Settlement village) {

		double endYear = village.getCurrentYear() + yearsToSimulate;		
		double startYear = village.getCurrentYear();

		// simulation loop!

		for (double year= startYear ; year < endYear; year++) {

			village.setCurrentYear(year);

			for (Home HouseH : village.getHousehold()) {
				
				System.out.println("Now running:"+HouseH.getName());

				if (HouseH.getOccupants().size() > 0 && HouseH.getName() != "Graveyard") {

					//	HouseH.calcWorkForce(year); //TODO currently not used for anything

					ArrayList<Actor> census = new ArrayList<>();				
					
					census.addAll(HouseH.getOccupants());
					
					System.out.println("size of household: "+census.size());

					for (Actor Person : census) {
						
						System.out.println("Cencus of "+ Person.getName());
			
						ComingOfAge.theWeightOfTheYears(Person, year);

						Passions.VirtueKenning(Person, year);

						Person.DeathCheck(village); // Did they die? In that case move to Graveyard

						Person.gettingChild(year); //TODO if a child dies right after birth it is not buried if the simulation ends that year!
						// resulting in an erronous existence in house and death date of -1 displayed!
						Person.getApartner(year, village);
						
						

					}
				}
			}
		}
		
		village.setChronicle(Chronicler.createChronicle(village));
	}
}

