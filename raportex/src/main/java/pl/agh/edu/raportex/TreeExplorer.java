package pl.agh.edu.raportex;

import java.io.File;
import java.util.ArrayList;

public class TreeExplorer {
	ArrayList<String> paths = new ArrayList<String>();
	String startPoint;
	File folder;

	
	public TreeExplorer(String startPoint) {
		this.startPoint = startPoint;
		this.folder = new File(startPoint);
		
	}
	
	
	File[] listOfFiles = folder.listFiles();
	
	void test() {
		for (File file : listOfFiles) {
		    System.out.println(file.getPath());
		}
		
		
	}
		
	
}
