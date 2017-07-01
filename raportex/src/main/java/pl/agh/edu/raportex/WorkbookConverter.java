package pl.agh.edu.raportex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.ss.usermodel.Workbook;

public class WorkbookConverter {
	public static ArrayList<Record> wezDaneZPlikow(ArrayList<String> sciezki) throws IOException {
		ArrayList<Record> dane = new ArrayList<Record>();
		for (String sciezka : sciezki) {
			dane.addAll(wezDaneZPliku(sciezka));
		}
		return dane;
	}
	

	public static ArrayList<Record> wezDaneZPliku(String pathname) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(pathname));
		File f = new File(pathname);
		File p = new File(f.getAbsoluteFile().getParent());
		File pp = new File(p.getAbsoluteFile().getParent());
		String rok = pp.getName();
		String mies = p.getName();
		String gosciu = f.getName();
		ArrayList<Record> dane = new ArrayList<Record>();
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			HSSFSheet arkusz = wb.getSheetAt(i);
			String nazwaProjektu = arkusz.getSheetName();
			for (int j = 1; j < arkusz.getPhysicalNumberOfRows(); j++) {
				HSSFRow wiersz = arkusz.getRow(j);
				if (wiersz.getPhysicalNumberOfCells() > 2) {
					String task = wiersz.getCell(1).getStringCellValue();
					double thetime = wiersz.getCell(2).getNumericCellValue();
					Record rek = new Record(rok, mies, gosciu, nazwaProjektu, task, thetime, pathname);
					dane.add(rek);
				}
			}
		}
		return dane;
	}
}
