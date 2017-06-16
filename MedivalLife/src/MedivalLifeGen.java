
import java.util.ArrayList;




public class MedivalLifeGen {

	/**
	 * 
	 */
	

	public static void main(String[] args) {

 System.out.println("test");
		//Namegenerator

		int startingYear = 1000;
		int yearsToSimulate = 50+(int)(Math.random()*50);
		
		NameGenerator RandName = new NameGenerator();


		//Create a Village list of households
		Settlement Village=new Settlement("Village");

		//The first Settlers
		Actor grandMomPop=new Actor(RandName.compose(3), startingYear, "Male");
		Actor grandFatherPop=new Actor(RandName.compose(3), startingYear, "Male");
		Home Farawayplace =new Home("Distant Town", grandFatherPop);
		Farawayplace.addOccupant(grandMomPop);
		
		Actor Pop=new Actor(RandName.compose(3), grandFatherPop,grandMomPop, startingYear-18);

		// The starting households
		Home Graveyard=new Home("Graveyard", Pop);
		Home Camp =new Home("Camp", Pop);

		Village.addHousehold(Graveyard);
		Village.addHousehold(Camp);





		//ArrayList<String> chronicleConlusion=new ArrayList<String>();


		Camp.addOccupant(Pop);

// Simulation!!
		
		CountingTheDays.simulation(yearsToSimulate, startingYear, Village);
/*
		for(int year=startingYear; year < startingYear+yearsToSimulate;year++)
		{			
			for(Home HouseH : Village.household)
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
							
							Person.DeathCheck(Village,year);

							Person.gettingChild(year);

							Person.getApartner(year);

							

						}
					}
				}
			}

		}

*/
			//Simulation end, compiling text
		
		String chronicle;

		chronicle="<h2>In the year of "+startingYear+" "+Pop.name+" took to the woods to start a new life as his own man.</h2>";
		chronicle+="<h3>This is his clan after "+yearsToSimulate+" years. </h3>";



			for(Home HouseH : Village.household)
			{

				int sizeOfHouse=HouseH.occupants.size();
				if(sizeOfHouse>0)
				{


					ArrayList<Actor> census=new ArrayList<Actor>();
					census.addAll(HouseH.occupants);

					chronicle+="-----------At "+HouseH.name+" -------------<br />";
					chronicle+="------------------------------------------<br />";

					for(Actor Person :census)
					{

						if(Person.deathYear==-1){chronicle+=Person.name+"("+Person.qSex()+")("+(int)Person.birthYear+"- "+").<br />";}
						else{chronicle+=Person.name+"("+(int)Person.birthYear+"- "+(int)Person.deathYear+").<br />";}
						chronicle+=Person.curiculum.toString()+"<br />";
						
						if(Person.kenning.size()>0){
							
							
							String aka=Person.kenning.toString();
							
							
							chronicle+="(aka: "+aka+")<br />";
							

						}
						

						


						
						chronicle+="---------------------------------<br />";

					}
				}
			}
			
			Gedcom.writer(Village);

System.out.print(chronicle);

		
	}




}






