package pl.agh.edu.raportex;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FilterRaport1RecordTest {
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
	public void test1() {
		RaportGenerator generator = new RaportGenerator();

		// when
		ArrayList<Raport1Record> result = generator.makeRaportOne(list);

		FilterRaport1Record raportTest = new FilterRaport1Record(result);

		ArrayList<Raport1Record> wynik = raportTest.filterByTimeSpendOnWork(2.0);

		// then
		assertEquals(30.0, wynik.get(0).getTime(), 0.001);
		assertEquals(34.5, wynik.get(1).getTime(), 0.001);
	}

	@Test
	public void test2() {
		RaportGenerator generator = new RaportGenerator();

		// when
		ArrayList<Raport1Record> result = generator.makeRaportOne(list);

		FilterRaport1Record raportTest = new FilterRaport1Record(result);

		ArrayList<Raport1Record> wynik = raportTest.filterByTimeSpendOnWork(31.0);

		// then
		assertEquals(34.5, wynik.get(0).getTime(), 0.001);
		assertEquals("Kowalski_Mariusz", wynik.get(0).getSurnameAndName());
	}

}
