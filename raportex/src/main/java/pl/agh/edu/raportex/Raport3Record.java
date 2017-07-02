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

	public String toCSVReport1String() {
		return java.util.Date.from(
			    dayOfWeek.toZonedDateTime()
	             .toInstant()
	)+","+time;
	}
		
	private String getDay(GregorianCalendar date) {
		switch (date.get(GregorianCalendar.DAY_OF_WEEK)) {
			case 1: return "Poniedzialek";
			case 2: return "Wtorek";
			case 3: return "Sroda";
			case 4: return "Czwartek";
			case 5: return "Piatek";
			case 6: return "Sobota";
			case 7: return "Niedziela";
			default: return "Nieznane";
		}
	}

}
