package pl.agh.edu.raportex;

public class InputStatistic {
	int fileNumber = 0;
	int recordNumber = 0;
	
	public InputStatistic(TreeExplorer explore, WorkbookConverter workbook) {
		this.fileNumber = explore.getFileNumber();
		this.recordNumber = workbook.getRecordNumber();
	}

	public int getFileNumber() {
		return fileNumber;
	}

	public int getRecordNumber() {
		return recordNumber;
	}
	
	public void printInputStats() {
		System.out.println("Wczytano " + getFileNumber() + "plikow");
		System.out.println("Wczytano " + getRecordNumber() + "wierszy");
	}
}
