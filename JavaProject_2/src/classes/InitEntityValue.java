package classes;
//<<<<<<< Upstream, based on branch 'main' of https://github.com/AccelerateKID-Steven/JavaProject2.git
//This Project is made by: Cocodadog, Potaioss, BlastedGlass07
//Scheduler - Input time and what you'll need to do, and press button. 
//Repeat as many times as necessary and the inputted stuff will sort by time. dd/mm/yy
public class InitEntityValue
{
	//field variables
	private String Plans, Time, Date;
	private int Hour, Minute, Day, Month, Year; //gonna combine all into Date, and use them to sort to-dos
	
	public InitEntityValue(String strPlan, String strTime){
		Plans = "Eat Dinner";
		Time = "5:30";
		Day = 5;
		Month = 5;
		Year = 5;
	}
	public void IntiEntityValue(String Plans, String Time, int Day, int Month, int Year) {
		this.Plans = Plans;
		this.Time = Time;
		this.Day = Day;
		this.Month = Month;
		this.Year = Year;
	}
	public String toString()
	{
	      String myString;
	      myString =  Time + " - " + Plans;
	      
	      return myString;
	      
	}
	public String getPlans(){return Plans;}
	public void setPlans(String Plans){this.Plans = Plans;}
	
	public String getTime(){return Time;}
	public void setTime(String Time){this.Time = Time;}
	
	public int getDay(){return Day;}
	public void setDay(int Day){this.Day = Day;}
	
	public int getMonth(){return Month;}
	public void setMonth(int Month){this.Month = Month;}
	
	public int getYear(){return Year;}
	public void setYear(int Year){this.Year = Year;}
}
