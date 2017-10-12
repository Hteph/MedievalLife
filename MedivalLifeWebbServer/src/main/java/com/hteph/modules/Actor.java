package com.hteph.modules;

import java.util.ArrayList;
import java.util.Collections;
import com.hteph.MedievalLife.ImpConstant;
import com.hteph.utilities.Dice;
import com.hteph.utilities.NameGenerator;

//@Entity
public class Actor {
	
	private	static int actorsCreated;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	int Id;

//	@Transient
	int nrOfAttr = ImpConstant.nrOfAttr;

	private String name;
	private String birthplace;
	private Home home;
	private String sex;
	private double birthDate; // birthdate with day and month derived from year fractions.
	private double deathYear = -1;
	private double[][] attrArray; // Array to store genetic potential Attribute and current attribute
	private double weight; //TODD should this be in attribute array? or otherwise being calculated from frame?[weight in lbs]
	private int[] pubPot = new int[nrOfAttr]; // this is the random factors that add to the stats in puberty, these may	be modified by events further
	private StringBuilder curiculum = new StringBuilder();
	
	private ArrayList<Integer> partners = new ArrayList<>();
	private ArrayList<Integer> children = new ArrayList<>();
	
	private ArrayList<String> kenning = new ArrayList<String>();
	private ArrayList<Family> familyHistory = new ArrayList<Family>(); 
	private double[] virtueArray = new double[14];	
	private Family currentFamily;


	// for random characters unknown parents

	private Actor father;
	private Actor mother;
	// test
	/*
	 * the virtues going between -5 and 5 negative sin, positive virtue
	 * 
	 * 0 identifier of which virtue/sin list that is in use 1 Chaste/Lustful 2
	 * Energetic/Slothful 3 Forgiving/Vengeful 4 Generous/Selfish 5 Honest/Deciteful
	 * 6 Just/Arbitary 7 Merciful/Cruel 8 Modest/Proud 9 Spiritual/Worldly 10
	 * Prudent/Reckless 11 Temperate/Indulgent 12 Trusting/Suspicious 13
	 * Valorous/Cowardly
	 * 
	 */

	/*
	 * Index of character attributes 0 ID with second value 0/1 indicating if it is
	 * an active character or not. 1 STRENGTH 2 Stamina or ENDURANCE, 3 Manual
	 * DEXTERITY, 4 Bodily AGILITY, 5 INTELLIGENCE, 6 AURA, Magicpower etc 7 Wisdom
	 * 8 Willpower 9 Charisma 10 Comliness, Appareance etc 11 Eyesigth 12 Hearing 13
	 * Smell/Taste 14 Touch 15 Voice 16 Morality 17 Piety 18 Fertility 19 Frame 20
	 * Height in 4" increasements above 50" 21 Aging point in 3 years increasements
	 * above 40
	 * 
	 */

	public Actor() {
		// for persistence use
	}

	// constructor, used for babies

