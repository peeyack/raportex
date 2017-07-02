package pl.agh.edu.raportex;

public class InputStatistic {
	int fileNumber = 0;
	int recordNumber = 0;
	
	public InputStatistic(TreeExplorer explore) {
		this.fileNumber = explore.getFileNumber();
	}
	
}
