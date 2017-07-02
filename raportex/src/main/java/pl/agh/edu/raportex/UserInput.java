package pl.agh.edu.raportex;
import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class UserInput {
	
	private String path="";
	private File tPath;
	
	
	public File getPath() {
		return tPath;
	} 
	
	public UserInput() {
	}


	public boolean readPath(String softVer) {
		boolean loadStatus = false;
		while (loadStatus == false) {
			displayReadPath(softVer);
			path = readOneLine();
			this.tPath = new File(path);
			if (tPath.isDirectory() || tPath.isFile()) {
				System.out.println("----------------------- \n" + "Sciezka zaakceptowana \n");
				loadStatus = true;
			} else {
				System.out.println("Bledna sciezka, sprobuj jeszcze raz!");
			}
		}
		return loadStatus;
	}
	
	private void displayReadPath(String softVer) {
		System.out.println("Witaj w programie Raportex " + softVer + "! \n"
				+ "Podaj sciezke do zasobu:\n");
	}
	
	
	public void displayReportChoice() {
		System.out.println("Wybierz raport:\n"
				+ "1. Raport ilosci godzin przepracowanych przez pracownikow \n"
				+ "2. Raport ilosci godzin przepracowanych przy projektach \n"
				+ "3. Raport ilosci godzin przepracowanych w poszczegolnych dniach tygodnia \n"
				+ "4. Wyswietlenie danych wejsciowych \n"
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
			} catch (NumberFormatException ex) {
				System.out.println("Blad wyboru! Sprobuj jeszcze raz. \n");
			}
		}
		
		return output;
	}
	
	public static String readOneLine() {
		Scanner scanner = new Scanner(System.in);
		
		String output  = scanner.nextLine();
		
		return output;
	}
	
		
	
	
	
}
