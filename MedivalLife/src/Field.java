

public class Field {
	
	double size; //size of field in acres
    String crop; // current planted crop
    double plantingTime;
    double fertility; // how fertile the field is
    
     
    //constructor
    public Field(double size , double fertility)
    {
    this.size=size;
    this.fertility=fertility;
    }
     
    //methods
    public void Planting(String crop, double time)
    {
    this.crop=crop;
    plantingTime=time;
    }
     
    public double Harvest(double time, double workforce)
    {
    	double x=0;
    	//something something yield something
    	
    	return x;
    }


}
