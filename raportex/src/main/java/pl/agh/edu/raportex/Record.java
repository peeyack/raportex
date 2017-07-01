package pl.agh.edu.raportex;

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
	
	
}
