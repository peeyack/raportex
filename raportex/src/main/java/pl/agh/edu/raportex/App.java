package pl.agh.edu.raportex;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;



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
				break;
			case 2:
				break;
			case 3:
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
    	while (!choice.equalsIgnoreCase("t")||choice.equalsIgnoreCase("n")) {
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
