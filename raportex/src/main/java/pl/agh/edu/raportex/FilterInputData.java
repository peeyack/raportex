package pl.agh.edu.raportex;

import java.util.ArrayList;

public class FilterInputData {
	ArrayList<Record> myData;
	ArrayList<Record> filteredData;

	public FilterInputData(ArrayList<Record> myData) {
		this.myData = myData;
		filteredData = new ArrayList<>();
	}

	public void filterBySurnameAndName(String surnameAndName) {
		for (Record data : myData) {
			if (data.getSurnameAndName().equals(surnameAndName)) {
				filteredData.add(data);
			}
		}
	}
}
