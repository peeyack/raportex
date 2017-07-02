package pl.agh.edu.raportex;

public class Raport2Record {
	
	private String projectName;
	private double time;
	
	public Raport2Record(String projectName, double time) {
		this.projectName = projectName;
		this.time = time;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String toCSVReport1String() {
		return projectName+","+time;
	}
	

}
