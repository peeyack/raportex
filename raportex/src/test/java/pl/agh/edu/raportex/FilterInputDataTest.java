package pl.agh.edu.raportex;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FilterInputDataTest {
	ArrayList<Record> list = new ArrayList<>();
	FilterInputData test;

	Record r1 = new Record("2017", "07", "Kowalski_Jan", "projekt1", "posprzątanie", 30, "C:/");
	Record r2 = new Record("2017", "07", "Kowalski_Mariusz", "projekt2", "posprzątanie2", 10, "C:/");
	Record r3 = new Record("2017", "07", "Kowalski_Mariusz", "projekt3", "posprzątanie3", 4.5, "C:/");
	Record r4 = new Record("2017", "07", "Kowalski_Mariusz", "projekt4", "posprzątanie3", 20, "C:/");

	@Before
	public void executedBeforeEach() {
		// given
		
		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);
	}

	@Test
	public void testFilteredByName() {

		// when
		FilterInputData test = new FilterInputData(list);

		// then
		assertEquals(test.filterBySurnameAndName("Kowalski_Mariusz").get(0).getSurnameAndName(), r2.getSurnameAndName());
	}

	@Test
	public void testFilteredByNameMultiValue() {
		// when
		FilterInputData test = new FilterInputData(list);

		// then
		assertEquals(test.filterBySurnameAndName("Kowalski_Mariusz").get(0).getSurnameAndName(), "Kowalski_Mariusz");
		assertEquals(test.filterBySurnameAndName("Kowalski_Mariusz").get(1).getSurnameAndName(), "Kowalski_Mariusz");
		assertEquals(test.filterBySurnameAndName("Kowalski_Mariusz").get(2).getSurnameAndName(), "Kowalski_Mariusz");
	}

	@Test
	public void testFilteredByProjekt() {

		// when
		FilterInputData test = new FilterInputData(list);
		
		// then
		assertEquals(test.filterByProjekt("projekt1").get(0).getProjectName(), "projekt1");
	}

}
