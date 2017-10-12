package com.hteph.utilities;

import java.util.ArrayList;

import com.hteph.modules.Actor;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;

public class Chronicler {
	
	
	public static String createChronicle(Settlement Village) {
		StringBuilder chronicle = new StringBuilder();

		chronicle.append("<!DOCTYPE html><html lang='en'><head>");
		chronicle.append("<link rel='stylesheet' href='resources/css/medievalStyle.css'>");
		chronicle.append("<title>A Medieval Heritage Tree</title></head><body>");
		chronicle.append("<header><h1>A Medieval Heritage Tree</h1>");
		chronicle.append("<span class='subtitle'>In the year of " + (int) Village.getFoundingYear() + " " + Village.getFounder()
		+ " took to the woods to start a new life as his own man.");
		chronicle.append("This is his clan at the year of " + (int)Village.getCurrentYear()+"</span></header>");

		for (Home HouseH : Village.getHousehold()) {

			int sizeOfHouse = HouseH.getOccupants().size();

			if (sizeOfHouse > 0) {
				chronicle.append("<div>");
				
				ArrayList<Actor> census = new ArrayList<Actor>();
				census.addAll(HouseH.getOccupants());
				
				chronicle.append("<h2>At " + HouseH.getName() + "</h2>");
				chronicle.append("<span class='tooltip'>");
				
				if(HouseH.getName().equals("Graveyard")) chronicle.append("<img class='largeIcon' src='resources/gfx/graveyard.png' alt='graveyard icon by Delapouite under CC BY 3.0'>");
				else chronicle.append("<img class='largeIcon' src='resources/gfx/house.png' alt='house icon by Delapouite under CC BY 3.0'>");
				
				chronicle.append("<span class='tooltiptext'>Click for hide/reveal location</span></span>");
				chronicle.append("<section class='household' id='"+HouseH.getName()+"'>");
				
				
				for (Actor person : census) {
					
					System.out.println(HouseH.getName()+" varv "+1+" of "+census.size());
					
					if (person.isAlive()) {
						chronicle.append("<header class='living person'><h3 id='id"+person.getId()+"'>"+person.getHtmlName() + "</h3>");
						chronicle.append("<span class='tooltip'>");
						chronicle.append("<img class='icon' src='resources/gfx/farmer.png' alt='farmer icon by Delapouite under CC BY 3.0'>");
						chronicle.append("<span class='tooltiptext'>Click me to hide/reveal persons chronicle</span></span>" );
						// The over of the current household get this marker
						if(HouseH.getDeedOwner().equals(person)) chronicle.append("<img class='deedIcon' src='resources/gfx/house.png' alt='house icon by Delapouite under CC BY 3.0'>");

						chronicle.append("<div class='factoid'> ("+ person.qSex() + ")(" + (int) person.getBirthYear() + "- "+ ")</div> </header>");
					} else {
						chronicle.append("<header class='dead person'><h3 id='id"+person.getId()+"'>"+person.getHtmlName() + "</h3>");
						chronicle.append("<span class='tooltip'>");
						chronicle.append("<img class='icon' src='resources/gfx/tombstone.png' alt='tombstone icon by Lorc under CC BY 3.0'>");
						chronicle.append("<span class='tooltiptext'>Click me to hide/reveal persons chronicle</span></span>" );
						chronicle.append("<div class='factoid'>(" + (int) person.getBirthYear() + "- "+ (int) person.getDeathYear() + ")</div></header>");
					}
					chronicle.append("<article class='chronicleText'>"+person.getCuriculum().toString());

					if (person.getKenning().size() > 0 && person.isAlive()) {

						chronicle.append("<p class='kenning'>(aka: " + person.getKenning().toString() + ")</p>");

					}												
					chronicle.append("</article>");
				}				
				chronicle.append("</section>");
			}	
			chronicle.append("</div>");
		}
		//chronicle.append(Gedcom.writer(Village));
		chronicle.append("<footer><span>All icons are made and manipulated at the excellent <a href='http://game-icons.net/'>game-icons.net</a></span></span>");
		chronicle.append("<aside id='utilities'> <button style='display: block' id='readability' type='button'>Readability</button>");
		chronicle.append("<button style='display: block' id='collapseArticle' type='button'>Collapse All</button></aside>");
		chronicle.append("<script type ='text/javascript' src ='resources/jquery-3.2.1.min.js'></script>");
		chronicle.append("<script type ='text/javascript' src ='resources/medievalJavascript.js'></script>");
		chronicle.append("</body></html>");
		
		return chronicle.toString();
	}

}
