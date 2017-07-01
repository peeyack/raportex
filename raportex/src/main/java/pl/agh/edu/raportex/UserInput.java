package pl.agh.edu.raportex;
import java.util.Scanner;

public class UserInput {
	
	private String path="";
	
	
	public String getPath() {
		return path;
	}
	
	public UserInput() {
	}


	public boolean readPath(String softVer) {
		boolean loadStatus = true;
		System.out.println("Witaj w programie Raportex " + softVer + "! \n"
				+ "Podaj sciezke do zasobu:\n");
		path = readOneLine();
		System.out.println("----------------------- \n"
				+"Sciezka zaakceptowana \n");
		return loadStatus;
	}
	
	
	public void displayReportChoice() {
		System.out.println("Wybierz raport:\n"
				+ "1. Raport ilosci godzin przepracowanych przez pracownikow \n"
				+ "2. Raport ilosci godzin przepracowanych przy projektach \n"
				+ "3. Raport ilosci godzin przepracowanych w poszczegolnych dniach tygodnia \n"
				+ "0. Zamknij \n");
	}
	
	public int readReportChoice() {
		boolean status = false;
		int output = 0;
		while (status == false) {
			displayReportChoice();			
			String choice =  readOneLine();
			try {
				output = Integer.parseInt(choice);
				status = true;
				System.out.println("----------------------- \n"
						+ "Wybrales raport numer: "+ output);
			} catch (NumberFormatException ex) {
				System.out.println("Blad wyboru! Sprobuj jeszcze raz. \n");
			}
		}
		
		return output;
	}
	
	public String readOneLine() {
		Scanner scanner = new Scanner(System.in);
		
		String output  = scanner.nextLine();
		
		return output;
	}
	
		
	
	
	
}
