package pl.agh.edu.raportex;

import java.util.ArrayList;

public class FilterInputData {
	ArrayList<Record> myData;

	public FilterInputData(ArrayList<Record> myData) {
		this.myData = myData;
	}

	public ArrayList<Record> filterBySurnameAndName(String surnameAndName) {
		ArrayList<Record> filteredData = new ArrayList<>();
		
		for (Record data : myData) {
			if (data.getSurnameAndName().equals(surnameAndName)) {
				filteredData.add(data);
			}
		}
		return filteredData;
	}
	
	public ArrayList<Record> filterByProjekt(String projektName) {
		ArrayList<Record> filteredData = new ArrayList<>();
		
		for (Record data : myData) {
			if (data.getProjectName().equals(projektName)) {
				filteredData.add(data);
			}
		}
		return filteredData;
	}
	

}
