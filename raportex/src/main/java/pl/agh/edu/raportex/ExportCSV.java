package pl.agh.edu.raportex;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ExportCSV {
	
	private ArrayList<String> list = new ArrayList<String>();
	
	
	
	public ExportCSV(ArrayList<String> input, String savePath) {
		


		
		FileWriter fw;
		try {
			fw = new FileWriter(new File(savePath));
			BufferedWriter bf  = new BufferedWriter(fw);
			for (String s: input) {
				bf.write(s+ System.lineSeparator());
			}
			bf.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
