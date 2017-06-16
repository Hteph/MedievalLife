
public class Passions {
	
	
	
	//Methods
	
	public static void VirtueKenning(Actor Person, double year)
	{
		/*
	1 Chaste/Lustful
	2 Energetic/Slothful
	3 Forgiving/Vengeful
	4 Generous/Selfish
	5 Honest/Deciteful
	6 Just/Arbitary
	7 Merciful/Cruel
	8 Modest/Proud
	9 Spiritual/Worldly
	10 Prudent/Reckless
	11 Temperate/Indulgent
	12 Trusting/Suspicious
	13 Valorous/Cowardly
		 */
		


		for(int i=1;i<Person.virtueArray.length;i++){

			double virtue=Person.virtueArray[i];
			
			
			if(Math.abs(virtue)>4.9){

			
				switch(i){
				case 1: if(virtue<0 && Person.kenning.indexOf("Lascivious")==-1){
					Person.kenning.add("Lascivious");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known in the village as Lascivious. " );
				}
				else if(Person.kenning.indexOf("the Chaste")==-1){
					Person.kenning.add("the Chaste");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known in the village as 'the Chaste'. ");
				}
				break;

				case 2: if(virtue<0 && Person.kenning.indexOf("Lackadaisical")==-1){
					Person.kenning.add("Lackadaisical");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as Lackadaisical. ");
				}
				else if(Person.kenning.indexOf("the Tireless")==-1){
					Person.kenning.add("the Tireless");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Tireless'. ");
				}
				break;

				case 3: if(virtue<0 && Person.kenning.indexOf("the Vindictive")==-1){
					Person.kenning.add("the Vindictive");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Vindictive'. ");
				}
				else if(Person.kenning.indexOf("Magnanimous")==-1){
					Person.kenning.add("Magnanimous");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'Magnanimous'. ");
				}
				break;

				case 4: if(virtue<0 && Person.kenning.indexOf("the Miser")==-1){
					Person.kenning.add("the Miser");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Miser'. ");
				}
				else if(Person.kenning.indexOf("Bounteous")==-1){
					Person.kenning.add("Bounteous");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'Bounteous'. ");
				}
				break;

				case 5: if(virtue<0 && Person.kenning.indexOf("the Devious")==-1){
					Person.kenning.add("the Devious");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as the Devious. ");
				}
				else if(Person.kenning.indexOf("Virtous")==-1){
					Person.kenning.add("Virtous");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'Virtous'. ");
				}
				break;

				case 6: if(virtue<0 && Person.kenning.indexOf("Capricious")==-1){
					Person.kenning.add("Capricious");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as Capricious. " );
				}
				else if(Person.kenning.indexOf("the Rightful")==-1){
					Person.kenning.add("the Rightful");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Rightful'. ");
				}
				break;

				case 7: if(virtue<0 && Person.kenning.indexOf("the Wicked")==-1){
					Person.kenning.add("the Wicked");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Wicked'. ");
				}
				else if(Person.kenning.indexOf("the Merciful")==-1){
					Person.kenning.add("the Merciful");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Merciful'. ");
				}
				break;

				case 8: if(virtue<0 && Person.kenning.indexOf("Illustrious")==-1){
					Person.kenning.add("Illustrious");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as Illustrious. ");
				}
				else if(Person.kenning.indexOf("the Humble")==-1){
					Person.kenning.add("the Humble");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Humble'. ");
				}
				break;

				case 9: if(virtue<0 && Person.kenning.indexOf("the Temporal")==-1){
					Person.kenning.add("the Temporal");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Temporal'. ");
				}
				else if(Person.kenning.indexOf("the Devote")==-1){
					Person.kenning.add("the Devote");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Devote'. ");
				}
				break;

				case 10: if(virtue<0 && Person.kenning.indexOf("Audacious")==-1){
					Person.kenning.add("Audacious");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'Audacious'. ");
				}
				else if(Person.kenning.indexOf("the Careful")==-1){
					Person.kenning.add("the Careful");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Careful'. ");
				}
				break;

				case 11: if(virtue<0 && Person.kenning.indexOf("Voluptuary")==-1){
					Person.kenning.add("Voluptuary");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Voluptuary'. ");
				}
				else if(Person.kenning.indexOf("the Mild")==-1){
					Person.kenning.add("the Mild");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Mild'. ");
				}
				break;

				case 12: if(virtue<0 && Person.kenning.indexOf("the Wary")==-1){
					Person.kenning.add("the Wary");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Wary'. ");
				}
				else if(Person.kenning.indexOf("the Innocent")==-1){
					Person.kenning.add("the Innocent");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Innocent'. ");
				}
				break;

				case 13: if(virtue<0 && Person.kenning.indexOf("the Caitiff")==-1){
					Person.kenning.add("the Caitiff");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Caitiff'. ");
				}
				else if(Person.kenning.indexOf("the Bold")==-1){
					Person.kenning.add("the Bold");
					Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" become known  in the village as 'the Bold'. ");
				}
				break;

				}
			}
			
			
			

		}
	}


}
