import java.util.ArrayList;

public class Family {

	

	Actor husb;
	Actor wife;
	ArrayList<Actor> chil= new ArrayList<Actor>();
	double marriageDate;
	
//constructor
	public Family( Actor one, Actor another, double year){
		
		if (one.qSex().equals("Male")){
		husb=one;
		wife=another;
		}else{
			husb=another;
			wife=one;	
		}
		
		
	}
	
	
	
	
//methods
	public String getGedcom(int nummer){ //the output function
		
		String A="0 @"+nummer+"@ FAM<br />1 HUSB @"+husb.qNumber()+"@ <br />2 WIFE @"+wife.qNumber()+"@ <br />";
		
		for(int i=0;i<chil.size();i++){
			int n=3+i;
			
			A+=n+" CHIL @"+chil.get(i).qNumber()+"@<br />";
		}
		
		return A;
	}
	
	
	public void addChild(Actor child){
		chil.add(child);
	}
	
}
