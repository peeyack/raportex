package pl.agh.edu.raportex;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

public class Raport3GeneratorTest {

	@Test
	public void test() {
		// given

		GregorianCalendar gc1 = new GregorianCalendar(2017, 1, 0);
		
		ArrayList<Record> list = new ArrayList<>();

		Record r1 = new Record("2017", "07", "Kowalski_Jan", "projekt1", "posprzątanie", 30, "C:/", gc1);
		Record r2 = new Record("2017", "07", "Kowalski_Mariusz", "projekt2", "posprzątanie2", 10, "C:/", gc1);
		Record r3 = new Record("2017", "07", "Kowalski_Mariusz", "projekt1", "posprzątanie3", 4.5, "C:/", gc1);
		Record r4 = new Record("2017", "07", "Kowalski_Mariusz", "projekt1", "posprzątanie3", 20, "C:/", gc1);

		list.add(r1);
		list.add(r2);
		list.add(r3);
		list.add(r4);

		RaportGenerator generator = new RaportGenerator();

		// when
		List<Raport3Record> result = generator.makeRaporThree(list);

		// then
		assertEquals(1, result.size());
		assertEquals(64.5, result.get(0).getTime(), 0.1);
	}

}
