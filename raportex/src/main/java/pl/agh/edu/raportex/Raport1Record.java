package pl.agh.edu.raportex;

public class Raport1Record {
	
	private String surnameAndName;
	private double time;
	
	public Raport1Record(String surnameAndName, double time) {
		this.surnameAndName = surnameAndName;
		this.time = time;
	}

	public String getSurnameAndName() {
		return surnameAndName;
	}

	public void setSurnameAndName(String surnameAndName) {
		this.surnameAndName = surnameAndName;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	public String toCSVReport1String() {
		return surnameAndName+","+time;
	}

}
