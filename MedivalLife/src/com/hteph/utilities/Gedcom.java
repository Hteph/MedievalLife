package com.hteph.utilities;
import com.hteph.modules.Actor;
import com.hteph.modules.Family;
import com.hteph.modules.Home;
import com.hteph.modules.Settlement;

public class Gedcom {

	//methods

	public static String writer(Settlement village)
	{
		String A="0 HEAD<br />1 FILE family.ged<br />1 GEDC<br />2 VERS 5.5<br />2 FORM LINEAGE - LINKED<br />1 CHAR ANSI<br />";



		int i=0;
		for(Family fam:village.families){

			A+="0 @F"+i+"@ FAM<br />1 HUSB @I"+fam.husb.qNumber()+"@<br />1 WIFE @I"+fam.wife.qNumber()+"@<br />";


			for(Actor kid:fam.chil){
				
				A+="1 CHIL @I"+kid.qNumber()+"@<br />";


			}
			A+="1 NCHI "+fam.chil.size()+"<br />";

			i++;
		}

		for(Home household:village.household){
			for(Actor person:household.occupants){

				A+="0 @I"+person.qNumber()+"@ INDI<br />";
				A+="1 NAME "+person.name+" /Wilder/<br />";
				if(person.qSex().equals("Male")){A+="1 SEX M<br />";}else{A+="1 SEX F<br />";}
				
				A+="1 BIRT <br />2 DATE "+(int)person.birthYear+"<br />";
				if(person.deathYear !=-1){A+="1 DEAT <br />2 DATE "+(int)person.deathYear+"<br />";}	
				
				for(Family famm:village.families){
					for(Actor kid:famm.chil){

					if(kid.equals(person)){A+="1 FAMC @F"+village.families.indexOf(famm)+"@<br />";}	
				}
				}


				for(Family fammy:person.familyHistory){
				if(fammy.husb.equals(person) || fammy.wife.equals(person)){A+="1 FAMS @F"+village.families.indexOf(fammy)+"@<br />";}			
				}
			}
		}

		A+="0 TRLR";


		return A;
	}

}
