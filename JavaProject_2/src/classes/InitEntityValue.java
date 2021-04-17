package classes;
//<<<<<<< Upstream, based on branch 'main' of https://github.com/AccelerateKID-Steven/JavaProject2.git
//This Project is made by: Cocodadog, Potaioss, BlastedGlass07
//Metric System Calculator/Converter - has item, converts measurements of it into metric or just convert
//for now we just want to do one measurements at a time
public class InitEntityValue
{
	//field variables
	private String Unit;
	private boolean UnitSys; //if UnitSys true, convert to metric. if UnitSys false, convert to imperial
	private float Imperial, Metric;
	
	//default constructor
	public InitEntityValue(){
		Unit = "Celcius";
		UnitSys = true;
		Imperial = 32;
		Metric = 0;
	}
	public void IntiEntityValue(String Unit, boolean UnitSys, float Imperial, float Metric) {
		this.Unit = Unit;
		this.UnitSys = UnitSys;
		this.Imperial = Imperial;
		this.Metric = Metric;
		
	}
	public String getUnit(){return Unit;}
	public void setUnit(String Unit){this.Unit = Unit;}
	
	public boolean getUnitSys(){return UnitSys;}
	public void setUnitSys(boolean UnitSys){this.UnitSys = UnitSys;}
	
	public float getImperial(){return Imperial;}
	public void setImperial(float Imperial){this.Imperial = Imperial;}
	
	public float getMetric(){return Metric;}
	public void setMetric(float Metric){this.Metric = Metric;}
}
