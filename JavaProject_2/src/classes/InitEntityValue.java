package classes;
//<<<<<<< Upstream, based on branch 'main' of https://github.com/AccelerateKID-Steven/JavaProject2.git
//This Project is made by: Cocodadog, Potaioss, BlastedGlass07
//Scheduler - Input time and what you'll need to do, and press button. 
//Repeat as many times as necessary and the inputted stuff will sort by time. dd/mm/yy

import java.util.ArrayList;

public class InitEntityValue
{
	//field variables
	private String Plans, Time, Date;
	protected String EventLocation;
	private int Hour, Minute, Day, Month, Year; //gonna combine all into Date, and use them to sort to-dos
	
	public InitEntityValue(){
		Plans = "Eat Dinner";
		Time = "5:30";
		Date = "5/5/2005"; //Day + "/" + Month + "/" + Year
	}
	public InitEntityValue(String Plans, String Time, String Date)
	{
		this.Plans = Plans;
		this.Time = Time;
		this.Date =  Date;
	}
	public class LocationAdder extends InitEntityValue
	{
		public LocationAdder()
		{
			EventLocation = "School";
		}
		public LocationAdder(String EventLocation)
		{
			this.EventLocation = EventLocation;
		}
	}
	
	
	
	public String getPlans(){return Plans;}
	public void setPlans(String Plans){this.Plans = Plans;}
	
	public String getTime(){return Time;}
	public void setTime(String Time){this.Time = Time;}
	
	public String getDate(){return Date;}
	public void setDate(String Date){this.Date = Date;}
	
	public String getEventLocation() {return EventLocation;}
	public void setEventLocation(String EventLocation) {this.EventLocation = EventLocation;}
}
