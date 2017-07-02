
package pl.agh.edu.raportex;

import java.util.GregorianCalendar;

public class Record {
	
	private static int count = 0;
	private int id;
	private String year;
	private String month;
	private String surnameAndName;
	private String projectName;
	private String task;
	private double time;
	private String src;
	private GregorianCalendar date;
	
	public Record(String year, String month, String surnameAndName,
				String projectName, String task, double time, String src, GregorianCalendar date) {
		
		id = count++;
		this.year = year;
		this.month = month;
		this.surnameAndName = surnameAndName;
		this.projectName = projectName;
		this.task = task;
		this.time = time;
		this.src = src;
		this.date = date;
		
	}
	public Record(String year, String month, String surnameAndName,
			String projectName, String task, double time, String src) {
	
	id = count++;
	this.year = year;
	this.month = month;
	this.surnameAndName = surnameAndName;
	this.projectName = projectName;
	this.task = task;
	this.time = time;
	this.src = src;
	
	
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}


	public String getSurnameAndName() {
		return surnameAndName;
	}

	public void setSurnameAndName(String surnameAndName) {
		this.surnameAndName = surnameAndName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	

	public GregorianCalendar getDate() {
		return date;
	}

	public void setDate(GregorianCalendar date) {
		this.date = date;
	}

	
	public String toLongString() {
		return "Record [id=" + id + ", year=" + year + ", month=" + month + ", surnameAndName=" + surnameAndName
				+ ", projectName=" + projectName + ", task=" + task + ", time=" + time + ", src=" + src + ", date="
				+ date.toInstant().toString() + "]";
	}
	
	public String toCSVReport1String() {
		return id + "," + year + ","  + month + "," + surnameAndName+ "," + projectName + "," + task + "," + time + "," + src + ","
				+ date.toInstant().toString();
	}



	
}

