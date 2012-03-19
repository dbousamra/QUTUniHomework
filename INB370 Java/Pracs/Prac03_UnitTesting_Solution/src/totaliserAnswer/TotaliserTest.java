package totaliserAnswer;

import org.junit.Test;
import static org.junit.Assert.*;

public class TotaliserTest {

	/* The following tests are sufficient to reveal the
	 * bugs in the incorrect version of the Totaliser
	 * program, but should not be considered a thorough
	 * test suite
	 */
	
	@Test
	/* This test passes */
	public void enterOneNumber() {
		Totaliser aTotaliser = new Totaliser();
		aTotaliser.enterValue(4);
		assertEquals(aTotaliser.getSum(), 4);
	}

	@Test
	/* This test fails because of the incorrect assignment
	 * in method enterValue
	 */
	public void enterAFewNumbers() {
		Totaliser aTotaliser = new Totaliser();
		aTotaliser.enterValue(1);
		aTotaliser.enterValue(6);
		aTotaliser.enterValue(3);
		assertEquals(aTotaliser.getSum(), 10);
	}
	
	@Test
	/* This test fails because of the incorrect declaration
	 * of the private field as static
	 */
	public void createTwoTotalisers() {
		Totaliser aTotaliser = new Totaliser();
		Totaliser anotherTotaliser = new Totaliser();
		aTotaliser.enterValue(4);
		anotherTotaliser.enterValue(6);
		assertTrue(aTotaliser.getSum() != anotherTotaliser.getSum());
	}
}