	public Actor(String generatedName, Actor father, Actor mother, double year) {
		
		attrArray = new double[nrOfAttr][2];
		attrArray[0][1] = 1; // Active
		attrArray[0][0] = actorsCreated;
		
		actorsCreated++;
		
		
		this.setFather(father);
		this.setMother(mother);
		birthplace = "This Village";
		father.addChildren(this);
		mother.addChildren(this);


		
		getCuriculum().append("<span>Born in year " + (int) year + " to " + father.getHtmlName() + " and " + mother.getHtmlName());

		if (Math.random() < 0.51) {
			sex = "Male";
		} else {
			sex = "Female";
		}

		if (sex.equals("Male")) {
			getCuriculum().append(", a son.</span>");
			setName(generatedName);
		} else {
			getCuriculum().append(", a daughter.</span>");
			setName(generatedName + "a");
		}

		
		
		setBirthYear(year);

		
		
			home = mother.home;
		home.addOccupant(this);	

		
		// default infant attributes, will later be exchanged for a species dependency
		double infantDefault[] = { 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 1, 0 };
		// basic virtues/sins
		for (int i = 1; i < 14; i++) {
			getVirtueArray()[i] = (Dice.d6() - Dice.d6()) / 3;
		}

		if (qSex().equals("Male")) {
			mother.getCuriculum().append("<span> " + mother.getHtmlName() + " gave birth to a son, named " + getHtmlName() + ".</span> ");
		} else {
			mother.getCuriculum().append("<span> " +mother.getHtmlName() + " gave birth to a daughter, named " + getHtmlName() + ". </span>");
		}

		for (int i = 1; i < attrArray.length; i++) {

			double inheritance = Math.random();
			double genotype;
			
			//just a fail check to stop eventual errors to propagate through generations
			if (father.attrArray[i][0] < 1) {
				father.attrArray[i][0] = Dice.d6() + Dice.d6();
			}
			if (mother.attrArray[i][0] < 1) {
				mother.attrArray[i][0] = Dice.d6() + Dice.d6();
			}

			//TODO expand for muttions
			if (inheritance < 0.45) {
				genotype = mother.attrArray[i][0];
			} else if (inheritance < 0.90) {
				genotype = father.attrArray[i][0];
			} else if (inheritance < 0.95) {
				genotype = (father.attrArray[i][0] + mother.attrArray[i][0]) / 2;
			} else if (inheritance < 0.99 && father.attrArray[i][0] != mother.attrArray[i][0]) {
				double A = Math.max(mother.attrArray[i][0], father.attrArray[i][0]);
				double B = Math.min(mother.attrArray[i][0], father.attrArray[i][0]);
				genotype = B + Math.random() * (A - B);
			} else {
				// Here should the new mutation possibilities go, see T5
				
				genotype = Dice.d6() + Dice.d6();
			}

			attrArray[i][0] = genotype;
			attrArray[i][1] = infantDefault[i];

			getPubPot()[i] = Dice.d6();

		}
		
	//	Settlement.addPopulation(this);
	}

	// constructor Used for random characters

	public Actor(String generatedName, String wantedSex, double timeNow) {

		attrArray = new double[nrOfAttr][2];
		attrArray[0][1] = 1; // Active
		attrArray[0][0] = actorsCreated;
		actorsCreated++;
		
		sex = wantedSex;
		birthplace = "Somewhere else";
		
		setName(generatedName);

		// generatedName
		for (int i = 1; i < 14; i++) {
			getVirtueArray()[i] = Dice.d6() - Dice.d6();
		}
		
		setBirthYear(timeNow - 15 - Dice.d6());
		
		if (sex.equals("Male")) {
			getCuriculum().append("<span> A man");
			setName(generatedName);
		} else {
			getCuriculum().append("<span> A woman");
			setName(generatedName + "a");
		}
	
		

		getCuriculum().append(" that arrived in the year of " + (int) timeNow + ".</span> ");

		for (int i = 1; i < attrArray.length; i++) {
			attrArray[i][0] = Dice.d6() + Dice.d6();
			
			attrArray[i][1] = attrArray[i][0] + Dice.d6();
		}
		
		System.out.println("Creating: "+this.toString());
	//	Settlement.addPopulation(this);
	}

	// methods ---------------------------------------------------------------------------------------------------------
	
	
	public double qAge(double a)// calculates age from input date
	{
		double A = a - getBirthYear();

		return A;
	}

	public int getId()// Returns objects ID
	{

		int ID = (int) attrArray[0][0];
		return ID;
	}

	public String qSex() {
		String A = this.sex;
		return A;
	}

	public void marriage(Actor Person, double year) {
		this.addPartner(Person);
		Person.addPartner(this);
		getCuriculum().append("<span class='marriage'>In " + (int) year + " married " + Person.getHtmlName() + ". </span>");
		Person.getCuriculum().append("<span class='marriage'>In " + (int) year + " married " + this.getHtmlName() + ". </span>");
		
	}
	
	public void addPartner(Actor person) {
		
		partners.add(person.getId());
		
	}
	

	public void remPartner(Actor Person) {
		this.partners.remove((Integer)Person.getId());

	}

