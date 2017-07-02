
package pl.agh.edu.raportex;

import java.io.File;
import java.util.ArrayList;

public class TreeExplorer {
	ArrayList<String> paths;
	int fileNumber = 0;

	ArrayList<String> employeeNames;
	
	public TreeExplorer() {
		paths = new ArrayList<String>();
		employeeNames = new ArrayList<String>();
	}

	public int getFileNumber() {
		return fileNumber;
	}


	public ArrayList<String> getPaths() {
		return paths;
	}

	public void treeSearch(String path) {
		
		File root = new File(path);
		File[] list = root.listFiles();
		
		if (path.endsWith(".xls")) {
			paths.add(path);
			return;
		}
		
		if (list == null)
			return;

		for (File file : list) {
			if (file.isDirectory()) {
				treeSearch(file.getAbsolutePath());
				/* System.out.println("Dir:" + file.getAbsoluteFile()); */
			} else {
				if (file.getName().endsWith(".xls")) {
					paths.add(file.getPath().toString());
					fileNumber++;
					employeeNames.add(file.getName().toString());
				}
			}
		}
	}
}