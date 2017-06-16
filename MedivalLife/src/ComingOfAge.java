



public class ComingOfAge {

	static int nrOfAttr= ImpConstant.nrOfAttr;

	/*
	  0 second value 0/1 indicating if it is an active character or not.
	  1 STRENGTH
	  2 Stamina or ENDURANCE,
	  3 Manual DEXTERITY,
	  4 Bodily AGILITY, 
	  5 INTELLIGENCE, 
	  6 AURA, Magicpower etc
	  7 Wisdom
	  8 Willpower
	  9 Charisma
	  10 Comliness, Appareance etc
	  11 Eyesigth
	  12 Hearing
	  13 Smell/Taste
	  14 Touch
	  15 Voice
	  16 Morality
	  17 Piety
	  18 Fertility
	  19 Frame
	  20 Height in 4" increasements above 50"
	  21 Agelimit  in 3 years increasements above 40

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

	static public void countingTheDays(Actor Person, double year)
	{

		double age=Person.qAge(year);

		if(age<3){agingInfant(Person);}
		else if(age<9){agingToddler(Person);}
		else if(age<12){agingYoungster(Person);}
		else if(age<15){agingJuvenil(Person);}
		else{WeigthOfYears(Person, year);}

	}



	public static void agingInfant(Actor Infant) //each year of Infancy 
	{
		// To be exchanged for a Species dependent mod, and also a change of length of childhood, 2 y for humans
		double[] infantAgeMods={2,0,0.3,0.1,0.2,0.1,0.1,0,0.3,0,0.25,1,1,0.5,0.75,0.2,0,0,0,0,0,1};


		double timeRange=infantAgeMods[0];

		for(int i=1;i<nrOfAttr;i++){
			Infant.attrArray[i][1]+=Infant.attrArray[i][0]*infantAgeMods[i]/timeRange;
		}



	}

	public static void agingToddler(Actor Toddler)
	{

		// To be exchanged for a Species dependent mod, and also a change of length of childhood, 6 y for humans

		double[] toddlerAgeMods={6,0.5,0.2,0.7,0.7,0.2,0.1,0,0.3,0,0.25,0,0,0.5,0.25,0.2,0,0,0,1,0.5,0};

		double timeRange=toddlerAgeMods[0];

		for(int i=1;i<nrOfAttr;i++){
			Toddler.attrArray[i][1]+=Toddler.attrArray[i][0]*toddlerAgeMods[i]/timeRange;

		}

	}


	public static void agingYoungster(Actor Youngster)
	{

		// To be exchanged for a Species dependent mod, and also a change of length of childhood, 6 y for humans

		double[] youngsterAgeMods={4,0.5,0.3,0.2,0.1,0.4,0.1,0,0.6,0.25,0.5,0,0,0,0,0.6,0.5,0.5,0,0,0.25,0};

		double timeRange=youngsterAgeMods[0];

		for(int i=1;i<nrOfAttr;i++){
			Youngster.attrArray[i][1]+=Youngster.attrArray[i][0]*youngsterAgeMods[i]/timeRange;
		}

		//test for parents Sin/Virtue
		
		for(int i=1;i<Youngster.virtueArray.length;i++){
			
			if(Dice.d6()<Math.abs(Youngster.mother.virtueArray[i])){
				
				double will=willPowerResistance(Youngster);
				double change=(Youngster.mother.virtueArray[i]-Youngster.virtueArray[i])*2*will/Dice.d6();
				Youngster.virtueArray[i]+=change;

			}
			
			if(Dice.d6()<Math.abs(Youngster.father.virtueArray[i])){
				double will=willPowerResistance(Youngster);
				double change=(Youngster.mother.virtueArray[i]-Youngster.virtueArray[i])*will/Dice.d6();
				Youngster.virtueArray[i]+=change;

			}
			
		}
		
		
		
	}

	public static void agingJuvenil(Actor Juvenil)
	{

		// To be exchanged for a Species dependent mod, and also a change of length of childhood, 6 y for humans

		double[] juvenilAgeMods={3,0.2,0.2,0,0,0.3,0.7,0.5,0,0.75,0,0,0,0,0,0,0.5,0.5,1,0,0.25,0};

		double timeRange=juvenilAgeMods[0];

		for(int i=1;i<nrOfAttr;i++){
			Juvenil.attrArray[i][1]+=(Juvenil.attrArray[i][0]*juvenilAgeMods[i]+Juvenil.pubPot[i])/timeRange;
		}



		if(Juvenil.qSex().equals("Female")){
			for(int i=1;i<nrOfAttr;i++){


				double[] humanFemale={3,-2,1,0,1,0,0,0,1,1,0,1,0,1,0,0,0,-1,-1,0,0,0};

				Juvenil.attrArray[i][1]+=Juvenil.attrArray[i][1]*humanFemale[i]/timeRange;
				
				//Parental influence on personality
				for(int n=1;n<Juvenil.virtueArray.length;n++){
					
					
					
					
					if(Dice.d6()<Math.abs(Juvenil.mother.virtueArray[n])){
						double will=willPowerResistance(Juvenil);
						double change=(Juvenil.mother.virtueArray[n]-Juvenil.virtueArray[n])*2*will/Dice.d6();
						Juvenil.virtueArray[n]+=change;

					}
					
					if(Dice.d6()<Math.abs(Juvenil.father.virtueArray[n])){
						double will=willPowerResistance(Juvenil);
						double change=(Juvenil.mother.virtueArray[n]-Juvenil.virtueArray[n])*will/Dice.d6();
						Juvenil.virtueArray[n]+=change;

					}
					
				}
				
			}
		}else{
			for(int i=1;i<Juvenil.virtueArray.length;i++){
				
				if(Dice.d6()<Math.abs(Juvenil.mother.virtueArray[i])){
					double will=willPowerResistance(Juvenil);
					double change=(Juvenil.mother.virtueArray[i]-Juvenil.virtueArray[i])*will/Dice.d6();
					Juvenil.virtueArray[i]+=change;

				}
				
				if(Dice.d6()<Math.abs(Juvenil.father.virtueArray[i])){
					double will=willPowerResistance(Juvenil);
					double change=(Juvenil.father.virtueArray[i]-Juvenil.virtueArray[i])*3*will/Dice.d6();
					Juvenil.virtueArray[i]+=change;

				}
				
			}
		}
		
		//and then, in the end,  who understand where teenagers get their ideas from?
		
		for(int i=1;i<14;i++){Juvenil.virtueArray[i]+=(Dice.d6()-Dice.d6())/5;}

	}


	public static void WeigthOfYears(Actor Person, double year)
	{
		double age=Person.qAge(year);

		double lifeExpectancy=Person.attrArray[21][1]*3+40;

		if(age>lifeExpectancy/2){ //aging starts ~35
			double fate=Math.random()-Person.virtueArray[11]/10-Person.virtueArray[2]/20;

			if(fate>0.9){CatastrophicAilment(Person, year);}
			else if(fate>0.8){DegenerativeIllness(Person, year);}
			else if(fate>0.4){WeightChange(Person);}
			else if(fate>0.2){Impairment(Person);}
		}   


		if(age>lifeExpectancy){ //average expected lifelength ~70
			double fate=Math.random();

			Person.attrArray[2][1]--; //dwindling lifeforce

			if(fate>0.8){CatastrophicAilment(Person, year);}
			else if(fate>0.7){DegenerativeIllness(Person, year);}
			else if(fate>0.3){WeightChange(Person);}
			else{Impairment(Person);}

		}
	}


	private static void DegenerativeIllness(Actor Person, double year) {

		switch(Dice.d6()){

		case 1: Person.curiculum.append(Person.name+" is pained by arthriris during most of the year "+(int)year+". ");
		Person.attrArray[3][1]+= -Dice.d6();
		Person.attrArray[4][1]+= -Dice.d6()/2;
		break;

		case 2: Person.curiculum.append(Person.name+" lost the light of the eyes during the year "+(int)year+". ");
		Person.attrArray[11][1]+= -Dice.d6();
		break;

		case 3:  Person.curiculum.append(Person.name+" become afflicted by diabetes during the year "+(int)year+". ");
		Person.attrArray[1][1]+= -Dice.d6();
		Person.attrArray[2][1]+= -Dice.d6()+2;
		break;

		case 4: Person.curiculum.append(Person.name+" is pained by gout during most of the year "+(int)year+". ");
		Person.attrArray[4][1]+= -Dice.d6();
		break;

		case 5: Person.curiculum.append(Person.name+" starts suffering from a clouded mind in the of year "+(int)year+". ");
		Person.attrArray[5][1]+= -Dice.d6();
		Person.attrArray[8][1]+= -Dice.d6();
		break;

		default:Person.curiculum.append(Person.name+" is disgracefully aged during of the year "+(int)year+". ");
		Person.attrArray[10][1]+= -Dice.d6();
		Person.attrArray[9][1]+= -Dice.d6()/2;
		break;
		}

	}

	static void CatastrophicAilment(Actor Person, double year)
	{

		Person.curiculum.append("In the year of "+(int)year+" "+ Person.name+" fell serious ill."); 
		switch(Dice.testD100attr(Person.attrArray[2][1])){


		case "CF" :Person.attrArray[2][1]=0; // Character probably dies

		break;
		case "CS":                         // May Survives just with a fright
			break; 

		case "F": Person.attrArray[2][1] = Person.attrArray[2][1]-10;  // May survive...
		Impairment(Person);
		break;

		default: Person.attrArray[2][1] = Person.attrArray[2][1]-5; // Probably survive
		Impairment(Person);
		break;


		}
	}


	static void Impairment(Actor Person)
	{
		int n;
		switch(Dice.testD100attr(Person.attrArray[2][1]))
		{

		case "CF": n=10; break;
		case "CS": n=1; break;
		case "F": n=5; break;
		default: n=3; break;
		}

		for(int i=0;i<n;i++){
			int fate=1+(int)Math.random()*nrOfAttr;
			Person.attrArray[fate][1]--;
		}
	}




	static void WeightChange(Actor Person)
	{
		Person.weight*=1.1; //actually this should check for living condition so there is food...
	}


	static double willPowerResistance(Actor Person){
		double n;
		switch(Dice.testD100attr(Person.getWill()))
		{

		case "CF": n=2; break;
		case "CS": n=0.5; break;
		case "F": n=1; break;
		default: n=0.5; break;
		}
		
		
		return n;
	}



}