	public void gettingChild(double year) {
		
		boolean pregnant = false;
		// menopause
		if (this.qSex().equals("Female") && attrArray[0][1] > 0) {

			if (qAge(year) > attrArray[18][1] + 30) {
				attrArray[18][1]--;
				
			}

			// conception?

			Actor actualFather = null;

			if (this.attrArray[18][1] > 0 && partners.size() > 0) {

				for (int i = 0; i < partners.size(); i++) {
					
					Actor partner = Settlement.getSomeone(partners.get(i));
					
					if (partner.qSex().equals("Male")) {

						int passion = 0;

						// Lust is a negative value! Thus it is minus the value in the eq below!!
						String partnerLust = Dice
								.testD100(50 - Math.pow(partner.getVirtueArray()[1], 3) + this.getApp());
						String ownLust = Dice.testD100(50 - Math.pow(this.getVirtueArray()[1], 3) + partner.getApp());

						switch (partnerLust) {

						case "CF":
							passion = -5;
							break;
						case "CS":
							passion = 10;
							break;
						case "F":
							passion = 0;
							break;
						default:
							passion = 5;
							break;
						}

						switch (ownLust) {
						case "CF":
							passion += -5;
							break;
						case "CS":
							passion += 10;
							break;
						case "F":
							passion += 0;
							break;
						default:
							passion += 5;
							break;
						}

						// code for unhappy combinations of lust should be inserted here

						while (!pregnant && passion > 0) {

							passion--;
							if (Dice.d100() <= 2 * (Math.min(this.attrArray[18][1], partner.attrArray[18][1]))) {
								pregnant = true;
								actualFather = partner;

							}
						}
					}
				}
			}

			// Now to the production of the child

			if (pregnant) // first trimester
			{
				switch (Dice.testD100attr(attrArray[2][1])) {
				case "CF":
					attrArray[2][1] += -0.2; // Miscarried with some complications
					attrArray[18][1] += -0.5;
				case "F":
					pregnant = false; // Miscarry with no further complications
					break;
				default:
					break; // All is well
				}

			}

			if (pregnant) // Second trimester
			{
				switch (Dice.testD100attr(attrArray[2][1])) {
				case "CF":
					attrArray[18][1] += -1; // Miscarried with complications
					attrArray[2][1] += -0.8;
				case "F":
					attrArray[2][1] += -0.2; // Miscarried with some complications
					getCuriculum().append("<span class='health'>"+this.getHtmlName() + " lost a child in the year of " + (int) year + ". </span>");
					pregnant = false;
					break;
				default:
					break; // All is well
				}

			}

			if (pregnant) // Third trimester
			{
				switch (Dice.testD100attr(attrArray[2][1])) {
				case "CF":
					attrArray[2][1] += -1; // Miscarried with complications
					attrArray[18][1] += -2;
					getCuriculum().append("<span class='health'>"+this.getHtmlName() + " lost late a child in the year of " + (int) year + ".</span> ");
					pregnant = false;
					break;
				default:
					break; // All is well
				}
			}

			// Labour time, should be modified if first child...
			double labourTime = 0;

			if (pregnant) {
				switch (Dice.testD100attr(attrArray[2][1])) {
				case "CF":
					labourTime = Dice.d6() + 8; // actual intervetion should be done
					attrArray[18][1] += -4;
					attrArray[2][1] += -2;
					break;
				case "F":
					labourTime = Dice.d6() / 2 + 4;
					attrArray[18][1] += -1;
					attrArray[2][1] += -0.5;
					break;

				case "CS":
					labourTime = Dice.d6() / 2 + 1;
					break;
				default:
					labourTime = Dice.d6() / 2 + 2;
					break;
				}
			}

			if (pregnant) // Delivery
			{

				switch (Dice.testD100attr(attrArray[2][1] + 5 - labourTime)) {
				case "CF":
					switch (Dice.testD100attr(attrArray[2][1])) {
					case "CF":
						attrArray[0][1] = 0; // Mother dies, details horrible
						getCuriculum()
								.append("<span class='health'>"+this.getHtmlName() + " died in childbirth in the year of " + (int) year + ". </span>");

						pregnant = false;
						break;
					case "F":
						attrArray[18][1] += -8;
						attrArray[2][1] += -5;
						pregnant = false;
						break;
					case "CS":
						attrArray[18][1] += -1;
						attrArray[2][1] += -1;
						attrArray[17][1] += 5; // Survived as by an miracle
						break;

					default:
						attrArray[18][1] += -4;
						attrArray[2][1] += -2;
						break;
					}
				case "F":
					switch (Dice.testD100attr(attrArray[2][1])) {
					case "CF":
						attrArray[0][1] = 0; // Mother dies, details horrible
						getCuriculum()
								.append("<span class='health'>"+this.getHtmlName() + " died in childbirth in the year of " + (int) year + ". </span>");

						break;
					case "F":
						attrArray[18][1] += -4;
						attrArray[2][1] += -2;
						break;
					case "CS":
						attrArray[18][1] += -1;
						break;

					default:
						attrArray[18][1] += -2;
						attrArray[2][1] += -1;
						break;
					}

				default:
					break; // All goes well
				}
			}

			if (pregnant) {

				NameGenerator RandName = new NameGenerator();

				Actor baby = new Actor(RandName.compose(3), actualFather, this, year);
				Settlement.addPopulation(baby);
				addChildren(baby);
				baby.setCurrentFamily(currentFamily);
				this.currentFamily.addChild(baby);
				
				pregnant = false;
				
				attrArray[18][1] += -2;

				// first year
				for (int i = 1; i < 12; i++) {
					switch (Dice.testD100attr(attrArray[2][1])) // should be modified by living conditions
					{
					case "CF":
						baby.attrArray[0][1] = 0; // baby dies suddenly
						getCuriculum().append("<span class='health'>"+baby.getHtmlName() + " died during the first year of life. </span>");
						i = 12;
						break;
					case "F": // here should be at test depending on living condition... when that is
								// implemented!

					default:
						break;
					}
				}
			}
		}
	}

