package pl.agh.edu.raportex;//wersja supertestowa

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RaportGenerator {

	// public static void main(String[] args) {

	// ArrayList<Record> dataFromWorkbookConventer = new ArrayList<Record>();
	// dataFromWorkbookConventer = WorkbookConverter.

	// double sum = 0;
	//
	// ArrayList<Record> list = new ArrayList<Record>();
	//
	// //dodajemy klientów
	// list.add(new Record("2017", "07", "Nowak_Jan", "projek1", "wykopanie
	// rowu", 13, "C:/Users/student/workspace"));
	// list.add(new Record("2017", "06", "Nowak_Jan", "projek2", "zasypanie
	// rowu", 8, "C:/Users/student/workspace2"));
	// list.add(new Record("2017", "05", "Kowalski_Piotr", "projek1",
	// "wyrzucenie śmieci", 7.5, "C:/Users/student/workspace4"));
	//
	// //Record r1 = new Record("2017", "04", "", projectName, task, time, src)
	//
	// System.out.println("Nazwisko_Imię " + "Projekty " + "Czas ");
	//
	// for(int i = 0; i < list.size(); i++) {
	// System.out.println(list.get(i).getSurnameAndName() + " " +
	// list.get(i).getProjectName() + " " + list.get(i).getTime());
	// if(list.get(i).getSurnameAndName() == "Nowak_Jan") {
	// sum += list.get(i).getTime();
	// }
	// }
	//
	// System.out.println("Łącznie liczba przepracowanych godzin = " + sum);
	//
	public ArrayList<Raport1Record> makeRaportOne(ArrayList<Record> list) {
		ArrayList<Raport1Record> raportOne = new ArrayList<>();
//petla
		for (int i = 0; i < list.size(); i++) {

			String surname = list.get(i).getSurnameAndName();
			boolean exists = false;
			for (int j = 0; j < raportOne.size(); j++) {
				if (surname.equals(raportOne.get(j).getSurnameAndName())) {
					raportOne.get(j).setTime(raportOne.get(j).getTime() + list.get(i).getTime());
					exists = true;

				}

			}

			if (!exists) {
				Raport1Record rekord = new Raport1Record(list.get(i).getSurnameAndName(), list.get(i).getTime());
				raportOne.add(rekord);
			}

		}

		return raportOne;
	}
	
	public ArrayList<Raport2Record> makeRaporTwo(ArrayList<Record> list) {
		ArrayList<Raport2Record> raportTwo = new ArrayList<>();
//petla
		for (int i = 0; i < list.size(); i++) {

			String project = list.get(i).getProjectName();
			boolean exists = false;
			for (int j = 0; j < raportTwo.size(); j++) {
				if (project.equals(raportTwo.get(j).getProjectName())) {
					raportTwo.get(j).setTime(raportTwo.get(j).getTime() + list.get(i).getTime());
					exists = true;

				}

			}

			if (!exists) {
				Raport2Record rekord = new Raport2Record(list.get(i).getProjectName(), list.get(i).getTime());
				raportTwo.add(rekord);
			}

		}

		return raportTwo;
	}
	
	public ArrayList<Raport3Record> makeRaporThree(ArrayList<Record> list) {
		ArrayList<Raport3Record> raportThree = new ArrayList<>();
//petla
		for (int i = 0; i < list.size(); i++) {

			GregorianCalendar DayOfTheWeek = list.get(i).getDate();
			boolean exists = false;
			for (int j = 0; j < raportThree.size(); j++) {
				if (DayOfTheWeek.equals(raportThree.get(j).getDayOfWeek())) {
					raportThree.get(j).setTime(raportThree.get(j).getTime() + list.get(i).getTime());
					exists = true;

				}

			}

			if (!exists) {
				Raport3Record rekord = new Raport3Record(list.get(i).getDate(), list.get(i).getTime());
				raportThree.add(rekord);
			}

		}

		return raportThree;
	}
	

}

