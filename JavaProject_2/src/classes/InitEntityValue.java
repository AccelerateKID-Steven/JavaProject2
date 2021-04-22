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
	
	//default constructor
	public InitEntityValue(){
		Plans = "Eat Dinner";
		Time = "4:30";
		Date = "8/10/2019";
	}
	public void IntiEntityValue(String Plans) {
		this.Plans = Plans;
		this.Time = Hour + " : " + Minute;
		this.Date = Day + "/" + Month + "/" + Year;
		
	}
	public String toString()
	{
	      String myString;
	      myString =  Time + " - " + Plans;
	      
	      return myString;
	      
	}
	public String getPlans(){return Plans;}
	public void setPlans(String Plans){this.Plans = Plans;}
	
	public int getHour(){return Hour;}
	public void setHour(int Hour){this.Hour = Hour;}
	
	public int getMinute(){return Minute;}
	public void setMinute(int Minute){this.Minute = Minute;}
	
	public int getDay(){return Day;}
	public void setDay(int Day){this.Day = Day;}
	
	public int getMonth(){return Month;}
	public void setMonth(int Month){this.Month = Month;}
	
	public int getYear(){return Year;}
	public void setYear(int Year){this.Year = Year;}
}
