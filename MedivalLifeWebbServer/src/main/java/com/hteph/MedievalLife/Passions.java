package com.hteph.MedievalLife;

import com.hteph.modules.Actor;

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
		
		if(Person.qAge(year)>12) { // Not until 12 years of age people take you seriously enough to give you strange nicknames

		for(int i=1;i<Person.getVirtueArray().length;i++){

			double virtue=Person.getVirtueArray()[i];
			
			
			if(Math.abs(virtue)>4.9){

			
				switch(i){
				case 1: if(virtue<0 && Person.getKenning().indexOf("Lascivious")==-1){
					Person.getKenning().add("Lascivious");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+  Person.getHtmlName()+" become known in the village as Lascivious. </span>");
				}
				else if(Person.getKenning().indexOf("the Chaste")==-1){
					Person.getKenning().add("the Chaste");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+  Person.getHtmlName()+" become known in the village as 'the Chaste'. </span>");
				}
				break;

				case 2: if(virtue<0 && Person.getKenning().indexOf("Lackadaisical")==-1){
					Person.getKenning().add("Lackadaisical");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as Lackadaisical. </span>");
				}
				else if(Person.getKenning().indexOf("the Tireless")==-1){
					Person.getKenning().add("the Tireless");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Tireless'. </span>");
				}
				break;

				case 3: if(virtue<0 && Person.getKenning().indexOf("the Vindictive")==-1){
					Person.getKenning().add("the Vindictive");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Vindictive'. </span>");
				}
				else if(Person.getKenning().indexOf("Magnanimous")==-1){
					Person.getKenning().add("Magnanimous");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'Magnanimous'. </span>");
				}
				break;

				case 4: if(virtue<0 && Person.getKenning().indexOf("the Miser")==-1){
					Person.getKenning().add("the Miser");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Miser'. </span>");
				}
				else if(Person.getKenning().indexOf("Bounteous")==-1){
					Person.getKenning().add("Bounteous");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'Bounteous'. </span>");
				}
				break;

				case 5: if(virtue<0 && Person.getKenning().indexOf("the Devious")==-1){
					Person.getKenning().add("the Devious");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as the Devious. </span>");
				}
				else if(Person.getKenning().indexOf("Virtous")==-1){
					Person.getKenning().add("Virtous");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'Virtous'. </span>");
				}
				break;

				case 6: if(virtue<0 && Person.getKenning().indexOf("Capricious")==-1){
					Person.getKenning().add("Capricious");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as Capricious. </span>" );
				}
				else if(Person.getKenning().indexOf("the Rightful")==-1){
					Person.getKenning().add("the Rightful");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Rightful'. </span>");
				}
				break;

				case 7: if(virtue<0 && Person.getKenning().indexOf("the Wicked")==-1){
					Person.getKenning().add("the Wicked");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Wicked'. </span>");
				}
				else if(Person.getKenning().indexOf("the Merciful")==-1){
					Person.getKenning().add("the Merciful");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Merciful'. </span>");
				}
				break;

				case 8: if(virtue<0 && Person.getKenning().indexOf("Illustrious")==-1){
					Person.getKenning().add("Illustrious");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as Illustrious. </span>");
				}
				else if(Person.getKenning().indexOf("the Humble")==-1){
					Person.getKenning().add("the Humble");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Humble'. </span>");
				}
				break;

				case 9: if(virtue<0 && Person.getKenning().indexOf("the Temporal")==-1){
					Person.getKenning().add("the Temporal");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Temporal'. </span>");
				}
				else if(Person.getKenning().indexOf("the Devote")==-1){
					Person.getKenning().add("the Devote");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Devote'. </span>");
				}
				break;

				case 10: if(virtue<0 && Person.getKenning().indexOf("Audacious")==-1){
					Person.getKenning().add("Audacious");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'Audacious'. </span>");
				}
				else if(Person.getKenning().indexOf("the Careful")==-1){
					Person.getKenning().add("the Careful");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Careful'. </span>");
				}
				break;

				case 11: if(virtue<0 && Person.getKenning().indexOf("Voluptuary")==-1){
					Person.getKenning().add("Voluptuary");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Voluptuary'. </span>");
				}
				else if(Person.getKenning().indexOf("the Mild")==-1){
					Person.getKenning().add("the Mild");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Mild'. </span>");
				}
				break;

				case 12: if(virtue<0 && Person.getKenning().indexOf("the Wary")==-1){
					Person.getKenning().add("the Wary");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Wary'. </span>");
				}
				else if(Person.getKenning().indexOf("the Innocent")==-1){
					Person.getKenning().add("the Innocent");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Innocent'. </span>");
				}
				break;

				case 13: if(virtue<0 && Person.getKenning().indexOf("the Caitiff")==-1){
					Person.getKenning().add("the Caitiff");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Caitiff'. </span>");
				}
				else if(Person.getKenning().indexOf("the Bold")==-1){
					Person.getKenning().add("the Bold");
					Person.getCuriculum().append("<span class='passion'>In the year of "+(int)year+" "+ Person.getHtmlName()+" become known  in the village as 'the Bold'. </span>");
				}
				break;

				}
			}
						

		}
	}

	}
}
