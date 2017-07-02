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
				break;
			case 2:
				RaportGenerator rap2 = new RaportGenerator();
				ArrayList<Raport2Record> report2List = rap2.makeRaporTwo(records);
				for (Raport2Record r : report2List) {
					System.out.println(r.toCSVReport1String());
				}
				break;
			case 3:
				RaportGenerator rap3 = new RaportGenerator();
				ArrayList<Raport3Record> report3List = rap3.makeRaporThree(records);
				for (Raport3Record r : report3List) {
					System.out.println(r.toCSVReport1String());
				}
				break;
			case 4:
				for (Record r : records) {
					System.out.println(r.toLongString());
				}
				saveCsvQuery(records, ui.getPath().getAbsolutePath());	
				
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
    	while (!choice.equalsIgnoreCase("t")||!choice.equalsIgnoreCase("n")) {
    	System.out.println("Czy zapisac raport do pliku CSV? (t/n)"); 
		choice = UserInput.readOneLine();
		
			if (choice.equalsIgnoreCase("t")) {
				ExportCSV.ExportCSVFromRecord(input, (path + "\\daneWejsRap.csv"));
				System.out.println("Plik zapisany w: \n"+path+"\\daneWejsRap.csv");
			} else if (choice.equalsIgnoreCase("n")) {
				
			} 
		}
	}
}
