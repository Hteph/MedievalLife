import java.util.ArrayList;

public class CountingTheDays {

	static void simulation(int yearsToSimulate, int startingYear, Settlement village){
	for(int year=startingYear; year < startingYear+yearsToSimulate;year++)
	{			
		System.out.println(year);
		
		for(Home HouseH : village.household)
		{
			if(HouseH.name!="Graveyard")
			{
				int sizeOfHouse=HouseH.occupants.size();
				if(sizeOfHouse>0)
				{
				HouseH.calcWorkForce(year);
				System.out.println(HouseH.getWorkForce());

					ArrayList<Actor> census=new ArrayList<Actor>();
					census.addAll(HouseH.occupants);

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
