package pl.agh.edu.raportex;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
  		


       
 /*    	//TEST DO EXPORT CSV
    	ArrayList<String> list = new ArrayList<>();
		list.add("dasfasdfasdfads");
		list.add("afdasdfasdfasdf");
		String savePath = "C:\\Test\\dupa.csv";
		ExportCSV exp= new ExportCSV(list,savePath);
    	//Test Do export CSV end
   */ 	
    	UserInput ui = new UserInput();
		ui.readPath("v0.1");
		//int choice = ui.readReportChoice();*/
		
    	
    	//Test treeExplorer
    	TreeExplorer zxc = new TreeExplorer();
    	zxc.treeSearch("C:\\Users\\student\\Desktop\\raportex\\raportex\\src\\test\\resources\\reporter-dane\\reporter-dane poprawne\\2013");
    	System.out.println(zxc.getFileNumber());
    }
}
