package pl.agh.edu.raportex;//wersja supertestowa

import java.util.ArrayList;

public class RaportGenerator {
	
	public static void main(String[] args) {
		
		
		
//		ArrayList<Record> dataFromWorkbookConventer = new ArrayList<Record>();
//		dataFromWorkbookConventer = WorkbookConverter.
		
		
		double sum = 0;
		
		ArrayList<Record> list = new ArrayList<Record>();
		
		//dodajemy klientów
		list.add(new Record("2017", "07", "Nowak_Jan", "projek1", "wykopanie rowu", 13, "C:/Users/student/workspace"));
		list.add(new Record("2017", "06", "Nowak_Jan", "projek2", "zasypanie rowu", 8, "C:/Users/student/workspace2"));
		list.add(new Record("2017", "05", "Kowalski_Piotr", "projek1", "wyrzucenie śmieci", 7.5, "C:/Users/student/workspace4"));
		
		//Record r1 = new Record("2017", "04", "", projectName, task, time, src)
		
			System.out.println("Nazwisko_Imię " + "Projekty " + "Czas ");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getSurnameAndName() + " " + list.get(i).getProjectName() + " " + list.get(i).getTime());
			if(list.get(i).getSurnameAndName() == "Nowak_Jan") {
				sum += list.get(i).getTime();
			}
		}
		
		System.out.println("Łącznie liczba przepracowanych godzin = " + sum);
	}

}
