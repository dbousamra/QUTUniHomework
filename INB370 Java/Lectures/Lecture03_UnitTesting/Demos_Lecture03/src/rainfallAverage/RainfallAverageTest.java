package rainfallAverage;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class RainfallAverageTest { 
	
	RainfallAverage brisbane = new RainfallAverage();
	RainfallAverage aliceSprings= new RainfallAverage();

	@Before
	public void setUp() throws Exception {
		brisbane.reset();
		aliceSprings.reset();
	}

	@Test
	public void noRainfallForAWeek() {
		for (int i = 0; i < 7; i++) { 
			assertTrue(aliceSprings.addTodaysRain(0));
		};
		assertEquals(aliceSprings.getAverage(), new Integer(0));
	}

	@Test
	public void rainsMoreInBrissie() {
		aliceSprings.addTodaysRain(0);
		brisbane.addTodaysRain(10);
		aliceSprings.addTodaysRain(5);
		brisbane.addTodaysRain(20);
		aliceSprings.addTodaysRain(0);
		brisbane.addTodaysRain(15);
		assertTrue(aliceSprings.getAverage() < brisbane.getAverage());
	}

	@Test
	public void resettingWorks() {
		brisbane.addTodaysRain(100);
		brisbane.addTodaysRain(300);
		brisbane.reset();
		brisbane.addTodaysRain(15);
		brisbane.addTodaysRain(20);
		brisbane.addTodaysRain(10);
		assertEquals(brisbane.getAverage(), new Integer(15));
	}
	
	@Test(expected = ArithmeticException.class)
	public void noRainfallData() {
		aliceSprings.getAverage();
	}
	
	/* The following test fails because the test is wrong,
	 * not the program being tested
	 */
	@Test
	public void negativeRainfall() {
		aliceSprings.addTodaysRain(20);
		aliceSprings.addTodaysRain(-40);
		assertEquals(aliceSprings.getAverage(), new Integer(-10));
	}

}
