package pl.agh.edu.raportex;

import java.util.GregorianCalendar;

public class Raport3Record {
	
	private int dayOfWeek;
	private double time;
	
	public Raport3Record(int dayOfWeek, double time) {
		this.dayOfWeek = dayOfWeek;
		this.time = time;
	}


	public int getDayOfWeek() {
		return dayOfWeek;
	}


	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}


	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String toCSVReport1String() {
		return Integer.toString(dayOfWeek)+","+time;
	}
	

}
