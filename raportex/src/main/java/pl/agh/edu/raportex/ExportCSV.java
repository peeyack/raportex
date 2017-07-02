package pl.agh.edu.raportex;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ExportCSV {
	
	private ArrayList<String> list = new ArrayList<String>();
	
	
	
	public static void ExportCSV(ArrayList<String> input, String savePath) {
		
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
	
	public static void ExportCSVFromRecord(ArrayList<Record> input, String savePath) {
		
				
		FileWriter fw;
		try {
			fw = new FileWriter(new File(savePath));
			BufferedWriter bf  = new BufferedWriter(fw);
			String header = "ID,Rok,Miesiac,Nazwisko i Imie,Zadanie,Czas [h],Zrodlo danych wejsciowych,Data" + System.lineSeparator();
			bf.write(header);
			for (Record s: input) {
				bf.write(s.toCSVReport1String()+ System.lineSeparator());
			}
			bf.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
