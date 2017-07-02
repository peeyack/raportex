package pl.agh.edu.raportex;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	UserInput ui=new UserInput();
    	ui.readPath("2.0");
    	TreeExplorer te=new TreeExplorer();
    	te.treeSearch(ui.getPath().getAbsolutePath());
    	ArrayList<Record> records=WorkbookConverter.getRecordsFromManyFiles(te.getPaths());
    	System.out.println("Ilość rekordów: "+records.size());
    	System.out.println("Ilość plików: "+te.getPaths().size());
   
    	System.out.println("Ilość błędów: "+WorkbookConverter.warnings.size());
    	
    	for (WorkbookConverterWarning warning:WorkbookConverter.warnings) {
    		System.out.println(warning.getText());
    	}
    	

/*    	ArrayList<String> list = new ArrayList<>();
		list.add("dasfasdfasdfads");
		list.add("afdasdfasdfasdf");
		String savePath = "C:\\Test\\dupa.csv";
		ExportCSV exp= new ExportCSV(list,savePath);
    	//Test Do export CSV end
   */ 	

		//int choice = ui.readReportChoice();*/
		
    	
    	//Test treeExplorer
    
    }
}