	public void DeathCheck(Settlement Village){
		
		double year= Village.getCurrentYear();

		for (int i = 0; i < nrOfAttr; i++) // Cleaning up the statline
		{
			if (attrArray[i][1] < 0) {
				attrArray[i][1] = 0;
			}
		}

		if (attrArray[2][1] < 1) {
			attrArray[0][1] = 0;
			getCuriculum().append("<span class='health'> In " + (int) year + " " + this.getHtmlName() + " died in bad health. </span>");
		} else if (attrArray[5][1] < 1) {
			attrArray[0][1] = 0;
			getCuriculum().append("<span class='health'> In " + (int) year + " " + this.getHtmlName() + " died of lost mind.</span> ");
		} else if (attrArray[6][1] < 1) {
			attrArray[0][1] = 0;
			getCuriculum().append("<span class='health'> In " + (int) year + " " + this.getHtmlName() + " died posessed by spirits. </span>");
		} else if (attrArray[8][1] < 1) {
			attrArray[0][1] = 0;
			getCuriculum().append("<span class='health'> In " + (int) year + " " + this.getHtmlName() + " died of lack of will to live. </span>");
		} else if (attrArray[19][1] < 1) {
			attrArray[0][1] = 0;
			getCuriculum().append("<span class='health'> In " + (int) year + " " + this.getHtmlName() + " died of wasting disease. </span>");
		}

		if (attrArray[0][1] == 0) {

			double base = Math.pow((this.attrArray[1][1] + this.attrArray[2][1] * 2) / 33, 2);

			home.useWorkForce(base * 270 * Math.random()); // was able to work some before demise

			// inheritance of toft

			if (home.getDeedOwner().equals(this)) {
				boolean inheritanceDone = false;

				if (this.partners.size() > 0) {
					home.setDeedOwner(Settlement.getSomeone(partners.get(0)));
					this.getCuriculum().append("<span class='inheritance'>The partner, " + Settlement.getSomeone(partners.get(0)).getHtmlName()
							+ ", inherited the deed to " + this.home.getName() + ".</span> ");
					inheritanceDone = true;
				} else if (this.children.size() > 0) {
					
					ArrayList<Actor> brood = getChildren();
					
					for (Actor child : brood) {
						if (child.isAlive()) {
							home.setDeedOwner(child);
							this.getCuriculum().append(
									"<span class='inheritance'> " + child.getHtmlName() + " inherited the deed to " + this.home.getName() + ". </span> ");
							inheritanceDone = true;
						}
					}
				}

				if (!inheritanceDone) {
					if (this.home.getOccupants().size() > 1) {
						for (Actor inhabitant : home.getOccupants()) {
							if (inhabitant.equals(this) && children.size()>0) {
								
								home.setDeedOwner(Settlement.getSomeone(children.get(0)));
								
								this.getCuriculum().append("<span class='inheritance'> " + inhabitant.getHtmlName() + " inherited the deed to "
										+ this.home.getName() + ". </span>");

							}
						}
					} else {
						// TODO just find a resident and hand the deed to that one.
						// When living condition are in, if there is no resident, find the most
						// overpopulated home and move some here
					}
				}
			}

			home.remOccupant(this);
			Village.getHome(0).addOccupant(this);
			attrArray[0][1]=0;
			getCuriculum().append("<span> In year " + (int) year + " " + this.getHtmlName() + " was buried. </span>");

			setDeathYear(year);

			//Now clear the dead person from all other partner lists in village
			
			ArrayList<Actor> partnerList = new ArrayList<Actor>();
			partnerList.addAll(getPartners());

			for (Actor Person : partnerList) {
				
				Person.remPartner(this);				
			}
			
			partners.clear();
		}
	}

