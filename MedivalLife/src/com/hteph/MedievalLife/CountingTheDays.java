package com.hteph.MedievalLife;
import java.util.ArrayList;

import com.hteph.modules.Actor;
import com.hteph.modules.Home;
import com.hteph.modules.Passions;
import com.hteph.modules.Settlement;

public class CountingTheDays {

	static void simulation(int yearsToSimulate, int startingYear, Settlement village){
	for(int year=startingYear; year < startingYear+yearsToSimulate;year++)
	{			
		System.out.println(year);
		
		for(Home HouseH : village.getHousehold())
		{
			if(HouseH.getName()!="Graveyard")
			{
				int sizeOfHouse=HouseH.getOccupants().size();
				if(sizeOfHouse>0)
				{
				HouseH.calcWorkForce(year);
				System.out.println(HouseH.getWorkForce());

					ArrayList<Actor> census=new ArrayList<Actor>();
					census.addAll(HouseH.getOccupants());

					for(Actor Person :census)
					{
						ComingOfAge.countingTheDays(Person,year);

						Passions.VirtueKenning(Person, year);
						
						Person.DeathCheck(village,year);

						Person.gettingChild(year);

						Person.getApartner(year, village);

						

					}
				}
			}
		}

	}
	
}
}
