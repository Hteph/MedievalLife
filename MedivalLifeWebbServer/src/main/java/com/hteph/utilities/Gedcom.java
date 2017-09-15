package com.hteph.utilities;

import com.hteph.modules.Actor;
import com.hteph.modules.Family;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;

public class Gedcom {

	// methods

	public static String writer(Settlement village) {
		String A = "0 HEAD<br />1 FILE family.ged<br />1 GEDC<br />2 VERS 5.5<br />2 FORM LINEAGE - LINKED<br />1 CHAR ANSI<br />";

		int i = 0;
		for (Family fam : village.getFamilies()) {

			A += "0 @F" + i + "@ FAM<br />1 HUSB @I" + fam.getHusband().qNumber() + "@<br />1 WIFE @I"
					+ fam.getWife().qNumber() + "@<br />";

			for (Integer kid : fam.getChildren()) {

				A += "1 CHIL @I" + Settlement.population.get(kid).qNumber() + "@<br />";

			}
			A += "1 NCHI " + fam.getChildren().size() + "<br />";

			i++;
		}

		for (Home household : village.getHousehold()) {
			for (Actor person : household.getOccupants()) {

				A += "0 @I" + person.qNumber() + "@ INDI<br />";
				A += "1 NAME " + person.getHtmlName() + " /Wilder/<br />";
				if (person.qSex().equals("Male")) {
					A += "1 SEX M<br />";
				} else {
					A += "1 SEX F<br />";
				}

				A += "1 BIRT <br />2 DATE " + (int) person.getBirthYear() + "<br />";
				if (person.getDeathYear() != -1) {
					A += "1 DEAT <br />2 DATE " + (int) person.getDeathYear() + "<br />";
				}
// This is removed for XML reasons should probably be inserted again in a smarter way -------------------------------------------------------------------------

//				for (Family famm : village.getFamilies()) {
//					for (Integer kid : famm.getChildren()) {
//
//
//							A += "1 FAMC @F" + village.getFamilies().indexOf(famm) + "@<br />";
//
//					}
//				}
//				for (Family fammy : person.getFamilyHistory()) {
//					if (fammy.getHusb().equals(person) || fammy.getWife().equals(person)) {
//						A += "1 FAMS @F" + village.getFamilies().indexOf(fammy) + "@<br />";
//					}
//				}
			}
		}

		A += "0 TRLR";

		return A;
	}

}
