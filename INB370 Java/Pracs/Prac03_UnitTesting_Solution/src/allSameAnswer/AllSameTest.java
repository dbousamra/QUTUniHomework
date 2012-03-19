package allSameAnswer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import allSameAnswer.AllSame; // <-- change this for different classes (A, B or C)

public class AllSameTest {
		
	/* The following tests are sufficient to reveal the
	 * bugs in the incorrect versions of the AllSame
	 * program, but should not be considered a thorough
	 * test suite
	 */

	private AllSame underTest; // <-- change this for different classes
	
	@Before
	/*
	 * Create a fresh planner before each test
	 */
	public void newSame() throws Exception {
		underTest = new AllSame();  // <-- change this for different classes
	}

	@Test(expected = Exception.class)
	/* Confirm that the program throws an exception if given
	 * no input data  - passed by all versions (even though it's
	 * accidental in the case of AllSameB!)
	 */
	public void noInput() throws Exception {
		underTest.same(new int[] {});
	}
	
	@Test(expected = Exception.class)
	/* Confirm that the program throws an exception if given
	 * a non-natural number - failed by AllSameB because it
	 * doesn't check its inputs
	 */
	public void nonNatInput() throws Exception {
		underTest.same(new int[] {3, 4, -1, 6, 7});
	}
	
	@Test
	/* Confirm that the program correctly identifies an array
	 * of identical numbers - passed by all versions
	 */
	public void identicalNumbers() throws Exception {
		assertTrue(underTest.same(new int[] {5, 5, 5, 5, 5}));
	}
	
	@Test
	/* Confirm that the first number is checked - passed by all
	 * versions
	 */
	public void firstNumber() throws Exception {
		assertEquals(underTest.same(new int[] {2, 7, 7, 7, 7}), false);
	}

	@Test
	/* Confirm that the last number is checked - failed by
	 * allSameB because it has an off-by-one error in its
	 * loop
	 */
	public void lastNumber() throws Exception {
		assertEquals(underTest.same(new int[] {7, 7, 7, 7, 2}), false);
	}
	
	@Test
	/* The following test identifies the flaw in the algorithm
	 * used by AllSameA.  This algorithm, due to Myers, "works"
	 * by calculating the average of the numbers and comparing
	 * this with the first number.  Surprisingly, this approach
	 * is successful in most cases, so the flaw is hard to
	 * detect by testing.  It fails when given an array of different
	 * numbers in which the first one just happens to equal the
	 * average of them all, as in this test.
	 */
	public void myersCheck() throws Exception {
		assertEquals(underTest.same(new int[] {4, 2, 6, 1, 7}), false);
	}
	
}
