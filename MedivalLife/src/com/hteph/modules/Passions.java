package com.hteph.modules;

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
		


		for(int i=1;i<Person.getVirtueArray().length;i++){

			double virtue=Person.getVirtueArray()[i];
			
			
			if(Math.abs(virtue)>4.9){

			
				switch(i){
				case 1: if(virtue<0 && Person.getKenning().indexOf("Lascivious")==-1){
					Person.getKenning().add("Lascivious");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known in the village as Lascivious. " );
				}
				else if(Person.getKenning().indexOf("the Chaste")==-1){
					Person.getKenning().add("the Chaste");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known in the village as 'the Chaste'. ");
				}
				break;

				case 2: if(virtue<0 && Person.getKenning().indexOf("Lackadaisical")==-1){
					Person.getKenning().add("Lackadaisical");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as Lackadaisical. ");
				}
				else if(Person.getKenning().indexOf("the Tireless")==-1){
					Person.getKenning().add("the Tireless");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Tireless'. ");
				}
				break;

				case 3: if(virtue<0 && Person.getKenning().indexOf("the Vindictive")==-1){
					Person.getKenning().add("the Vindictive");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Vindictive'. ");
				}
				else if(Person.getKenning().indexOf("Magnanimous")==-1){
					Person.getKenning().add("Magnanimous");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'Magnanimous'. ");
				}
				break;

				case 4: if(virtue<0 && Person.getKenning().indexOf("the Miser")==-1){
					Person.getKenning().add("the Miser");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Miser'. ");
				}
				else if(Person.getKenning().indexOf("Bounteous")==-1){
					Person.getKenning().add("Bounteous");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'Bounteous'. ");
				}
				break;

				case 5: if(virtue<0 && Person.getKenning().indexOf("the Devious")==-1){
					Person.getKenning().add("the Devious");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as the Devious. ");
				}
				else if(Person.getKenning().indexOf("Virtous")==-1){
					Person.getKenning().add("Virtous");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'Virtous'. ");
				}
				break;

				case 6: if(virtue<0 && Person.getKenning().indexOf("Capricious")==-1){
					Person.getKenning().add("Capricious");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as Capricious. " );
				}
				else if(Person.getKenning().indexOf("the Rightful")==-1){
					Person.getKenning().add("the Rightful");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Rightful'. ");
				}
				break;

				case 7: if(virtue<0 && Person.getKenning().indexOf("the Wicked")==-1){
					Person.getKenning().add("the Wicked");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Wicked'. ");
				}
				else if(Person.getKenning().indexOf("the Merciful")==-1){
					Person.getKenning().add("the Merciful");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Merciful'. ");
				}
				break;

				case 8: if(virtue<0 && Person.getKenning().indexOf("Illustrious")==-1){
					Person.getKenning().add("Illustrious");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as Illustrious. ");
				}
				else if(Person.getKenning().indexOf("the Humble")==-1){
					Person.getKenning().add("the Humble");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Humble'. ");
				}
				break;

				case 9: if(virtue<0 && Person.getKenning().indexOf("the Temporal")==-1){
					Person.getKenning().add("the Temporal");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Temporal'. ");
				}
				else if(Person.getKenning().indexOf("the Devote")==-1){
					Person.getKenning().add("the Devote");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Devote'. ");
				}
				break;

				case 10: if(virtue<0 && Person.getKenning().indexOf("Audacious")==-1){
					Person.getKenning().add("Audacious");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'Audacious'. ");
				}
				else if(Person.getKenning().indexOf("the Careful")==-1){
					Person.getKenning().add("the Careful");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Careful'. ");
				}
				break;

				case 11: if(virtue<0 && Person.getKenning().indexOf("Voluptuary")==-1){
					Person.getKenning().add("Voluptuary");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Voluptuary'. ");
				}
				else if(Person.getKenning().indexOf("the Mild")==-1){
					Person.getKenning().add("the Mild");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Mild'. ");
				}
				break;

				case 12: if(virtue<0 && Person.getKenning().indexOf("the Wary")==-1){
					Person.getKenning().add("the Wary");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Wary'. ");
				}
				else if(Person.getKenning().indexOf("the Innocent")==-1){
					Person.getKenning().add("the Innocent");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Innocent'. ");
				}
				break;

				case 13: if(virtue<0 && Person.getKenning().indexOf("the Caitiff")==-1){
					Person.getKenning().add("the Caitiff");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Caitiff'. ");
				}
				else if(Person.getKenning().indexOf("the Bold")==-1){
					Person.getKenning().add("the Bold");
					Person.getCuriculum().append("In the year of "+(int)year+" "+ Person.getName()+" become known  in the village as 'the Bold'. ");
				}
				break;

				}
			}
			
			
			

		}
	}


}