	public boolean isAlive() {
		
		boolean A = true;

		if (this.attrArray[0][1] == 0) {
			A = false;
		}
		return A;
	}

	// Time for Love!!
	// ------------------------------------------------------------------
	public void getApartner(double year, Settlement village) {		

		if (partners.size() < 1 && isAlive()  && this.qAge(year) > 15) {// should be expanded to actually allow for more partners
			

			ArrayList<Actor> eligblePartners = new ArrayList<Actor>();

			// going through the whole Village
			for (Home HouseH : village.getHousehold()) {
				// finding houshold and if it is populated and not the graveyard
				int sizeOfHouse = HouseH.getOccupants().size();
				if (sizeOfHouse > 0 && !HouseH.getName().equals("Graveyard")) {
					
					// getting the occupants
					ArrayList<Actor> census = new ArrayList<Actor>();
					census.addAll(HouseH.getOccupants());

					for (Actor person : census) {
						
						// old enough and not engaged in other relation, and (for now) not of same sex, this will of course change
						
						if (person.qAge(year) > 15 && person.getPartners().size() < 1 && person.equals(this) && !this.qSex().equals(person.qSex())) {
							// Not to close related...

							boolean testParent = false;
							boolean testChild = false;
							boolean testMother = false;
							boolean testFather = false;

							if (birthplace.equals("This Village")) {
								testParent = person.children.contains(this);
								testChild = this.children.contains(person);
								testMother = this.getMother().equals(person.getMother());
								testFather = this.getFather().equals(person.getFather());

							}
							if (!testParent && !testChild && !testMother && !testFather) { //No incest... or at least not too much

								eligblePartners.add(person);
							}
						}
					}
				}
			}

			if (eligblePartners.size() > 0) {

				// if there are several in the list choose one at random and only one each year

				Actor target;

				if (eligblePartners.size() > 1) {

					Collections.shuffle(eligblePartners);
					target = eligblePartners.get(0);
					eligblePartners.remove(target);
				} else {
					target = eligblePartners.get(0);
					eligblePartners.remove(target);
				}

				getCuriculum().append(
						"<span> In the year " + (int) year + " " + getHtmlName() + " was courting " + target.getHtmlName() + ". </span> ");
				// Do they like your looks

				String testApp = Dice.testD100attr(this.getApp());

				// Are they needy? To lust passion is an small appearance effect added

				String partnerLust = Dice.testD100(50 - Math.pow(target.getVirtueArray()[1], 3) + (this.getApp() - 10) * 2);

				int passion = 0;
				// Calculationg the passion for marriage, more mods (economical) should be added
				switch (partnerLust) {
				case "CF":
					passion = -5;
					break;
				case "CS":
					passion = 15;
					break;
				case "F":
					passion = -1;
					break;
				default:
					passion = 1;
					break;
				}

				switch (testApp) {
				case "CF":
					passion += -5;
					break;
				case "CS":
					passion += 10;
					break;
				case "F":
					passion += 0;
					break;
				default:
					passion += 5;
					break;
				}

				if (passion > 0) {

					target.marriage(this, year);

					Family family = new Family(target, this, year);
					village.getFamilies().add(family);
//					target.addFamily(family);
//					this.addFamily(family);

					// if target for love do not live in the same home move in. This should be
					// changed to a option to build a new home
					if (!target.home.equals(this.home)) {
						home.addOccupant(target);
					}

				}
			}

			// if still single test if the will and passion is good for going to the city to
			// find a partner

			if (this.partners.size() < 1) {
				int desperation;
				String postagePartner = Dice.testD100attr(getWill() - getVirtueArray()[1]);
				switch (postagePartner) {
				case "CF":
					desperation = -5;
					break;
				case "CS":
					desperation = 5;
					break;
				case "F":
					desperation = -1;
					break;
				default:
					desperation = 1;
					break;
				}
				// modified by the number of children
				desperation += 10 - this.children.size() * 3;

				if (desperation > 0) {

					// should add code for the problem of finding someone!

					getCuriculum().append("<span class='partnerQuest'> In the year of " + (int)year + " " + getHtmlName()
							+ " travelled to a far town to find a lifepartner. </span>");
					String partnerSex;
					if (this.qSex().equals("Male")) {
						partnerSex = "Female";
					} else {
						partnerSex = "Male";
					}

					NameGenerator RandName = new NameGenerator();

					Actor Partner = new Actor(RandName.compose(3), partnerSex, year);
					Settlement.addPopulation(Partner);
					Partner.marriage(this, year);
					home.addOccupant(Partner);
					Family family = new Family(Partner, this, year);
					village.getFamilies().add(family);
					Partner.addFamily(family);
					this.addFamily(family);
				}
			}
		}
	}

