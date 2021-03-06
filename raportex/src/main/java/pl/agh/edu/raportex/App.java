package pl.agh.edu.raportex;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;



public class App 
{

    public static void main( String[] args ) throws InterruptedException, IOException
 
    

    {

		UserInput ui = new UserInput();
		ui.readPath("2.0");
		TreeExplorer te = new TreeExplorer();
		te.treeSearch(ui.getPath().getAbsolutePath());
		ArrayList<Record> records = WorkbookConverter.getRecordsFromManyFiles(te.getPaths());
		
		System.out.println("Ilość rekordów: " + records.size());
		System.out.println("Ilość plików: " + te.getPaths().size());
		System.out.println("Ilosc bledow we wczytanych plikach: " + WorkbookConverter.warnings.size());
		
		

		while (true) {
			System.out.println("------------------------------------");
			int choice = ui.readReportChoice();
			if (choice != 0) {
				System.out.println("----------------------- \n" + "Wybrales raport numer: " + choice);
			}
			switch (choice) {
			case 1:
				RaportGenerator rap1 = new RaportGenerator();
				ArrayList<Raport1Record> report1List = rap1.makeRaportOne(records);
				for (Raport1Record r : report1List) {
					System.out.println(r.toCSVReport1String());
				}
				saveCsvQueryR1(report1List,ui.getPath().getAbsolutePath());
				break;
			case 2:
				RaportGenerator rap2 = new RaportGenerator();
				ArrayList<Raport2Record> report2List = rap2.makeRaporTwo(records);
				for (Raport2Record r : report2List) {
					System.out.println(r.toCSVReport1String());
				}
				saveCsvQueryR2(report2List,ui.getPath().getAbsolutePath());
				break;
				
			case 3:
				RaportGenerator rap3 = new RaportGenerator();
				ArrayList<Raport3Record> report3List = rap3.makeRaporThree(records);
				for (Raport3Record r : report3List) {
					System.out.println(r.toCSVReport1String());
				}
				saveCsvQueryR3(report3List,ui.getPath().getAbsolutePath());
				break;
			case 4:
				for (Record r : records) {
					System.out.println(r.toLongString());
				}
				saveCsvQuery(records, ui.getPath().getAbsolutePath());	
				
				break;
			case 5: 
				for (WorkbookConverterWarning r : WorkbookConverter.warnings ) {
					System.out.println(r.getText());
				}
				if (WorkbookConverter.warnings.size() ==0) {
					System.out.println("Nie ma bledow w danych, 0 rekordow wyswietlonych \n");
				}
				break;	
			case 6:
				System.out.println("Wybierz filtr: \n "
						+ "1. filtr po nazwisku \n"
						+ "2. filtr po projekcie");
				String wybor = UserInput.readOneLine();
				
					switch (wybor) {
						case "1" :
							System.out.println("wpisz imie i nazwisko");
							FilterInputData data1 = new FilterInputData(records);
							records = data1.filterBySurnameAndName(UserInput.readOneLine());
							break;
						case "2" :
							System.out.println("wpisz nazwe projektu");
							FilterInputData data2 = new FilterInputData(records);
							records = data2.filterByProjekt(UserInput.readOneLine());
							break;
					}
				break;
				
			case 0:
				System.out.println("Do zobaczenia!");
				System.exit(0);
				break;
			}
		}
	
	

    }
    
    
    
    private static void saveCsvQuery(ArrayList<Record> input, String path) {
		String choice = "";
		
    	while (true) {
    	System.out.println("Czy zapisac raport do pliku CSV? (t/n)"); 
		choice = UserInput.readOneLine();
		
			if (choice.equalsIgnoreCase("t")) {
				ExportCSV.ExportCSVFromRecord(input, (path + "\\daneWejsRap.csv"));
				System.out.println("Plik zapisany w: \n"+path+"\\daneWejsRap.csv");
				break;
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Plik nie zostal zapisany!");
				break;
			} 
		}
	}
    
    private static void saveCsvQueryR1(ArrayList<Raport1Record> input, String path) {
		String choice = "";
    	while (true) {
    	System.out.println("Czy zapisac raport do pliku CSV? (t/n)"); 
		choice = UserInput.readOneLine();
		
			if (choice.equalsIgnoreCase("t")) {
				ExportCSV.ExportCSVFromRaport1Record(input, (path + "\\Rap1.csv"));
				System.out.println("Plik zapisany w: \n"+path+"\\Rap1.csv");
				break;
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Plik nie zostal zapisany!");
				break;
			} 
		}
	}
    
    private static void saveCsvQueryR2(ArrayList<Raport2Record> input, String path) {
		String choice = "";
    	while (true) {
    	System.out.println("Czy zapisac raport do pliku CSV? (t/n)"); 
		choice = UserInput.readOneLine();
		
			if (choice.equalsIgnoreCase("t")) {
				ExportCSV.ExportCSVFromRaport2Record(input, (path + "\\Rap2.csv"));
				System.out.println("Plik zapisany w: \n"+path+"\\Rap2.csv");
				break;
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Plik nie zostal zapisany!");
				break;
			} 
		}
	}
    
    private static void saveCsvQueryR3(ArrayList<Raport3Record> input, String path) {
		String choice = "";
    	while (true) {
    	System.out.println("Czy zapisac raport do pliku CSV? (t/n)"); 
		choice = UserInput.readOneLine();
		
			if (choice.equalsIgnoreCase("t")) {
				ExportCSV.ExportCSVFromRaport3Record(input, (path + "\\Rap3.csv"));
				System.out.println("Plik zapisany w: \n"+path+"\\Rap3.csv");
				break;
			} else if (choice.equalsIgnoreCase("n")) {
				System.out.println("Plik nie zostal zapisany!");
				break;
			} 
		}
	}
    
 
}
