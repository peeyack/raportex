package pl.agh.edu.raportex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.ss.usermodel.Workbook;

public class WorkbookConverter {

	public static ArrayList<WorkbookConverterWarning> warnings = new ArrayList<WorkbookConverterWarning>();

	
	static int recordNumber = 0;
	
	public static int getRecordNumber() {
		return recordNumber;
	}

	public static ArrayList<Record> getRecordsFromTree(String path) throws IOException {
		TreeExplorer treeExplorer = new TreeExplorer();
		treeExplorer.treeSearch(path);
		return getRecordsFromManyFiles(treeExplorer.getPaths());
	}

	public static ArrayList<Record> getRecordsFromManyFiles(ArrayList<String> paths) throws IOException {
		ArrayList<Record> dane = new ArrayList<Record>(); //wszystkie rekordy
		for (String sciezka : paths) {
			dane.addAll(getRecordsFromOneFile(sciezka));
		}
		HashSet<Record> zbior=new HashSet<Record>(dane);
		ArrayList<Record> listDeletedDuplicates=new ArrayList<Record>(zbior);
		if (dane.size()!=listDeletedDuplicates.size()) warnings.add(new WorkbookConverterWarning("duplikaty w danych w ilości "+(dane.size()-listDeletedDuplicates.size())));
		return listDeletedDuplicates;
	}
	
	
	public static ArrayList<Record> getRecordsFromOneFile(String pathname) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(pathname));
		File file = new File(pathname);
		File monthDirectory = new File(file.getAbsoluteFile().getParent());
		File yearDirectory = new File(monthDirectory.getAbsoluteFile().getParent());
		String year = yearDirectory.getName();
		String month = monthDirectory.getName();
		String fileName = file.getName();
		String sname = fileName.split("\\.")[0];
		ArrayList<Record> data = new ArrayList<Record>();
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			HSSFSheet sheet = wb.getSheetAt(i);
			String projectName = sheet.getSheetName();
			for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
				HSSFRow wiersz = sheet.getRow(j);
				String tekst="w roku "+year+" w miesiącu "+month+" w pliku "+fileName+" w projekcie "+projectName+" w wierszu "+wiersz.getRowNum();
				if (wiersz.getPhysicalNumberOfCells() > 2) {
					GregorianCalendar gc = new GregorianCalendar();
					boolean good = true;
					try {
						gc.setTime(wiersz.getCell(0).getDateCellValue());
					} catch (IllegalStateException | NumberFormatException e) {
						good = false;
						warnings.add(new WorkbookConverterWarning("błąd daty "+tekst));
					}
					if (gc.get(Calendar.MONTH)+1!=Integer.parseInt(month) || gc.get(Calendar.YEAR)!=Integer.parseInt(year)) {
						warnings.add(new WorkbookConverterWarning("data nie zgadza się z folderem "+tekst));
					}
					String task="";
					try {
						task = wiersz.getCell(1).getStringCellValue();
					} catch (Exception e) {
						good = false;
						warnings.add(new WorkbookConverterWarning("błąd zadania "+tekst));
					}
					if (task.equals("")) {
						good=false;
						warnings.add(new WorkbookConverterWarning("puste zadanie "+tekst));
					}
					double thetime=0.0;
					try {
						thetime = wiersz.getCell(2).getNumericCellValue();
					}
					catch (Exception e) {
						good=false;
						warnings.add(new WorkbookConverterWarning("błąd ilości godzin "+tekst));
					}
					if (thetime<=0.0 || thetime>=24.0) {
						good=false;
						warnings.add(new WorkbookConverterWarning("błąd ilości godzin "+tekst));
					}
					else if (thetime>=13.0)
					{
						warnings.add(new WorkbookConverterWarning("nieustawowa ilość godzin "+tekst));
					}
					if (good) {
						Record rek = new Record(year, month, sname, projectName, task, thetime, pathname, gc);
						data.add(rek);
					}
				}
				else {
					warnings.add(new WorkbookConverterWarning("puste dane w wierszu "+tekst));
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
