package pl.agh.edu.raportex;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {

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
				
				break;

			case 0:
				System.out.println("Do zobaczenia!");
				System.exit(0);
				break;
			}
		}
		
		

		/*
		 * ArrayList<String> list = new ArrayList<>(); list.add("dasfasdfasdfads");
		 * list.add("afdasdfasdfasdf"); String savePath = "C:\\Test\\dupa.csv";
		 * ExportCSV exp= new ExportCSV(list,savePath); //Test Do export CSV end
		 */

		// */

		/*
		 * //Test treeExplorer TreeExplorer zxc = new TreeExplorer(); zxc.
		 * treeSearch("C:\\Users\\student\\Desktop\\raportex\\raportex\\src\\test\\resources\\reporter-dane\\reporter-dane poprawne\\2013"
		 * ); System.out.println(zxc.getFileNumber());
		 */
	}
}
