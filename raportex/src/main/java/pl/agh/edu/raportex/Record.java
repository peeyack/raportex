
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((surnameAndName == null) ? 0 : surnameAndName.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (surnameAndName == null) {
			if (other.surnameAndName != null)
				return false;
		} else if (!surnameAndName.equals(other.surnameAndName))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}

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

