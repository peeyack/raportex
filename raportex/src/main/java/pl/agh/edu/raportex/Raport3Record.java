package pl.agh.edu.raportex;

import java.util.GregorianCalendar;

public class Raport3Record {
	
	private GregorianCalendar dayOfWeek;
	private double time;
	
	public Raport3Record(GregorianCalendar dayOfWeek, double time) {
		this.dayOfWeek = dayOfWeek;
		this.time = time;
	}


	public GregorianCalendar getDayOfWeek() {
		return dayOfWeek;
	}


	public void setDayOfWeek(GregorianCalendar dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}


	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	
	

}
