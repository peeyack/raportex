package pl.agh.edu.raportex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.ss.usermodel.Workbook;



public class WorkbookConverter {
	static int recordNumber = 0;
	
	public static int getRecordNumber() {
		return recordNumber;
	}

	public static ArrayList<Record> getRecordsFromTree(String path) throws IOException {
		TreeExplorer treeExplorer=new TreeExplorer();
		treeExplorer.treeSearch(path);
		return getRecordsFromManyFiles(treeExplorer.getPaths());
	}
	
	public static ArrayList<Record> getRecordsFromManyFiles(ArrayList<String> paths) throws IOException {
		ArrayList<Record> dane = new ArrayList<Record>(); //wszystkie rekordy
		for (String sciezka : paths) {
			dane.addAll(getRecordsFromOneFile(sciezka));
		}
		return dane; //całość danych do analizy
	}
	
	

	public static ArrayList<Record> getRecordsFromOneFile(String pathname) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(pathname));
		File file = new File(pathname);
		File monthDirectory = new File(file.getAbsoluteFile().getParent());
		File yearDirectory = new File(monthDirectory.getAbsoluteFile().getParent());
		String year = yearDirectory.getName();
		String month = monthDirectory.getName();
		String fileName=file.getName();
		String sname = fileName.split("\\.")[0];
		ArrayList<Record> data = new ArrayList<Record>();
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			HSSFSheet sheet = wb.getSheetAt(i);
			String projectName = sheet.getSheetName();
			for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
				HSSFRow wiersz = sheet.getRow(j);
				if (wiersz.getPhysicalNumberOfCells() > 2) {
					GregorianCalendar gc=new GregorianCalendar();
					gc.setTime(wiersz.getCell(0).getDateCellValue());
					String task = wiersz.getCell(1).getStringCellValue();
					double thetime = wiersz.getCell(2).getNumericCellValue();
					Record rek = new Record(year, month, sname, projectName, task, thetime, pathname,gc);
					data.add(rek);
					recordNumber++;
				}
			}
		}
		return data;
	}
}
