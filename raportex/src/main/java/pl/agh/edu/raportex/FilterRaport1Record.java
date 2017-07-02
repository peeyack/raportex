package pl.agh.edu.raportex;

import java.util.ArrayList;

public class FilterRaport1Record {
	ArrayList<Raport1Record> myData;

	public FilterRaport1Record(ArrayList<Raport1Record> data) {
		this.myData = data;
	}
	
	
	public ArrayList<Raport1Record> filterByTimeSpendOnWork(Double time) {
		ArrayList<Raport1Record> filteredData = new ArrayList<>();
		
		for (Raport1Record data : myData) {
			if (data.getTime() > time) {
				filteredData.add(data);
			}
		}
		return filteredData;
	}

}