	private void addFamily(Family family) {

		currentFamily = family;
		getFamilyHistory().add(family);

	}
	
	@Override
	public String toString() {
		
		StringBuilder test = new StringBuilder();
		
		for(int i=0;i<nrOfAttr;i++) {
			
			test.append(i+":"+attrArray[i][1]+",");
			
		}
		
		return name+" "+test;
	}

	// fast get the different Attributes, should in the end be made for them all...

	public double getWill() {
		double A = attrArray[8][1];
		return A;
	}

	private double getApp() {
		int A = (int) attrArray[10][1];
		return A;
	}

	public Actor getMother() {
		return mother;
	}

	public void setMother(Actor mother) {
		this.mother = mother;
	}

	public double[] getVirtueArray() {
		return virtueArray;
	}

	public void setVirtueArray(double[] virtueArray) {
		this.virtueArray = virtueArray;
	}

	public Actor getFather() {
		return father;
	}

	public void setFather(Actor father) {
		this.father = father;
	}

	public int[] getPubPot() {
		return pubPot;
	}

	public void setPubPot(int[] pubPot) {
		this.pubPot = pubPot;
	}

	public StringBuilder getCuriculum() {
		return curiculum;
	}

	public void setCuriculum(StringBuilder curiculum) {
		this.curiculum = curiculum;
	}

	public String getName() {
		
		return name;
	}
	
	public String getHtmlName() {
		
		String htmlname = "<span class='id"+this.getId()+"'><a href='#id"+this.getId()+"'>"+this.name+"</a></span>";
		
		return htmlname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBirthYear() {
		return birthDate;
	}

	public void setBirthYear(double birthYear) {
		this.birthDate = birthYear;
	}

	public double getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(double deathYear) {
		this.deathYear = (int) deathYear;
	}

	public ArrayList<String> getKenning() {
		return kenning;
	}

	public void setKenning(ArrayList<String> kenning) {
		this.kenning = kenning;
	}

	public ArrayList<Family> getFamilyHistory() {
		return familyHistory;
	}

//	public void setFamilyHistory(ArrayList<Family> familyHistory) {
//		this.familyHistory = familyHistory;
//	}

//	public int getId() {
//		return Id;
//	}
//
//	public void setId(int id) {
//		Id = id;
//	}


	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

//	public static int getActorsCreated() {
//		return actorsCreated;
//	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public double[][] getAttrArray() {
		return attrArray;
	}

	public void setAttrArray(double[][] attrArray) {
		this.attrArray = attrArray;
	}

	public ArrayList<Actor> getPartners() {
		
		ArrayList<Actor> occupantslist = new ArrayList<>();
		
		for(int person:partners) {
			
			occupantslist.add(Settlement.getSomeone(person));
		}
		return occupantslist;
	}

//	public void setPartners(ArrayList<Actor> partners) {
//		this.partners = partners;
//	}

	public ArrayList<Actor> getChildren() {
		
		ArrayList<Actor> childrenslist = new ArrayList<>();
		
		for(int person:children) {
			
			childrenslist.add(Settlement.getSomeone(person));
		}
		return childrenslist;
	}

	public void addChildren(Actor child) {
		
		children.add(child.getId());
	}

	public Family getCurrentFamily() {
		return currentFamily;
	}

	public void setCurrentFamily(Family newFamily) {
		this.currentFamily = newFamily;
	}


	

}
